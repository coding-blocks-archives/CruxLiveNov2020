package L31_LL;

public class LinkedList {

	private class Node {
		int data;
		Node next;
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

}
