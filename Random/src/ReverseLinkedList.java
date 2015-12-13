import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class ReverseLinkedList {

	public static void main(String[] args) {
		List<Integer> nums = new LinkedList<>();
		Stack <Integer> revNums = new Stack<>();
		for(int i = 0; i < 10; i++){
			nums.add((int)(Math.random() * 100 ));
		}
		System.out.println(nums);
		for(int i : nums){
			revNums.push(i);
		}
		while(!revNums.isEmpty()){
			System.out.print(revNums.pop()+" ");
		}

	}

}
