package PCTPractice;

public class TopView {
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
		int arr[] = { 6, 5, 3, 4, 2, 1, 20, 19, 18, 17, 16, 15, 14, 13 };
		Node root = null;
		for (int i = 0; i < arr.length; i++) {
			root = insert(root, arr[i]);
		}
		str += root.data;
		getLeftTopView(root, 0);
		System.out.println(str);
		countTemp = 0;
		getRightTopView(root, 0);
		System.out.println(str);
	}

	static int countTemp = 0;

	private static void getLeftTopView(Node root, int count) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		int countt = count;
		if (count > countTemp) {
			str = root.data + " " + str;
			countTemp = count;
		}

		if (root.left != null) {
			++countt;
			getLeftTopView(root.left, countt);
			countt = count;
		}
		if (root.right != null) {
			--countt;
			getLeftTopView(root.right, countt);
			countt = count;
		}
//		System.out.println(root.data);
		--countt;
	}

	static String str = "";
	static int count = 0;

	private static void getRightTopView(Node root, int count) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		int countt = count;
		if (count > countTemp) {
			str += " " + root.data;
			countTemp = count;
		}

		if (root.left != null) {
			--countt;
			getRightTopView(root.left, countt);
			countt = count;
		}
		if (root.right != null) {
			++countt;
			getRightTopView(root.right, countt);
			countt = count;
		}
//		System.out.println(root.data);
		--countt;
	}

	private static Node insert(Node root, int data) {
		// TODO Auto-generated method stub
		if (root == null) {
			TopView c = new TopView();
			return c.new Node(data);
		}
		if (data <= root.data)
			root.left = insert(root.left, data);
		else
			root.right = insert(root.right, data);
		return root;
	}
}
