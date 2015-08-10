import java.util.LinkedList;


public class CamelCase {
	
	public static LinkedList<String> splitCamelCaseString(String s)	{
		char [] cArray = s.toCharArray();
		LinkedList<Integer> al = new LinkedList<Integer>();
		al.add(0);
		
		for(int i = 1; i < cArray.length; i++){
			char c = cArray[i];
			if(c >= 65 && c <= 90){ // check if letter is an uppercase and add it
				al.add(i); // add it here if it's uppercase
			}
		}
		
		LinkedList<String> strl = new LinkedList<String>();
		if(al.size() == 1){
			strl.add(s); // handle lowercase
			return strl;
		}
		
		int prev = 0;
		int curr = 0;
		int begin = 0;
		
		for (int x = 0; x < al.size(); x++){
			curr = al.get(x);
			if(curr == s.length() - 1){
				// do nothing
			}
			if(curr == prev + 1 && curr !=s.length() -1){
				prev = curr;
			} else if(curr == prev + 1 && curr == s.length() -1){
				strl.add(s.substring(begin, curr+1));
			}else {
				strl.add(s.substring(prev, curr));
				prev = curr;
				begin = curr;
				if(x == al.size() -1){
					strl.add(s.substring(curr, s.length()));
				}
			}
		}
		return strl;
	}

	public static void main(String[] args) {
		String camelcs =  "MyNameIsAyo";
		System.out.println(splitCamelCaseString(camelcs));

	}

}
