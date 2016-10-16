import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StripWord {

	public static void writeOutput() throws IOException{
		File f = new File("sub10.srt");
		File written = new File("output.txt");
		FileWriter fw = new FileWriter(written);
		BufferedReader br = null; 
		try{
			br = new BufferedReader(new FileReader(f));
			String currentLine;
			while((currentLine = br.readLine()) != null){
					if(currentLine != null && !currentLine.contains("[^A-Za-z]")){
					String strip = currentLine;
					if(strip.contains("<i>")){
						strip = strip.replace("<i>", "");
					}
					if(strip.contains("</i>")){
						strip = strip.replace("</i>", "");
					}
					strip = strip.replaceAll("[^A-Za-z ]", "");
					strip+="\n";
					fw.write(strip);
				}
			}
			br.close();
			fw.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void writeAnswers() throws IOException{
		File f = new File("output.txt");
		File written = new File("answers.txt");
		FileWriter fw = new FileWriter(written, true);
		BufferedReader br = null; 
		try{
			br = new BufferedReader(new FileReader(f));
			String currentLine;
			while((currentLine = br.readLine()) != null){
				if(currentLine.trim().length() > 0){
						fw.write(currentLine.trim()+"\n");
					}else{
						continue;
					}
			}
			br.close();
			fw.close();
		}catch(FileNotFoundException e){
			System.out.println("File not found");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException{
		writeOutput();
		writeAnswers();

	}

}
