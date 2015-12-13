import java.util.Arrays;
import java.util.Scanner;

public class ah {
	
	public static void printReverse(int [] ar){
		int revAr[] = new int [ar.length];
		for(int i = ar.length -1; i >= 0; i--){
			revAr[ar.length- 1 - i] = ar[i];
		}
		System.out.println(Arrays.toString(revAr));
	}
	public static void getLargest(int [] ar){
		int max = 0; 
		for(int i = 0; i < ar.length; i++){
			if(ar[i] > max){
				max = ar[i];
			}
		}
		System.out.println("The highest number is "+max);
		Arrays.sort(ar);
		System.out.println("Highest "+ar[ar.length-1]);
	}
	
	public static void computeTwice(int [] ar){
		for(int i = 0; i < ar.length; i++){
			ar[i] = ar[i] * 2;
		}
		System.out.println("Numbers are "+Arrays.toString(ar));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int numbers[] = new int [10];
		for(int i = 0; i < numbers.length; i++){
			System.out.println("Enter a number");
			numbers[i] = sc.nextInt();
		}
		
		getLargest(numbers);
		computeTwice(numbers);
		printReverse(numbers);
		

	}

}
