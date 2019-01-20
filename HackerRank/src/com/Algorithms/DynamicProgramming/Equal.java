package com.Algorithms.DynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

public class Equal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int noOfInput = in.nextInt();
		for (int i = 0; i < noOfInput; i++) {
			int n = in.nextInt();
			int arr[] = new int[n];
			for (int j = 0; j < n; j++)
				arr[j] = in.nextInt();
			int result = makeEqual(arr);
			System.out.println(result);
		}
	}

	private static int makeEqual(int[] arr) {
		// TODO Auto-generated method stub
//		List<Integer> lst = new ArrayList<>();
//		lst = Arrays.stream(arr).boxed().collect(Collectors.toList());
		boolean repeat = false;
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[0] != arr[i]) {
				repeat = true;
				break;
			}
		}
		while (repeat) {
//			lst.sort(null);
			Arrays.sort(arr);
			int temp[] = new int[arr.length - 1];
			for (int j = 1; j < arr.length; j++) {
				temp[j - 1] = arr[j] - arr[0];
			}

//			List<Integer> templst = new ArrayList<>();
//			templst = Arrays.stream(temp).boxed().collect(Collectors.toList());
//			templst.sort(null);
			boolean flag = false;
			int index = 0;
			int addParam = 0;
			for (int j = 0; j < temp.length; j++) {
				if (temp[j] == 1) {
					index = j + 1;
					flag = true;
					addParam = 1;
					break;
				} else if (temp[j] == 2) {
					index = j + 1;
					flag = true;
					addParam = 2;
					break;
				} else if (temp[j] == 5) {
					index = j + 1;
					flag = true;
					addParam = 5;
					break;
				}
			}
			if (!flag) {
				for (int j = 0; j < temp.length; j++) {
					if (temp[j] != 0) {
						index = j + 1;
						if (temp[j] > 5)
							addParam = 5;
						else if (temp[j] > 2)
							addParam = 2;
						else if (temp[j] > 1)
							addParam = 1;
						break;
					}
				}

			}
			if (addParam != 0) {
				count++;
				int assign;
				for (int i = 0; i < arr.length; i++) {
					if (index != i) {
						arr[i] += addParam;
					}
				}
			}
			repeat = false;
			for (int i = 1; i < arr.length; i++) {
				if (arr[0] != arr[i]) {
					repeat = true;
					break;
				}
			}
		}
		return count;
	}

}
