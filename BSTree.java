/*Name: Ayomitunde Fafore
 * Class: CSC 3410
 */
import java.io.*;
import java.util.*;
import java.lang.Math;

public class BSTree {

	public static void main(String[] args) {
		new BSTree().run(); 

	}
	static class Node {
		// Initialize variable, and left and right nodes.
		Node left; // 
		Node right;
		int data;
		
		public Node(int data) {
			this.data = data;
		}
	}
	/*The run method consist of the the random integer that is used as the root
	 * Random numbers are also created in this method and are used throughout the
	 * application
	 * 
	 */
	public void run() {
		int k = (int)(100 * Math.random());
		//int rootOf = 0;
		
		Node root = new Node(k); // k is used as the root of the tree, k could be any number from the random numbers generated
		int i, j;
		System.out.println("Root: "+k);
		for (i = 0; i < 50; i++)
		{
			j = (int)(100 * Math.random());			
			System.out.println("Number: "+j);
			insert(root, j); // j consists of any random number generated
		}
		System.out.println("Traversing tree in order");
	    printInOrder(root);
		System.out.println("\n\n");
		
		
	}
	
	/*The insert method is created to insert nodes into the tree
	 * the value is checked for organization and placement of the node. 
	 * 
	 */
	
	public void insert(Node node, int data){
		/*If the node is greater than the former node, place it in the right side, 
		 * if it is lesser then place it at the left side.
		 * 
		 */
		if (data < node.data) { 
			if (node.left !=null){
				insert(node.left, data);
				
			}
			else
			{
				System.out.println("  Inserted " + data + " to left of " + node.data);
				node.left = new Node(data);
			}
		}
		else if (data > node.data) {
			if (node.right != null) {
				insert(node.right, data);
			}
			else {
				System.out.println("   Inserted " + data + " to right of " + node.data);
				node.right = new Node(data);
			}
			
		}
		
		
	}
	// printInOrder method used to sort the data and print them in order
	public void printInOrder(Node node) {
		if (node != null) {
			printInOrder(node.left);
			System.out.println("  Tranversed " + node.data);
			printInOrder(node.right);
		}
	}
		public void printInO(Node node, int re) {
		    if (node == null)
		      return;
		    if (node.data > re) {
		      // print in order
		      printInO(node.left, re);
		      System.out.println("  Traversed " + node.data);
		      printInO(node.right, re);
		    }
	
}
		public void printAllpaths(Node node, int [] path, int len){
			if(node == null)
				return;
			path[len] = node.data;
			len++;
			if(node.left == null && node.right == null){
				for(int i = 0; i < len; i++){
					System.out.println(path[i] +" ");
				}
				return;
			}
			printAllpaths(node.left,path,len);
			System.out.println();
			printAllpaths(node.right,path,len);
		}
}
