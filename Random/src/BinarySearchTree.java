import java.util.Arrays;

class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}
}
public class BinarySearchTree {
	public static Node root;
	
	public BinarySearchTree(){
		this.root = null;
	}
	
	public boolean find(int key){
		Node current = root;
		while(current != null){
			if(current.data == key){
				return true;
			}else if(current.data > key){
				current = current.left;
			}else{
				current = current.right;
			}
		}
		return false;
	}
	
	public boolean delete(int key){
		Node parent = root;
		Node current = root;
		boolean isLeftChild = false;
		while(current.data != key){
			parent = current;
			if(current.data > key){
				isLeftChild = true;
				current = current.left;
			}else{
				isLeftChild = false;
				current = current.right;
			}
			if(current == null){
				return false;
			}
		}
		
		if(current.left == null && current.right == null){
			if(current == root){
			root = null;
			}
		if(isLeftChild){
			parent.left = null;
		}else{
			parent.right = null;
		}
	}
	else if(current.right == null){
		if(current == root){
			root = current.left;
		}else if(isLeftChild){
			parent.left = current.left;
		}else{
			parent.right = current.left;
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
		
		int [] nums = new int [20];
		for(int i = 0; i < nums.length; i++){
			nums[i] = (int) (Math.random() * 100); 
		}
		System.out.println("Numbers are "+Arrays.toString(nums));
		BinarySearchTree tree = new BinarySearchTree(nums[0]);
		for(int i : nums){
			tree.addNode(i);
		}
		//Insert();
		tree.InOrder();
		tree.PostOrder();
		tree.preOrder();	
		
		

	}

}