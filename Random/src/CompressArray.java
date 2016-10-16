import java.util.Arrays;
import java.util.HashMap;

public class CompressArray {

	public static int[] copyArray(int [] num){
	    int x = 0;
	    int numDuplicate = 0;
	    int[] copy = new int[num.length]; // we use this to copy the non duplicates
	    HashMap<Integer, Integer> count = new HashMap<>(); //hashmap to check duplicates
	    for(int i = 0; i < num.length; i++){
	        if(count.containsKey(num[i])){
	            count.put(num[i], count.get(num[i])+1);
	            numDuplicate++; // keep track of duplicates
	        }else{
	            count.put(num[i], 1); // first occurence
	            copy[x] = num[i]; // copy unique values, empty values will be at end
	            x++;
	        }
	    }
	    // return only what is needed
	    int newSize = num.length - numDuplicate;
	    num = new int[newSize];
	    for(int i = 0; i < num.length; i++){
	    	num[i] = copy[i];
	    }
	    return num;
	}
	
	public static int[] jacks(int [] num){
		int maxValue = ~((-1) >>> 1); // Smallest number possible for int.
        int minValue = (-1) >>> 1; // Biggest number possible for int.
        for (int i = 0; i < num.length; i++) {
            if (maxValue < num[i]) maxValue = num[i];
            if (minValue > num[i]) minValue = num[i];            
        }
//        System.out.println(maxValue+" "+minValue);
//        System.out.println(maxValue - minValue + 1);
        boolean[] existedOrNaw = new boolean[maxValue - minValue + 1];
        int realSize = 0;
        for (int i = 0; i < num.length; i++) {
            if (!existedOrNaw[num[i] - minValue]) {
                realSize++;
                existedOrNaw[num[i] - minValue] = true;
            }
        }
        int[] resultArrayBecauseAyoDidntLetUsUseASeparateDataStructure = new int[realSize];
        int j = 0;
        existedOrNaw = new boolean[maxValue - minValue + 1];
        for (int i = 0; i < num.length; i++) {
            if (!existedOrNaw[num[i] - minValue]) {
                resultArrayBecauseAyoDidntLetUsUseASeparateDataStructure[j++] = num[i];
                existedOrNaw[num[i] - minValue] = true;
            }
        }        
		return resultArrayBecauseAyoDidntLetUsUseASeparateDataStructure;
	}


	public static void main(String[] args) {
	    // sample elements
	    int[] nums = new int[150];
	    for(int i = 0; i < nums.length; i++){
	        nums[i] = (int)(Math.random() * 20);
	    }
	    System.out.println("Actual array "+ Arrays.toString(nums)+" with length of "+nums.length);
	    System.out.println("My answer "+Arrays.toString(copyArray(nums))+" with length of "+copyArray(nums).length);
	    System.out.println("Jack's answer "+Arrays.toString(jacks(nums))+" with length of "+jacks(nums).length);

	}
}
