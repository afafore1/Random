import java.util.Arrays;
import java.util.Scanner;


public class BinarySearchTree {
	private int data;
	private BinarySearchTree left;
	private BinarySearchTree right;
	
	public BinarySearchTree(int num){
		this.data = num; // set data to num
		this.left = null; // left and right doesn't have a value when we begin operation
		this.right = null;
	}
	
	public void addNode(int num){
		if(num < this.data){
			if(this.left != null){
				this.left.addNode(num);
				System.out.println("Inserting "+num+" to the left of "+this.data);
			}
			else{
				this.left = new BinarySearchTree(num);
				System.out.println("Inserting "+this.data);
			}
		}else{
			if(this.right != null){
				this.right.addNode(num);
				System.out.println("Inserting "+num+" to the right of "+this.data);
			}else{
				this.right = new BinarySearchTree(num);
				System.out.println("Inserting "+this.data);
			}
		}
	}
	
	public void preOrder(){
		System.out.println("Printing out in PreOrder "+this.data);
		if(this.left != null){
			this.left.preOrder();
		}
		if(this.right!= null){
			this.right.preOrder();
		}
	}
	
	public void InOrder(){
		if(this.left != null){
			this.left.InOrder();
		}
		System.out.println("Printing out in Order "+this.data);
		if(this.right != null){
			this.right.InOrder();
		}
	}
	
	public void PostOrder(){
		if(this.left != null){
			this.left.PostOrder();
		}
		if(this.right != null){
			this.right.PostOrder();
		}
		System.out.println("Printing out in Post Order "+this.data);
	}

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree(20);
		int [] nums = {15, 200, 25, -5, 0, 100, 20, 12, 126, 1000, -150};
		for(int i : nums){
			tree.addNode(i);
		}
		//Insert();
		tree.InOrder();
		tree.PostOrder();
		tree.preOrder();	
		
		

	}

}
