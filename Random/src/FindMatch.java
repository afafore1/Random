import java.util.Arrays;
import java.util.List;

public class FindMatch {
	static int[] pop1save = new int[4];
	static int[] pop2save = new int[4];
	static int[] pop3save = new int[4];
	static int[] pop4save = new int[4];
	static int[] pop5save = new int[4];
	
	static int[] fitnessLevel(int a, int b, int c, int d, int e){
		int results [] = new int []{a,b,c,d,e};
		Arrays.sort(results);
		return results;
	}
	static int[] population(int ans, int gen){
		int [] result = new int[4];
		int [] pop1 = new int [4];
		int [] pop2 = new int[4];
		int [] pop3 = new int[4];
		int [] pop4 = new int[4];
		int [] pop5 = new int[4];
		for(int i = 0; i < pop1.length; i++){
			int value1 = (int)(Math.random() * ans);
			pop1[i] = value1;
			pop1save[i] = value1;
			int value2 = (int)(Math.random() * ans);
			pop2[i] = value2;
			pop2save[i] = value2;
			int value3 = (int)(Math.random() * ans);
			pop3[i] = value3;
			pop3save[i] = value3;
			int value4 = (int)(Math.random() * ans);
			pop4[i] = value4;
			pop4save[i] = value4;
			int value5 = (int)(Math.random() * ans);
			pop5[i] = value5;
			pop5save[i] = value5;
		}
			int p1 = (pop1[0] + (2*pop1[1]) + (3*pop1[2]) + (4 * pop1[3]) - ans);
			int p2 = (pop2[0] + (2*pop2[1]) + (3*pop2[2]) + (4 * pop2[3]) - ans);
			int p3 = (pop3[0] + (2*pop3[1]) + (3*pop3[2]) + (4 * pop3[3]) - ans);
			int p4 = (pop4[0] + (2*pop4[1]) + (3*pop4[2]) + (4 * pop4[3]) - ans);
			int p5 = (pop5[0] + (2*pop5[1]) + (3*pop5[2]) + (4 * pop5[3]) - ans);
			System.out.println(p1+" "+p2+" "+p3+" "+p4+" "+p5);
			result = fitnessLevel(p1,p2,p3,p4,p5);
		return result;
	}
	
	static void breedAndCombine(){
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int ans = 30;
		System.out.println(population(ans,0));
		
		

	}

}
