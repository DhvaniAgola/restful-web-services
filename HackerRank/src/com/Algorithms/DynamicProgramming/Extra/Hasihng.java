//PCT question
//Program is correct

package com.Algorithms.DynamicProgramming.Extra;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hasihng {
	static List<Integer> finallst = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();
		int n = 5;

		List<Integer> lst = new ArrayList<>();
		lst.add(5);
		lst.add(10);
		lst.add(15);
		lst.add(20);
		lst.add(25);
//		for (int i = 0; i < n; i++) {
//			int input = scn.nextInt();
//			if (input != -1)
//				lst.add(scn.nextInt());
//			else
//				break;
//		}
		int arr[] = new int[n];
		findLocation(n, lst, arr);
	}

	private static void findLocation(int n, List<Integer> lst, int[] arr) {
		// TODO Auto-generated method stub

		for (int i = 0; i < arr.length; i++) {
			arr[i] = '\0';
		}
		for (int i = 0; i < lst.size(); i++) {
			int insert = lst.get(i);
			int index = insert % n;
			fun(n, lst, insert, index, arr);
			System.out.println();
		}
	}

	private static void fun(int n, List<Integer> lst, int insert, int index, int[] arr) {
		// TODO Auto-generated method stub
		finallst.add(index);
		System.out.print(index + " ");
		if (arr[index] == '\0') {
			arr[index] = insert;
			return;
		} else {
			if (insert < 10) {
				int finallstindex = finallst.size() - 1;
				int indexdir = -1;
				while (true) {
					indexdir = finallst.get(finallstindex);
					if (index != indexdir)
						break;
					else {
						System.out.print(index + " ");
						finallstindex--;
					}
				}

				if (index < indexdir) {
					while (true) {
						index++;
						finallst.add(index);
						System.out.print(index + " ");
						if (arr[index] == '\0') {
							arr[index] = insert;
							break;
						}
					}
				} else if (index > indexdir) {
					while (true) {
						index--;
						finallst.add(index);
						System.out.print(index + " ");
						if (arr[index] == '\0') {
							arr[index] = insert;
							break;
						}
					}
				}
				return;
			}
			int lastdigit = insert % 10;
			insert = removeLastDigit(insert);
//			index = insert % n;
			if (lastdigit % 2 == 0) {
				index -= insert % n;
				index = (index + n) % n;
			} else {
				index += insert % n;
				index = index % n;
			}
			fun(n, lst, insert, index, arr);

		}

	}

	private static int removeLastDigit(int insert) {
		// TODO Auto-generated method stub
		insert = insert / 10;
		return insert;
	}

}
