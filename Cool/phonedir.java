/*
 * This program creates a directory of names and numbers and it allows you to do tasks such as
 * add information, remove information and edit information.
 * all inputs come fromm user and the program outputs records in order
 * Data structure used: Linked list
 * Algorithm: show all method, delete all, change first, change last, add new change number, quit and select a record methods 
 */
package Cool;
import java.util.*;
import java.lang.String;
import java.lang.Object;

public class phonedir {
//	 @SuppressWarnings("rawtypes")
//	static LinkedList phone;
	static LinkedList <String> phone = new LinkedList<String>();
	
	public static void questions(){
		//Display commands
		System.out.println("List of Commands:\n" +
				"   a - Show all records\n" +
				"   d - delete the current record\n" +
				"   f  - change the first name in current record\n" +
				"   l  - change the last name in current record\n" +
				"   n - add a new record\n" +
				"   p - change the phone number in current record\n" +
				"   q - quit\n" +
				"   s - select a record from record list\n");

		//Prompt user to enter a command
		Scanner input = new Scanner(System.in); 
		System.out.println("Enter a command from the list above: ");
		String command = input.nextLine();
		//indicates which method should be used 
		if (command.equalsIgnoreCase("a"))
		{
			showAll();
		}
		else if (command.equalsIgnoreCase("d"))
		{
			deleteRecord();
		}
		else if (command.equalsIgnoreCase("f"))
		{
			changeFirst();
		}
		else if (command.equalsIgnoreCase("l"))
		{
			changeLast();
		}
		else if (command.equalsIgnoreCase("n"))
		{
			addNew();
		}
		else if (command.equalsIgnoreCase("p"))
		{
			changePhone();
		}
		else if (command.equalsIgnoreCase("q"))
		{
			quit();
		}
		else if (command.equalsIgnoreCase("s"))
		{
			selectRecord();
		}
		else
		{

			//Illegal command will display an error message.
			System.out.println("Illegal command");
		}
		System.out.println();
	}


	public static void main(String[] args) {
		questions();
	}
		
	//Shows all records
	private static void showAll(){
		for (int i = 0; i < phone.size(); i++ )//loops through directory and prints each one out
		{
			System.out.println(phone.get(i));
		}
		questions();
	}

	//precondition: takes in an input with scanner
	//postcondition: removes that record from the linked list
	private static void deleteRecord()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter name to delete: ");
		String key = input.nextLine();
		for (int i = 0; i < phone.size(); i++)
		{
			if(phone.get(i).contains(key)){
				phone.remove(i);
			}
		}
		questions();
	}

	//precondition: takes in an input with scanner
	//postcondition: Changes the first name of the current record
	private static void changeFirst()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter name to change: ");
		String key = input.nextLine();
		for (int i = 0; i < phone.size(); i++)
		{
			if(phone.get(i).contains(key)){
				String info = phone.get(i);
				int s = info.indexOf(" ");
				phone.remove(info);
				String strip = info.substring(s, info.length());
				System.out.print("Enter new First name:");
				String newName = input.nextLine();
				String replace = newName + " "+strip;
				phone.add(i, replace);
			}
		}
		questions();
		//phone.set((String) curr);
	}
	//precondition: takes in an input with scanner
	//postcondition: Change the last name of the current record
	private static void changeLast()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter last name to change: ");
		String CallFile = input.nextLine();
		String key = CallFile;

		for (int i = 0; i < phone.size(); i++)
		{
			if(phone.get(i).contains(key)){
				String info = phone.get(i);
				int s = info.lastIndexOf(" ");
				phone.remove(info);
				int u = info.lastIndexOf(" ");
				int x = info.indexOf(" ");
				String strip = info.substring(x,u);
				System.out.print("Enter new last name:");
				String newName = " "+input.nextLine();
				String replace = info.replace(strip,newName);
				phone.add(i, replace);
			}
		}
		questions();
		// phone.set((String) curr);
	}
//Precondition: takes in 2 inputs the name and number and creates a new record
	//postcondition: Add a new record and allows you to do other commands
	private static void addNew()
	{
		Scanner input = new Scanner(System.in);
		System.out.print("Enter first name: ");
		String fname = input.nextLine();
		System.out.print("Enter last name: ");
		String lname = input.nextLine();
		System.out.println("Enter phone number: ");
		String number = input.nextLine();
		String addinfo = fname + " "+ lname + " "+number;
		phone.add(addinfo);

		questions();
		}
	
	//precondition: takes in an input with scanner
	//postcondition: Change the phone number of the current record
	private static void changePhone()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number to change: ");
		String CallFile = input.nextLine();
		String key = CallFile;

		for (int i = 0; i < phone.size(); i++)
		{
			if(phone.get(i).contains(key)){
				String info = phone.get(i);
				int s = info.lastIndexOf(" ");
				phone.remove(info);
				String strip = info.substring(0,s);
				System.out.print("Enter new phone number:");
				String newNum = input.nextLine();
				String replace = strip+ " "+newNum;
				phone.add(i, replace);
			}
		}
		questions();
	}

	//Quits the program
	private static void quit()
	{
		System.exit(0);
	}
	//precondition: takes in an input with scanner
	//postcondition: Selects a record from the record list
	private static void selectRecord()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a name to select information for: ");
		String key = input.nextLine();
		for (int i = 0; i < phone.size(); i++)
		{
			if(phone.get(i).contains(key)){
				System.out.println(phone.get(i));
			}
		}
		questions();
	}

	
}
   