package API;

import java.util.Scanner;
import java.net.URL;
import java.applet.Applet;
import java.applet.AudioClip;

public class Audio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter song wav file url");
			String filename = sc.nextLine();
			URL url = new URL(filename);
			AudioClip ac = Applet.newAudioClip(url);
			ac.play();
			
			System.out.println("Press any key to exit.");
			System.in.read();
			ac.stop();
		} catch(Exception e){
			System.out.println(e);
		}

	}

}
