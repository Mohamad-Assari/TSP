import java.util.Arrays;
import java.util.Scanner;

public class Exhaustive {
	Point []all_nodes;
	Point []ideal_nodes;
	double min_distance;
	public Exhaustive(){
		System.out.println("Exhaustive");
		System.out.println("please enter your numbers");
		get_input();
		long startTime = System.currentTimeMillis();
		find_the_path();
		long stopTime = System.currentTimeMillis();
		System.out.println("time:  "+(stopTime-startTime)+"  ms");
		see_results();
		
		
		
	}
	public void see_results(){
		System.out.println("total distance:  "+min_distance);
		for(int i=0;i<ideal_nodes.length;i++){
			System.out.println(ideal_nodes[i].x+" "+ideal_nodes[i].y);
		}
		System.out.println(ideal_nodes[0].x+" "+ideal_nodes[0].y);

	}
	//******************************************************************
	public void find_the_path(){
		//ideal_nodes=all_nodes;
		min_distance=total_distance(all_nodes);

		
		// by starting it from 1 we reduce the complexity to (n-1)!
		permutation(1, all_nodes);

	}
	//******************************************************************
	public void permutation(int prefix,Point []ghand){
		if(prefix==ghand.length-1){		
			
				if(total_distance(ghand)<min_distance){
					min_distance=total_distance(ghand);
					for(int i=0;i<all_nodes.length;i++){
						ideal_nodes[i]=ghand[i];	
					}
					
				}
			return;
		}
		
		for(int i=prefix;i<ghand.length;i++){
			Point temp=ghand[prefix];
			ghand[prefix]=ghand[i];
			ghand[i]=temp;
			
			permutation(prefix+1, ghand);

			//making the array as it used to be:
			temp=ghand[i];
			ghand[i]=ghand[prefix];
			ghand[prefix]=temp;
			
		}
		
	}
	//*************************************************************
	
	public double total_distance(Point []path){
		double d=0;
		for(int i=0;i<path.length-1;i++){
			d+=distance(path[i], path[i+1]);
		}
		d+=distance(path[path.length-1], path[0]);
	return d;	
	}
	
	public double distance(Point a, Point b){
		double temp;
		temp=(a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
		return Math.sqrt(temp);
	}
	
//*********************************************************************************
		@SuppressWarnings("resource")
		public void get_input(){

			String[] tokens;
			Scanner scanner = new Scanner(System.in);
			tokens = scanner.nextLine().split("\\s");
			all_nodes=new Point[Integer.parseInt(tokens[0])];
			ideal_nodes=new Point[Integer.parseInt(tokens[0])];
			
				if(tokens.length!=1) return;  //error detection
		//	n=Integer.parseInt(tokens[0]);
					int city_number=0;
			while (true) {
				tokens = scanner.nextLine().split("\\s");
				
				//checks if it's the end
				if(tokens[0].equals("#"))    break;
				
				all_nodes[city_number]=(new Point(Integer.parseInt(tokens[0]),Integer.parseInt(tokens[1])));
				city_number++;
				
				
					
			
				System.out.println(Arrays.toString(tokens));
				
				
			}

			scanner.close();

		}
//************************************************************************************	


}
