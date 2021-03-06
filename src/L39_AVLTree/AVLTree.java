package L39_AVLTree;

public class AVLTree {

	private class Node {
		int data;
		Node left;
		Node right;
		int ht;

		public Node(int data) {
			this.data = data;
			this.ht = 0;
		}
	}

	private Node root;

	public void add(int item) {
		root = add(root, item);
	}

	private Node add(Node node, int item) {

		if (node == null) {
			Node nn = new Node(item);
			return nn;
		}

		if (item <= node.data)
			node.left = add(node.left, item);
		else
			node.right = add(node.right, item);

		// node ht update -> bcz you have added a new node under your present node
		node.ht = Math.max(ht(node.left), ht(node.right)) + 1;

		// balancing factor
		int bf = bf(node);

		// LL Case
		if (bf > 1 && item < node.left.data) {
			return rightRotate(node);
		}

		// RR Case
		if (bf < -1 && item > node.right.data) {
			return leftRotate(node) ;
		}
		
		// LR Case
		if (bf > 1 && item > node.left.data) {
			node.left = leftRotate(node.left) ;
			return rightRotate(node) ;
		}
		
		// RL Case
		if (bf < -1 && item < node.right.data) {
			node.right = rightRotate(node.right) ;
			return leftRotate(node) ;
		}

		return node;
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

	private int ht(Node node) {

		if (node == null)
			return -1;

		return node.ht;
	}

	private int bf(Node node) {

		return ht(node.left) - ht(node.right);

	}

	private Node rightRotate(Node c) {

		// values capture
		Node b = c.left;
		Node T3 = b.right;

		// update
		b.right = c;
		c.left = T3;

		// ht update
		c.ht = Math.max(ht(c.left), ht(c.right)) + 1;
		b.ht = Math.max(ht(b.left), ht(b.right)) + 1;

		// updated root node
		return b;
	}

	private Node leftRotate(Node c) {

		// values capture
		Node b = c.right;
		Node T2 = b.left;

		// update
		b.left = c;
		c.right = T2;

		// ht update
		c.ht = Math.max(ht(c.left), ht(c.right)) + 1;
		b.ht = Math.max(ht(b.left), ht(b.right)) + 1;

		// updated root node
		return b;
	}

}
