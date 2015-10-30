
public class Euler7 {
	public static boolean isaPrime(long n){
		if(n % 2 == 0 && n != 2) return false;
		for(int i = 3; i < Math.sqrt(n); i++){
			if(n % i == 0)return false;
		}
		return true;
	}
	
	public static boolean Primes(long n){
		for(int i = 2; i < n; i++){
			if(n % i == 0 && n != 2){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int count = 0;
		int max = 200000;
		int hit = 10001;
		boolean [] isPrime = new boolean[max+1];
		for(int i = 2; i < max; i++){
			isPrime[i] = true;
		}
		for(int i = 2; i < Math.sqrt(max); i++){
			if(isPrime[i]){
				for(int j = i*i; j < max; j+=i){
					isPrime[j] = false;
				}
			}
		}
		for(int i = 2; i < max; i++){
			if(isPrime[i]){
				count++;
			}
			if(count == hit){
				System.out.println(i);
				break;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("time taken "+(end - start)+" ms");

		start = System.currentTimeMillis();
		int counter = 0;
		for(int i = 2; i < max; i++){
			if(Primes(i)){
				counter++;
			}
			if(counter == hit){
				System.out.println(i);
				break;
			}
		}
		end = System.currentTimeMillis();
		System.out.println("time taken for func "+(end - start)+" ms");

	}

}
