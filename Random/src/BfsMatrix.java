import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BfsMatrix {

	/*
	 *  0 --- 1-------5----6--8
	 *  | \    \      |   /  /
		|  \    \     |  /  /
		|   \    \    | /  /
		2    3----4---7---9
		
		
			    0 1 2 3 4 5 6 7 8 9
			  ---------------------
			0 | 0 1 1 1 0 0 0 0 0 0
			1 | 1 0 0 0 1 1 0 0 0 0
			2 | 1 0 0 0 0 0 0 0 0 0
			3 | 1 0 0 0 1 0 0 0 0 0
			4 | 0 1 0 1 0 0 0 1 0 0
			5 | 0 1 0 0 0 0 1 1 0 0
			6 | 0 0 0 0 0 1 0 1 1 0
			7 | 0 0 0 0 1 1 1 0 0 1
			8 | 0 0 0 0 0 0 1 0 0 1
			9 | 0 0 0 0 0 0 0 1 1 0
			  ---------------------
			  
0 1 1 1 0 0 0 0 0 0
1 0 0 0 1 1 0 0 0 0
1 0 0 0 0 0 0 0 0 0
1 0 0 0 1 0 0 0 0 0
0 1 0 1 0 0 0 1 0 0
0 1 0 0 0 0 1 1 0 0
0 0 0 0 0 1 0 1 1 0
0 0 0 0 1 1 1 0 0 1
0 0 0 0 0 0 1 0 0 1
0 0 0 0 0 0 0 1 1 0
		*/
	
	private Queue<Integer> queue;
	
	public BfsMatrix(){
		queue = new LinkedList<>(); // FIFO
	}
	
	void bfs(int adjacencyMatrix[][], int source){
		int numNodes = adjacencyMatrix[source].length -1; // 10
		boolean [] visited = new boolean[numNodes + 1]; // 
		int element; // 
		visited[source] = true;
		queue.add(source); // 0 
		while(!queue.isEmpty()){
			element = queue.remove(); //0
			System.out.println("Current node being visited is "+element);
			for(int i = 0; i < numNodes; i++){
				if(adjacencyMatrix[element][i] == 1 && !visited[i]){
					queue.add(i); // 3,4,5
					visited[i] = true; //0,1,2,3,4,5
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int numNodes;
		int source ;
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter number of nodes in the graph: ");
			numNodes = sc.nextInt();
			
			int matrix[][] = new int [numNodes+1][numNodes+1];
			System.out.println("Enter the matrix");
			for(int i = 0; i < numNodes; i++){
				for(int j = 0; j < numNodes; j++){
					matrix[i][j] = sc.nextInt();
				}
			}
			System.out.println("Source vertex ?");
			source = sc.nextInt();
			
			BfsMatrix b = new BfsMatrix();
			b.bfs(matrix, source);
		}catch(InputMismatchException e){
			e.printStackTrace();
		}

	}

}
