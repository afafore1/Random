
public class trythis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String workon = "a good boy is a good girl that likes bitches";
		String nob = null;
		String mula = "";
		if(workon.contains("b")){
			nob = workon.replaceAll("b", "");
		}
		if(nob.contains("a")){
			mula = nob.replaceAll("a", "aa");
		}
		char [] t = workon.toCharArray();
		for(int i = 0; i < t.length;i++){
			if(t[i] == 'b'){
				//System.out.println(t[i]);
			}
		}
		System.out.println(mula);
		
		String n = workon.replaceAll("b", "").replaceAll("a", "aa");
		System.out.println(n);

	}

}
