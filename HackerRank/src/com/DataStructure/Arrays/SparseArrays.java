package com.DataStructure.Arrays;

import java.util.Scanner;

public class SparseArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		Scanner scn2 = new Scanner(System.in);
		int noOfStrings = scn.nextInt();
		String strings[] = new String[noOfStrings];
		for (int i = 0; i < noOfStrings; i++) {
			strings[i] = scn2.nextLine();
		}

		int noOfQueries = scn.nextInt();
		String queries[] = new String[noOfQueries];
		for (int i = 0; i < noOfQueries; i++) {
			queries[i] = scn2.nextLine();
		}
		int[] res = matchingStrings(strings, queries);
		for (int i = 0; i < res.length; i++)
			System.out.println(res[i]);
	}

	private static int[] matchingStrings(String[] strings, String[] queries) {
		// TODO Auto-generated method stub
		int output[] = new int[queries.length];
		int count;
		for (int i = 0; i < queries.length; i++) {
			count = 0;
			for (int j = 0; j < strings.length; j++) {
				if (queries[i].equals(strings[j]))
					count++;
			}
			output[i] = count;
		}
		return output;
	}

}
