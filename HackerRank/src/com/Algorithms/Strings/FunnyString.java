//Correct Program

package com.Algorithms.Strings;

import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		Scanner scn2 = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			String str = scn2.nextLine();
			System.out.println(checkFunnyString(str));
		}
	}

	public static String checkFunnyString(String str) {
		StringBuilder sb = new StringBuilder(str);
		String r = sb.reverse().toString();
		int s, reverse;
		boolean flag = true;
		for (int i = 0; i < str.length() - 2; i++) {
			s = str.charAt(i) - str.charAt(i + 1);
			if (s < 0)
				s *= -1;
			reverse = r.charAt(i) - r.charAt(i + 1);
			if (reverse < 0)
				reverse *= -1;
			if (s != reverse) {
				flag = false;
				break;
			}
		}
		if (flag)
			return "Funny";
		else
			return "Not Funny";
	}

}
