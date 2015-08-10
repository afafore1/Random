
public class GCD {
	
	public static int findGCD(int i, int x){
		if(x == 0){
			return i;
		}
		if(i/2 == x && i%x ==0){
			return x;
		}
		return findGCD(x, i%x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 54;
		int x = 1024;
		System.out.println(findGCD(i,x));

	}

}
