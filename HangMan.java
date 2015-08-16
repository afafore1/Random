import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class HangMan {
	public static void main(String[] args) {
		// Declare array which words will be stored in
		String [] words = new String [100];
		String wordfile = "wordsEn.txt"; // get file name
		// read in words in text file into array
		try{
			@SuppressWarnings("resource")
			Scanner file = new Scanner(new File(wordfile));
			//while(file.hasNext()){
				String wordnext = file.nextLine();
				words = wordnext.split("\\s+"); // remove whitespaces
			//}
		}catch(FileNotFoundException e) // this is the file not found exception handling
		{
			System.out.print("The file you have entered does not exist, please try again!");
			System.exit(0); // exit program
		}
		String choice = words[(int) (Math.random() * words.length)]; // get a random word
		String temp = choice; 
		System.out.println(temp.replaceAll("[a-z]", "_ ")); // replace all alphabets with _
		// declare rights and wrongs for keeping count
		int wrongs = 0; 
		int rights = 0;
		// store words selected that are in choice
		Character [] wordspicked = new Character [choice.length()];
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);	

		// this represents ascii of the hangman
		String x ="     _______\n     |/      |\n     |      (_)\n     |      \\|/\n     |       |\n     |      / \\\n     |\n    _|___";	


		while(true){
			// get user input
			System.out.print("Enter a letter: ");
			String l = sc.nextLine(); // get entered letter
			char t = ' ';
			if(!(l.length() == 0)){
			t = l.charAt(0); // convert to char
			}
			boolean [] pick = new boolean [choice.length()]; // this is used for getting selected index
			// check if entered letter exist in choice and if it has not already been selected
			if(choice.contains(l) && !Arrays.asList(wordspicked).contains(t)){ 

				// mark index of chosen words in this loop
				for(int o = 0; o < choice.length(); o++){ 
					if(choice.charAt(o) == t){
						pick[o] = true;
					}
				}

				// if the index in the bool array is true, store that index alphabet in array
				for(int o = 0; o < choice.length(); o++){
					if(pick[o] == true){
						wordspicked[o] = t;
						rights++; // increment rights.. 
					}
				}
				
			}else{

				wrongs++; // if wrongs, increment wrongs
				System.out.println("You are hanging the man :(");
				// handle how to print man hanging, index is important here
				switch(wrongs){
				// better way to get indexes?? too lazy to try ??
				case 1:
					System.out.println(x.substring(0,46));
					break;
				case 2:
					System.out.println(x.substring(0,68));
					break;
				case 3:
					System.out.println(x.substring(0,84));
					break;
				case 4:
					System.out.println(x.substring(0,94));
					break;
				case 5:
					System.out.println(x.substring(0, 102));
					break;
				case 6:
					System.out.println(x.substring(0, x.length()-1));
				}
			}
			//print along as letters are entered
			for(int i = 0; i < wordspicked.length; i++){
				if(wordspicked[i] == null){
					wordspicked[i] = '_';
				}
			}
			System.out.println(Arrays.toString(wordspicked).replaceAll("[\\[\\],]", ""));

			// limit number of wrongs to 6
			if(wrongs == 6){ 
				System.out.println("You LOSER!!!");
				System.out.println("\nThe word was "+choice);
				break;
			}
			// if rights is size of choice then you win!
			if(rights == choice.length()){
				System.out.println("You win!!");
				break;
			}
		}

	}

}
