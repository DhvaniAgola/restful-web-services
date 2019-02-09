package PCTPractice;

import java.util.ArrayList;
import java.util.List;

public class AncestorWithLevelOrderInsertion {
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

	private static void preOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	static List<Integer> lst = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16 };
		Node root = null;

		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				AncestorWithLevelOrderInsertion a = new AncestorWithLevelOrderInsertion();
				root = a.new Node(arr[i]);
				lst.add(root.data);
			} else {
				root = insert(root, lst.get(index), arr[i]);
				if (i % 2 == 0)
					index++;
			}
		}
		preOrder(root);
		int a = 1;
		int b = 2;
		System.out.println();
		int ans = preAncestor(root, a, b);
		int distance = getDist(root, a, b);
		System.out.println(ans);
		System.out.println("distance : " + distance);
	}

	private static int getDist(Node root, int a, int b) {
		// TODO Auto-generated method stub
		int ance = root.data;
		List<Integer> lsta = new ArrayList<>();
		List<Integer> lstb = new ArrayList<>();
		lstF.clear();
		getPath(root, a, lsta);
		lsta.clear();
		lsta.addAll(lstF);
		lstF.clear();
		getPath(root, b, lstb);
		lstb.clear();
		lstb.addAll(lstF);

		l: for (int i = lsta.size() - 1; i >= 0; i--) {
			for (int j = lstb.size() - 1; j >= 0; j--) {
				if (lsta.get(i) == lstb.get(j)) {
					ance = lsta.get(i);
					break l;
				}
			}
		}
		List<Integer> lstAnc = new ArrayList<>();
		for (int i = 0; i < lsta.size(); i++) {
			lstAnc.add(lsta.get(i));
			if (lsta.get(i) == ance)
				break;
		}

		return (lsta.size() - 1) + (lstb.size() - 1) - ((lstAnc.size() - 1) * 2);
	}

	static List<Integer> lstF = new ArrayList<>();

	private static int preAncestor(Node root, int a, int b) {
		// TODO Auto-generated method stub
		int ancestor = root.data;
		List<Integer> lsta = new ArrayList<>();
		List<Integer> lstb = new ArrayList<>();
		lstF.clear();
		getPath(root, a, lsta);
		lsta.clear();
		lsta.addAll(lstF);
		lstF.clear();
		getPath(root, b, lstb);
		lstb.clear();
		lstb.addAll(lstF);
		l: for (int i = lsta.size() - 1; i >= 0; i--) {
			for (int j = lstb.size() - 1; j >= 0; j--) {
				if (lsta.get(i) == lstb.get(j)) {
					ancestor = lsta.get(i);
					break l;
				}
			}
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
		getPath(root.left, a, lstTemp);
		lstTemp.clear();
		lstTemp.addAll(lst);
		getPath(root.right, a, lstTemp);
		lstTemp.clear();
		lstTemp.addAll(lst);

	}

	private static Node insert(Node root, Integer parent, int data) {
		// TODO Auto-generated method stub
		if (root == null)
			return root;
		if (root.data == parent) {
			AncestorWithLevelOrderInsertion a = new AncestorWithLevelOrderInsertion();
			if (root.left == null)
				root.left = a.new Node(data);
			else
				root.right = a.new Node(data);
			lst.add(data);
		}
		insert(root.left, parent, data);
		insert(root.right, parent, data);
		return root;
	}

}
