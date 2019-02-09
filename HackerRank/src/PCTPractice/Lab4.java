package PCTPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lab4 {
	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			left = null;
			right = null;
			this.data = data;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 6, 4, 3, 2, 10, 11 };
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			root = insert(root, arr[i]);
		}

		preCheck(root);
		if (flag)
			System.out.println("AVL");
		else
			System.out.println("NotAVL");
	}

	static boolean flag = true;

	private static void preCheck(Node root) {
		// TODO Auto-generated method stub
		List<Integer> lst = new ArrayList<>();
		int l = 0;
		int r = 0;

		if (root == null)
			return;
		if (root.left != null) {
			lst.clear();
			lstF.clear();
			getLength(root.left, lst);
			l = Collections.max(lstF);
		}
		if (root.right != null) {
			lst.clear();
			lstF.clear();
			getLength(root.right, lst);
			r = Collections.max(lstF);
		}
		if ((Math.max(l, r) - Math.min(l, r)) > 1)
			flag = false;

		if (root.left != null)
			preCheck(root.left);
		if (root.right != null)
			preCheck(root.right);

	}

	static List<Integer> lstF = new ArrayList<>();

	private static void getLength(Node root, List<Integer> lst) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		lst.add(root.data);
		List<Integer> lstTemp = new ArrayList<>();
		lstTemp.addAll(lst);
		if (root.left == null && root.right == null) {
			lstF.add(lstTemp.size());
		} else {
			if (root.left != null) {
				getLength(root.left, lstTemp);
				lstTemp.clear();
				lstTemp.addAll(lst);
			}
			if (root.right != null) {
				getLength(root.right, lstTemp);
				lstTemp.clear();
				lstTemp.addAll(lst);
			}

		}
	}

	private static Node insert(Node root, int data) {
		// TODO Auto-generated method stub
		if (root == null) {
			Lab4 c = new Lab4();
			return c.new Node(data);
		}
		if (data <= root.data)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right, data);
		return root;
	}
}
