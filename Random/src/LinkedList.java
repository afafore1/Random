
class Linked {

	private Node head;
	private int listCount;
	
	public LinkedList(){
		head = new Node(null); // head will start will null
		listCount = 0; // initialize count cos we will return size 
	}
	
	public void add(Object data){
		Node temp = new Node(data);
		Node current = head;
		
		while(current.getNext() != null){
			current = current.getNext();
		}
		current.setNext(temp);
		listCount++;
	}
	
	public void add(Object data, int index){
		Node temp = new Node(data); // storing as objects cos it can be any type
		Node current = head;
		for(int i = 0; i < index && current.getNext() != null; i++){
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		listCount++;
	}
	
	public Object get(int index){
		if(index < 0) return null;
		Node current = head.getNext();
		for(int i = 0; i < index; i++){
			if(current.getNext() == null) return null;
			current = current.getNext();
		}
		return current.getData();
	}
	
	public int size(){
		return listCount;
	}
	
	public boolean remove(int index){
		if(index < 0 || index > size()){
			return false;
		}
		Node current = head;
		for(int i = 0; i < index; i++){
			if(current.getNext() == null){
				return false;
			}
			current = current.getNext();
		}
		current.setNext(current.getNext().getNext());
		listCount--;
		return true;
	}
	
	public String toString(){
		Node current = head.getNext();
		String output = "[";
		while(current != null){
			output += current.getData().toString()+", ";
			current = current.getNext();
		}
		output+="]";
		return output;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	private class Node{
		Node next; //next node
		Object data; 
		
		public Node(Object _data){ // injecting into the constructor
			next = null; // next is always null
			data = _data;
		}
		
		public Node(Object _data, Node _next){
			next = _next;
			data = _data;
		}
		
		public Object getData(){
			return data;
		}
		
		public void setData(Object _data){
			data = _data;
		}
		
		public Node getNext(){
			return next;
		}
		
		public void setNext(Node _next){
			next = _next;
		}
	}

}
