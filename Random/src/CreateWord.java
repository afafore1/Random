import java.util.ArrayList;

public class CreateWord {
	static ArrayList<String> dict = new ArrayList<String>();
	
	public static boolean isInDictionary(String word){
		dict.add("mobile");
		dict.add("samsung");
		dict.add("go");
		dict.add("i");
		dict.add("like");
		dict.add("ice");
		dict.add("icecream");
		dict.add("sam");
		dict.add("sung");
		dict.add("man");
		dict.add("mango");
		dict.add("and");
		dict.add("cream");
		if(dict.contains(word)) return true;
		return false;
	}
	
	public static boolean wB(String str){
		int len = str.length();
		if(len == 0) return true;
		boolean [] wb = new boolean[len+1];
		for(int i = 1; i <= len; i++){
			//if wb[i] is false, then check if current prefix can make it true
			if(wb[i] == false && isInDictionary(str.substring(0,i))) wb[i] = true;
			if(wb[i]){
				if(i == len) return true;
				for(int j = i+1; j <=len; j++){
					if(wb[j] == false && isInDictionary(str.substring(i, j-1))) wb[j] = true;
					if(j == len && wb[j]){
						return true;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		if(wB("ilikesamsung")){
			 System.out.println("Yes\n");
		}else{
			 System.out.println("nah");;
		}

	}

}
