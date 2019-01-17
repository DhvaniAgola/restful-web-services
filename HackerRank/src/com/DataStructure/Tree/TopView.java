// Program is correct and passed all the testcases
package com.DataStructure.Tree;

import java.util.Scanner;

public class TopView {
	private class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			left = null;
			right = null;
			this.data = data;
		}

	}

	static String str = "";
	static int leftCountFlag = 0;
	static int rightCountFlag = 0;

	public static Node insert(Node root, int data) {
		if (root == null) {
			TopView t = new TopView();
			return t.new Node(data);
		}
		if (data <= root.data) {
			root.left = insert(root.left, data);
		} else {
			root.right = insert(root.right, data);
		}
		return root;
	}

//	private static void printInorder(Node root) {
//		// TODO Auto-generated method stub
//		if (root == null)
//			return;
//
//		printInorder(root.left);
//		printInorder(root.right);
//		System.out.println(root.data);
//
//	}

	private static void leftTopView(Node root, int leftCount) {
		int leftCountTemp = leftCount;
		if (root == null)
			return;
		if (leftCount < leftCountFlag) {
			str = root.data + " " + str;
			leftCountFlag = leftCount;
		}
		if (root.left != null) {
			leftCountTemp--;
			leftTopView(root.left, leftCountTemp);
		}
		if (root.right != null) {
			leftCountTemp = leftCount;
			leftCountTemp++;
			leftTopView(root.right, leftCountTemp);
		}
	}

	private static void rightTopView(Node root, int rightCount) {
		int rightCountTemp = rightCount;
		if (root == null)
			return;
		if (rightCountTemp > rightCountFlag) {
			str += " " + root.data;
			rightCountFlag = rightCountTemp;
		}
		if (root.right != null) {

			rightCountTemp++;
			rightTopView(root.right, rightCountTemp);
		}
		if (root.left != null) {
			rightCountTemp = rightCount;
			rightCountTemp--;
			rightTopView(root.left, rightCountTemp);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int noOfInput = scn.nextInt();
		Node root = null;
		while (noOfInput > 0) {
			int n = scn.nextInt();
			root = insert(root, n);
			noOfInput--;
		}

//		int arr[] = { 37, 23, 108, 59, 86, 64, 94, 14, 105, 17, 111, 65, 55, 31, 79, 97, 78, 25, 50, 22, 66, 46, 104,
//				98, 81, 90, 68, 40, 103, 77, 74, 18, 69, 82, 41, 4, 48, 83, 67, 6, 2, 95, 54, 100, 99, 84, 34, 88, 27,
//				72, 32, 62, 9, 56, 109, 115, 33, 15, 91, 29, 85, 114, 112, 20, 26, 30, 93, 96, 87, 42, 38, 60, 7, 73,
//				35, 12, 10, 57, 80, 13, 52, 44, 16, 70, 8, 39, 107, 106, 63, 24, 92, 45, 75, 116, 5, 61, 49, 101, 71,
//				11, 53, 43, 102, 110, 1, 58, 36, 28, 76, 47, 113, 21, 89, 51, 19, 3 };
//		int arr[] = { 4, 3, 9, 2, 5, 6, 7, 8 };
//		int arr[] = { 1, 14, 3, 7, 4, 5, 15, 6, 13, 10, 11, 2, 12, 8, 9 };
//		int arr[] = { 5, 8, 7, 6 };
//		for (int i = 0; i < arr.length; i++) {
//			root = insert(root, arr[i]);
//		}
		topView(root);

	}

	private static void topView(Node root) {
		// TODO Auto-generated method stub
		str += root.data;
		int leftCount = 0;
		leftTopView(root, leftCount);
		int rightCount = 0;
		rightTopView(root, rightCount);
		System.out.println(str);
	}

}
