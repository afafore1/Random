import java.util.ArrayDeque;
import java.util.Deque;

public class LinkedListReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList(5);
		ll.next = new LinkedList(4);
		ll.next = new LinkedList(9);
		ll.next = new LinkedList(0);
		ll.next = new LinkedList(5);
		
		System.out.println("Original LinkList "+ll.toString());
		
		ll = recurReverse(ll);
		System.out.println("Recursive LinkedList "+ll.toString());
		ll = iterReverse(ll);
		System.out.println("Iterative LinkedList "+ll.toString());
	}
	
	public static LinkedList recurReverse(LinkedList ll){
		if(ll == null || ll.next == null){
			return ll;
		}
		LinkedList remainingReverse = recurReverse(ll.next);
		LinkedList current = remainingReverse;
		while(current.next != null){
			current = current.next;
		}
		current.next = ll;
		ll.next = null;
		
		return remainingReverse;
	}
	
	public static LinkedList iterReverse(LinkedList ll){
		if(ll == null || ll.next == null){
			return ll;
		}
		LinkedList prevNode, currentNode, nextNode;
		prevNode = null;
		nextNode = null;
		currentNode = ll;
		while(currentNode != null){
			nextNode = currentNode.next;
			currentNode = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		return prevNode;
	}
}
		class LinkedList{
			public LinkedList next;
			public int value;
			
			public LinkedList(int value){
				this.value = value;
				this.next = null;
			}
			public String toString(){
				String data = "";
				LinkedList current = this;
				do{
					data += current.value + ",";
					current = current.next;
				}while(current != null);
				return data;
			}
		}
