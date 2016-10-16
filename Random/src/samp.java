import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
public class samp {




	public static void main(String[] args) {
		// declaration section:
		// smtpClient: our client socket
		// os: output stream
		// is: input stream
//		Socket smtpSocket = null;  
//		DataOutputStream os = null;
//		BufferedReader is = null;
//		// Initialization section:
//		// Try to open a socket on port 25
//		// Try to open input and output streams
//		try {
//			smtpSocket = new Socket("smtp.gsu.edu", 25);
//			os = new DataOutputStream(smtpSocket.getOutputStream());
//			is = new BufferedReader(new InputStreamReader(smtpSocket.getInputStream()));
//		} catch (UnknownHostException e) {
//			System.err.println("Don't know about host: hostname");
//		} catch (IOException e) {
//			System.err.println("Couldn't get I/O for the connection to: hostname");
//		}
//		// If everything has been initialized then we want to write some data
//		// to the socket we have opened a connection to on port 25
//		if (smtpSocket != null && os != null && is != null) {
//			try {
//				// The capital string before each colon has a special meaning to SMTP
//				// you may want to read the SMTP specification, RFC1822/3
//				os.writeBytes("HELO gsu.edu\n");    
//				os.writeBytes("MAIL FROM: afafore1@student.gsu.edu\n");
//				os.writeBytes("RCPT TO: afafore1@student.gsu.edu\n");
//				os.writeBytes("DATA\n");
//				os.writeBytes("Subject: testing\n");
//				os.writeBytes("Hello Ayomitunde this is just a test for networks\n"); // message body
//				os.writeBytes(".\n");
//				os.writeBytes("QUIT");
//				// keep on reading from/to the socket till we receive the "Ok" from SMTP,
//				// once we received that then we want to break.
//				String responseLine;
//				while ((responseLine = is.readLine()) != null) {
//					System.out.println("Server: " + responseLine);
//					if (responseLine.indexOf("Ok") != -1) {
//						break;
//					}
//				}
//				// clean up:
//				// close the output stream
//				// close the input stream
//				// close the socket
//				os.close();
//				is.close();
//				smtpSocket.close();   
//			} catch (UnknownHostException e) {
//				System.err.println("Trying to connect to unknown host: " + e);
//			} catch (IOException e) {
//				System.err.println("IOException:  " + e);
//			}
//		}
		try {
			InetAddress localhost = InetAddress.getByName("gsu.edu");
			String ipAddress = localhost.getHostAddress();
			System.out.println("ipAddress is "+ipAddress);
			String hostname = localhost.getHostName();
			System.out.println(hostname);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}           
}
