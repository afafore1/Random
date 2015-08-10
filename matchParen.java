import java.util.Stack;


public class matchParen {
	
	public static boolean isMatched(String s){
		if(s.length() == 0 || s.length() == 1){
			return false;
		}
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '('){
				stack.push('(');
			}else if(s.charAt(i) == ')'){
				if(!stack.isEmpty()){
					stack.pop();
				}else{
					return false;
				}
			}
		}
		if(stack.isEmpty())
			return true;
		else
			return false;
		 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()())()(())";
		String m = "(()()())()";
		System.out.println(isMatched(s));
		System.out.println(isMatched(m));

	}

}
