package L50_TrieHuffman;

public class HuffmanClient {

	public static void main(String[] args) {
		
		Huffman h = new Huffman("aaaabbcddddd") ;
		
		System.out.println(h.encode("dabd"));
		System.out.println(h.decode("0111010"));
	}

}
