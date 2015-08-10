
public class PermutationMany {
	
	static void permute(String[] words, int depth, String permutation){
		if(depth == words.length){
			System.out.println(permutation);
		}
		else{
			String w = words[depth];
			for(int i = 0; i < w.length(); i++){
				permute(words, depth + 1,permutation + w.charAt(i));
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] words = {"232", "123"};
		permute(words, 0,"");

	}

}
