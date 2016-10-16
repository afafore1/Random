import java.util.ArrayList;
import java.util.HashMap;

public class LongestNonRepeatChar {

	public static void nonRepChar(String s){
		HashMap<Character, Boolean> flag = new HashMap<Character, Boolean>();
		HashMap<Character, Integer> charIndex = new HashMap<Character, Integer>();
		ArrayList<String> substrings = new ArrayList<>();

		for(int i = 0; i < s.length(); i++){
			flag.put(s.charAt(i), false);
			charIndex.put(s.charAt(i), i);
		}

		String sol = "";
		for(int i = 0; i < s.length(); i++){
			if(flag.get(s.charAt(i)) == true){
				substrings.add(sol);
				if(i+1 < s.length()){
					if(s.charAt(i-1) == s.charAt(i)){
						sol = String.valueOf(s.charAt(i));
						sol += s.substring(s.indexOf(s.charAt(i))+1, i);
						System.out.println(sol);
					}else{
						sol = s.substring(s.indexOf(s.charAt(i))+1, i);
					}
				}
				//flag.put(s.charAt(i), false);
			}else{
				flag.put(s.charAt(i), true);
				sol += s.charAt(i);
			}
		}
		String lSubstring = "";
		for(int i = 0; i < substrings.size(); i++){
			if(substrings.get(i).length() > lSubstring.length()){
				lSubstring = substrings.get(i);
			}
		}
		System.out.println(substrings);
		System.out.println("Answer is "+lSubstring);
	}

	public static void main(String[] args) {
		nonRepChar("geeksforgeeks");
	}

}
