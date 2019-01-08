package com.DataStructure.Tree.extra;

class Node
{
	int data;
	Node left;
	Node right;
	Node(int data)
	{
		this.data=data;
		this.right=null;
		this.left=null;
		
	}
}
public class DistanceBetweenTwoNodes {
	public static Node insert(Node root, int data)
	{
		if(root==null)
		{
			return new Node(data);
		}
		if(data<=root.data)
		{
			root.left=insert(root.left, data);
		}
		else
		{
			root.right=insert(root.right, data);
		}
		return root;
	}
	public static void preorder(Node root)
	{
		if(root==null)
			return;
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}
public static void main(String[] args) {
	int intarr[]= {1,2,5,3,6,4};
	Node root=null;
	for(int i=0;i<intarr.length;i++)
	{
		root=insert(root,intarr[i]);	
	}
	preorder(root);
}
}
