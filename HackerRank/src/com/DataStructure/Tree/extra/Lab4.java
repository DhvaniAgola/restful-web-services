package com.DataStructure.Tree.extra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lab4 {

	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = null;
		Scanner scn = new Scanner(System.in);
		int arr[] = { 5, 2, 12, 1, 3, 9, 17, 15, 19, -1 };
		int i = 0;
		while (true) {
			int n = arr[i];
			if (n != -1)
				root = insertNode(root, n);
			else
				break;
			i++;
		}
		preOrderForAVL(root);
		if (!flag)
			System.out.println("NOT");
		else
			preOrder(root);
	}

	static boolean flag = true;

	private static void preOrderForAVL(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		int lefth = 0;
		int righth = 0;
		if (root.left != null) {
			lefth = finalHeight(root.left);
		}
		if (root.right != null) {
			righth = finalHeight(root.right);
		}
		if (Math.max(lefth, righth) - Math.min(lefth, righth) > 1)
			flag = false;
		preOrderForAVL(root.left);
		preOrderForAVL(root.right);
	}

	static List<Integer> length = new ArrayList<>();

	public static int finalHeight(Node root) {
		length.clear();
		height(root, 0);
		return Collections.max(length);
	}

	public static int height(Node root, int h) {
		// TODO Auto-generated method stub

		if (root.left == null && root.right == null)
			length.add(h);
		if (root.left != null) {
			h++;
			h = height(root.left, h);
		}
		if (root.right != null) {
			h++;
			h = height(root.right, h);
		}
		--h;
		return h;
	}

	private static void preOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	private static Node insertNode(Node root, int data) {
		// TODO Auto-generated method stub
		if (root == null) {
			Lab4 l = new Lab4();
			return l.new Node(data);
		}
		if (data <= root.data)
			root.left = insertNode(root.left, data);
		else
			root.right = insertNode(root.right, data);
		return root;
	}

}
