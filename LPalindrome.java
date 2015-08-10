
public class LPalindrome {

	public static String longestPalindrome(String s){
		char[] c = s.toCharArray();
		int maxlen = 0; 
		int len = 0;
		int begin = 0;
		for(int i = 0; i < s.length()-1;i++){
			len = 0;
			while(i-len-1 >= 0 && i+len+1<s.length() && c[i-len-1]== c[i+len+1]){
				len+=1;
			}
			if(len*2+1 > maxlen){
				begin = i-(len-1)-1;
				maxlen = len*2+1;
			}
			len = 0;
			while(i>=len && i+len+1<s.length() && c[i-len]==c[i+len+1]){
				len+=1;
			}
			if(len*2 > maxlen){
				begin = i-(len-1);
				maxlen = len*2;
			}
		}
		return new String(c,begin,maxlen);
	}
	public static void main(String[] args) {
		String s = "thisisatestforlongestljkdioehlayayayylkjdayayayayayayayayakahkdh";
		System.out.println(longestPalindrome(s));

	}

}
