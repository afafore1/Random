import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicInteger;

public class md5ver {

	public static String getMD5(String input){
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hash = number.toString(16);
			while(hash.length() < 32){
				hash = "0" + hash;
			}
			return hash;
		}catch(NoSuchAlgorithmException e){
			throw new RuntimeException(e);
		}
	}
	
	static void swap(AtomicInteger a, AtomicInteger b){
		a.set(b.getAndSet(a.get()));
	}
	public static void main(String[] args) {
		
	}

}
