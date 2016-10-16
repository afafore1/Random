import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class PLC5 {

	private static byte[] getSalt(){
		SecureRandom sr = new SecureRandom();
		byte[] salt = new byte[20];
		sr.nextBytes(salt);
		return salt;
	}
	
	public static String hashPassword(byte[] salt, String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update((password + salt).getBytes());
        byte[] concat = md.digest();
        String result = (new BigInteger((concat)).toString(16));
        return result;
    }
	
	public static void main(String[] args) {
		int p = 3;
		int q = 11;
		int n = p * q;
		int phi = (p-1)*(q-1);
		
	}

}
