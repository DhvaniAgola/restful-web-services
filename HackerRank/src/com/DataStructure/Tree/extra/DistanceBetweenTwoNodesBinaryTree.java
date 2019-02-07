package com.DataStructure.Tree.extra;

import java.util.ArrayList;
import java.util.List;

public class DistanceBetweenTwoNodesBinaryTree {
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

	static List<Node> lst = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

		Node root = null;
		root = LevelOrderInsertion(root, arr[0], null);
//		lst.add(root);
		int index = 0;
		for (int i = 1; i < arr.length; i++) {
			root = LevelOrderInsertion(root, arr[i], lst.get(index));
			if (i % 2 == 0)
				index++;
		}
		preOrder(root);
		System.out.println();
		int a = 2;// from which node
		int b;
		int ans;
		int dist = 2;
		for (int i = 0; i < arr.length; i++) {
			b = arr[i];
			ans = finDistance(root, a, b);// will return distance between a and b
			if (ans == dist)
				System.out.print(arr[i] + " ");// will print all nodes which are at the distance of 'dist' from a
		}
//		System.out.println(ans);
	}

	static List<Integer> pathF = new ArrayList<>();

	private static int finDistance(Node root, int a, int b) {
		// TODO Auto-generated method stub
		List<Integer> patha = new ArrayList<>();
		List<Integer> pathb = new ArrayList<>();
		flag = false;
		findPath(root, a, patha);
		patha.clear();
		patha.addAll(pathF);
		pathF.clear();
		flag = false;
		findPath(root, b, pathb);
		pathb.clear();
		pathb.addAll(pathF);
		pathF.clear();
//		System.out.println("patha : " + patha);
//		System.out.println("pathb : " + pathb);
		int ans = findCommonAnscestor(patha, pathb);
		int distance = getDistance(patha, pathb, ans);
		return distance;
	}

	private static int getDistance(List<Integer> patha, List<Integer> pathb, int anscester) {
		// TODO Auto-generated method stub
		int lengthofanscester = 0;
		for (int i = 0; i < patha.size(); i++) {
			if (patha.get(i) == anscester)
				break;
			else
				lengthofanscester++;
		}
		int finalans = (patha.size() - 1) + (pathb.size() - 1) - (2 * lengthofanscester);
		return finalans;
	}

	private static int findCommonAnscestor(List<Integer> patha, List<Integer> pathb) {
		// TODO Auto-generated method stub

		for (int i = patha.size() - 1; i >= 0; i--) {
			for (int j = pathb.size() - 1; j >= 0; j--) {
				if (patha.get(i) == pathb.get(j)) {
					return patha.get(i);
				}
			}
		}
		return patha.get(0);
	}

	static boolean flag = false;

	private static List<Integer> findPath(Node root, int a, List<Integer> path) {
		// TODO Auto-generated method stub
		path.add(root.data);
		List<Integer> lstTemp = new ArrayList<>();
		lstTemp.addAll(path);
		if (root.data == a) {
			flag = true;
			pathF.addAll(lstTemp);
			return path;
		}
		if (root.left != null && !flag) {
			lstTemp = findPath(root.left, a, lstTemp);
			lstTemp.clear();
			lstTemp.addAll(path);
		}
		if (root.right != null && !flag) {
			lstTemp = findPath(root.right, a, lstTemp);
			lstTemp.clear();
			lstTemp.addAll(path);
		}
		return lstTemp;
	}

	private static void preOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	private static Node LevelOrderInsertion(Node root, int data, Node parent) {
		// TODO Auto-generated method stub
		if (root == null) {
			DistanceBetweenTwoNodesBinaryTree d = new DistanceBetweenTwoNodesBinaryTree();
			root = d.new Node(data);
			lst.add(root);
			return root;
		}
		if (root == parent) {
			if (root.left == null) {
				root.left = LevelOrderInsertion(root.left, data, parent);

			} else
				root.right = LevelOrderInsertion(root.right, data, parent);
		} else {
			if (root.left != null)
				root.left = LevelOrderInsertion(root.left, data, parent);
			if (root.right != null)
				root.right = LevelOrderInsertion(root.right, data, parent);
		}
		return root;
	}

}
