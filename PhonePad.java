import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


public class PhonePad {
	public static char[] getChars(char s){
		switch(s){
		case '1':
			char[] one = {};
			return one;
			
		case '2':
			char[] two = {'a','b','c'};
			return two;
			
		case '3':
			char[] three = {'d','e','f'};
			return three;
			
		case '4':
			char[] four = {'g','h','i'};
			return four;
			
		case '5':
			char[] five = {'j','k','l'};
			return five;
			
		case '6':
			char[] six = {'m','n','o'};
			return six;
		case '7':
			char [] seven = {'p','q','r','s'};
			return seven;
		case '8':
			char [] eight = {'t','u','v'};
			return eight;
		case '9':
			char [] nine = {'w','x','y','z'};
			return nine;
		case '0':
			char[] zero = {' '};
			return zero;
			
		}
		return null;
	}
	
	
	public static void perm(long val){
		perm("",String.valueOf(val));
	}
	
	private static void perm(String pre, String sur){
		if(sur.length() == 0){
			System.out.println(pre);
		}else{
			char[] chars = getChars(sur.charAt(0));
			if(chars.length > 0){
				for(char c: chars){
					perm(pre + c, sur.substring(1));
				}
			}else{
				perm(pre,sur.substring(1));
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number to check word: ");
		long num = sc.nextLong();
		perm(num);

	}

}
