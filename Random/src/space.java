import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class space {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readWriteFile();
	}
	
	static void readWriteFile(){
		try{
			Scanner sc = new Scanner(new File("ya"));
			BufferedWriter bfw = new BufferedWriter(new FileWriter("na.txt"));
			String line;
			while(sc.hasNext()){
				line = sc.next();
				if(line.charAt(0) == ' '){
					System.out.println("who");
				}else{
					System.out.println(line);
				}
			}
		}catch(IOException e){
			System.out.println("no file");
		}
	}

}
