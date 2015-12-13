import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SortStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s = new Stack<>();
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < 20; i++){
			int val = (int)(Math.random() * 100 + 1);
			s.add(val); // add random numbers to the stack
			q.add(val);
		}
		System.out.println(Arrays.toString(s.toArray())); //[0,9,4,20] --> [20] -> [4,20]-> [0,4,9,20] --> [20,9,4,0]
		q.add(s.pop()); // add first element
		while(!s.isEmpty()){
			int c = s.pop();
			for(int i = 0; i < q.size(); i++){
				int peek = q.peek(); // 20
				if(peek > c){
					int temp = q.poll();
					q.add(c);
					q.add(temp);
				}
			}
		}
		for(int i = 0; i < q.size(); i++){
			s.add(q.poll());
		}
		System.out.println(Arrays.toString(s.toArray()));

	}

}
