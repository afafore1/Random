
public class Countwords {
	
	public static int countWords(String str){
		if(str == null){
			return -1;
		}
		int count = 0;
		int len = str.length();
		
		char lastChar = str.charAt(0);
		for(int i = 0; i < len; i++){
			if(str.charAt(i) == ' ' && lastChar != ' '){
				++count;
				lastChar = ' ';
			}
			lastChar = str.charAt(i);
		}
		if(lastChar != ' '){
			++count;
		}
		return count;
	}

	public static void main(String[] args) {
		String str = " an b   c   d";
		System.out.println("String is "+str);
		System.out.println("word count is "+countWords(str));

	}

}
