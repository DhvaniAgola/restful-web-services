package com.PCTBasicProblems;

import java.util.Scanner;

public class TranscriptNamePrinting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		String input = scn.nextLine();
		String arr[] = new String[3];

		arr = input.split(" ");

		String FN = arr[0];
		String SN = "";
		String MN = "";
		if (arr.length == 3) {

			SN = arr[2];
			MN = arr[1];
		} else if (arr.length == 2) {

			if (arr[1] != null) {
				char c = arr[1].charAt(arr[1].length() - 1);
				if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' || c == 'a' || c == 'e' || c == 'i'
						|| c == 'o' || c == 'u')
					SN = arr[1];
				else
					MN = arr[1];
			}
		}

		String output = "";
		if (SN != "")
			output += SN;
		if (FN != "")
			output += " " + FN;
		if (MN != "")
			output += " " + MN;

		System.out.println(output.trim());
	}

}
