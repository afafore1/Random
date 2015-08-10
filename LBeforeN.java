import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Scanner;


public class LBeforeN {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next();
		long startTimer = System.currentTimeMillis();
		for(int i = a.length() -1; i > 0; i--){
			if(a.charAt(i) < a.charAt(i - 1)){
				System.out.println(a.substring(0, i-1) + getVal(a.substring(i-1, a.length())));
				return;
			}else{
				continue;
			}
		}
		long endTimer = System.currentTimeMillis();
		NumberFormat formatterr = new DecimalFormat("#0.00000");
		System.out.print("Execution time for binary recursive is " + formatterr.format((endTimer - startTimer) / 1000d) + " seconds\n");	
	}
	private static String getVal(String substring){
		if(substring.length() == 1){
			return substring;
		}
		char last = substring.charAt(substring.length() -1);
		String b = ""+last;
		char [] a = substring.substring(0, substring.length() -1).toCharArray();
		Arrays.sort(a);
		for(int i = a.length -1; i >= 0; i--){
			b = b + String.valueOf(a[i]);
		}
		return b;
	}

}
