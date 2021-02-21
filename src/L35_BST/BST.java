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

}
