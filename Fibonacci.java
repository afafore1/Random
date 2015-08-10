import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;


public class Fibonacci {
	public static int fib(int a){
		if(a == 0 || a == 1){
			return 1;
		}
		return fib(a-1) + fib(a-2);
	}
	
	public static void main(String[] args) {
		   int number = 40;
	        BigInteger a = BigInteger.ZERO;
	        BigInteger b = BigInteger.ONE;
	        long startTime = System.currentTimeMillis();
	        BigInteger c = BigInteger.ONE;
	        for(int i = 0; i<number;i++){
	            a=b;
	            b=c;
	            c = a.add(b);
	            System.out.println("---Iterative---"+a);
	        }
	        long endTime = System.currentTimeMillis();
			NumberFormat formatter = new DecimalFormat("#0.00000");
			System.out.print("\nExecution time for iterative is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");
			
			long sTime = System.currentTimeMillis();
	        for(int i = 0; i < number; i++)
	        System.out.println("----recursive----"+fib(i));
	        long eTime = System.currentTimeMillis();
			NumberFormat formater = new DecimalFormat("#0.00000");
			System.out.print("\nExecution time for recursion is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");
	        
		

	}

}
