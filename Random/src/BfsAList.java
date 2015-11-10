import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BfsAList {
	
	private Map<Integer, List<Integer>> _adjacencyList;
	private Queue<Integer> queue;
	
	public BfsAList(int V){// v here is number of vertices
		_adjacencyList = new HashMap<Integer, List<Integer>>();
		queue = new LinkedList<Integer>();
		for(int i = 0; i < V; i++){
			_adjacencyList.put(i, new LinkedList<Integer>());// add a linkedlist for each vertex
			
		}
	}
	
	public void setEdge(int source, int dest){ // adds edge between vertices
		if(source > _adjacencyList.size() || dest > _adjacencyList.size()){
			System.out.println("Vertex not present");
			return;
		}
		List<Integer> sourceList = _adjacencyList.get(source); // get the corresponding source list
		sourceList.add(dest); // add an edge between this source and another vertex
		List<Integer> destList = _adjacencyList.get(dest);
		destList.add(source); // undirected graph, edge goes both ways
	}
	
	public List<Integer> getEdge(int source){
		if(source > _adjacencyList.size()){
			System.out.println("Vertex not present");
			return null; 
		}
		return _adjacencyList.get(source);
	}
	
	void bfs(int source){
		int V = _adjacencyList.size();
		boolean [] visited = new boolean[V];
		List<Integer> nodes = new LinkedList<Integer>();
		int i, element;
		visited[source] = true;
		queue.add(source);
		while(!queue.isEmpty()){
			element = queue.remove(); // remove first which will be source
			System.out.println(element +" removed");
			i = element;
			nodes.add(element);
			List<Integer> iList = getEdge(i);
			System.out.println(i+" -> "+iList);
			//System.out.println(i + "\t");
			int x = 0; 
			while(x < iList.size()){
				if(visited[iList.get(x)] == false){
					queue.add(iList.get(x));
					visited[iList.get(x)] = true;
				}
				x++;
			}
		}
		System.out.println("vertices---"+nodes);
		
	}
	/*
	 * 
0 1
1 2
2 3
3 0
0 2

test with this

  			0 --- 1-------5----6--8
		    | \    \      |   /  /
			|  \    \     |  /  /
			|   \    \    | /  /
			2    3----4---7---9
			
			V = 10, E = 13
0 1
0 2
0 3
1 5
1 4
3 4
4 7
5 6
5 7
6 7
6 8
7 9
8 9


	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int source;
		int dest;
		int E;
		int V; 
		int start = 0;
		int count = 0;
		Scanner sc = new Scanner(System.in);
		try{
			System.out.println("Enter number of vertices and edges in this graph");
			V = sc.nextInt();
			E = sc.nextInt();
			BfsAList gList = new BfsAList(V);
			
			// get edge in graph
			System.out.println("Enter edges in graph.. i.e. <source> 1 <destination> 2");
			while(count < E){
				source = sc.nextInt();
				dest = sc.nextInt();
				gList.setEdge(source, dest);
				count++;
			}
			System.out.println("Enter start vertex: ");
			start = sc.nextInt();
			gList.bfs(start);
		}catch(InputMismatchException e){
			System.out.println("Error in input format");
		}
		sc.close();

	}

}
