package Steph;

public class Euler1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		long i = 0;
		long j=0;
		long max = 1000;
		long start = System.currentTimeMillis();
		for(; i<max; i++)
		{
			if(i%3==0 || i%5==0)
			{j = j+i;

			}
		}
		long end = System.currentTimeMillis();			
		System.out.println(j);
		System.out.println("Time taken is "+(end - start)+ " ms");
		//n(n+1)/2
		start = System.currentTimeMillis();
		long ans = (max-1)*((max/3)+1)/2 + (max)*((max/5)+1)/2 - (max-10)*((max/15)+1)/2;
		System.out.println(ans-max);
		end = System.currentTimeMillis();
		System.out.println("Time is "+(end - start));
	}

}
