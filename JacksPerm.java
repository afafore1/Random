import java.util.Arrays;


public class JacksPerm {
	static int count = 0;
	public static void main(String[] args) {
		int n = 197;
		char[] str = String.valueOf(n).toCharArray(); // take num and put into charArray
		perm(str,0);
		
	}
	public static void swap(char[] str, int a, int b){
		char t = str[a]; 
		str[a] = str[b];
		str[b] = t;
	}
	public static void perm(char[] str, int pos){ // permutation calculation done here
			if(pos==str.length-1){ //check position, if it's equal to the length of str... then print it
				System.out.println(String.valueOf(str));
				return;
			}
			for(int i = pos;i<str.length;i++){ // loop to end of string
				swap(str,pos,i); // call swap method to swap whatever we have
				perm(str,pos+1); // call perm	
				swap(str,pos,i); // swap again
			}
	}
}
