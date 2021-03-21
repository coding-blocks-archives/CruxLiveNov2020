package L50_TrieHuffman;

public class Client {

	public static void main(String[] args) {
		
//		System.out.println(patternMatching("aacdefaae", "aad"));
		
		Trie trie = new Trie() ;
		
		trie.addWord("ant");
		trie.addWord("arc");
		trie.addWord("and");
		trie.addWord("an");
		trie.addWord("see");
		trie.addWord("sea");
		trie.addWord("seen");

		trie.displayTrie();
		
		System.out.println(trie.searchWord("arc"));
		
		trie.removeWord("see");
		trie.removeWord("seen");
		
		trie.displayTrie();
	}
	
	public static int patternMatching(String src, String patt) {
		
		for(int i = 0 ; i <= src.length() - patt.length() ; i++) {
			
			int j = 0 ;
			while(j < patt.length()) {
				
				if(src.charAt(i+j) != patt.charAt(j))
					break ;
				
				j++ ;
			}
			
			if(j == patt.length())
				return i ;
			
		}
		
		return -1 ;
	}

}
