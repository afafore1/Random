import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

import com.ayo.getforge.*;

public class Twitter1 {
	static int MAX_FIND = 50;
	// From leetcode ... too slow ? Better way to solve this.. I think so. 
	public static ArrayList<ArrayList<Integer>> fourSum(Integer[] num, int target){
		Arrays.sort(num);

		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		for(int i = 0; i < num.length; i++){
			for(int j = i+1; j < num.length; j++){
				int k = j+1;
				int l = num.length -1;

				while(k < l){
					int sum = num[i] + num[j] + num[k] + num[l];
					if(sum > target){
						l--;
					} else if(sum < target){
						k++;
					}else if(sum == target){
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(num[i]);
						temp.add(num[j]);
						temp.add(num[k]);
						temp.add(num[l]);

						if(!hashSet.contains(temp)){
							hashSet.add(temp);
							result.add(temp);
						}

						k++;
						l--;
					}
				}
			}
		}
		return result;
	}



	public static int[] twoSum(Integer[] nums, int target){
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int [] result = new int[2];

		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				int index = map.get(nums[i]);
				result[0] = index+1;
				result[1] = i+1;
				break;
			}else{
				map.put(target-nums[i], i);
			}
		}
		return result;
	}

	public static String getPair(Integer[] arr, int target){
		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
		String result = "";
		for(int i = 0; i < arr.length; i++){
			hm.put(arr[i], arr[i]);
		}

		for(int i = 0; i < arr.length; i++){
			if(hm.get(target - arr[i]) != null){
				result +=arr[i] + ","+(target-arr[i]+"; ");
			}
		}
		return result;
	}

	public static int threeSumClosest(Integer[] nums, int target){
		int min = Integer.MAX_VALUE;
		int result = 0;

		Arrays.sort(nums);
		for(int i = 0; i < nums.length; i++){
			int j = i +1;
			int k = nums.length -1;
			while(j < k){
				int sum = nums[i] + nums[j] + nums[k];
				int diff = Math.abs(sum-target);
				if(diff == 0) return sum;
				if(diff < min){
					min = diff;
					result = sum;
				}if(sum <= target){
					j++;
				}else{
					k--;
				}
			}
		}
		return result;
	}

	// mine starts here 
	public static String threeSumE(Integer[] nums, int target){
		Arrays.sort(nums);
		String result = "";
		int count = 0;
		for(int i = 0; i < nums.length; i++){
			int nexti = i+1;
			int end = nums.length-1;
			while(nexti < end){
				int sum = nums[i] + nums[nexti] + nums[end];
				if(sum == target) {
					count++; 
					result += nums[i]+","+nums[nexti]+","+nums[end]+"; ";
				}
				if(sum < target){
					nexti++;
				}else{
					end--;
				}
				if(count == MAX_FIND) break;
			}

		}
		return result;
	}

	// this should be better but it only is in some cases... find better way .. ? spend more time on this ayo !!
	public static String BthreeSumE(Integer[] nums, int target){
		Arrays.sort(nums); // sort the array
		String result = ""; // result will be stored here 
		int count = 0; // keep count of the results 
		int mid = nums.length/2; // mid-point of array
		if(target < nums[mid]){ // check if the number we are looking for is smaller than what's in the middle, discard anything greater
			for(int i = 0; i < mid; i++){
				int ni = i+1;
				int e = mid;
				while(ni < e){ // while next increment of i is less than the middle.. (which is end now in this case)
					int s = nums[i] + nums[ni] + nums[e]; // add them all
					if(s == target){ // if our sum is the desired number, increment count and store result
						count++;
						result+= nums[i]+","+nums[ni]+","+nums[e]+"; ";
					}
					if(s < target){ // if the sum is less than the number we want.. we need to move on to next increment
						ni++;
					}else{ // if sum is greater than target, decrease our end
						e--;
					} if(count == MAX_FIND)break;
				}
			}
		}
		else if(target > nums[nums.length-1]){ // if this number is soooooo :) great than max in array
			for(int i = nums.length-1; i > 0; i--){ // start adding from end of array
				int begin = 0;
				int n = begin+1;
				while(n < i){
					int sum = nums[i]+nums[n]+nums[begin];
					if(sum == target){
						count++;
						result +=nums[i]+","+nums[n]+","+nums[begin]+"; ";
					}
					if(sum > target){
						i--;
						//i--;
					}else{
						n++;
						begin++;
					}
					if(count == MAX_FIND) break;
				}
			}
		}
		else{
			System.out.println("ti's greater yo ");
			for(int i = 0; i < nums.length; i++){
				int nexti = mid/2;
				int end = nums.length-1;
				while(nexti < end){
					int sum = nums[i] + nums[nexti] + nums[end];
					if(sum == target) {
						count++; 
						result += nums[i]+","+nums[nexti]+","+nums[end]+"; ";
					}
					if(sum < target){
						nexti++;
					}else{
						end--;
					}
					if(count == MAX_FIND) break;
				}
			}
		}
		return result;
	}
	public static String JTSumE(Integer[] nums, int target){
		Arrays.sort(nums);
		String result = "";
		int count = 0;
		for(int i = 0; i < nums.length; i++){
			int nexti = i+1;
			int end = nums.length-1;
			while(nexti < end){
				int sum = nums[i] + nums[nexti] + nums[end];
				if(sum == target) {
					count++; 
					result += nums[i]+","+nums[nexti]+","+nums[end]+"; ";
				}
				if(sum < target){
					i++;
					nexti++;
				}else{
					end--;
				}
				if(count == MAX_FIND) break;
			}

		}
		return result;
	}



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
	public static String findNums(Integer [] nums, int findSum){
		Arrays.sort(nums);
		boolean nfound = true;
		String result = "";
		int numsFound1 = 0;
		int i1 = 0;
		while(nfound){ 
			int x1 = i1+1;
			if(x1 == nums.length - 1) nfound = false;
			int f1 = nums[i1];
			int s1 = nums[x1];
			for(int o1 = x1+1; o1 < nums.length; o1++){
				if(f1+s1+nums[o1] == findSum){
					int key = nums[o1];
					if(binarySearch(nums,key) != -1){
						numsFound1++; 
						result+= f1+","+s1+","+key+ "; ";
					}
				}
			}if(numsFound1 == MAX_FIND){
				nfound=false;
			}
			i1++;
		}
		return result;
	}

	public static String noLogic(Integer [] nums, int findSum){
		Arrays.sort(nums);
		boolean Notfound = true;
		int i = 0;
		int numsFound = 0;
		String result = "";
		while(Notfound){
			int x = i+1; // Arrayoutofboundindex here.. can be fixed.. 
			if(x == nums.length - 1) Notfound = false;
			int f = nums[i]; //{1,34,4,56,6,56,7634,3,34,34}
			int s = nums[x]; //f = 1, s = 34
			for(int o = x+1; o < nums.length;o++){
				int testSum = f+s+nums[o];
				if(testSum == findSum){
					numsFound++;
					result+= f+","+ s+","+nums[o]+"; "; 
				}
			}
			if(numsFound == MAX_FIND){
				Notfound = false; // this is just to find 10 different combinations.
			}
			i++;
		}
		return result;
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("What number yo? ");
		int findSum = sc.nextInt();
		HashSet<Integer> theSet = new <Integer>HashSet();
		while(theSet.size()<3000){
			theSet.add((int)(Math.random()*9000000));
		}
		Integer[] nums = theSet.toArray(new Integer[theSet.size()]);

		long start = System.nanoTime();
		System.out.println(noLogic(nums, findSum));
		long end = System.nanoTime();
		System.out.println("Time taken for noLogic "+(end-start)+" ns\n");

		start = System.nanoTime();
		System.out.println(findNums(nums,findSum));
		end = System.nanoTime();
		System.out.println("Time taken for findNums "+(end - start)+" ns\n");

		start = System.nanoTime();
		System.out.println("For threesumsE "+threeSumE(nums, findSum));
		end = System.nanoTime();
		System.out.println("Time taken "+(end - start)+" ns\n");

		start = System.nanoTime();
		System.out.println("For JTSumE "+JTSumE(nums, findSum));
		end = System.nanoTime();
		System.out.println("Time taken "+(end - start)+" ns\n");

		start = System.nanoTime();
		System.out.println("For BthreesumsE "+BthreeSumE(nums, findSum));
		end = System.nanoTime();
		System.out.println("Time taken "+(end - start)+" ns\n");

	}

}



/*
 * array - [2,3,54,6,4,4,5,6,7,7,6,4,4,6,67,7,76,67,54,4]
 * 30
 */
