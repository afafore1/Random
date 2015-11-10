import java.util.Arrays;

public class SecretaryProblem {

	public static void main(String[] args) {
		
		int [] cash = new int[100];
		for(int i = 0; i < cash.length; i++){
			cash[i] = (int) (Math.random() * 100 +1);
		}
		//System.out.println(Arrays.toString(cash));
		int p = 37;
		int nextBest = 0;
		int best = 0;
		for(int i = 0; i < p; i++){
			if(cash[i] > nextBest){
				nextBest = cash[i];
			}
		}
		for(int i = p; i < cash.length; i++){
			if(cash[i] > nextBest){
				best = cash[i];
				break;
			}
		}
		System.out.println(Arrays.toString(cash));
		System.out.println(best);

	}

}
