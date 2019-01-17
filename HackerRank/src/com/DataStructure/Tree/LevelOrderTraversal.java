package com.DataStructure.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LevelOrderTraversal {
	private class Node {
		Node right;
		Node left;
		int data;

		Node(int data) {
			left = null;
			right = null;
			this.data = data;
		}
	}

	public static void levelOrder(Node root) {
		List<Node> nodeList = new ArrayList<>();
		if (root == null)
			return;
		nodeList.add(root);
		for (int i = 0; i < nodeList.size(); i++) {
			if (nodeList.get(i).left != null)
				nodeList.add(nodeList.get(i).left);
			if (nodeList.get(i).right != null)
				nodeList.add(nodeList.get(i).right);
		}
		for (int i = 0; i < nodeList.size(); i++) {
			System.out.print(nodeList.get(i).data + " ");
		}
	}

	public static Node insert(Node root, int data) {
		if (root == null) {
			LevelOrderTraversal l = new LevelOrderTraversal();
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
		int t = scan.nextInt();
		Node root = null;
		while (t-- > 0) {
			int data = scan.nextInt();
			root = insert(root, data);
		}
		scan.close();
		levelOrder(root);
	}

}
