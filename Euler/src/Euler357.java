import java.util.LinkedList;
import java.util.List;

public class Euler357 {
	public static void getDivisors(long n, List divs){
		divs.add(1);
		divs.add(n);
		long nSqrt = (long) Math.sqrt(n);
		for(int i = 2; i <= nSqrt; i++){
			if(n % i == 0){
				divs.add(i);
				if(i != n/i){
					divs.add(n/i);
				}
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int max = 20000000;
		long sum = 0;
		List divs = new LinkedList<Integer>();
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
		int maxSums = 100;
		int divSums = 0;
		while(divSums < maxSums){
			for(int i = 1; i < maxSums;){
				getDivisors(i, divs);
				for(int j = 0; j < divs.size();j++){
					int primeCheck = (divs.get(j) + i) / divs.get(i);
				}
			}
			i++;
		}
		System.out.println(divs);
		System.out.println(divSums);
		long end = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("time taken is "+(end - start)+" ms");

	}

}
