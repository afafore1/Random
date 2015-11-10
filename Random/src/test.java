import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class test {
	static long sumOfIntegers(int [] arr){
		long sum = 0; 
		for(int i = 0; i < arr.length; i++){
			sum+= arr[i];
		}
		return sum;
	}
	
	public static boolean isPalindrome(String s){
		if(s.length() == 0 || s.length() == 1) return true;
		if(s.charAt(0) == s.charAt(s.length() -1)) return isPalindrome(s.substring(1, s.length()-1));
		return false;
	}
	
	static int count_palindromes(String s){
		int counter = 0;
		boolean isPal = false;
		if(s.length() == 0 || s.length() == 1) counter++;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(0) == s.charAt(s.length() -1)){
				counter++;
			}
			s = s.substring(1, s.length()-1);
		}
//		for(int i = 0; i < s.length(); i++){
//			if(isPalindrome(s)){
//				counter++;
//			}else{
//				s = s.substring(i);
//			}
//		}
		return counter;
	}
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("String ?");
		String in = sc.nextLine();
		System.out.println(count_palindromes(in));
	}

}
