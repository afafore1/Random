import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

	private HashMap<Integer, LinkedList<Integer>> nodes;
	private Stack<Integer> stack;
	private boolean [] visited;
	Stack<Integer> temp;
	int size = 5;
	
	TopologicalSort(){
		nodes = new HashMap<>();
		stack = new Stack<>();
		temp = new Stack<>();
		visited = new boolean[size+1];
	}
	
	void addNode(int x){
		nodes.put(x, new LinkedList<Integer>());
	}
	
	LinkedList<Integer> getList(int x){
		return nodes.get(x);
	}
	void addEdge(int x, int y){
		getList(x).add(y);
	}
	
	void makeList(){
		for(int i = 1; i <= 5; i++){
			addNode(i);
			visited[i] = false;
		}
		
		addEdge(1,2);
		addEdge(1,3);
		addEdge(1,4);
		addEdge(3,5);
		addEdge(2,5);
		addEdge(4,5);

	}
	
	void TopoSort(int i){
		visited[i] = true;
		Iterator<Integer> children = getList(i).iterator();
		while(children.hasNext()){
			int nextChild = children.next();
			if(!visited[nextChild]){
				TopoSort(nextChild);
			}
		}
		stack.push(i);
	}
	
	void start(){
		for(int i = 1; i <= size; i++){
			if(!visited[i]){
				TopoSort(i);
			}
		}
	}
	
	void printStack(){
		while(!stack.isEmpty()){
			System.out.println(stack.pop()+" ");
		}
	}
	public static void main(String[] args) {
		TopologicalSort tps = new TopologicalSort();
		tps.makeList();
		tps.start();
		tps.printStack();

	}

}
