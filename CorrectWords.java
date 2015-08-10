
public class CorrectWords {

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
	static void getNearWord(char s){
		char x = s.charAt(0);
		System.out.println(x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] words = {"101", "123"};
		permute(words, 0,"");
		char s = 'h';
		System.out.println((int)s);
	}

	}
