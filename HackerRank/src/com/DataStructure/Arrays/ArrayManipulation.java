//Program is correct but fails for some testcases due to timeout
package com.DataStructure.Arrays;

import java.util.Scanner;

public class ArrayManipulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int arrSize = scn.nextInt();

		int operations = scn.nextInt();
		int arrOp[][] = new int[operations][3];
		for (int i = 0; i < operations; i++) {
			for (int j = 0; j < 3; j++)
				arrOp[i][j] = scn.nextInt();
		}
		long result = arrayManipulation(arrSize, arrOp);
		System.out.println(result);
	}

	private static long arrayManipulation(int arrSize, int[][] arrOp) {
		// TODO Auto-generated method stub
		long arr[] = new long[arrSize];
		for (int i = 0; i < arrOp.length; i++) {
			for (int j = arrOp[i][0] - 1; j <= arrOp[i][1] - 1; j++) {
				arr[j] += arrOp[i][2];
			}
		}
		long max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}

}
