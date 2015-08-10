
public class FindAllPossibleSubset {

	public static void main(String[] args) {
		int [] a = new int[] {1,2,3,4,5};
		int k = 3;
		int len = a.length;
		int result = 0;
		
		StringBuffer s = new StringBuffer();
		int diff = len - k;
		
		for(int i = 1; i <=diff; i++){
			s.append('0');
		}
		for(int i = 1; i <= k; i++){
			s.append('1');
		}
		
		String binStr = s.toString();
		String finalbinStr = s.reverse().toString();
		int last = Integer.parseInt(finalbinStr,2);
		System.out.println("Subsets of size "+k +" are");
		printSubset(a, binStr);
		result = Integer.parseInt(binStr,2);
		while(result < last){
			binStr = findNext(result, len);
			printSubset(a,binStr);
			result = Integer.parseInt(binStr,2);
		}

	}
	
	public static void printSubset(int[] a, String binaryString){
		int len = binaryString.length();
		for(int i = 0; i < len; i++){
			if(binaryString.charAt(i) == '1'){
				System.out.println(a[i]+ " ");
			}
		}
		System.out.println();
	}

}
