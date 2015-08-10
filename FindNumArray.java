import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;


public class FindNumArray {
	
	public static void findPairs(Integer[] nums,int x){
		long st = System.currentTimeMillis();
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		int count = 0;
		for(int i = 0; i < nums.length; i++){
			if(pairs.containsKey(nums[i])){ // check if key exist.. 
				//System.out.println(nums[i] +","+pairs.get(nums[i])+";"); // if yes put it in, and get it's pair to sum
				count++;
			}else{
				pairs.put(x-nums[i], nums[i]); // else, put x-current number, to equal value
				//System.out.println(pairs);
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(count);
		System.out.println((end - st)+" ms");
	}

	public static void main(String[] args) {
		HashSet<Integer> theSet = new <Integer>HashSet();
		while(theSet.size()<1000000){
			theSet.add((int)(Math.random()*2000000));
		}
		Integer[] nums = theSet.toArray(new Integer[theSet.size()]);
		int x = 600000;
		int count = 0;
		findPairs(nums,x);
		long start = System.currentTimeMillis();
		Arrays.sort(nums);
		int pivot = x / 2;
		int pivotIndex = -1;
		int xIndex = -1;
		while(pivotIndex < nums.length-1 && nums[++pivotIndex]<pivot);
		while(xIndex < nums.length-1 && nums[++xIndex]<x);
		if(nums[pivotIndex]<pivot){
			System.out.println("There ain't no way man!");
		}else{
			boolean foundOrNah = false;
			for(int i = 0; i <= pivotIndex;i++){
				if(contains(x-nums[i],nums,pivotIndex+1,xIndex)){
					//System.out.println("GOT EEM! A = " + nums[i] + " B = " + (x-nums[i]));
					count++;
					foundOrNah = true;
				}
			}
			if(!foundOrNah) 
				System.out.println("Can't see nu'in brah!");
		}
		System.out.println("Found " + count);
		long stop = System.currentTimeMillis();
		System.out.println("Time elapsed: " + (stop - start) + " ms");
	}
	
	public static boolean contains(int theNum, Integer[] nums, int lo, int hi){
		while(true){// Binary search
			if(hi-lo<=1){
				if(nums[hi] == theNum || nums[lo] == theNum) return true;
				return false;
			}
			int ind = (lo+hi)/2;
			int i = nums[ind];
			if(i == theNum){
				return true;
			}else if(theNum < i){
				hi = ind;
			}else{
				lo = ind;
			}
		}

	}

}
