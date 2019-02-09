package PCTPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LengthOfTree {
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
		int arr[] = { 6, 5, 4, 3, 2, 1, 10, 8, 9, 12, 11, 13, 14, 15, 16 };
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			root = insertNode(root, arr[i]);
		}
		preOrder(root);
		FindLength(root);
		System.out.println();
		System.out.println(Collections.max(lst));
	}

	static int c = 0;

	private static void FindLength(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			lst.add(c);

		} else {

			if (root.left != null) {
				++c;
				FindLength(root.left);
			}
			if (root.right != null) {
				++c;
				FindLength(root.right);
			}
		}
		--c;
	}

	private static Node insertNode(Node root, int data) {
		// TODO Auto-generated method stub
		if (root == null) {
			LengthOfTree l = new LengthOfTree();
			return l.new Node(data);
		}
		if (data <= root.data)
			root.left = insertNode(root.left, data);
		else
			root.right = insertNode(root.right, data);
		return root;
	}

}
