import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Testing {
	static void swap(char a, char b){
		char temp;
		temp = a;
		a = b;
		b = temp;
	}
	static void swapNums(int [] a){
		int rPointer = a.length -1;
		for(int lPointer = 0; lPointer < rPointer; lPointer++){
			if(a[lPointer] == 0){
				for(int i = lPointer; i < rPointer; i++){
					a[i] = a[i] ^ a[i+1];
					a[i+1] = a[i] ^ a[i+1];
					a[i] = a[i] ^ a[i+1];
				}
				rPointer--;
				lPointer--; //decrement cos we move zero away
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map <Character, Integer> wordCount = new HashMap<Character, Integer>();
		String check = "and so it goes the rain";
		for(int i = 0; i < check.length(); i++){
			char c = check.charAt(i);
			if(c != ' ')
			if(wordCount.containsKey(c)){
				wordCount.put(c, wordCount.get(c) + 1);
			}else{
				wordCount.put(c, 1);
			}
		}
		System.out.println(wordCount.toString());
		int [] a = new int [] {1,0,3,5,2,4,0,5,6,0,3,6,3,3};
		swapNums(a);
		System.out.println(Arrays.toString(a));
		
	}

}
