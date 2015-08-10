package Cool;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Calculator {
	public static void main(String[] args)
	{
		boolean quit = false; // This will be used later to terminate the program
		/*
		 * Get user's expression and make calculation
		 * Also replace x if there is an x in the user input
		 */
		Scanner sc = new Scanner(System.in);		
		System.out.print("Enter an infix expression: ");
		String postfix = sc.nextLine();
		if(postfix.contains("x")){
			while(!quit) 
			{
				System.out.print("Enter a value for x: ");
				String X = sc.nextLine();
				if (X.equals("q")) {
					System.exit(1);
				}
				String getXvalue = postfix.replaceAll("x", X);
				if(!isFloat(getXvalue)){
					if(test(getXvalue)){
						String rsult = compute(getXvalue);
						System.out.println("Answer to expression: "+rsult);
					}else{
						System.out.println("Error in expression!! No matching right parentheses for left parentheses");
					}
				}
			}
		}
		else {
			if (!isFloat(postfix)){
				System.out.print("Error, cannot accept a floats!!");
			}else if(isFloat(postfix) && test(postfix)){
				String result = compute(postfix);
				System.out.println("Answer to expression: "+result);	
			}
		}
	}

	// This is used to check for floating numbers. If it exist, print out an error message
	public static boolean isFloat(String Htoken){
		char[] sr = Htoken.toCharArray();
		for (int j = 0; j< sr.length; j++){
			if(sr[j] != '.'){
				continue;
			}
			else if(sr[j] == '.'){
				return false;
			}
		}
		return true;
	}
//	 This is used to perform the operation based on the operator specified.
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
	// Used to check the operators allowed.
//	public static boolean isOprt(String htoken)
//	{
//
//		String OprtL = "+-%/*()";
//		if (OprtL.indexOf(htoken) >=0)
//			return true;
//		else
//			return false;
//
//
//	}
	// Used to check the operands allowed.
//	public static boolean isOprd(String operand)
//	{
//		int check;
//		try
//		{
//			check = Integer.parseInt(operand);
//		}
//		catch (Exception ignore)
//		{
//			return false;
//		}
//		return true;
//	}
	// this is used to check the expression entered. Used to check matching parentheses and where the operator is entered
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

	// Used to check order of precedence
//	public boolean orderEquation(String l, String r) {
//
//		return (l == "(") || ((l == "*" || l == "/" || l == "%") && r!= "(") || ((l == "+" || l == "-")&&(r =="+"|| r == "-" || r == ")"));
//	}
//	public static void cP(String postfix) {
//		StringTokenizer st = new StringTokenizer(postfix);
//		int oprt = 0;
//		int oprd = 0;
//		while (st.hasMoreTokens()) {
//			String htoken = st.nextToken();
//			if (isOprd(htoken)){
//				oprd++;					 
//			}
//			else if (isOprt(htoken)){
//				oprt++;
//			}
//			if (oprt == oprd){
//				System.out.println("Error in expression!! Cannot have equal number of operators and operands.");
//			}
//		}
//	}

	public static String compute(String input) {
		//Process the list into an ArrayList
		        ArrayList<String> processedList = new ArrayList<String>();
		        if (input.isEmpty()) {
		            return "Error";
		        } else {
		        	StringTokenizer st = new StringTokenizer(input);
		            while (st.hasMoreTokens()) {
		                processedList.add(st.nextToken());
		            }
		        }
		//A Stack, we will use this for the calculation
		        Stack<String> tempList = new Stack<String>();
		//Iterate over the whole processed list
		        Iterator<String> iter = processedList.iterator();
		        while (iter.hasNext()) {
		        	String temp = iter.next();
		        	if (temp.matches("[0-9]*")) {
		        		//If the current item is a number (aka operand), push it onto the stack
		        		tempList.push(temp);
		        	} else if (temp.matches("[(*-/+)]")) {
		        		//If the current item is an operator we pop off the last two elements 
		        		//of our stack and calculate them using the operator we are looking at. 
		        		//Push the result onto the stack. 
		        		if (temp.equals("*")) {
		        			int rs = Integer.parseInt(tempList.pop());
		        			int ls = Integer.parseInt(tempList.pop());
		        			int result = ls * rs;
		        			tempList.push("" + result);
		        		} else if (temp.equals("-")) {
		        			int rs = Integer.parseInt(tempList.pop());
		        			int ls = Integer.parseInt(tempList.pop());
		        			int result = ls - rs;
		        			tempList.push("" + result);
		        		} else if (temp.equals("/")) {
		        			int rs = Integer.parseInt(tempList.pop());
		        			int ls = Integer.parseInt(tempList.pop());
		        			int result = ls / rs;
		        			tempList.push("" + result);
		        		} else if (temp.equals("+")) {
		        			int rs = Integer.parseInt(tempList.pop());
		        			int ls = Integer.parseInt(tempList.pop());
		        			int result = ls + rs;
		        			tempList.push("" + result);
		        		}else {
		        			return "Error";
		        		} 
		        	}
		        }
		//Return the last element on the Stack.
		        return tempList.pop();
		    }
}
