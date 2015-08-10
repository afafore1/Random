import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Scanner;


public class AutoWrite {

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {
		
		Runtime.getRuntime().exec("notepad.exe");
		Thread.sleep(2000);
		Robot r = new Robot();
		String word = "I love dazzles".toLowerCase();
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			if(c != ' '){
//				r.keyPress(KeyEvent.VK_CAPS_LOCK);
				r.keyPress(c-'a'+KeyEvent.VK_A);
//				r.keyPress(KeyEvent.VK_CAPS_LOCK);
			}else{
				r.keyPress(KeyEvent.VK_SPACE);
			}
			Thread.sleep(200);
		}
//		r.keyPress(KeyEvent.VK_S);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_T);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_E);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_P);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_H);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_A);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_N);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_I);
//		Thread.sleep(200);		
//		r.keyPress(KeyEvent.VK_E);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_SPACE);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_L);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_O);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_V);
//		Thread.sleep(200);		
//		r.keyPress(KeyEvent.VK_E);
//		Thread.sleep(200);		
//		r.keyPress(KeyEvent.VK_S);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_SPACE);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_M);
//		Thread.sleep(200);
//		r.keyPress(KeyEvent.VK_E);
//		Thread.sleep(200);	

		

	}

}
