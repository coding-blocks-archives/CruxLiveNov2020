package L31_LL;

public class LinkedList {

	private class Node {
		int data;
		Node next;

		public Node() {

		}

		public Node(int data) {
			this.data = data;
		}

	}

	private Node head;

	// O(n)
	public void display() {

		System.out.println("-----------------------");

		Node temp = head; // int i = 0

		while (temp != null) { // i < arr.length

			System.out.print(temp.data + " ");
			temp = temp.next; // i++

		}
		System.out.println(".");

		System.out.println("-----------------------");
	}

	// O(n)
	public int size() {

		int count = 0;

		Node temp = head;

		while (temp != null) {

			count++;
			temp = temp.next;

		}

		return count;

	}

	// O(1)
	public boolean isEmpty() {
		return head == null;
	}

	// O(1)
	public int getFirst() throws Exception {

		if (isEmpty())
			throw new Exception("LL is Empty");

		return head.data;
	}

	// O(n)
	public int getLast() throws Exception {

		if (isEmpty())
			throw new Exception("LL is Empty");

		Node temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}

		return temp.data;
	}

	// O(n)
	public int getAt(int idx) throws Exception {

		if (isEmpty())
			throw new Exception("LL is Empty");

		if (idx < 0 || idx >= size()) {
			throw new Exception("Invalid Index.");
		}

		Node temp = head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp.data;

	}

	// O(n)
	private Node getNodeAt(int idx) throws Exception {

		if (isEmpty())
			throw new Exception("LL is Empty");

		if (idx < 0 || idx >= size()) {
			throw new Exception("Invalid Index.");
		}

		Node temp = head;

		for (int i = 1; i <= idx; i++) {
			temp = temp.next;
		}

		return temp;

	}

	// O(n)
	public void addLast(int item) {

		// create a new node
		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (isEmpty()) {

			head = nn;

		} else {

			// move to the last node
			Node temp = head;

			while (temp.next != null) {
				temp = temp.next;
			}

			// you can also obtain the last node by getNodeAt fxn
			// Node temp = getNodeAt(size()-1) ;

			// linking
			temp.next = nn;

		}

	}

	// O(1)
	public void addFirst(int item) {

		Node nn = new Node();
		nn.data = item;
		nn.next = null;

		if (isEmpty()) {

			head = nn;

		} else {

			// linking
			nn.next = head;

			// head update bcz we have done addition at start
			head = nn;

		}
	}

	// O(n)
	public void addAt(int idx, int item) throws Exception {

		if (idx < 0 || idx > size()) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0)
			addFirst(item);

		else if (idx == size())
			addLast(item);

		else {

			// create a new node
			Node nn = new Node();
			nn.data = item;
			nn.next = null;

			// linking
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = getNodeAt(idx);

			nm1.next = nn;
			nn.next = np1;

		}

	}

	// O(n)
	public int removeLast() throws Exception {

		if (isEmpty())
			throw new Exception("LL is Empty");

		int rv = getLast();

		if (size() == 1) {
			head = null;
		} else {
			Node lastSecond = getNodeAt(size() - 2);
			lastSecond.next = null;
		}

		return rv;

	}

	// O(1)
	public int removeFirst() throws Exception {

		if (isEmpty())
			throw new Exception("LL is Empty");

		int rv = getFirst();

//		if (size() == 1) {
//			head = null ;
//		} else {
//			head = head.next ;
//		}

		head = head.next;

		return rv;

	}

	// O(n)
	public int removeAt(int idx) throws Exception {
		if (idx < 0 || idx >= size()) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0)
			return removeFirst();

		else if (idx == size() - 1)
			return removeLast();

		else {

			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;

			return n.data;
		}

	}

	public void reverseI() {

		Node prev = null;
		Node curr = head;

		while (curr != null) {

			Node ahead = curr.next;
			curr.next = prev;

			prev = curr;
			curr = ahead;
		}

		head = prev;

	}

	public void reverseR() {
		// reverseR(null, head);

		Node temp = head;

		reverseR(head);

		temp.next = null;
	}

	private void reverseR(Node prev, Node curr) {

		if (curr == null) {
			head = prev;
			return;
		}

//		Node ahead = curr.next ;
//		
//		curr.next = prev;

//		reverseR(curr, ahead);

		reverseR(curr, curr.next);

		curr.next = prev;

	}

	private void reverseR(Node curr) {

		if (curr.next == null) {
			head = curr;
			return;
		}

		reverseR(curr.next);

		curr.next.next = curr;

	}

	public int mid() {

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;

		}

		return slow.data;
	}

	public int kthFromLast(int k) {

		Node fast = head;

		for (int i = 1; i <= k; i++) {
			fast = fast.next;
		}

		Node slow = head;

		while (fast != null) {

			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

	public void createDummyList() {

		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		Node n10 = new Node(100);
		Node n11 = new Node(110);
		Node n12 = new Node(120);
		Node n13 = new Node(130);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n13.next = n12;
		n12.next = n11;
		n11.next = n7;

		Node h1 = n1;
		Node h2 = n13;

		// logic ....
		System.out.println(intersection(h1, h2));

	}

	private int intersection(Node h1, Node h2) {

		Node fp = h1;
		Node sp = h2;

		while (fp != sp) {

			if (fp == null)
				fp = h2;
			else
				fp = fp.next;

			if (sp == null)
				sp = h1;
			else
				sp = sp.next;
		}

		return fp.data;
	}
}
