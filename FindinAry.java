import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class FindinAry {
	
	public static boolean useList(String[] arr, String target){
		return Arrays.asList(arr).contains(target);
	}
	
	public static boolean useSet(String [] arr, String target){
		Set<String> set = new HashSet<String>(Arrays.asList(arr));
		return set.contains(target);
	}
	
	public static boolean sLoop(String [] arr, String target){
		for(String s : arr){
			if(s.equals(target)){
				return true;
			}
		}
		return false;
	}
	
	public static boolean BinSearch(String [] arr, String target){
		int a = Arrays.binarySearch(arr, target);
		if(a > 0)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] arr = new String[] { "CD", "BC", "EF", "DE", "AB"};
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			useList(arr, "A");
		}
		long endTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");
		
		long starttTime = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			useSet(arr, "A");
		}
		long enddTime = System.currentTimeMillis();
		NumberFormat formattter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time is " + formatter.format((enddTime - starttTime) / 1000d) + " seconds\n");
		
		long startingTime = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			sLoop(arr, "A");
		}
		long endingTime = System.currentTimeMillis();
		NumberFormat formtter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time is " + formatter.format((endingTime - startingTime) / 1000d) + " seconds\n");
		
		long mstartTime = System.currentTimeMillis();
		for(int i = 0; i < 100000; i++){
			BinSearch(arr, "A");
		}
		long mendTime = System.currentTimeMillis();
		NumberFormat formter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time is " + formatter.format((mendTime - mstartTime) / 1000d) + " seconds\n");
		


	}

}
