package Cool;
import java.util.Scanner;

public class MatrixMul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter base of squared matrices");
		n = sc.nextInt();
		int[][] a = new int [n][n];
		int[][] b = new int [n][n];
		int[][] c = new int [n][n];
		
		System.out.println("Enter elements of first matrix row wise \n");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println("Enter elements of second matrix row wise \n");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				b[i][j] = sc.nextInt();
			}
		}
		System.out.println("Multiplying...");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				for(int k = 0; k < n; k++){
					c[i][j] = c[i][j] + a[i][k] * b[k][j];
				}
			}
		}
		System.out.println("Product is");
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				System.out.println(c[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();

	}

}
