package L42_HashMapImplementation;

import java.util.ArrayList;

public class HashMap<K, V> {

	private class Node {

		K key;
		V value;
		Node next;

		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

	}

	private ArrayList<Node> bucketArray;
	private int size;

	public HashMap() {
		this(4);
	}

	public HashMap(int buckets) {

		bucketArray = new ArrayList<>();
		size = 0;

		for (int i = 0; i < buckets; i++) {
			bucketArray.add(null);
		}

	}

	private int hashFunction(K key) {

		int code = key.hashCode();
		int bn = code % bucketArray.size();
		return bn;

	}

	public void put(K key, V value) {

		int bn = hashFunction(key);

		// check if the key is already present, if yes then update the value
		Node temp = bucketArray.get(bn);

		while (temp != null) {

			if (temp.key.equals(key)) {
				temp.value = value;
				return;
			}

			temp = temp.next;
		}

		// if flow of your code comes here then it means key was absent
		Node nn = new Node(key, value);

		Node head = bucketArray.get(bn);
		nn.next = head;
		bucketArray.set(bn, nn);

		size++;

		double loadFactor = (1.0 * size) / bucketArray.size();
		double threshold = 2;

		if (loadFactor > threshold)
			rehash();

	}

	private void rehash() {

		ArrayList<Node> oba = bucketArray;
		ArrayList<Node> nba = new ArrayList<>(); // []

		for (int i = 0; i < 2 * oba.size(); i++) {
			nba.add(null);
		}

		bucketArray = nba;
		size = 0;

		for (Node temp : oba) {

			while (temp != null) {
				put(temp.key, temp.value);
				temp = temp.next ;
			}
		}

	}

	public V get(K key) {

		int bn = hashFunction(key);

		Node temp = bucketArray.get(bn);

		while (temp != null) {

			if (temp.key.equals(key)) {
				return temp.value;
			}

			temp = temp.next;

		}

		return null;

	}

	public boolean containsKey(K key) {

		int bn = hashFunction(key);

		Node temp = bucketArray.get(bn);

		while (temp != null) {

			if (temp.key.equals(key)) {
				return true;
			}

			temp = temp.next;

		}

		return false;

	}

	public V remove(K key) {

		int bn = hashFunction(key);

		Node prev = null;
		Node temp = bucketArray.get(bn);

		while (temp != null) {

			if (temp.key.equals(key))
				break;

			prev = temp;
			temp = temp.next;
		}

		// if given key was not present
		if (temp == null)
			return null;

		// if key was present
		if (prev == null) {
			bucketArray.set(bn, temp.next);
		} else {
			prev.next = temp.next;
		}

		size--;

		return temp.value;

	}

	@Override
	public String toString() {

		String s = "";

		for (Node temp : bucketArray) {

			while (temp != null) {
				s += temp.key + "=" + temp.value + "  ";
				temp = temp.next;
			}

		}

		return s;

	}

}
