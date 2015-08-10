package Cool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSDFS {
	private boolean [] checked;
	private int[] connectedTo;
	private final int SOURCE;
	
	public BFSDFS(Graph g, int rootVertex){
		checked = new boolean[g.verticesInGraph()];
		connectedTo = new int[g.verticesInGraph()];
		
		SOURCE = rootVertex;
		bfs(g, rootVertex);
		
		
	}
	private void bfs(Graph g, int source){
	Queue parentsQueue = new ArrayDeque();
	checked[source] = true;
	parentsQueue.add(source);
	while(!parentsQueue.isEmpty()){
		int parentVertex = (int) parentsQueue.remove();
		for(int child : g.getVerticesConnectedTo(parentVertex)){
			if(!checked[child]){
				connectedTo[child] = parentVertex;
				checked[child] = true;
				parentsQueue.add(child);
			}
		}
	}
	}
	
	public boolean hasPathTo(int vertex){
		return checked[vertex];
	}
	
	public List pathTo(int vertex){
		if(!hasPathTo(vertex)) return null;
		
		List path = new ArrayList();
		path.add(vertex);
		while(connectedTo[vertex] != SOURCE){
			vertex = connectedTo[vertex];
			path.add(vertex);
			
		}
		path.add(SOURCE);
		return path;
	}

}
