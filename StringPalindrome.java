import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
public class StringPalindrome {

	public static boolean isPal(String s){
		if(s.length() == 0 || s.length() == 1) // if string's length is 1 or 0, return true 
			return true;
//		if(s.charAt(0) != s.charAt(s.length() -1)){
//			return false;
//		}
		if(s.charAt(0) == s.charAt(s.length()-1)) // check if the letter at 0 index equal to letter at end of string
			return isPal(s.substring(1, s.length()-1)); // check for the two..
		return false;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter string to check: ");
		String uString = sc.nextLine().replaceAll("\\p{P}", "").replaceAll("[\\s]", "").toLowerCase();
		System.out.println(uString);
		//System.out.println(uString.substring(1,uString.length()-1));
		long startTime = System.currentTimeMillis();
		if(isPal(uString)){
			System.out.println(uString+ " is a palindrome");
		}
		else{
			System.out.println(uString+" is not a palindrome");
		}
		long endTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");
		
		
	}


}

