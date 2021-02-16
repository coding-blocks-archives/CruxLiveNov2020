package L33_BinaryTree;

import java.util.Scanner;

public class BinaryTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BinaryTree() {
		root = construct(null, true);
	}

	// ilc : is left child
	// ilc : true -> parent left child create
	// ilc : false -> parent right child create
	private Node construct(Node parent, boolean ilc) {

		if (parent == null)
			System.out.println("Enter the data for root node ?");
		else {

			if (ilc)
				System.out.println("Enter the data for left child of " + parent.data + " ?");
			else
				System.out.println("Enter the data for right child of " + parent.data + " ?");

		}

		int item = scn.nextInt();

		Node nn = new Node();
		nn.data = item;

		System.out.println(nn.data + " has left child ?");
		boolean hlc = scn.nextBoolean();

		if (hlc == true)
			nn.left = construct(nn, true);

		System.out.println(nn.data + " has right child ?");
		boolean hrc = scn.nextBoolean();

		if (hrc == true)
			nn.right = construct(nn, false);

		return nn;

	}

	public void display() {
		System.out.println("--------------------");
		display(root);
		System.out.println("--------------------");
	}

	private void display(Node node) {

		if (node == null)
			return;

		String str = "";

		if (node.left == null)
			str += ".";
		else
			str += node.left.data;

		str += " -> " + node.data + " <- ";

		if (node.right == null)
			str += ".";
		else
			str += node.right.data;

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		if (node == null)
			return 0;

		int ls = size(node.left);
		int rs = size(node.right);

		return ls + rs + 1;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node == null)
			return Integer.MIN_VALUE;

		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(node.data, Math.max(lm, rm));
	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null)
			return false;

		if (node.data == item)
			return true;

		boolean lf = find(node.left, item);
		boolean rf = find(node.right, item);

		return lf || rf;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		if(node == null)
			return -1 ;
		
		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

}
