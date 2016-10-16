import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class kdl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> nums = new HashSet<>();
		nums.add(3);
		nums.add(7);
		nums.add(9);
		Stack<Integer> d = new Stack<Integer>();
		Iterator<Integer> t = nums.iterator();
		while(t.hasNext()){
			int n = t.next();
			System.out.println(n);
			d.push(n);
			if(t.hasNext() == false){
				int poped = d.pop();
				System.out.println("this poped "+poped);
			}
		}
		char ch = 'c';
		int pos = ch - 'a' + 1;
		System.out.println(pos);
		
		int n = 4;
		int rem = n % 26;
		char l = (char)((int)'A' + rem);
		System.out.println(l);

	}

}
