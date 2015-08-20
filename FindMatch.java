import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import com.ayo.getforge.*;

public class Twitter1 {
	public static int binarySearch(Integer[] nums, int key) {
		// sample: [2, 3, 3, 4, 5, 6, 20, 23, 23, 32, 45, 50, 53, 453]
		int lo = 0; // start of array
		int hi = nums.length - 1; // end of array
		while (lo <= hi) {
			// Key is in a[lo..hi] or not present.
			int mid = lo + (hi - lo) / 2; // mid point
			if      (key < nums[mid]) hi = mid - 1; //
			else if (key > nums[mid]) lo = mid + 1;
			else return mid;
		}
		return -1;
	}
	public static void findNums(Integer [] nums, int findSum){
		
		boolean nfound = true;
		int numsFound1 = 0;
		int i1 = 0;
		while(nfound){ // if even, 10.. 
			int x1 = i1+1;
			if(x1 == nums.length - 1) nfound = false;
			int f1 = nums[i1];
			int s1 = nums[x1];
			for(int o1 = x1+1; o1 < nums.length; o1++){
				if(f1+s1+nums[o1] == findSum){
					int key = nums[o1];
					if(binarySearch(nums,key) != -1){
						numsFound1++; 
						System.out.println(f1+" + "+s1+" + "+key+ " found "+numsFound1);
					}
				}
			}if(numsFound1 == 50)nfound = false;
			i1++;
		}
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What number yo? ");
		int findSum = sc.nextInt();
		HashSet<Integer> theSet = new <Integer>HashSet();
		while(theSet.size()<3000){
			theSet.add((int)(Math.random()*9000));
		}
		Integer[] nums = theSet.toArray(new Integer[theSet.size()]);
		Arrays.sort(nums);
		long start = System.currentTimeMillis();
		boolean Notfound = true;
		int i = 0;
		int numsFound = 0;
		while(Notfound){
			int x = i+1; // Arrayoutofboundindex here.. can be fixed.. 
			if(x == nums.length - 1) Notfound = false;
			int f = nums[i]; //{1,34,4,56,6,56,7634,3,34,34}
			int s = nums[x]; //f = 1, s = 34
			for(int o = x+1; o < nums.length;o++){
				int t = findSum - f + s;
				int testSum = f+s+nums[o];
				if(testSum == findSum){
					numsFound++; System.out.println(f+" + "+ s+" + "+nums[o] + " found "+numsFound); 
				}
			}
			if(numsFound == 50)Notfound = false; // this is just to find 10 different combinations.
			i++;
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken "+(end-start)+" ms");
		
		start = System.currentTimeMillis();
		findNums(nums,findSum);
		end = System.currentTimeMillis();
		System.out.println("Time taken "+(end - start)+" ms");

	}

}
