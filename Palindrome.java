import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
public class Palindrome {
	
	public static boolean isPal(long n){
		String first = String.valueOf(n).substring(1);
		int l = (int) n % 10;
		int f = Integer.parseInt(first);
		if(l != f) return false;
		long num = n; 
		long reverse = 0;
		long mod = 0;
		while(num > 0){ 
			mod = num % 10; 
			reverse = reverse * 10 + mod; 
			num =  num/10;	
		}
		if( reverse != n){
			return false;
		}
		return true;
	}
	
	public static boolean isPalindrome(long n){
		StringBuilder s = new StringBuilder();
		char [] chars = String.valueOf(n).toCharArray();
		for(int i = chars.length -1; i >= 0; i--){
			s.append(chars[i]);
		}
		String r = String.valueOf(s);
		long reverse = Long.parseLong(r);
		if(reverse == n){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		long num = sc.nextLong();
		
		long sTime = System.currentTimeMillis();
		if(isPal(num)){
			System.out.println(num + " is a palindrome");
		}
		else{
			System.out.println(num + " is not a palindrome");
		}
		long eTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time for divide and get rev is " + formatter.format((eTime - sTime) / 1000d) + " seconds\n");
		
		long startTime = System.currentTimeMillis();
		if(isPalindrome(num)){
			System.out.println(num + " is a palindrome");
		}
		else{
			System.out.println(num + " is not a palindrome");
		}
		long endTime = System.currentTimeMillis();
		NumberFormat formater = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time for reversing is " + formater.format((endTime - startTime) / 1000d) + " seconds\n");
		

	}

}
