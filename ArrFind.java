import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class ArrFind {
	
	public static void findPairs(Integer[] nums,int x){
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		int count = 0;
		for(int i = 0; i < nums.length; i++){
			if(pairs.containsKey(nums[i])){ // check if key exist.. 
				System.out.println(nums[i] +","+pairs.get(nums[i])+";"); // if yes put it in, and get it's pair to sum
				break;
				//count++;
			}else{
				pairs.put(x-nums[i], nums[i]); // else, put x-current number, to equal value
			}
		}
		System.out.println(count);
	}
	
	public static int binarySearch(Integer[] a, int key) {

		 int lo = 0;
	        int hi = a.length - 1;
	        while (lo <= hi) {
	            // Key is in a[lo..hi] or not present.
	            int mid = lo + (hi - lo) / 2;
	            if      (key < a[mid]) hi = mid - 1;
	            else if (key > a[mid]) lo = mid + 1;
	            else return mid;
	        }
	        return -1;
	    }
	
	public static void findP(Integer [] arr, int x){
		int a = 0;
		for(int i = arr.length -1; i >0; i--){
			if(arr[i] < x){
				a = arr[i];
			}
			int b = x - a;
			System.out.println(binarySearch(arr,b));
		}
		
	}

	public static void main(String[] args) {
		HashSet<Integer> theSet = new <Integer>HashSet();
		while(theSet.size()<1000000){
			theSet.add((int)(Math.random()*2000000));
		}
		Integer[] nums = theSet.toArray(new Integer[theSet.size()]);
		int x = 600000;
		long start = System.currentTimeMillis();
		findPairs(nums,x);
		long stop = System.currentTimeMillis();
		System.out.println("Time elapsed: " + (stop - start) + " ms");
		//findP(nums,x);
		
	}

}
