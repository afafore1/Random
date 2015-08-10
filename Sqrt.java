
public class Sqrt {

	public static double sqrt(double number){
		double t; // declare a var t
		double squareroot = number/2; // divide num by 2 e.g 9/2 = 4.0
		do{
			t = squareroot; // t = 4.0.. |t = 3.0|..
			squareroot = (t + (number /t)) / 2; // (4.0 +(9/4.0))/2 ..|3.0|...(3+(9/3))/2=3.0
		}while ((t - squareroot) != 0); // keep doing this while t-sqrt is not 0 ... |4-3 != 0|..do again
		
		return squareroot;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double num = 9.0;
		System.out.println(sqrt(num));

	}

}
