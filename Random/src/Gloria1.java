import java.util.Arrays;

public class Gloria1 {

	public static int countDigits(int n)
	{
		String number = String.valueOf(n); // convert the number to string... and then get length.
		return number.length();
	}
	public static void main(String[] args) {
		int [] age = new int[50];
		int [] a = new int[] {11,82,53,4};
		int x = 0;
		int maxAge = 0;
		for(int i = 0; i < age.length; i++)
		{
			age[i] = (int)(Math.random() * 50);
		}
		while(x < age.length)
		{
			if(maxAge < age[x])
			{
				maxAge = age[x];
			}
			x++;
		}

		System.out.println("Max age is "+maxAge);
		System.out.println("Digit count is "+countDigits(38234));
		System.out.println("a = "+Arrays.toString(a)+" Reversed a = "+Arrays.toString(reverseArray(a)));
		int [][] aa = new int [2][2];
		aa[0][0] = 2;
		aa[0][1] = 4;
		aa[1][0] = 9;
		aa[1][1] = 18;
		System.out.println(percentEven(aa));
	}
	
	public static double percentEven(int[][]pEven)
	{
		double perc = 0.0;
		int len = pEven.length * pEven[0].length;
		int numEven = 0;
		for(int i = 0; i < pEven.length; i++)
		{
			for(int j = 0; j < pEven.length; j++)
			{
				if(pEven[i][j] % 2 == 0)
				{
					numEven++;
				}
			}
		}
		if(numEven == 0) return 0.0;
		perc = (numEven/(double)len) * 100;
		return perc;
	}
	
	public static int [] reverseArray(int [] a)
	{
		int[] newA = new int[a.length];
		for(int i = a.length - 1, j = 0; i >= 0; i--, j++)
		{
			newA[j] = a[i];
		}
		return newA;
	}

}
