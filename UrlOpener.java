import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class UrlOpener {
	/*code to print html code from site
	if you want to increase visitor count to a particular website for example, you could simply create an application that calls 
	a browser and opens the website
*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			URL google = new URL("http://google.com"); 
			BufferedReader in = new BufferedReader(new InputStreamReader(google.openStream()));
			String iLine;
			
			while((iLine = in.readLine()) != null){
				System.out.println(iLine); // lines are processed here
			}
			in.close();
		}catch(MalformedURLException me){
			System.out.println(me);
		} catch(IOException ioe){
			System.out.println(ioe);
		}

	}

}
