import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;


public class reversenum {
	
	public static long getR(long num){
		long reverse = 0;
		while(num != 0){
			reverse = reverse * 10; // 0.. 50
			reverse = reverse + (num % 10); //531
			num /= 10;//1
		}
		return reverse;
	}
	
	public static String reverse(long num){
		StringBuilder str = new StringBuilder();
		char [] s = String.valueOf(num).toCharArray();
		for(int i = s.length -1; i >= 0; i--){
			str.append(s[i]);
		}
		return str.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long sTime = System.currentTimeMillis();
		System.out.println(getR(-1355485895));
		long eTime = System.currentTimeMillis();
		NumberFormat formater = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time is " + formater.format((eTime - sTime) / 1000d) + " seconds\n");

		long startTime = System.currentTimeMillis();
		System.out.println(reverse(-1355485895));
		long endTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");


	}

}
