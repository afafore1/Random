
public class CubeRoot {
	
	public static double sqrt(int number){
		double t; // declare a var t
		double squareroot = number/3; // divide num by 2 e.g 9/2 = 4.0
		do{
			t = squareroot; // t = 4.0.. |t = 3.0|..
			squareroot = (t + (number /t)) / 3; // (4.0 +(9/4.0))/2 ..|3.0|...(3+(9/3))/2=3.0
		}while ((t - squareroot) != 0); // keep doing this while t-sqrt is not 0 ... |4-3 != 0|..do again
		
		return squareroot;
	}

	public static void main(String[] args) {
		int n = 27;
		System.out.println(sqrt(n));
		System.out.println(Math.cbrt(n));

	}

}
