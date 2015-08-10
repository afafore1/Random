import java.util.Arrays;
import java.util.Scanner;
public class PhonePady {

	public static void main(String[] args) {
		String[] button = new String[10]; // there are 10 buttons that will be used. 0-9
		char theChar = 'a'; // first char is a
		for (int i = 0; i < button.length; i++) { // loop through the buttons length
			if(i == 0){
				button[i] = " "; // if key pad is 0, return space
			} else if(i==1){
				button[i] = ""; // if key pad is 1, return nothing
			} else {
				button[i] = "";
				if(i != 7 && i != 9){
					for (int j = 1; j <= 3; j++) {
						button[i] += theChar++;
					}
				}else{
					for (int j = 1; j <= 4; j++) {
						button[i] += theChar++;
					}
				}
			}
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number to check word: ");
		String num = sc.nextLine();
		if(num.length()>0){
			char previous = num.charAt(0);
			int count = 0;
			for (int i = 1; i <= num.length(); i++) {
				count++;
				if(i<num.length() && num.charAt(i)!=previous || i == num.length()){
					String theButton = button[previous-'0'];
					if(theButton.length() > 0)
						System.out.print(theButton.charAt((count-1) % theButton.length()));
					count = 0;
					if(i<num.length())
						previous = num.charAt(i);
				}
			}
		}
	}
}

