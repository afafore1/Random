import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class threeSumProb {

	static int binarySearch(Integer[] nums, int key){
		int start = 1;
		int end = nums.length -1;
		while(start < end){
			int mid = start + (end - start)/2;
			if(key < nums[mid]){
				end = mid -1;
			}else if(key > nums[mid]){
				start = mid+1;
			}else{
				return mid;
			}
		}
		return -1;

	}
	static void findNums2(int S, Integer [] nums){
		int count = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++){
			int n = i+1;
			int end = nums.length -1;
			while(n < end){
				if(end/2 > S) end /=2;
				int search = S - (nums[i] + nums[n]); // search for remain
				if(!(search > 0)) continue;
				//System.out.println(S+" "+nums[i]+" "+nums[n] + " "+search);
				int fsearch = binarySearch(nums,search);
				if(fsearch != -1) {
					count++;
					int sum = nums[i] + nums[n] + nums[fsearch];
					System.out.println(nums[i] + " + "+nums[n]+" + "+nums[fsearch]+" = "+sum+"; ");
					if(count == 300) System.exit(0);;
				}else{
					end--;
				}
				n++;
			}
			
		}
	}

	static void findNums(int S, Integer [] nums){
		int count = 0;
		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++){
			if(count == 30) {
				break;
			}
			int n = i+1;
			int end = nums.length -1;
			while(n < end){
				int sum = nums[i] + nums[n] + nums[end]; // get the sum of all 3
				if(sum == S) {
					System.out.println(nums[i] + " + "+nums[n]+" + "+nums[end]+" = "+sum+"; ");
					count++;
					System.out.println(count);
				}
				if(sum < S){
					n++;
				}else{
					end--;
				}
			}
			

		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> set = new HashSet<Integer>();
		while(set.size() < 1000){
			set.add((int)(Math.random() * 3000));
		}
		Integer[] nums = set.toArray(new Integer[set.size()]);
		long start = System.currentTimeMillis();
		findNums(2000, nums);
		long end = System.currentTimeMillis();
		System.out.println("Time taken for findNums is "+(end - start)+" ms");
		findNums2(2000, nums);


	}

}
