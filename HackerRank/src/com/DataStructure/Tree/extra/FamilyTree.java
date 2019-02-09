package com.DataStructure.Tree.extra;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
	class Node {
		String data;
		Node left;
		Node right;

		Node(String data) {
			this.data = data;
			left = null;
			right = null;
		}
	}

	static boolean ans[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[] = { "Motilal Jawahar", "Jawahar Indira", "Motilal Kamala", "Indira Sanjay", "Sanjay Varun",
				"Indira Rajiv", "Rajiv Priyanka", "Rajiv Rahul" };
		Node root = null;
		for (int i = 0; i < str.length; i++) {
			String arr[] = str[i].trim().split(" ");
			if (i == 0) {
				FamilyTree f = new FamilyTree();
				root = f.new Node(arr[0]);
			}
			root = insertNode(root, arr);
		}
		preOrder(root);
		String str2[] = { "Motilal parent Indira", "Varun Descendant Indira", "Priyanka sibling varun",
				"sanjay child indira", "sanjay ancestor varun", "kamala ancestor rahul", "priyanka sibling rahul",
				"rahul descendant motilal" };
		ans = new boolean[str2.length];
		for (int i = 0; i < str2.length; i++) {
			String arr2[] = str2[i].trim().split(" ");
			if (arr2[1].trim().equalsIgnoreCase("CHILD")) {
				checkChild(root, i, arr2[0], arr2[2]);
			} else if (arr2[1].trim().equalsIgnoreCase("parent")) {
				checkChild(root, i, arr2[2], arr2[0]);
			} else if (arr2[1].trim().equalsIgnoreCase("ancestor")) {
				checkAncestor(root, i, arr2[0], arr2[2]);
			} else if (arr2[1].trim().equalsIgnoreCase("descendant")) {
				checkAncestor(root, i, arr2[2], arr2[0]);
			} else if (arr2[1].trim().equalsIgnoreCase("sibling")) {
				checkSibling(root, i, arr2[0], arr2[2]);
			}
		}
		for (int i = 0; i < ans.length; i++) {
			if (ans[i])
				System.out.print("T ");
			else
				System.out.print("F ");
		}
	}

	private static void checkSibling(Node root, int i, String sib1, String sib2) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		if (root.left != null && root.right != null) {
			if ((root.left.data.trim().equalsIgnoreCase(sib1.trim())
					&& root.right.data.trim().equalsIgnoreCase(sib2.trim()))
					|| (root.left.data.trim().equalsIgnoreCase(sib2.trim())
							&& root.right.data.trim().equalsIgnoreCase(sib1.trim())))

			{
				ans[i] = true;
			}
		}
		checkSibling(root.left, i, sib1, sib2);
		checkSibling(root.right, i, sib1, sib2);
	}

	static List<String> Flist = new ArrayList<>();

	private static void checkAncestor(Node root, int i, String ance, String desc) {
		// TODO Auto-generated method stub
		List<String> lst = new ArrayList<>();
		lst.clear();
		Flist.clear();
		getPath(root, desc, lst);
		for (String j : Flist) {
			if (j.trim().equalsIgnoreCase(ance.trim()))
				ans[i] = true;
		}
	}

	private static void getPath(Node root, String desc, List<String> lst) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		List<String> lstTemp = new ArrayList<>();
		lst.add(root.data);
		lstTemp.addAll(lst);
		if (root.data.trim().equalsIgnoreCase(desc.trim())) {
			Flist.addAll(lst);
		}
		if (root.left != null) {
			getPath(root.left, desc, lstTemp);
			lstTemp.clear();
			lstTemp.addAll(lst);
		}
		if (root.right != null) {
			getPath(root.right, desc, lstTemp);
			lstTemp.clear();
			lstTemp.addAll(lst);
		}
	}

	private static void checkChild(Node root, int i, String child, String parent) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		if (root.data.trim().equalsIgnoreCase(parent.trim())) {
			if (root.left != null) {
				if (root.left.data.trim().equalsIgnoreCase(child.trim()))
					ans[i] = true;
			}
			if (root.right != null) {
				if (root.right.data.trim().equalsIgnoreCase(child.trim()))
					ans[i] = true;
			}
		}
		checkChild(root.left, i, child, parent);
		checkChild(root.right, i, child, parent);
	}

	private static void preOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	private static Node insertNode(Node root, String[] arr) {
		// TODO Auto-generated method stub
		FamilyTree f = new FamilyTree();
		if (root == null)
			return root;
		if (root.data.trim().equalsIgnoreCase(arr[0].trim())) {
			if (root.left == null) {
				root.left = f.new Node(arr[1]);
			} else
				root.right = f.new Node(arr[1]);
		}
		insertNode(root.left, arr);
		insertNode(root.right, arr);
		return root;
	}

}
