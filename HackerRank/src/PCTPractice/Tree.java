package PCTPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tree {
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

	private static void printPreOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		System.out.print(root.data + " ");
		printPreOrder(root.left);

		printPreOrder(root.right);

	}

	private static void printPostOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		printPreOrder(root.left);
		printPreOrder(root.right);
		System.out.print(root.data + " ");
	}

	private static void printInOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;

		printPreOrder(root.left);
		System.out.print(root.data + " ");
		printPreOrder(root.right);
	}

	static boolean flag = true;

	public static void main(String[] args) {
//		int arr[] = { 5, 3, 15, 16, 17, 2, 6, 14, 13, 12, 11, 10, 8, 7 };
		int arr[] = { 5, 4, 3, 2, 1, 12, 9, 8, 11, 10, 14, 13, 15 };
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			root = insertNode(root, arr[i]);
		}
		System.out.println("Preorder : ");
		printPreOrder(root);
		System.out.println("Inorder : ");
		printInOrder(root);
		System.out.println("Postorder : ");
		printPostOrder(root);
		System.out.println();
		traverseAndCheckAVL(root);
		if (flag)
			System.out.println("AVL");
		else
			System.out.println("NOT AVL");
	}

	private static void traverseAndCheckAVL(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		boolean value = checkAVL(root);
		if (!value)
			flag = false;
		traverseAndCheckAVL(root.left);
		traverseAndCheckAVL(root.right);
	}

	static List<Integer> h = new ArrayList<>();

	private static boolean checkAVL(Node root) {
		// TODO Auto-generated method stub
		int HeightLeft = 0;
		int HeightRight = 0;
		h.clear();
		findHeight(root.left, 0);
		if (h.size() != 0)
			HeightLeft = Collections.max(h);
		else
			HeightLeft = 0;
		h.clear();
		findHeight(root.right, 0);
		if (h.size() != 0)
			HeightRight = Collections.max(h);
		else
			HeightRight = 0;
		if (HeightLeft != HeightRight)
			return false;
		else
			return true;
	}

	private static void findHeight(Node root, int level) {
		// TODO Auto-generated method stub
		int ltemp = level;
		ltemp++;
		if (root == null)
			return;
		if (root.left == null && root.right == null)
			h.add(ltemp);
		if (root.left != null) {
			findHeight(root.left, ltemp);
			ltemp = level;
		}
		if (root.right != null) {
			findHeight(root.right, ltemp);
			ltemp = level;
		}
	}

	private static Node insertNode(Node root, int data) {
		// TODO Auto-generated method stub
		if (root == null) {
			Tree t = new Tree();
			return t.new Node(data);
		}
		if (data <= root.data)
			root.left = insertNode(root.left, data);
		else
			root.right = insertNode(root.right, data);
		return root;
	}

}
