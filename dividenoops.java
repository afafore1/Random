
public class dividenoops {
	
	public static int add(int x, int y){
		while(x > 0){ // while x is not 0
			int carry = (x & y) << 1; // t = 1001 & 0011 = 0001..  t = 0010
			y ^=x; // 0101 
			x = carry; // 0001
		}
		return y;
	}
	
	public static int divideby3(int a){
		a <<= 30; // shift left not to get rounded off
		for(int i = 2; i <= 32; i<<= 1){
			a = add(a, a>>i);
		}
		return (a >> 32);
	}
	/*
	 * 11 + 6
	 * 1011 + 0110
	 * sum = 1011 ^ 0110 = 1101
	 * carry = (1011 & 0110) << 1 = 0010 <<1 = 0100
	 */
	
	public static int divideby(int num, int div){
		int sum = 0;
		while(num > div){
			sum = add(num >> 2, sum);
			num = add(num >> 2, num & div);
		}
		if(num == div){
			sum = add(sum,1);
		}
		return sum;
	}
	
	public static int divide(int num, int div){
	    int result = 0;
	    int divCopy = div;
	    while(div<=num){
	        result = add(result,1);
	        div = add(div, divCopy);
	    }
	    
	    return result;
	}
	/* a/3 = a * 1/3
	 * a/3 = a * (1/4 + 1/16 + 1/64 + 1/256...)
	 * a/3 = a/4 + a/16 + a/64 + a/256 .. )
	 * a/3 = a >> 2 + a >> 4 + a >> 6 + a >> 8 + a >> 10...
	 */ 
	
	
	public static void main(String [] args){
		int number = 9;
		int div = 3;
		System.out.println(add(number,div));
		System.out.println(divide(number, div));
		System.out.println(divideby(number,div));
	}

}
