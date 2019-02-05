package com.DataStructure.Tree.extra;

import java.util.ArrayList;
import java.util.List;

public class LevelInsertion {
	private class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static List<Node> lst = new ArrayList<>();
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5, 6, 7 };
		Node root = null;
		root = insert(root, arr[0]);
		lst.add(root);
		for (int i = 1, index = 0; i < arr.length; i++) {
			root = lst.get(index);
			root = insert(root, arr[i]);
			if (i % 2 == 0)
				index++;
		}

		preOrder(lst.get(0));
	}

	private static void preOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}

	private static Node insert(Node root, int data) {
		// TODO Auto-generated method stub
		if (root == null) {
			LevelInsertion l = new LevelInsertion();
			return l.new Node(data);
		} else {
			System.out.println(root.data + " : " + data);
			if (root.left == null) {
				root.left = insert(root.left, data);
				lst.add(root.left);
			} else {
				root.right = insert(root.right, data);
				lst.add(root.right);
			}
			return root;
		}
	}

}
