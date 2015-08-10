import java.util.HashSet;
import java.util.List;
import java.util.Arrays;
import java.util.Set;


public class CheckDuplicatesInArray {
	
	public static boolean bruteforce(String[] in){
		for(int i = 0; i< in.length; i++){
			for(int j = 0; j < in.length; j++){
				if(in[i].equalsIgnoreCase(in[j]) && i != j){
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean bruteforceInt(int[] s){
		for(int i = 0; i < s.length; i++){
			for(int j = 0; j < s.length; j++){
				if(s[i] == s[j] && i!=j){
					System.out.println("duplicates are "+s[i] +" and "+s[j]);
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean Set(String[] in){
		List inputLst = Arrays.asList(in);
		Set inputSet = new HashSet(inputLst);
		if(inputSet.size() < inputLst.size()){
			return true;
		}
		return false;
	}
	
//	public static boolean SetInt(int [] s){
//		List inLst = Arrays.asList(s);
//		Set inSet = new HashSet(inLst);
//		if(inSet.size() < inLst.size()){
//			return true;
//		}
//		return false;
//	}
	
	public static boolean addSet(String [] in){
		Set tempSet = new HashSet();
		for(String s : in){
			if(!tempSet.add(s)){
				return true;
			}
		}
		return false;
	}
	public static boolean SetInt(int [] s){
		Set tempset = new HashSet();
		for(int x : s){
			if(!tempset.add(x)){
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] names = new String[] {"Ayo", "Shade", "Steph", "Ayo"};
		int [] s = new int [] {2,5,3,6,4};
		System.out.println(bruteforceInt(s));
		System.out.println(SetInt(s));
		System.out.println(bruteforce(names));
		System.out.println(Set(names));
		System.out.println(addSet(names));

	}

}
