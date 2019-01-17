package com.DataStructure.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class HeightOfBinaryTree {

	/*
	 * class Node int data; Node left; Node right;
	 */
	class Node {
		Node left;
		Node right;
		int data;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static int count = 0;
	public static List<Integer> lstHeight = new ArrayList<>();

	public static int height(Node root) {
		// Write your code here.
		count++;
		if (root.left != null) {
			height(root.left);
			// System.out.println(root.data + " -left- " + root.left.data);
			// System.out.println(root.data + " -right- " + root.right.data);
		}
		if (root.right != null) {
			height(root.right);
		}
		if (root.left == null && root.right == null) {
			lstHeight.add(count);
//			count--;
		}
		count--;
		int temp = Collections.max(lstHeight);
		return temp - 1;
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			HeightOfBinaryTree h = new HeightOfBinaryTree();
			return h.new Node(data);
		} else {
			Node cur;
			if (data <= root.data) {
				cur = insert(root.left, data);
				root.left = cur;
			} else {
				cur = insert(root.right, data);
				root.right = cur;
			}
			return root;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		int height = height(root);
		System.out.println(height);
	}
}