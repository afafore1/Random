import java.util.LinkedList;

import javax.xml.soap.Node;


public class CheckLengthLinkedList {
	public int length(){
		int count = 0;
		Node current = this.head;
		while(current != null){
			count++;
			current = current.next();
		}
		return count;
	}
	
	public static int rlength(Node current){
		if(current == null){
			return 0;
		}
		return 1+length(current.next());
	}

	public static void main(String[] args) {
		LinkedList l = new LinkedList();
		l.add("B");
		l.add("C");
		l.add("Y");
		l.add(0, "Z");
		int count = 0;
		for(int i = 0;i < l.size();i++){
			count++;
		}
		System.out.println("count is "+count);
		System.out.println(l);
		Object val = l.get(3);
		System.out.println(val);
		

	}

}
