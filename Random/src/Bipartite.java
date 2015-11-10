import java.util.LinkedList;
import java.util.Scanner;

public class Bipartite {
	static int V = 0; // number of vertices
	
	boolean isBipartite(int G[][], int source){
		int colorArr[] = new int[V]; // assign colors to vertices
		for(int i = 0; i < V; ++i){
			colorArr[i] = -1;
		}
		colorArr[source] = 1; // assign 1 to first color
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.add(source); // add source to list
		while(q.size() != 0){ // continue while the queue is not empty
			int top = q.poll(); // dequeue head vertex from queue
			for(int j = 0; j < V; ++j){
				if(G[top][j] == 1 && colorArr[j] == -1){
					colorArr[j] = 1-colorArr[top];
					q.add(j);
				}else if(G[top][j] == 1 && colorArr[j] == colorArr[top]){
					System.out.println("Graph not bipartite at "+top+" and "+j+" with colors "+colorArr[j]);
					return false; // graph is not bipartite
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of vertices");
		V = sc.nextInt();
		int G[][] = new int [V+1][V+1];
		System.out.println("Enter adjacency matrix:");
		for(int i = 0; i < V; i++){
			for(int j = 0; j < V; j++){
				G[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter a sounce vertex");
		int source = sc.nextInt();
		Bipartite bp = new Bipartite();
		if(bp.isBipartite(G, source)){
			System.out.println("Graph is Bipartite");
		}else{
			System.out.println("Graph is not Bipartite");
		}

	}

}
