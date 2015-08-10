package Steph;
import java.util.Arrays;
import java.util.Scanner;

public class array2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][] raise = new int [5][2];
		Scanner sc = new Scanner(System.in);		
		for(int i = 0;i < raise.length; i++){
			for(int j = 0; j < 1; j++){
				System.out.println("Enter value: ");
				raise[i][j] = sc.nextInt();
			}
		}

		for(int i = 0; i < raise.length; i++){
			for(int j = 0; j < 1; j++){
				System.out.println(raise[i][j]+": "+raise[i][j]*raise[i][j]);
			}
		}
	}
}

/*1 1
 * 4 16
 * 6 36
 * 8 64
 * 7 49
 */


