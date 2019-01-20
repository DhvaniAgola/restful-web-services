//Program is correct but fails for some testcases due to timeout
package com.Algorithms.DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SherlockAndCost {
	static List<Integer> lst = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Scanner scn = new Scanner(System.in);
//		int noOfInput = scn.nextInt();
//		for (int i = 0; i < noOfInput; i++) {
//			int n = scn.nextInt();
//			int B[] = new int[n];
//			for (int j = 0; j < n; j++) {
//				B[j] = scn.nextInt();
//			}
		int B[] = { 10, 1, 10, 1, 10 };
		lst.clear();
		int result = cost(B);

		System.out.println(result);
//		}
	}

	private static int cost(int[] B) {
		// TODO Auto-generated method stub
		int a[] = new int[B.length];

		createArrA(B, a, 0);
		int max = Collections.max(lst);
		return max;
	}

	private static void createArrA(int[] b, int a[], int index) {
		int tempindex = index;
		for (int j = 1; j <= b[index]; j++) {
			a[index] = j;

			if (index == b.length - 1) {
				checkSum(a);
			} else if (index < (b.length - 1)) {
				tempindex = index;
				createArrA(b, a, ++tempindex);
			}
		}
	}

	private static void checkSum(int[] a) {
		// TODO Auto-generated method stub
		int sum = 0;
		int diff = 0;
		for (int i = 0; i < a.length - 1; i++) {
			diff = a[i + 1] - a[i];
			if (diff < 0)
				diff *= -1;
			sum += diff;
		}
		lst.add(sum);
	}

}
