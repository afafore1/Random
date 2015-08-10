
public class Pal {
	
	public static boolean isPal(String s, String y){
		if(s.length() != y.length()){
			return false;
		}
		char [] w1 = s.toCharArray();
		char [] w2 = y.toCharArray();
		int fiterator = 0;
		int biterator = w2.length -1;
		while(!(fiterator > w1.length-1) || !(biterator < 0))
		{
			if(w1[fiterator] != w2[biterator] ){
				return false;
			}
			fiterator++;
			biterator++;
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "ayayayayayayayaya";
		System.out.println(isPal(s,""));

	}

}
