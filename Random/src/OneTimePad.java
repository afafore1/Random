import java.util.Scanner;

public class OneTimePad {
	public static int getBinary(char c){
		int index = 0;
		index = (int)c - 97;
		return index;
	}
	
	public static String getString(int c){
		String result = null;
		int index = Integer.parseInt(String.valueOf(c),2);
		if(index > 25){ //28 % 25
			index -=(index % 24);
		}
		index += 97;
		result = String.valueOf(Character.toString((char)index));
		return result;
	}

	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		String test = sc.nextLine();
		test = test.toLowerCase().replaceAll("[^A-Za-z ]", "");
		System.out.print("Enter key: ");
		String key = sc.nextLine();
		String converted = "";
		int j = 0;
		for(int i = 0; i < test.length(); i++){
			char c = test.charAt(i);
			if(!(c == ' ')){
				j %= key.length();
				int conv = getBinary(c) ^ getBinary(key.charAt(j));
				conv = Integer.parseInt(Integer.toBinaryString(conv));
				converted += getString(conv);
				j++;
			}else{
				converted+=" ";
			}
		}
		
		System.out.println(converted);
		
		

	}

}
