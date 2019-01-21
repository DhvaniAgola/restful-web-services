//Program is not correct

package com.Algorithms.DynamicProgramming;

import java.util.Scanner;

public class constructTheArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k = scn.nextInt();
		int x = scn.nextInt();
		long answer = countArray(n, k, x);
		System.out.println(answer);
	}

	private static long countArray(int n, int k, int x) {
		// TODO Auto-generated method stub
		long modulo = 1000000007;
		int tempN = n - 4;
		long param = 1;
		long cal1 = 0;
		long cal2 = 0;
		while (tempN > 0) {
			if (tempN >= 2) {
				param *= (long) Math.pow(k - 1, 2);
				tempN -= 2;
			} else {
				param *= (long) Math.pow(k - 1, tempN);
				tempN -= tempN;
			}
			if (param > modulo) {
				param = param % modulo;
			}
		}
		param *= (k - 2);
		if (param > modulo) {
			param = param % modulo;
		}
		cal1 = param;
		cal2 = param * (k - 1);
		if (cal2 > modulo) {
			cal2 = cal2 % modulo;
		}
		cal1 += cal2;
		if (cal1 > modulo) {
			cal1 = cal1 % modulo;
		}
		return cal1;
	}

}
