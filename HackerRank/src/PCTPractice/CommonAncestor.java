package PCTPractice;

import java.util.ArrayList;
import java.util.List;

public class CommonAncestor {
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

	private static void preOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 6, 5, 3, 4, 2, 1, 10, 8, 9, 12, 11, 13, 14, 15, 16 };
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			root = insert(root, arr[i]);
		}
		preOrder(root);
		System.out.println();
		int a = 11;
		int b = 9;
		int ans = preAncestor(root, a, b);
//		System.out.println(ans);
	}

	static List<Integer> lstF = new ArrayList<>();

	private static int preAncestor(Node root, int a, int b) {
		// TODO Auto-generated method stub
		int ancestor = root.data;
		List<Integer> lsta = new ArrayList<>();
		List<Integer> lstb = new ArrayList<>();
		getPath(root, a, lsta);
		lsta.clear();
		lsta.addAll(lstF);
		lstF.clear();
		getPath(root, b, lstb);
		lstb.clear();
		lstb.addAll(lstF);
		L1: for (int i = lsta.size() - 1; i >= 0; i--) {
			for (int j = lstb.size() - 1; j >= 0; j--) {
				if (lsta.get(i) == lstb.get(j)) {
					ancestor = lsta.get(i);
					break L1;
				}
			}
		}
		for (int i = 0; i < lsta.size(); i++) {
			System.out.print(lsta.get(i) + " ");
			if (lsta.get(i) == ancestor)
				break;
		}
		return ancestor;
	}

	private static void getPath(Node root, int a, List<Integer> lst) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		lst.add(root.data);
		List<Integer> lstTemp = new ArrayList<>();
		lstTemp.addAll(lst);
		if (root.data == a) {
			lstF.addAll(lstTemp);
		}
		if (a < root.data)
			getPath(root.left, a, lst);
		else
			getPath(root.right, a, lst);
		lstTemp.clear();
		lstTemp.addAll(lst);
		return;

	}

	private static Node insert(Node root, int data) {
		// TODO Auto-generated method stub
		if (root == null) {
			CommonAncestor c = new CommonAncestor();
			return c.new Node(data);
		}
		if (data <= root.data)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right, data);
		return root;
	}

}
