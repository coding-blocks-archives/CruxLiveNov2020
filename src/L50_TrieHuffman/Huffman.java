package L50_TrieHuffman;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Huffman {

	private class Node implements Comparable<Node> {
		char ch;
		int cost;
		Node left;
		Node right;

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}

	HashMap<Character, String> encoder = new HashMap<>();
	HashMap<String, Character> decoder = new HashMap<>();

	public Huffman(String str) {

		// 1. create a frequency map
		HashMap<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			map.put(ch, map.getOrDefault(ch, 0) + 1);

		}

		// 2. create a pair and priority queue
		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (char ch : map.keySet()) {

			Node nn = new Node();
			nn.ch = ch;
			nn.cost = map.get(ch);

			pq.add(nn);
		}

		// 3. work till pq size != 1 , remove 2 nodes, create a new node and put in pq
		while (pq.size() != 1) {

			Node n1 = pq.remove();
			Node n2 = pq.remove();

			Node parent = new Node();
			parent.cost = n1.cost + n2.cost;
			parent.left = n1;
			parent.right = n2;

			pq.add(parent);
		}

		// 4. fill encoder decoder
		Node ln = pq.remove();
		fillEncoderDecoder(ln, "");

		System.out.println(encoder);
		System.out.println(decoder);

	}

	private void fillEncoderDecoder(Node node, String ans) {

		if (node.left == null && node.right == null) {
			encoder.put(node.ch, ans);
			decoder.put(ans, node.ch);
			return;
		}

		fillEncoderDecoder(node.left, ans + "0");
		fillEncoderDecoder(node.right, ans + "1");

	}

	public String encode(String str) {

		String ans = "";

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			ans += encoder.get(ch);

		}

		return ans;
	}

	public String decode(String str) {

		String ans = "";
		String key = "";

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			key += ch;

			if (decoder.containsKey(key)) {
				ans += decoder.get(key);
				key = "";
			}

		}

		return ans;

	}

}
