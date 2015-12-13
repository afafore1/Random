import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class BfsAList {

	private Map<Integer, List<Integer>> _adjacencyList;
	private Queue<Integer> queue;
	private int [] distTo;
	private int [] visited;
	private LinkedHashMap<Integer, Integer> set = new LinkedHashMap<Integer, Integer>();

	public BfsAList(int V){// v here is number of vertices
		_adjacencyList = new HashMap<Integer, List<Integer>>();
		queue = new LinkedList<Integer>();
		distTo = new int [V];
		visited = new int[V];
		for(int i = 0; i < V; i++){
			_adjacencyList.put(i, new LinkedList<Integer>());// add a linkedlist for each vertex
			distTo[i] = 0;
			visited[i] = -1;
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
		List<Integer> nodes = new LinkedList<Integer>();
		int i, element;
		visited[source] = 0;
		distTo[source] = 0;
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
				int index = iList.get(x);
				if(visited[index] == -1){
					queue.add(index);
					visited[index] = i;
					distTo[index] = distTo[i] + 1;
				}
				x++;
			}
		}
		System.out.println(Arrays.toString(visited));
		System.out.println("vertices---"+nodes);

	}

	// has this node been visited at all ?
	public int hasPath(int v){
		return visited[v];
	}

	// is there a path from this source to this destination?
	public boolean hasPathFrom(int s, int v){
		if(getEdge(s).contains(v))return true;
		return false;
	}

	public double distTo(int v){
		return distTo[v];
	}

	public void shortestPath(int v, int e){
		if(e == v){
			System.out.println(v+"-->"+v);
			System.exit(0);
		}
		for(int i = e; i > 0; i= visited[i]){
			if(i == v)break;
			if(visited[i] != -1){
				set.put(i, visited[i]);
			}
		}
		String dset = set.toString().replace("}", "").replace("{", "");
		dset = new StringBuilder(dset).reverse().toString().replaceAll("=", "-->");
		System.out.println(dset);
	}

	//[0, 1, 1, 1, 2, 2, 3, 3, 4, 4]
	//[0, 1, 5, 6, 7]

	/*0 -> [1, 2, 3]
			1 removed
			1 -> [0, 5, 4]
			2 removed
			2 -> [0]
			3 removed
			3 -> [0, 4]
			5 removed
			5 -> [1, 6, 7]
			4 removed
			4 -> [1, 3, 7]
			6 removed
			6 -> [5, 7, 8]
			7 removed
			7 -> [4, 5, 6, 9]
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
		int destination = 0;
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
			System.out.println("Enter source and destination vertex: ");
			start = sc.nextInt();
			destination = sc.nextInt();
			gList.bfs(start);
			gList.shortestPath(start, destination);
		}catch(InputMismatchException e){
			System.out.println("Error in input format");
		}
		sc.close();

	}

}
