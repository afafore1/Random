package Cool;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;
 // this program is not efficient.. but it is quite close
// you can modify it to make it work for what you want.
public class Eric2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 int nums = sc.nextInt();
		 String chars = String.valueOf(nums);
		 int len = chars.length(); // get length of string
		 char frequentChar = ' '; // most frequent will be here
		 int maxlen = 0; // max length initialized
		 long startTime = System.currentTimeMillis();
		 for(int i = 0; i < len; i++){
			 char currentchar = chars.charAt(0); // get first character
			 //System.out.println(currentchar);
			 chars = chars.replaceAll(currentchar + "", "");//remove all occurrence of it
			 //System.out.println(chars);
			 if(maxlen < (len-chars.length())){ // if max is less than original length - remaining length
				 frequentChar = currentchar; //most frequent will be the current character
				 maxlen = len - chars.length();
			 }
			 System.out.println("Char "+currentchar +" occured "+(len - chars.length())+" time(s)");
			 len = chars.length();
		 }
		 System.out.println("Max occurance is: "+maxlen+" by "+frequentChar);
		 long endTime = System.currentTimeMillis();
		 NumberFormat formatter = new DecimalFormat("#0.00000");
		 System.out.print("\nExecution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");

	}

}
