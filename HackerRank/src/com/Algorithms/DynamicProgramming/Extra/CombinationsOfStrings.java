/*
 * This program correct
 * This program takes characters as an input and give the all combinations and permutations of fix length.
 */

package com.Algorithms.DynamicProgramming.Extra;

import java.util.ArrayList;
import java.util.List;

public class CombinationsOfStrings {
	static int count = 1;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int arr[] = { 1, 2, 3 };
//		makePandCWithRepetition(arr, 4);
		List<Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		lst.add(3);
//		lst.add(5);
//		for (int i = 1; i <= 3; i++) {
//			makePandCWithoutRepetition(lst, i);
//		}
		for (int i = 1; i <= 3; i++) {
			makePandCWithoutRepetition2(lst, i);
		}
	}

	/*
	 * This method will give all permutations of 'strLength' size made of characters
	 * from lst lst : give all the characters strLength : number of characters which
	 * are going to be chosen
	 */
	private static void makePandCWithoutRepetition(List<Integer> lst, int strLength) {
		// TODO Auto-generated method stub
		int arrIndex = 0;
		int newIndex = 0;
		String str = "";
		withoutRepetition(lst, strLength, arrIndex, newIndex, str);
	}

	private static void withoutRepetition(List<Integer> lst, int strLength, int arrIndex, int newIndex, String str) {
		// TODO Auto-generated method stub
		String strTemp = str;
		List<Integer> lstTemp = new ArrayList<>();
		lstTemp.addAll(lst);
		for (int i = 0; i < lst.size() && str.length() < strLength; i++) {
			strTemp += lstTemp.get(i);
			int temp = lstTemp.get(i);
			lstTemp.remove(new Integer(temp));

			withoutRepetition(lstTemp, strLength, arrIndex, newIndex + 1, strTemp);
			strTemp = str;
			lstTemp.clear();
			lstTemp.addAll(lst);

		}
		if (str.length() == strLength) {
			System.out.println(count + " : " + str);
			count++;
		}
		str = "";
	}

	/*
	 * This method will give no repetitions in output string even if some duplicate
	 * characters will be in input. eg.input=1,2,3,3 ; in output there is no
	 * repetitions of '3'
	 */
	private static void makePandCWithoutRepetition2(List<Integer> lst, int strLength) {
		// TODO Auto-generated method stub
		int arrIndex = 0;
		int newIndex = 0;
		String str = "";
		for (int i = 0; i < lst.size() - 1; i++) {
			for (int j = i + 1; j < lst.size(); j++) {
				if (lst.get(i) == lst.get(j)) {
					lst.remove(j);
				}
			}
		}
		withoutRepetition2(lst, strLength, arrIndex, newIndex, str);
	}

	private static void withoutRepetition2(List<Integer> lst, int strLength, int arrIndex, int newIndex, String str) {
		// TODO Auto-generated method stub
		String strTemp = str;
		List<Integer> lstTemp = new ArrayList<>();
		lstTemp.addAll(lst);
		for (int i = 0; i < lst.size() && str.length() < strLength; i++) {
			strTemp += lstTemp.get(i);
			int temp = lstTemp.get(i);
			lstTemp.remove(new Integer(temp));
			withoutRepetition2(lstTemp, strLength, arrIndex, newIndex + 1, strTemp);
			strTemp = str;
			lstTemp.clear();
			lstTemp.addAll(lst);

		}
		if (str.length() == strLength) {
			System.out.println(count + " : " + str);
			count++;
		}
		str = "";
	}

	private static void makePandCWithRepetition(int[] arr, int strLength) {
		// TODO Auto-generated method stub
		int arrIndex = 0;
		int newIndex = 0;
		String str = "";
		withRepetition(arr, strLength, arrIndex, newIndex, str);

	}

	private static void withRepetition(int[] arr, int strLength, int arrIndex, int newIndex, String str) {
		// TODO Auto-generated method stub
		String strTemp = str;
		for (int i = 0; i < arr.length && str.length() < strLength; i++) {
			strTemp += arr[i];
			withRepetition(arr, strLength, arrIndex, newIndex + 1, strTemp);
			strTemp = str;

		}
		if (str.length() == strLength) {
			System.out.println(count + " : " + str);
			count++;
		}
		str = "";
	}

}
