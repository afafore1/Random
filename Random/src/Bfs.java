import java.util.LinkedList;
import java.util.Queue;

public class Bfs {
	int numV; // number of vertices
	boolean [][] G; // graph as adjacency matrix.... PS: should make implementation using adjacency list
	String graph = "0---1-------5---6\n|\\    \\     |  /\n| \\    \\    | /\n2  3----4---7"; // representation of the graph
	
	void graphSetup(){
		/*
		 *      0 --- 1------5---6
			| \    \     |  /
			|  \    \    | /
			2   3----4---7
			
			    0 1 2 3 4 5 6 7
			  -----------------
			0 | 0 1 1 1 0 0 0 0
			1 | 1 0 0 0 1 1 0 0
			2 | 1 0 0 0 0 0 0 0
			3 | 1 0 0 0 1 0 0 0
			4 | 0 1 0 1 0 0 0 1
			5 | 0 1 0 0 0 0 1 1
			6 | 0 0 0 0 0 1 0 1
			7 | 0 0 0 0 1 1 1 0
			  ------------------
		 */
		System.out.println(graph);
		numV = 8;
		G = new boolean [numV][numV]; // this is actually a waste of space 
		G[0][1] = G[1][0] = true;
		G[0][2] = G[2][0] = true;
		G[0][3] = G[3][0] = true;
		G[1][4] = G[4][1] = true;
		G[1][5] = G[5][1] = true;
		G[3][4] = G[4][3] = true;
		G[4][7] = G[7][4] = true;
		G[5][7] = G[7][5] = true;
		G[5][6] = G[6][5] = true;
		G[6][7] = G[7][6] = true;
		
		
	}
	
	void printGraph(int startIndex, int endIndex,int start){
		int startIn = graph.indexOf(String.valueOf(start));
		int endIn = graph.indexOf(String.valueOf(endIndex));
		
		if(graph.contains(String.valueOf(startIndex)) && graph.contains(String.valueOf(endIndex))){	
			if(startIndex != start){
				System.out.println(graph.substring(startIn,endIn)+endIndex);
				
			}else{
				System.out.println(graph.substring(graph.indexOf(String.valueOf(startIndex)),graph.indexOf(String.valueOf(endIndex)))+endIndex);
			}			
		}		
		else System.out.println("end of graph, if all nodes are not touched then this graph is disconnected");
	}
	
	void doBfs(){
		boolean [] V = new boolean[numV]; //visited 
		int numComponents = 0; // disconnected graph
		for(int i = 0; i < numV; ++i){
			if(!V[i]){ // if this node has not been visited
				++numComponents;
				System.out.printf("Starting BFS for comp %d starting at node %d%n",numComponents,i);
				doBfs(i,V);
			}
		}		
	}
	
	void doBfs(int start, boolean [] V){
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.offer(start);
		V[start] = true;
		while(!Q.isEmpty()){
			int current = Q.poll(); // head of queue
			System.out.printf("Current node %d%n", current);
			for(int i = 0; i < numV; ++i){
				if(G[current][i] && !V[i]){ // if there is a path between current and next vertex and current is not already visited
					Q.offer(i); // add to queue and set it to visited
					V[i] = true;
					System.out.printf("Adding node %d to the queue%n",i);
					printGraph(current,i,start);
				}
			}
			System.out.printf("Done processing node %d%n",current);
		}
		System.out.printf("Done with Bfs from start node %d%n", start);
	}
	Bfs(){
		graphSetup(); // set up the graph
		System.out.println("----------------------------------\n");
		doBfs();
		System.out.println();
	}
	public static void main(String [] args){
		new Bfs();
	}

}
