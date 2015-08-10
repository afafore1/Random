import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;


public class NumberArray {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		boolean nfound = true;
		int [] nums = new int [200];
		int x = 600;
		StringBuilder arrs = new StringBuilder();
		while(nfound){
		for(int i = 0;i <nums.length;i++){
			int value = (int)((Math.random() * 499 + 1));
			nums[i] = value;
		}
		
		Arrays.sort(nums);
		int s = 0;
		int e = nums.length -1;
		while(s < e){
			int max = nums[e];
			int numfind = x - max;
			if(nums[s] != numfind){
				nfound = true;
			}
			else if(nums[s] == numfind){
				System.out.println(nums[s]+ "+"+max);
				arrs.append(nums[s]+ ","+nums[e]+ ";");
				nfound = false;
			}
			e--;
			s++;
		}
		}
		System.out.println(arrs.toString());
		long endTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");

	}

}
