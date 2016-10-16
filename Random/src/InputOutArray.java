import java.util.Scanner;

public class InputOutArray {
	public static String compute(String s){
		String result = "[";
		int comp = Integer.parseInt(s) + 1;
		String change = String.valueOf(comp);
		for(int i = 0; i < change.length(); i++){
			char c = change.charAt(i);
			result +=c+",";
		}
		// replace last , in string
		StringBuilder b = new StringBuilder(result);
		b.replace(result.lastIndexOf(","), result.lastIndexOf(",") + 1, "");
		result = b.toString();
		result+="]";
		return result;
	}
	
	public static int [] solve(int [] num){
		int number = 0;
		String n = "";
		for(int i = 0; i < num.length; i++){
			n+= i;
		}
		number = Integer.parseInt(n) + 1;
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number");
		String input = sc.nextLine();
		System.out.println(compute(input));

	}

}
