package Cool;
import java.util.Arrays;
import java.util.Scanner;


public class Eric1 {
	public static double m(int i){
			if(i == 1){
				return (double)i/(2.*+1.);
			}else{
				return (double)i/(double)(2.*i+1)+m(i-1);
			}
			
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter value for i: ");
		int i = sc.nextInt();
		for(int x = 1; x <= i; x++){
			System.out.println(m(x));
		}
		
	}

}
