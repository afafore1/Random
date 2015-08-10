import java.util.Scanner;


public class ReverseString {
	
	public static String reverseS(String s){
		StringBuilder str = new StringBuilder();
		char [] strC = s.toCharArray();
		for(int i = strC.length -1; i >=0; i--){
			str.append(strC[i]);
		}
		return str.toString();
	}
	
	public static String recursiveR(String s){
		if(s.length() < 2){
			return s;
		}
		return recursiveR(s.substring(1)) + s.charAt(0);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("What's your name?: ");
		String myname = sc.nextLine();
		String reverse = new StringBuffer(myname).reverse().toString();
		System.out.println(reverse);
		String Rreverse = reverseS(myname);
		System.out.println(Rreverse);
		String recur = recursiveR(myname);
		System.out.println(recur);

	}

}
