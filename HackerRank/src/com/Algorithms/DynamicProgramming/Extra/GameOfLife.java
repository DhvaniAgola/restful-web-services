package com.Algorithms.DynamicProgramming.Extra;

import java.util.Scanner;

public class GameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int r = scn.nextInt();
		int c = scn.nextInt();
//		char arr[][] = new char[r][c];
		Scanner scnString = new Scanner(System.in);
//		for (int i = 0; i < r; i++) {
//			for (int j = 0; j < c; j++) {
//				arr[i][j] = scnString.next().charAt(0);
//			}
//
//		}
		char arr[][] = { { '#', '@', '#' }, { '#', '@', '@' }, { '@', '#', '@' } };
		int n = scn.nextInt();
		char ans[][] = new char[r][c];
		ans = checkLife(r, c, arr, n);
		int finalans = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(ans[i][j]);
				if (ans[i][j] == '@')
					finalans++;
			}
			System.out.println();
		}
		System.out.println(finalans);
	}

	private static char[][] checkLife(int r, int c, char[][] arr, int n) {
		// TODO Auto-generated method stub
		int count = 0;
		char arrNew[][] = new char[r][c];
		while (n-- > 0) {
			arrNew = new char[r][c];
			count = 0;
			for (int i = 0; i < r; i++) {

				for (int j = 0; j < c; j++) {

					count = countNeightbour(r, c, i, j, arr, arrNew);
					arrNew = makeDicision(i, j, arr, arrNew, count);
				}
			}
			arr = arrNew;
		}
		return arrNew;
	}

	private static char[][] makeDicision(int i, int j, char[][] arr, char[][] arrNew, int count) {
		// TODO Auto-generated method stub
		if (arr[i][j] == '@') {
			if (count == 0 || count == 1 || count >= 4) {
				arrNew[i][j] = '#';
			} else {
				arrNew[i][j] = arr[i][j];
			}
		} else {
			if (count == 3) {
				arrNew[i][j] = '@';
			} else {
				arrNew[i][j] = arr[i][j];
			}
		}
		return arrNew;
	}

	private static int countNeightbour(int r, int c, int i, int j, char[][] arr, char[][] arrNew) {
		// TODO Auto-generated method stub
		int count = 0;
		if (i > 0) {

			if (arr[i - 1][j] == '@')
				count++;
			if (j > 0) {
				if (arr[i - 1][j - 1] == '@')
					count++;
			}

			if (j < c - 1) {
				if (arr[i - 1][j + 1] == '@')
					count++;

			}
		}
		if (j > 0) {
			if (arr[i][j - 1] == '@')
				count++;
		}
		if (j < c - 1) {
			if (arr[i][j + 1] == '@')
				count++;
		}

		if (i < r - 1) {
			if (arr[i + 1][j] == '@')
				count++;
			if (j > 0) {
				if (arr[i + 1][j - 1] == '@')
					count++;
			}
			if (j < c - 1) {
				if (arr[i + 1][j + 1] == '@')
					count++;
			}
		}
		return count;
	}

}
