import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class b {
	private static Queue<Integer> queue;
	private static int [][] adjMatrix;
	private static List<Integer> set;
	final static int size = 10;
	b(){
		queue = new LinkedList<>();
		set = new LinkedList<>();
		adjMatrix = new int [size][size];
	}
	
	static void bfs(int source){
		boolean [] visited = new boolean[size+1];
		visited[source] = true;
		queue.add(source);
		while(!queue.isEmpty()){
			int current = queue.remove();
			set.add(current);
			for(int i = 0; i < size; i++){
				if(adjMatrix[current][i] == 1 && !visited[i]){
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}
	
	static void printOrder(){
		for(int i = 0; i < set.size(); i++){
			System.out.println(set.get(i));
		}
	}
	
	@SuppressWarnings("resource")
	static void fillMatrix(){
		try {
			Scanner sc = new Scanner(new File("ya"));
			int x = 0;
			while(sc.hasNextLine()){
				String line = sc.nextLine();
				String [] tokens = line.split(" ");
				for(int i = 0; i < tokens.length; i++){
					int curr = Integer.parseInt(tokens[i]);
					adjMatrix[x][i] = curr;
				}
				x++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("No file");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new b();
		b.fillMatrix();
		b.bfs(0);
		printOrder();
		

	}

}
