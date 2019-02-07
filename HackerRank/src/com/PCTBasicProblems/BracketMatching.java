package com.PCTBasicProblems;

import java.util.Scanner;
import java.util.Stack;

public class BracketMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
//		String input[] = new String[n];
		String input[] = { "(the[is]{valid})", "{the(is[valis])}", "(this)(is)(valid)", "([{this is valid}])",
				"(the[is]{invalid))", "(the[is]{invalid}}", "(this](is}{invalid))", "({[this is invalid})]",
				"(the[is]{valid})", "(the[is]{valid))", "{this(is[valid])}", "(this](is}{valid)" };
		Scanner scnString = new Scanner(System.in);
//		for (int i = 0; i < n; i++)
//			input[i] = scnString.nextLine();

		String output[] = new String[n];
		output = matchBrackets(input);
		for (int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}

	private static String[] matchBrackets(String[] input) {
		// TODO Auto-generated method stub
		String output[] = new String[input.length];
		Stack<Integer> stc = new Stack<>();
		for (int i = 0; i < input.length; i++) {
			stc.clear();
			for (int j = 0; j < input[i].length(); j++) {
				if (input[i].charAt(j) == '{' || input[i].charAt(j) == '[' || input[i].charAt(j) == '(')
					stc.push((int) input[i].charAt(j));
				else if (input[i].charAt(j) == '}') // ||input[i].charAt(j)==']' ||input[i].charAt(j)=='(')
				{
					if (stc.lastElement() == '{')
						stc.pop();
					else
						break;
				} else if (input[i].charAt(j) == ']') // ||input[i].charAt(j)==']' ||input[i].charAt(j)=='(')
				{
					if (stc.lastElement() == '[')
						stc.pop();
					else
						break;
				} else if (input[i].charAt(j) == ')') // ||input[i].charAt(j)==']' ||input[i].charAt(j)=='(')
				{
					if (stc.lastElement() == '(')
						stc.pop();
					else
						break;
				}
			}
			if (stc.isEmpty())
				output[i] = "TRUE";
			else
				output[i] = "FALSE";
		}

		return output;
	}

}
