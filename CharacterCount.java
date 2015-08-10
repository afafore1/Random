import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;


public class CharacterCount {

	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String mychar = "";
		while((mychar = in.readLine()) != null && mychar.length() != 0){
			int len = mychar.length();
		Map<Character, Integer> numChars = new HashMap<Character, Integer>(Math.min(len, 26)); // return smaller of two ints
		for(int i = 0; i < len; ++i){
			char charAt = mychar.charAt(i);
			if(!numChars.containsKey(charAt))
			{
				numChars.put(charAt, 1);
			}else{
				numChars.put(charAt, numChars.get(charAt) + 1);
			}
			
		}
		System.out.println(numChars.toString().replaceAll("=", ":").replaceAll("\\{", "").replaceAll("}", ""));
		long endTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		System.out.print("\nExecution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");
		}
		

	}

}
