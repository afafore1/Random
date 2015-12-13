import java.util.*;
import java.util.Arrays;

public class PhoneNumbers
{
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args)
	{
		String phoneList[][] = new String [][]{{"Harrison, Rose: "}, {"James, Jean: ", "Smith, William: ", "Smith, Brad: "},
			{"415-555-2234", "415-555-9098", "415-555-1785", "415-555-9224"}};

			System.out.println(Arrays.deepToString(phoneList)); //this line is to make sure the 2D arrays work

			String input;

			System.out.print("Enter the first few letters of a last name to search for: ");
			input = scan.nextLine();

			int match = -1;
			System.out.println(phoneList.length);
			for(int i = 0; i < phoneList.length; i++)
			{
				for(int j = 0; j < phoneList.length; j++){
					System.out.println(phoneList[i][j]);
				}

			}    


	}
}