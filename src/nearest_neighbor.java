import java.util.Arrays;
import java.util.Scanner;

public class nearest_neighbor {
	//int n;
//	ArrayList<Point> unvisited=new ArrayList<Point>();
//	ArrayList<Point> visited=new ArrayList<Point>();
	Point all_nodes[];
	Point visited_nodes[];
	double total_distance=0;
	Point begining;
	int number_of_seen_nodes=0;
	
	public nearest_neighbor(){	
		get_input();

		long startTime = System.currentTimeMillis();
		find_the_path();
		long stopTime = System.currentTimeMillis();
		
		System.out.println("time:  "+(stopTime-startTime)+"  ms");
		see_results();
	}
	
	public void see_results(){
		System.out.println("total distance is: "+total_distance);
		for(int j=0;j<visited_nodes.length;j++){
			System.out.println(visited_nodes[j].x+" "+visited_nodes[j].y);
		}
		System.out.println(begining.x+" "+begining.y);
	}
	public double distance(Point a, Point b){
		double temp;
		temp=(a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y);
		return Math.sqrt(temp);
	}
	
	
	public void find_the_path(){
		
		
		Point current;
		current=all_nodes[0];
		begining=all_nodes[0];
		all_nodes[0].seen=true;
		visited_nodes[0]=all_nodes[0];
		number_of_seen_nodes++;

		double nearest;
		int its_index=0;//meghdare alaki
		
		while(number_of_seen_nodes<all_nodes.length){
		//	System.out.println(number_of_seen_nodes);
			nearest=Double.MAX_VALUE;
			for(int j=0;j<all_nodes.length;j++){
				if(!all_nodes[j].seen){
					if(distance(current, all_nodes[j])<=nearest){
						nearest=distance(current, all_nodes[j]);
						its_index=j;
					}
				}
			}

			current=all_nodes[its_index];
			all_nodes[its_index].seen=true;
			visited_nodes[number_of_seen_nodes]=all_nodes[its_index];
			number_of_seen_nodes++;
			
			total_distance+=nearest;
		}
		total_distance+=distance(begining, current);
	//	System.out.println(total_distance);
		
		
	}
	
	
	
	
//*********************************************************************************
	@SuppressWarnings("resource")
	public void get_input(){
		System.out.println("nearest neighbour");
		System.out.println("please enter the numbers");
		
		String[] tokens;
		Scanner scanner = new Scanner(System.in);
		tokens = scanner.nextLine().split("\\s");
		
			if(tokens.length!=1) return;  //error detection
	//	n=Integer.parseInt(tokens[0]);
			all_nodes=new Point[Integer.parseInt(tokens[0])];
			visited_nodes=new Point[Integer.parseInt(tokens[0])];
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
