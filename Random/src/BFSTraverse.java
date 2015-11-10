import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
		 *  0 --- 1-------5----6--8
		 *  | \    \      |   /  /
			|  \    \     |  /  /
			|   \    \    | /  /
			2    3----4---7---9
			
adjacency list
0,1
0,2
0,3
1,5
1,4
3,4
4,7
5,6
5,7
6,7
6,8
7,9
8,9

			
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
adjacency matrix from graph above
			  
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

public class BFSTraverse {

	private Queue<Integer> queue;
	
	
	public BFSTraverse(){
		queue = new LinkedList<Integer>();
	}
	
	void bfs(int adjacency_matrix[][], int source){
		int numNodes = adjacency_matrix[source].length - 1;
		boolean [] visited = new boolean[numNodes + 1];
		int i, element;
		visited[source] = true; // set source vertex/node as visited so we start from it
		queue.add(source); // add source to the queue
		
		while(!queue.isEmpty()){ // while the queue is not empty... remember queue is FIFO (first in first out)
			element = queue.remove(); // remove head node.. this is parent
			i = element; // set i to the head
			System.out.print(i + "\t");			
			
			/*
			 *loop through all nodes from i
			 *and check if there is a path to
			 *head, if there exist a path and that node is not visited
			 *mark it as visited and increment i
			 */
			while(i <= numNodes){
				if(adjacency_matrix[element][i] == 1 && visited[i] == false){
					queue.add(i); // child
					visited[i] = true;
				}
				i++;
				
			}
			
		}
	}
	public static void main(String[] args) {
		int numNodes, source;
		Scanner sc = null;
		try{
			System.out.println("Enter number of nodes in graph");
			sc = new Scanner(System.in);
			numNodes = sc.nextInt();
			
			int adjacency_matrix[][] = new int[numNodes + 1][numNodes + 1];
			System.out.println("Enter adjacency matrix");
			for(int i = 0; i < numNodes; i++){
				for(int j = 0; j < numNodes; j++){
					adjacency_matrix[i][j] = sc.nextInt();
				}
			}
			System.out.print("Source vertex ? ");
			source = sc.nextInt();
			
			System.out.println("BFS traversal of graph is ");
			BFSTraverse bfst = new BFSTraverse();
			bfst.bfs(adjacency_matrix, source);
		}catch (InputMismatchException e){
			System.out.println("Wrong input format");
		}
		sc.close();

	}

}
