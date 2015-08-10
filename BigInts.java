import java.math.BigInteger;


public class BigInts {
	
	public static int bitwiseMul(int a, int b){
		if(a ==0||b==0){
			return 0;
		}
		if(a==1){
			return b;
		}else if(b == 1){
			return a;
		}
		int result = 0;
		while(b >= 1){
			if((b&1)== 1){
				result = result + a;
			}
			a <<= 1;
			b >>=1;
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 1098847899;
		int b = 298748974;
		BigInteger ab = BigInteger.valueOf(b);
		BigInteger bc = BigInteger.valueOf(a);
		System.out.println(ab.multiply(bc));
		
		System.out.println(bitwiseMul(a,b));

	}

}
