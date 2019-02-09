package PCTPractice;

import java.util.Stack;

public class CreateTree {
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "(F(B(A)(D(C)(E)))(G(I(H)())))";
		Node root = null;
		root = getNodeData(root, str);
	}

	private static Node getNodeData(Node root, String str) {
		// TODO Auto-generated method stub
		String d = "";
		String parent = "";
		Stack<String> stc = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != '(' && str.charAt(i) != ')') {
				d += str.charAt(i);
			} else {
				if (!stc.isEmpty())
					parent = stc.lastElement();
				if (d != "") {
					// add node
					stc.push(d);
					root = createNode(root, parent, stc.lastElement());
					System.out.println("root : " + root.data);
					d = "";
				}
				if (str.charAt(i) == ')') {
					if (!stc.empty())
						stc.pop();
//					System.out.println(d);
					d = "";
				}
			}

		}
		preOrder(root);
		return null;
	}

	private static void preOrder(Node root) {
		// TODO Auto-generated method stub
		if (root == null)
			return;
		System.out.println(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	private static Node createNode(Node root, String parent, String lastElement) {
		// TODO Auto-generated method stub
		/////////// Traver the tree and all node////
		CreateTree c = new CreateTree();
		if (parent.trim().equals("")) {
			return c.new Node(lastElement);
		}
		if (root == null)
			return root;
		if (root != null) {
			if (root.data.trim().equals(parent.trim())) {
				if (root.left == null)
					root.left = c.new Node(lastElement);
				else
					root.right = c.new Node(lastElement);
			}
		}
		root.left = createNode(root.left, parent, lastElement);
		root.right = createNode(root.right, parent, lastElement);
		return root;
		////////////////

	}

}
