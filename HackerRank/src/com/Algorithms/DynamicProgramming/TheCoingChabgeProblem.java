//Program is correct but fails for some testcases due to timeout

package com.Algorithms.DynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

public class TheCoingChabgeProblem {
	static int count = 0;

	/**
	 * @param n
	 * @param c
	 * @return
	 */
	public static long getWays(long n, long c[]) {

		long min = findMin(c);
		long limit = n / min;
		for (int i = 1; i <= limit; i++) {
			getSum(c, c.length, i, n);
		}
		return count;
	}

	public static long findMin(long c[]) {
		long min = c[0];
		for (int i = 0; i < c.length; i++) {
			if (c[i] < min)
				min = c[i];
		}
		return min;
	}

	public static void getSum(long c[], int length, int r, long n) {
		long data[] = new long[r];
		combination(c, data, 0, length - 1, 0, r, n);
	}

	public static void combination(long c[], long data[], int start, int end, int index, int r, long n) {
		if (r == index) {
			long sum = 0;
			for (int i = 0; i < r; i++) {
				sum += data[i];
			}
			checkSum(sum, data, n);
			return;
		}
		for (int i = start; i <= end; i++) {// for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = c[i];
			combination(c, data, i, end, index + 1, r, n);
		}
	}

	public static void checkSum(long sum, long data[], long n) {
		if (n == sum) {
			for (int i = 0; i < data.length; i++)
				System.out.print(data[i] + " ");
			System.out.println();
			count++;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int m = scn.nextInt();
		long c[] = new long[m];
		for (int i = 0; i < m; i++) {
			c[i] = scn.nextInt();
		}
		long ans = getWays(n, c);
		System.out.println(ans);
	}

}
