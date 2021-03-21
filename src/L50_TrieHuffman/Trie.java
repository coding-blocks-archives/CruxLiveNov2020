package L50_TrieHuffman;

import java.util.HashMap;

public class Trie {

	private class Node{
		char ch ;
		boolean eow ;
		HashMap<Character, Node> map ;
		
		public Node(char ch) {
			this.ch = ch ;
			this.eow = false ;
			map = new HashMap<>() ;
		}
	}
	
	private Node root ;
	
	public Trie() {
		root = new Node('*') ;
	}
	
	public void addWord(String word) {	
		addWord(root, word) ;		
	}

	private void addWord(Node node, String word) {
		
		if(word.length() == 0) {
			node.eow = true ;
			return ;
		}
		
		char ch = word.charAt(0) ;
		String row = word.substring(1) ;
		
		boolean charIsPresent = node.map.containsKey(ch) ;
		
		if(charIsPresent) {
			addWord(node.map.get(ch), row);
		}else {
			
			Node nn = new Node(ch) ;
			node.map.put(ch, nn) ;
			addWord(nn, row);
		}
	}
	
	public boolean searchWord(String word) {	
		return searchWord(root, word) ;		
	}

	private boolean searchWord(Node node, String word) {
		
		if(word.length() == 0) {
			return node.eow ;
		}
		
		char ch = word.charAt(0) ;
		String row = word.substring(1) ;
		
		boolean charIsPresent = node.map.containsKey(ch) ;
		
		if(charIsPresent) {
			return searchWord(node.map.get(ch), row);
		}else {
			return false ;
		}
	}

	public void removeWord(String word) {	
		removeWord(root, word) ;		
	}

	private void removeWord(Node node, String word) {
		
		if(word.length() == 0) {
			node.eow = false ;
			return ;
		}
		
		char ch = word.charAt(0) ;
		String row = word.substring(1) ;
		
		boolean charIsPresent = node.map.containsKey(ch) ;
		
		if(charIsPresent) {
			
			Node child = node.map.get(ch) ;
			
			removeWord(child , row);
			
			if(child.eow == false && child.map.size() == 0) {
				node.map.remove(ch) ;
			}
			
		}else {
			return ;
		}
	}

	public void displayTrie() {
		display(root) ;
	}

	private void display(Node node) {
		
		String str = node.ch + " -> " ;
		
		for(char ch : node.map.keySet()) {
			str += ch + " " ;
		}
		
		System.out.println(str);
		
		for(char ch : node.map.keySet()) {
			display(node.map.get(ch)) ;
		}
		
	}
	
	
}







