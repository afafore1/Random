import java.io.*;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileNotFoundException; // throws IOException is used for exception handling

public class AsAnagram {

	public static void main(String[] args)  throws FileNotFoundException  {
		// TODO Auto-generated method stub
		int Wordct = 0; // Wordct will be used to count the number of words in the file
		String Arrs [] = new String[10]; // Array object Arrs will hold 10 objects
		int i = 0;
		
		Scanner question = new Scanner(System.in); // Scanner object used to prompt user question
		System.out.print("Please enter name of your input file: "); // give user direction of what to do
		String CallFile = question.nextLine(); // String CallFile will equal whatever the user entered as their input file
		try {
			Scanner UserFile = new Scanner(new File(CallFile)); // Creates a scanner object that scans the entered file
			while (UserFile.hasNext()){
				String Words = UserFile.nextLine(); // scans next line
				Arrs = Words.trim().split("\\s+"); // use of \\s to match any white space characters as a delimiter
				for (String o: Arrs){ if (o.length()>12){ // check the length of the character of words
					Wordct--; // if the character of the word is greater than 12, it will be ignored and the program will continue
				}
				else {
					Wordct++;
				}
				}
				}
				UserFile.close(); // Closes the users input file
			}
			catch(FileNotFoundException e) // This handles if the file does not exist.
			{
				System.out.println("File name entered does not exist, please try again!");
				System.exit(0);
				}
		if (Wordct > 50) // check if the words in the input file is more than 50
		{
			System.out.println("there are more than 50 words in the input file"); // print message
			System.exit(0); // exit the program
		}
		if(Wordct == 0){ // check if the input file is empty
			System.out.println("the input file is empty");
			System.exit(0); // terminate the program
		} 
		/* We are creating two arrays to hold the original words entered in the input file
		 * and the signature array is used to hold the sorted words after removing punctuation, white spaces e.t.c
		 */
		String OriginalWord [] = new String[Wordct]; 
		String Signature []	= new String[Wordct];
		
		Scanner UserFile = new Scanner(new File(CallFile));
		while (UserFile.hasNext()){
			
			String Words = UserFile.nextLine();
			Arrs = Words.split("\\s+"); 
			for (String o:Arrs){ 
				if (o.length()>12)
				continue;
				OriginalWord[i++] = o;
			 	}
		}
		UserFile.close();
		
		for (int v = 0; v<OriginalWord.length; v++)
		{
			String StrippedWords = OriginalWord[v].replaceAll("\\W", "").toLowerCase();// Remove all punctuation and change words to lowercase
			Signature[v] = StrippedWords; //The signature array is then set to the words with no punctuation
			char S [] = Signature[v].toCharArray(); // this is used so that the array can be sorted
			Arrays.sort(S); // sort words by characters
			String SortedWords = new String(S); 
			Signature[v] = SortedWords; // Sorted words are stored in the signature array
		}
		int v;
		int p;
		for (v = 0; v<Signature.length; v++)	{
			for (p = v+1; p < Signature.length; p++){
				if (Signature[v].compareTo(Signature[p])==0) // compare words and see if they are equal
				{
					String hold = Signature[v];
					String holder = OriginalWord[v];
					Signature[v] = Signature[p];
					OriginalWord[v] = OriginalWord[p];
					Signature[p] = hold;
					OriginalWord[p] = holder;
				}
			}
			
		}
		PrintWriter DisplayFile = new PrintWriter("output.txt"); // Create a new file called output.txt and display the results in the file
		int u = 0;
		
		for (i = 0; i<Signature.length;)
		{
			if (Signature[i].equals(Signature[u]))
			{
				DisplayFile.print(OriginalWord[i]+ " "); // print onto output file
				System.out.print(OriginalWord[i]+ " ");// print onto screen
				i++; //increment i
			}
			else
			{
				DisplayFile.println();
				System.out.println();
				u = i;
			}
		}
		DisplayFile.close(); // close the output file

	}

}
