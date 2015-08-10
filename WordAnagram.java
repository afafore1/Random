import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;


public class WordAnagram {
	
	public static boolean isAnagram(String f, String l){
		// Trim spaces in string and convert to lowercase, get character sequence represented by strings
		char [] word1 = f.replaceAll("[\\s]", "").replaceAll("\\W", "").toCharArray();
		char [] word2 = l.replaceAll("[\\s]", "").replaceAll("\\W", "").toCharArray();
		Arrays.sort(word1); // sort the words
		Arrays.sort(word2);
		if(word1.length != word2.length){ // compare lengths
			return false;
		}
		
		return Arrays.equals(word1, word2);
	}

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String f = "ayomitundefafore";
		String l = "yaotnuediffoamer";
		System.out.println(isAnagram(f,l));
		long endTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");


	}

}
