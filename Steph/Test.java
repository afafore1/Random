package Steph;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
	public static boolean isPrime(long n){
		if(n != 2 && n % 2 == 0){
			return false;
		}
		for(int i = 3; i <= Math.floor(Math.sqrt(n));i+=2){
			if(n % i == 0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		long sum = 0;
		for(int i = 2; i < 2000000; i++){
			if(isPrime(i)){
				//System.out.println("this is prime "+i);
				sum+=i;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(sum);
		System.out.println("Time taken is "+(end-start)+" ms");
		
		long newsum = 0;
		int max = 2000000;
		boolean [] isaPrime = new boolean[max+1];
		for(int i = 2; i <= max; i++){
			isaPrime[i] = true;
		}
		
		for(int i = 2; i < max; i++){
			if(isaPrime[i]){
				for(int j = i; j*i < max;j+=i){
					isaPrime[j*i] = false;
				}
			}
		}
		for(int i = 2; i < max; i++){
			if(isaPrime[i]){
				newsum+=i;
			}
		}
		System.out.println(newsum);
		
	}

}
