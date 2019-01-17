package com.DataStructure.Tree;

import java.util.Scanner;

public class LowestCommonAncestor {
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

	public static Node lca(Node root, int v1, int v2) {
		// Write your code here.
		if (root == null)
			return root;
		if (v1 < root.data && v2 < root.data)
			root = lca(root.left, v1, v2);

		else if (v1 > root.data && v2 > root.data)
			root = lca(root.right, v1, v2);
		return root;
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			LowestCommonAncestor l = new LowestCommonAncestor();
			return l.new Node(data);
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
		Node root = null;
		int intarr[] = { 23, 16, 15, 9, 6, 17, 10, 13, 8, 26, 18, 2, 22, 24, 12, 5, 20, 25, 21, 4, 19, 1, 3, 14, 7 };
		for (int i = 0; i < intarr.length; i++) {
			root = insert(root, intarr[i]);
		}
		int v1 = scan.nextInt();
		int v2 = scan.nextInt();
		scan.close();
		System.out.println("root.data : " + root.data);
		Node ans = lca(root, v1, v2);
		System.out.println(ans.data);
	}
}
