package L35_BST;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;

	public BST(int[] in) {
		root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int lo, int hi) {

		if (lo > hi)
			return null;

		int mid = (lo + hi) / 2;

		Node nn = new Node();
		nn.data = in[mid];

		nn.left = construct(in, lo, mid - 1);
		nn.right = construct(in, mid + 1, hi);

		return nn;

	}

	public BST() {

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

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		if (node.right == null)
			return node.data;

		return max(node.right);

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node == null)
			return false;

		if (item > node.data) // right
			return find(node.right, item);

		else if (item < node.data) // left
			return find(node.left, item);

		else
			return true;
	}

	public void replaceWithSumOfLarger() {
		replaceWithSumOfLarger(root, new int[1]);
	}

	private void replaceWithSumOfLarger(Node node, int[] sum) {

		if (node == null)
			return;

		replaceWithSumOfLarger(node.right, sum);

		int temp = node.data;
		node.data = sum[0];
		sum[0] += temp;

		replaceWithSumOfLarger(node.left, sum);

	}

	public void printInRange(int lo, int hi) {
		printInRange(root, lo, hi);
	}

	private void printInRange(Node node, int lo, int hi) {

		if (node == null)
			return;

		if (node.data < lo)
			printInRange(node.right, lo, hi);
		else if (node.data > hi)
			printInRange(node.left, lo, hi);
		else {

			printInRange(node.left, lo, hi);
			System.out.println(node.data);
			printInRange(node.right, lo, hi);
		}

	}

	public void replaceWithSumOfLarger2() {
		System.out.println(replaceWithSumOfLarger2(root, 0));
	}

	private int replaceWithSumOfLarger2(Node node, int val) {

		if (node == null)
			return val;

		int largerSumValues = replaceWithSumOfLarger2(node.right, val);

		int temp = node.data;
		node.data = largerSumValues;

		return replaceWithSumOfLarger2(node.left, largerSumValues + temp);
	}

	public void add(int item) {

		if (root == null) {
			Node nn = new Node();
			nn.data = item;
			root = nn;
		} else {
			add(root, item);
		}
	}

	private void add(Node node, int item) {

		// left
		if (item <= node.data) {

			if (node.left == null) {
				Node nn = new Node();
				nn.data = item;
				node.left = nn;
			} else {
				add(node.left, item);
			}
		}

		// right
		else {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = item;
				node.right = nn;
			} else {
				add(node.right, item);
			}

		}

	}

	public void add2(int item) {

		if (root == null) {
			Node nn = new Node();
			nn.data = item;
			root = nn;
		} else {
			add2(root, null, item);
		}

	}

	private void add2(Node node, Node parent, int item) {

		if (node == null) {
			Node nn = new Node();
			nn.data = item;

			if (item <= parent.data)
				parent.left = nn;
			else
				parent.right = nn;

			return;
		}

		if (item <= node.data)
			add2(node.left, node, item);
		else
			add2(node.right, node, item);

	}

	public void add3(int item) {

		root = add3(root, item);
	}

	private Node add3(Node node, int item) {

		if (node == null) {
			Node nn = new Node();
			nn.data = item;
			return nn;
		}

		if (item <= node.data)
			node.left = add3(node.left, item);
		else
			node.right = add3(node.right, item);

		return node;

	}

	public void remove(int item) {

		if(root == null)
			return ;
		
		if (root.data == item) {
			if (root.left == null && root.right == null)
				root = null;
			else if (root.left != null && root.right == null)
				root = root.left;
			else if (root.left == null && root.right != null)
				root = root.right;
			else
				remove(root, null, item);
		} else
			remove(root, null, item);
	}

	private void remove(Node node, Node parent, int item) {

		if (node == null)
			return;

		if (item < node.data)
			remove(node.left, node, item);
		else if (item > node.data)
			remove(node.right, node, item);
		else {

			// case 1 : leaf
			if (node.left == null && node.right == null) {

				if (node.data <= parent.data) // node is left child of parent
					parent.left = null;
				else // node is right child of parent
					parent.right = null;

			}

			// case 2 : left != null && right == null
			else if (node.left != null && node.right == null) {

				if (node.data <= parent.data)
					parent.left = node.left;
				else
					parent.right = node.left;

			}

			// case 3 : left == null && right != null
			else if (node.left == null && node.right != null) {

				if (node.data <= parent.data)
					parent.left = node.right;
				else
					parent.right = node.right;

			}

			// case 4 : left != null && right != null
			else {

				int max = max(node.left);

				remove(node.left, node, max);

				node.data = max;

			}

		}

	}

}
