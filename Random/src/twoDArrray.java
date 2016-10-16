import java.util.Arrays;

public class twoDArrray {
	public static int[][] processArray(int [][] arr){
		int[][] process = new int[arr.length+1][arr[0].length+1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if(arr[i][j] >= 0)
				process[i][process[i].length -1] = process[i][process[j].length -1]+1;
				process[process.length -1][j] = process[process.length -1][j] +1;
				process[i][j] = arr[i][j];
			}
			
		}

		return process;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] arr = new int[][]{{1,-2,0},{3,-4,-5}};
		int[][] p = processArray(arr);
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j <= p.length; j++) {
				System.out.print(p[i][j]+" ");
			}
			System.out.println();
		}
		

	}

}
