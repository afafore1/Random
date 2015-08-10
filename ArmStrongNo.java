
public class ArmStrongNo {
	
	public static boolean isArmStrong(int n){ // 153
		int result = 0;
		int num = n;
		while(num > 0){
			int mod = num % 10;
			result = result + mod * mod * mod;
			num = num / 10;
		}
		if( result == n){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 153;
		System.out.println(isArmStrong(i));

	}

}
