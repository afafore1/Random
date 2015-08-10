import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Collections;

public class findNum{
	
	public static void find(int[] arr, int x){
		long startTime = System.currentTimeMillis();
		Arrays.sort(arr);
		int len = arr.length -1;
		int st = 0;
		int a = 0;
		int b = 0;
		while(len > b){
			int mid = (len+b)/2;
			if(arr[mid] > x){
				mid--;
				len = mid;
			}
			else if(arr[mid] < x){
				a = arr[mid];
				if(a + arr[b] == x){
					System.out.println("A: "+a+" B: "+b);
					b++;
				}else{
					len = mid;
				}
			}

		}
		long endTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time for sp is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");
		
		
	}
	public static void main(String []args){
		long start = System.currentTimeMillis();
		int [] nums = new int [2000000];
		for(int i = 0; i < nums.length; i++){
			nums[i] = (int) (Math.random() * 2000000);
		}
		Arrays.sort(nums);
		Collections.shuffle(Arrays.asList(nums));
//		System.out.println(Arrays.toString(nums));
		int x = 600000;
//		int count = 0;
//		boolean goteeem = false;
//		for(int i = 0;i < nums.length;i++){
//			for(int j = 0;j < i; j++){
//				if(nums[i] + nums[j] == x){
//					System.out.println("GOT EEEEM! A = " + nums[i] + " B = " + nums[j]);
//					goteeem = true;
//					//break;
//				}
//			}
//			if(goteeem) 
//				count++;
//		}
		find(nums, x);
		long stop = System.currentTimeMillis();
		System.out.println("Time elapsed: " + (stop - start) + " ms");
//		System.out.println(count);
//		long endTime = System.currentTimeMillis();
//		NumberFormat formatter = new DecimalFormat("#0.00000");
//		System.out.print("\nExecution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");
		//find(nums, x);

	}
}