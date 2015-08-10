package Steph;

import java.util.Arrays;


public class CollisionTest {
	public static void main(String[] args)  {
		int [] isEven = new int [101];
		for(int i = 1; i <= 100; i++){
			if(i % 2 == 0){
				int value = i;
				isEven[i] = value;
			}

		}
		Arrays.sort(isEven);
		int [] top10 = Arrays.copyOfRange(isEven, isEven.length - 10,isEven.length);
		for(int i = top10.length -1; i >=0; i--){
			System.out.print(top10[i]+" ");
		}

	}
}
