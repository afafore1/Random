package Cool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class testing {
	public static ArrayList<Integer> solution(int [] A)  {
		if(A == null){
			System.out.println("Error");
		}else if (A.length == 0){
			System.out.println("Error");
		}
		ArrayList<Integer> m = new ArrayList<Integer>();
		int p = 1;
		int sumlow = 0;
		int sumhigh = 0;
		int rsorter = A.length;
		for(int i = 0; i < p; i++ ){
			sumlow+=A[i]; 
			for(int j = p+1; j < rsorter; j++){
				sumhigh +=A[j];
			}
			if(sumlow==sumhigh){
				m.add(p);
				//return StringUtils.join(" - ", p);
				//System.out.println(sumlow+"This is p "+p);	
			}
			if(p != A.length) p++; sumhigh = 0;
			
		}
			return m;
		
		//		System.out.println(sumlow); this is for debug
		//		System.out.println(sumhigh);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] tes = {-1,3,-4,5,1,-6,2,1};
		long start = System.currentTimeMillis();
		System.out.println(solution(tes));
		long end = System.currentTimeMillis();
		System.out.println("Time taken "+(end-start)+" ms");

	}

}
