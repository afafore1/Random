
public class Euler50 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int max = 2000000;
		long sum = 0;
		boolean [] isPrime = new boolean [max + 1];
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
		for(int i = 0; i < max;i++){
			if(isPrime[i]){
				sum+=i;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("time taken is "+(end - start)+" ms");

	}


}
