package L33_BinaryTree;

import java.util.Scanner;
import java.util.Stack;

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

	public BinaryTree(int[] pre, int[] in) {
		root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if(plo > phi || ilo > ihi)
			return null ;
		
		Node nn = new Node();
		nn.data = pre[plo];

		int si = -1;
		int nel = 0;

		for (int i = ilo; i <= ihi; i++) {

			if (in[i] == pre[plo]) {
				si = i;
				break;
			}

			nel++;
		}

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);

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

		if (node == null)
			return -1;

		int lh = ht(node.left);
		int rh = ht(node.right);

		return Math.max(lh, rh) + 1;

	}

	private int max = Integer.MIN_VALUE;

	public int diameter() {
		diameter(root);
		return max;
	}

	private void diameter(Node node) {

		if (node == null)
			return;

		diameter(node.left);
		diameter(node.right);

		int presentDiameterRootNode = ht(node.left) + ht(node.right) + 2;

		if (presentDiameterRootNode > max)
			max = presentDiameterRootNode;

	}

	public int diameter2() {
		return diameter2(root);
	}

	private int diameter2(Node node) {

		if (node == null)
			return 0;

		int ld = diameter2(node.left);
		int rd = diameter2(node.right);

		int sd = ht(node.left) + ht(node.right) + 2; // self node diameter root node -> max distance ?

		return Math.max(sd, Math.max(ld, rd));

	}

	private class DiaPair {
		int diameter = 0;
		int ht = -1;
	}

	public int diameter3() {
		return diameter3(root).diameter;
	}

	private DiaPair diameter3(Node node) {

		if (node == null) {
			return new DiaPair();
		}

		DiaPair ldp = diameter3(node.left);
		DiaPair rdp = diameter3(node.right);

		DiaPair sdp = new DiaPair();

		// sdp diameter
		int ld = ldp.diameter;
		int rd = rdp.diameter;
		int sd = ldp.ht + rdp.ht + 2;

		sdp.diameter = Math.max(sd, Math.max(ld, rd));

		// sdp ht
		sdp.ht = Math.max(ldp.ht, rdp.ht) + 1;

		return sdp;

	}

	private boolean res = true;

	public boolean isBalanced() {
		isBalanced(root);
		return res;
	}

	private void isBalanced(Node node) {

		if (node == null)
			return;

		isBalanced(node.left);
		isBalanced(node.right);

		int bf = ht(node.left) - ht(node.right);

		if (bf <= -2 || bf >= 2)
			res = false;

	}

	public boolean isBalanced2() {
		return isBalanced2(root);
	}

	private boolean isBalanced2(Node node) {

		if (node == null)
			return true;

		boolean lb = isBalanced2(node.left);
		boolean rb = isBalanced2(node.right);

		int bf = ht(node.left) - ht(node.right);

		if (lb && rb && (bf == -1 || bf == 0 || bf == 1))
			return true;
		else
			return false;
	}

	private class BalPair {
		boolean isBal = true;
		int ht = -1;
	}

	public boolean isBalanced3() {
		return isBalanced3(root).isBal;
	}

	private BalPair isBalanced3(Node node) {

		if (node == null)
			return new BalPair();

		BalPair lbp = isBalanced3(node.left);
		BalPair rbp = isBalanced3(node.right);

		BalPair sbp = new BalPair();

		// sbp isBal
		boolean lb = lbp.isBal;
		boolean rb = rbp.isBal;
		int bf = lbp.ht - rbp.ht;

		if (lb && rb && (bf == -1 || bf == 0 || bf == 1))
			sbp.isBal = true;
		else
			sbp.isBal = false;

		// sbp ht
		sbp.ht = Math.max(lbp.ht, rbp.ht) + 1;

		return sbp;

	}

	public boolean flipEquivalent(BinaryTree other) {

		return flipEquivalent(this.root, other.root);
	}

	private boolean flipEquivalent(Node n1, Node n2) {

		if (n1 == null && n2 == null)
			return true;

		if (n1 == null || n2 == null)
			return false;

		if (n1.data != n2.data)
			return false;

		boolean flip = flipEquivalent(n1.left, n2.right) && flipEquivalent(n1.right, n2.left);

		if (flip)
			return true;

		boolean noflip = flipEquivalent(n1.left, n2.left) && flipEquivalent(n1.right, n2.right);

		return flip || noflip;

	}

	public void display2() {
		display2(root);
	}

	private void display2(Node node) {

		if (node == null)
			return;

		System.out.println("hii " + node.data);

		display2(node.left);
		System.out.println("coming back from left child and going towards right");
		display2(node.right);

		System.out.println("byee " + node.data);

	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	// NLR : preorder
	// LNR : inorder
	// LRN : postorder
	// NRL : rev postorder
	// RNL : rev inorder
	// RLN : rev preorder
	private void preorder(Node node) {

		if (node == null)
			return;

		// N
		System.out.print(node.data + " ");

		// L
		preorder(node.left);

		// R
		preorder(node.right);

	}

	private class Pair {
		Node n;
		boolean sd;
		boolean ld;
		boolean rd;
	}

	public void preorderI() {

		Stack<Pair> s = new Stack<>();

		Pair sp = new Pair();
		sp.n = root;

		s.push(sp);

		while (!s.isEmpty()) {

			Pair tp = s.peek();

			if (tp.sd == false) {

				System.out.print(tp.n.data + " ");
				tp.sd = true;

			} else if (tp.ld == false) {

				Pair lp = new Pair();
				lp.n = tp.n.left;

				if (lp.n != null)
					s.push(lp);

				tp.ld = true;

			} else if (tp.rd == false) {

				Pair rp = new Pair();
				rp.n = tp.n.right;

				if (rp.n != null)
					s.push(rp);

				tp.rd = true;

			} else {
				s.pop();
			}

		}

		System.out.println();

	}

	public int sum() {
		return sum(root);
	}

	private int sum(Node node) {

		if (node == null)
			return 0;

		int ls = sum(node.left);
		int rs = sum(node.right);

		return ls + rs + node.data;
	}

	private int maxSum = Integer.MIN_VALUE;

	public int maxSubtreeSum1() {
		return maxSubtreeSum1(root);
	}

	private int maxSubtreeSum1(Node node) {

		if (node == null)
			return 0;

		int ls = maxSubtreeSum1(node.left);
		int rs = maxSubtreeSum1(node.right);

		int ts = ls + rs + node.data;

		if (ts > maxSum)
			maxSum = ts;

		return ts;

	}

	public int maxSubtreeSum2() {
		return maxSubtreeSum2(root);
	}

	private int maxSubtreeSum2(Node node) {

		if (node == null)
			return Integer.MIN_VALUE;

		int lMaxSubtreeSum = maxSubtreeSum2(node.left);
		int rMaxSubtreeSum = maxSubtreeSum2(node.right);

		int selfNodeSum = sum(node.left) + sum(node.right) + node.data;

		return Math.max(selfNodeSum, Math.max(lMaxSubtreeSum, rMaxSubtreeSum));

	}

	// mss : max subtree sum
	private class MSSPair {
		int mss = Integer.MIN_VALUE;
		int entireSum = 0;
	}

	public int maxSubtreeSum3() {
		return maxSubtreeSum3(root).mss;
	}

	private MSSPair maxSubtreeSum3(Node node) {

		if (node == null)
			return new MSSPair();

		MSSPair lp = maxSubtreeSum3(node.left);
		MSSPair rp = maxSubtreeSum3(node.right);

		MSSPair sp = new MSSPair();

		// sp maxSubtreeSum
		sp.mss = Math.max(lp.entireSum + rp.entireSum + node.data, Math.max(lp.mss, rp.mss));

		// sp entiresum
		sp.entireSum = lp.entireSum + rp.entireSum + node.data;

		return sp;

	}

}
