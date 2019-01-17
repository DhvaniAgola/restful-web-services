package com.Algorithms.Warmup;

import java.util.Scanner;

public class DiagonalDifference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int dim = scn.nextInt();
		int arr[][] = new int[dim][dim];
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				arr[i][j] = scn.nextInt();
			}
		}

		int result = diagonalDifference(arr);
		System.out.println(result);
	}

	private static int diagonalDifference(int[][] arr) {
		// TODO Auto-generated method stub
		int sumLeftDia = 0;
		int sumRightDia = 0;
		int dif = 0;
		for (int i = 0; i < arr.length; i++) {
			sumLeftDia += arr[i][i];
			sumRightDia += arr[i][arr.length - 1 - i];
		}
		dif = sumLeftDia - sumRightDia;
		if (dif < 0)
			dif *= -1;
		return dif;
	}

}
