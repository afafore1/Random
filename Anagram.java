import java.text.DecimalFormat;
import java.text.NumberFormat;


public class Anagram {
	
	public static boolean isAnagram(String word, String a){
		if(word.length() != a.length()){
			return false;
		}
		char [] cword = word.toCharArray(); // put the number in charArray
		for(char x : cword){ // loop through the word
			int index = a.indexOf(x); // index of each char in a
			if(index != -1){
				a = a.substring(0, index) + a.substring(index + 1, a.length());
			}else{
				return false;
			}
		}
		return a.isEmpty();
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String word = "ayomitundefafore";
		String a = "meayotnuediffoar";
		System.out.println(isAnagram(word,a));
		long endTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");

	}

}
