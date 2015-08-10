package Cool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class test {	
    public static boolean test(String post)
    {
    	Stack<Character> s = new Stack<Character>();
    	for(int i =0; i < post.length(); i++){
    		if(post.charAt(i) == '(') s.push('(');
    		if(post.charAt(i) == ')'){
    			if(s.isEmpty())	return false;
    			if(s.pop() != '(') return false;
    		}
    	}
    	return s.isEmpty();

    }
    
    public static String calculate(String f,String opr,String l)
	{
		int num1 = Integer.parseInt(f);
		int num2 = Integer.parseInt(l);
		int result = 0;
		if (opr == "+")
		{
			result = num1 + num2;
		}
		else if (opr == "-")
		{
			result = num1 - num2;
		}
		else if (opr == "*")
		{
			result = num1 * num2;
		}
		else if (opr == "/")
		{
			result = num1 / num2;
		}
		else if (opr == "%")
		{
			result = num1 % num2;
		}
		return ""+result;
	}
    
	public static String compute(String input) {
		        Stack<String> tempList = new Stack<String>();
		        String [] tempo = new String[input.length()];
		        for(int i = 0; i < input.length(); i++){
		        	String temp = input.charAt(i);
		        	System.out.println(temp);
		        	if (temp.matches("[0-9]*")) {
		        		//If the current item is a number (aka operand), push it onto the stack
		        		tempList.push(temp);
		        	} else {
		        		//If the current item is an operator we pop off the last two elements 
		        		//of our stack and calculate them using the operator we are looking at. 
		        		//Push the result onto the stack. 
		        		if (temp == "*") {
		        			int rs = Integer.parseInt(tempList.pop());
		        			System.out.println(rs);
		        			int ls = Integer.parseInt(tempList.pop());
		        			int result = ls * rs;
		        			tempList.push(String.valueOf(result));
		        		} else if (temp ==  "-") {
		        			int rs = Integer.parseInt(tempList.pop());
		        			int ls = Integer.parseInt(tempList.pop());
		        			int result = ls - rs;
		        			tempList.push(String.valueOf(result));
		        		} else if (temp ==  "/") {
		        			int rs = Integer.parseInt(tempList.pop());
		        			int ls = Integer.parseInt(tempList.pop());
		        			int result = ls / rs;
		        			tempList.push(String.valueOf(result));
		        		} else if (temp == "+") {
		        			int rs = Integer.parseInt(tempList.pop());
		        			int ls = Integer.parseInt(tempList.pop());
		        			int result = ls + rs;
		        			tempList.push(String.valueOf(result));
		        		}
		        	}
		        }		        	
		//Return the last element on the Stack.
		        return tempList.pop();
		    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner sc = new Scanner(System.in);
//		System.out.print("Enter: ");
//		String en = sc.nextLine();
//		if(!test(en)){
//			System.out.println("Error in expression!! No matching right parentheses for left parentheses");
//		}
//		System.out.println(compute(en));
		String input = "ayomitunde44";
		String [] tempo = new String [input.length()];
		for(int i = 0; i < input.length(); i++){
			
			System.out.println(input.charAt(i));
		}
	}

}
