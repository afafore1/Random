import java.util.Scanner;

public class SecondstoMinutes {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("We are going to convert Seconds to Minutes!");
		System.out.println("How many seconds are you trying to convert?");
		// Ask the user 
		int userSeconds = input.nextInt();
		// See how many minutes
		int seconds2Minutes = userSeconds / 60;
		// See the remaining seconds
		int remainingSeconds = userSeconds % 60;
		
		
		
		
		// See how many hours
		int remainingHours = seconds2Minutes /  60;
		// See how many minutes
		int remainingMinutes = seconds2Minutes % 60;
		// See how many seconds
		int remainingSeconds2 = remainingMinutes % 60;
		
		if (seconds2Minutes < 60)
			
		{
		
			System.out.println(userSeconds + " is converted to " + seconds2Minutes +
				" minutes and " + remainingSeconds + " seconds " );	
		}
		
		else
		
		{
			int t = userSeconds % 3600;
			remainingMinutes = t /60;
			remainingSeconds2 = t % 60;
			System.out.println(userSeconds + " is converted to " + remainingHours + " hour and " + remainingMinutes +
					" minutes and " + remainingSeconds2 + " seconds " );			
		}
		
		
	}

}