package Cool;

import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class PostCalc {
	 public static boolean isOperand(String s)
	  {
	    int test=0;
	    try
	    {
	      test=Integer.parseInt(s); 
	    }
	    catch (Exception ignore)
	    {
	      return false;
	    }
	    return true;
	  }
	 
	  public static boolean isOperator(String token)
	  {
	    String tokenList="+-*/%()";
	    if (tokenList.indexOf(token)>=0) 
	    	return true;
	    return false;
	  }
	  public boolean Precedence(char a, char b)
	  {
		  return (a == '(') || ((a == '*' || a == '/' || a == '%') && b!= '(') || ((a == '+' || a == '-')&&(b =='+'|| b == '-' || b == ')'));
	  }
	  
	  public static String mathmatics(String operand1, String operand2, String operator)
	  {
	    int value1=Integer.parseInt(operand1);
	    int value2=Integer.parseInt(operand2);
	    int result=0;
	 
	    if (operator.equals("+"))
	    {
	      result=value1+value2;
	    }
	    else if (operator.equals("-"))
	    {
	      result=value1-value2;
	    }
	    else if (operator.equals("*"))
	    {
	      result=value1*value2;
	    }
	    else if (operator.equals("/"))
	    {
	      result=value1/value2;
	    }
	    else if (operator.equals("%"))
	    {
	    	result =value1%value2;
	    }
	 
	    return ""+result; 
	  }
	 
	  public static int evaluate(String postfix)
	  {
	    Stack<String> stack=new Stack<String>();
	    StringTokenizer st = new StringTokenizer(postfix);
	    while (st.hasMoreTokens())
	    {
	      String token=st.nextToken();
	      checkForDouble(token);
	      if (isOperand(token))
	      {
	        stack.push(token);
	      }
	      if (isOperator(token))
	      {
	        String operand2=stack.pop();
	        String operand1=stack.pop();
	        String value=mathmatics(operand1,token,operand2);
	        stack.push(value);
	      }
	      if (token.equals("_")) {
	    	  String operand = stack.pop();
	    	  String temp = "-" + operand;
	    	  stack.push(temp);
	      }
	    }
	     
	    String result = stack.pop();
	    return Integer.parseInt(result);
	  }
	  
	 public static void checkForDouble(String token) {
		 char[] stringArr;
		 stringArr = token.toCharArray();
		 for (int i=0; i < stringArr.length; i++) {
			 if (stringArr[i] == '.') {
				 System.out.println("Error in expression!! Cannot accept floating point numbers.");
				 System.exit(1);
			 }
			 
		 }
	}

	public static void check(String post) {
		 char[] stringArr;
		 stringArr = post.toCharArray();
		 if (stringArr[0] == '+' || stringArr[0] == '-' || stringArr[0] == '*' || stringArr[0] == '/' || stringArr[0] == '%') {
			 System.out.println("Error in expression!! Not a postfix expression. Expression cannot start with an operator.");
			 System.exit(1);
		 }
		 for (int i=0; i < stringArr.length; i++) {
			 if (stringArr[i] == '(' && !(stringArr[i] == ')')) {
				 System.out.println("Error in expression!! No matching right parentheses for left parentheses");
				 if (!(stringArr[i] == '(') && stringArr[i] == ')')
				 {
					 System.out.println("Error in expression!! No matching left parentheses for right parentheses");
				 }
				 
				 System.exit(1);
			 } 
		 }
	 }
	
	public static void checkOp(String post) {
		StringTokenizer st = new StringTokenizer(post);
		int operator = 0;
		int operand = 0;
		while (st.hasMoreTokens()) {
			String token=st.nextToken();
			if (isOperand(token))
				operand++;
			else if (isOperator(token))
				operator++;
		}
		if (operator == operand) {
			System.out.println("Error in expression!! Cannot have equal number of operands and operators.");
			System.exit(1);
		}
	}
	 
	  
	  public static void main(String[] args)
	  {
		Scanner scan = new Scanner(System.in);
	    String postfix; 
	    String X;
	    boolean quit =  false;
	    System.out.println("Enter infix expression:");
	    postfix = scan.nextLine();
	    if(postfix.contains("x")){
	    while(!quit) {
	    System.out.println("Enter value for x");
	    X = scan.nextLine();
	    if (X.equals("q")) {
	    	System.exit(1);
	    }
	    String replacedString = postfix.replaceAll("x", X);
	    check(replacedString);
	    checkOp(replacedString);
	    int result=evaluate(replacedString);
	    System.out.println("Answer to expression "+result);
	    }
	    }
	  }
}
