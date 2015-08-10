package Steph;

public class Euler2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long i = 0;
		long j = 1;
		long max = 4000000;
		long sum = 0;

		
		while(j<=max){
			long temp = i;
			i = j;
			j = temp + i;
			if(j%2==0)
			{
				sum += j;
			}
		}
		System.out.println(sum);


	}

}
