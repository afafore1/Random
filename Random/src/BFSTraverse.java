import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
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
		int element;
		HashMap<Integer, Integer> colors = new HashMap<>();
		visited[source] = true; // set source vertex/node as visited so we start from it
		queue.add(source); // add source to the queue
		colors.put(source, 0); // assign color 0
		while(!queue.isEmpty()){ 
			element = queue.remove(); // remove head node.. this is parent
			for(int i = 0; i < numNodes; i++){
				if(adjacency_matrix[element][i] == 1 && Objects.equals(colors.get(i), colors.get(element))){ // same set with different number
					System.out.println("not bipartite here "+i+" and "+element); // this will give duplicate.. use set
				}
				if(adjacency_matrix[element][i] == 1 && visited[i] == false){
					queue.add(i); // child
					visited[i] = true;
					colors.put(i, 1 - colors.get(element)); // this will make it alternate
				}
				
			}
			
		}
		System.out.println();
	}
	
	void dfs(int adjacency_matrix[][], int source){
		Stack<Integer> stack = new Stack<>();
		int numNodes = adjacency_matrix[source].length -1;
		boolean [] visited = new boolean[numNodes +1];
		visited[source] = true;
		stack.add(source);
		while(!stack.isEmpty()){
			int current = stack.peek(); // don't remove the element but get it
			System.out.println("Current node being visited is "+current);
			for(int x = 0; x <= numNodes; x++){
				if(adjacency_matrix[current][x] == 1 && visited[x] == false){
					visited[x] = true;
					stack.push(x);
					break;
				}else if(x == numNodes){
					stack.pop();
				}
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
			bfst.dfs(adjacency_matrix, source);
		}catch (InputMismatchException e){
			System.out.println("Wrong input format");
		}
		sc.close();

	}

}
