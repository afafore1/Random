import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Sieve {
	
	public static boolean isaPrime(long n){
		if(n % 2 == 0 && n != 2) return false;
		for(int i = 3; i <= Math.floor(Math.sqrt(n)); i+=2){
			if(n % i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		
		int n = 200000000;
		long sum = 0;
		int lim = (int) Math.sqrt(n);
		long startTime = System.currentTimeMillis();
		boolean [] isPrime = new boolean[n + 1];
		for(int i = 2; i <= n; i++){ // Every number is prime
			isPrime[i] = true;
		}
		for(int i = 2; i < lim; i++){ 
			if(isPrime[i]){
				for(int j = i; i*j < n; j++){
					isPrime[i*j] = false;
				}
			}
		}
		
		for(int i = 2; i <= n; i++){
			if(isPrime[i]){
				//System.out.println(i);
				sum+= i;
			}
		}
		
		System.out.println(sum);
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken "+(endTime-startTime)+" ms");
//		NumberFormat formatter = new DecimalFormat("#0.00000");
//		System.out.print("\nExecution time is " + formatter.format((endTime - startTime) / 1000d) + " seconds\n");
		sum = 0;
		//System.out.println(isaPrime(97));
		startTime = System.currentTimeMillis();
		for(int i = 2; i <= n; i++){
			if(isaPrime(i)){
				sum+=i;
			}
		}
		endTime = System.currentTimeMillis();		
		System.out.println(sum);
		System.out.println("Time taken for isaPrime "+(endTime-startTime)+ " ms");

	}
	

}