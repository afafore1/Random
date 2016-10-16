import java.math.BigInteger;

public class Networks1 {

	public static BigInteger fact(BigInteger n){
		return n.equals(BigInteger.ONE) ? BigInteger.ONE : n.multiply(fact(n.subtract(BigInteger.ONE)));
	}
	
	public static double binomailDist(int N, int n, double p){
		BigInteger Nvalue = BigInteger.valueOf(N);
		BigInteger nvalue = BigInteger.valueOf(n);
		BigInteger diff = Nvalue.subtract(nvalue);
		BigInteger div = fact(nvalue).multiply(fact(diff));
		BigInteger ans = fact(Nvalue).divide(div);
		double ansr = Double.parseDouble(ans.toString());
		ansr = ansr * Math.pow(p, n);
		double result = ansr * (Math.pow(1 - p, N-n));
		return result;
	}
	public static void main(String[] args) {
		int N = 35;
		int n = 10;
		double p = 0.1;
		double result = 0;
		for(n += 1; n < N; n++){
			result += binomailDist(N, n, p);
		}
		System.out.println(result);
	}

}
