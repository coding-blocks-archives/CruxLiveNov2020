package L32_GenericTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTree {

	Scanner scn = new Scanner(System.in);

	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;

	public GenericTree() {
		root = construct(null, -1);
	}

	private Node construct(Node parent, int ith) {

		// prompt
		if (parent == null) {
			System.out.println("Enter the data for root node ?");
		} else {
			System.out.println("Enter the data for " + ith + " child of " + parent.data + " ?");
		}

		// take input of data
		int item = scn.nextInt();

		// create a new node
		Node nn = new Node();

		// update the data
		nn.data = item;

		// prompt
		System.out.println("Enter the number of children for " + nn.data + " ?");

		// take input for children
		int noc = scn.nextInt();

		// loop
		for (int j = 0; j < noc; j++) {

			Node child = construct(nn, j);
			nn.children.add(child);
		}

		return nn;

	}

	public void display() {
		System.out.println("---------------------");
		display(root);
		System.out.println("---------------------");

	}

	private void display(Node node) {

		// self work
		String str = node.data + " -> ";

		for (Node child : node.children) {
			str += child.data + " ";
		}

		str += ".";
		System.out.println(str);

		// smaller problem
		for (Node child : node.children) {
			display(child);
		}

	}

	public int size() {
		return size(root);
	}

	private int size(Node node) {

		int ts = 0;

		for (Node child : node.children) {
			int cs = size(child);
			ts += cs;
		}

		return ts + 1;

	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {

		int tm = node.data;

		for (Node child : node.children) {
			int cm = max(child);

			if (cm > tm) {
				tm = cm;
			}
		}

		return tm;

	}

	public int ht() {
		return ht(root);
	}

	private int ht(Node node) {

		int th = -1;

		for (Node child : node.children) {
			int ch = ht(child);

			if (ch > th) {
				th = ch;
			}
		}

		return th + 1;

	}

	public boolean find(int item) {
		return find(root, item);
	}

	private boolean find(Node node, int item) {

		if (node.data == item) {
			return true;
		}

		for (Node child : node.children) {

			boolean cf = find(child, item);

			if (cf)
				return true;

		}

		return false;

	}

	public void mirror() {
		mirror(root);
	}

	private void mirror(Node node) {

		// smaller prob
		for (Node child : node.children) {
			mirror(child);
		}

		// work
		int i = 0;
		int j = node.children.size() - 1;

		while (i < j) {

			Node in = node.children.get(i);
			Node jn = node.children.get(j);

			node.children.set(i, jn);
			node.children.set(j, in);

			i++;
			j--;
		}
	}

	public void printAtLevel(int level) {
		printAtLevel(root, level, 0);
	}

	private void printAtLevel(Node node, int level, int count) {

		if (level == count) {
			System.out.println(node.data);
			return;
		}

		for (Node child : node.children) {
			printAtLevel(child, level, count + 1);
		}

	}

	public void linearize() {
		linearize(root);
	}

	private void linearize(Node node) {

		for (Node child : node.children)
			linearize(child);

		while (node.children.size() > 1) {
			Node temp = node.children.remove(1);
			Node tail = getTail(node.children.get(0));
			tail.children.add(temp);
		}

	}

	private Node getTail(Node node) {

		if (node.children.size() == 0)
			return node;

		return getTail(node.children.get(0));

	}

	public void display2() {
		display2(root);
	}

	private void display2(Node node) {

		System.out.println("Hii " + node.data);

		for (int i = node.children.size() - 1; i >= 0; i--) {

			Node child = node.children.get(i);

			System.out.println("Going towards " + child.data);
			display2(child);
			System.out.println("Coming back from " + child.data);

		}

		System.out.println("Bye " + node.data);

	}

	public void preorder() {
		preorder(root);
		System.out.println();
	}

	private void preorder(Node node) {

		// N
		System.out.print(node.data + " ");

		// C
		for (Node child : node.children)
			preorder(child);

	}

	public void postorder() {
		postorder(root);
		System.out.println();
	}

	private void postorder(Node node) {

		// C
		for (Node child : node.children)
			postorder(child);

		// N
		System.out.print(node.data + " ");

	}

	public void levelorder() {

		Queue<Node> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {

			// remove
			Node rn = q.remove() ;
			
			// print
			System.out.print(rn.data + " ");
			
			// child enqueue
			for(Node child : rn.children)
				q.add(child) ;
			
		}
		
		System.out.println();
	}
	
	public void levelorderLinewise() {

		Queue<Node> q = new LinkedList<>();
		Queue<Node> h = new LinkedList<>();
		
		q.add(root);

		while (!q.isEmpty()) {

			// remove
			Node rn = q.remove() ;
			
			// print
			System.out.print(rn.data + " ");
			
			// child enqueue
			for(Node child : rn.children)
				h.add(child) ;
			
			if(q.isEmpty()) {
				System.out.println();
				q = h ;
				h = new LinkedList<>() ;
			}
			
		}
		
		System.out.println();
	}

}













