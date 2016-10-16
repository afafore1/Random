import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BaconNumber {

	private Map<Integer, List<Integer>> _adjacencyList;
	private Map<Integer, String> _movies; // will store neighbors here
	private Queue<Integer> queue;
	private int [] visited;
	private LinkedHashMap<Integer, Integer> set = new LinkedHashMap<Integer, Integer>();

	public BaconNumber(int V){// v here is number of vertices
		_adjacencyList = new HashMap<Integer, List<Integer>>();
		_movies = new HashMap<Integer, String>();
		queue = new LinkedList<Integer>();
		visited = new int[V];
		for(int i = 0; i < V; i++){
			_adjacencyList.put(i, new LinkedList<Integer>());// add a linkedlist for each vertex
			visited[i] = -1;
		}
	}
	
	private void fillNeighbors(){
		//0 = A, 1 = B, 2 = C, 3 = D, 4 = E
		_movies.put(0, "Z Movie 0 | B Movie 1 Movie 2 Movie 7 | C Movie 1 Movie 7 | D Movie 2 Movie 7 | E Movie 2");
		_movies.put(1, "A Movie 1 Movie 2 Movie 7 | C Movie 1 Movie 7 | D Movie 2 Movie 7 | E Movie 2");
		_movies.put(2, "A Movie 1 Movie 7 | B Movie 1 Movie 7 | D Movie 7");
		_movies.put(3, "E Movie 2 | A Movie 2 Movie 7 | B Movie 2 Movie 7 | C Movie 7");
		_movies.put(4, "D Movie 2 | A Movie 2 | B Movie 2 | F Movie 3 | G Movie 3");
	}

	public String getMovies(int s, int v){
		String result = "";
		// just getting corresponding character
		int rem = v % 26;
		char l = (char)((int)'A' + rem);
		//System.out.println("this is char "+l);
		String movie = _movies.get(s);
		String [] tokens = movie.split("\\|");
		for(int i = 0; i < tokens.length; i++){
			String next = tokens[i];
			if(next.contains(String.valueOf(l))){
				result = next;
				break;
			}
		}
		return result;
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


	String query(int source, int dest){
		List<Integer> nodes = new LinkedList<Integer>();
		int i, element;
		visited[source] = source;
		queue.add(source);
		while(!queue.isEmpty()){
			element = queue.remove();
			i = element;
			if(i == dest) break; // we stop as soon as we reach destination
			nodes.add(element);
			List<Integer> iList = getEdge(i);
			System.out.println(i+" -> "+iList);
			int x = 0; 
			while(x < iList.size()){
				int index = iList.get(x);
				if(visited[index] == -1){
					queue.add(index);
					visited[index] = i;
				}
				x++;
			}
		}
		String result = "";
		for(int x = dest; x >= 0; x= visited[x]){
			if(x == source) break; // we are done
			if(visited[x] != -1){
				result += getMovies(x,visited[x]); // get predecessor of x movies from x
			}
		}
		
		return result;
	}

/*
Enter number of vertices and edges in this graph
5 2
Enter edges in graph.. i.e. <source> 1 <destination> 2
0 2
0 4
Enter source and destination vertex: 
2 4
 * 
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
			BaconNumber bn = new BaconNumber(V);
			

			// get edge in graph
			System.out.println("Enter edges in graph.. i.e. <source> 1 <destination> 2");
			while(count < E){
				source = sc.nextInt();
				dest = sc.nextInt();
				bn.setEdge(source, dest);
				count++;
			}
			bn.fillNeighbors(); // fill the neighbors here
			System.out.println("Enter source and destination vertex: ");
			start = sc.nextInt();
			destination = sc.nextInt();
			System.out.println(bn.query(start, destination));
		}catch(InputMismatchException e){
			System.out.println("Error in input format");
		}
		sc.close();

	}


}
