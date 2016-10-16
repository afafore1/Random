import java.util.Arrays;
import java.util.HashMap;

public class lab3 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int target = 100;
		HashMap<Integer, Integer> twoSum = new HashMap<>();
		int[] arr = new int[100];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * 100);
		}
		
		for(int i = 0; i < arr.length; i++){
			if(twoSum.containsKey(arr[i])){
				int sum = arr[i] + twoSum.get(arr[i]);
				System.out.println(arr[i]+" + "+twoSum.get(arr[i])+" = "+sum);
			}else{
				twoSum.put(target - arr[i], arr[i]); // 56, 44
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken is "+(end - start)+" ms");
		System.out.println(Arrays.toString(arr));
	}

}
