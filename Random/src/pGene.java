import java.util.Arrays;

public class pGene {
	
	public static void isPrime(boolean[] primes, int num){
		primes = new boolean[num + 1];
		for(int i = 2; i <= num; i++){
			if(i % 2 == 0 && i != 2){
				primes[i] = false;
			}else{
				primes[i] = true;
			}
		}
		
		for(int i = 3; i <= Math.sqrt(num); i+=2){
			if(primes[i]){
				for(int j = i*i; j < num; j+=i){
					primes[j] = false;
				}
			}
		}
		//return primes;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int max = 20;
		boolean [] isPrime = new boolean[max + 1];
		isPrime(isPrime, max);
		
		System.out.println(Arrays.toString(isPrime));

	}

}
