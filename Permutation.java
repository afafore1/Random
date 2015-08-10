
import java.util.Scanner;

public class Permutation {
//public static int count = 1;
	public static void permString(String bString, String eString){
		if(eString.length() <= 1)
			System.out.println(" Permutations are "+bString + eString);
		else
			for(int i = 0; i < eString.length(); i++){
				try{
					String nString = eString.substring(0, i) + eString.substring(i+1);
					permString(bString + eString.charAt(i), nString);
				} catch (StringIndexOutOfBoundsException exception){
					exception.printStackTrace();
				}
		
				
			}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a string to find it's permutations: ");
		String input = sc.nextLine();		
		permString("",input);
		
		

	}

}
