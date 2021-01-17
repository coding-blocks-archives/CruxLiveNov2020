package L17_LeetcodeBacktracking;

public class _1079_LetterTilePossibilities {

	public static void main(String[] args) {

		System.out.println(numTilePossibilities("AAABBC")) ;
	}

	static int count ;
	
	public static int numTilePossibilities(String tiles) {

		count = 0 ;
		
		int[] freq = new int[26];

		for (int i = 0; i < tiles.length(); i++) {
			char ch = tiles.charAt(i);
			freq[ch - 'A']++;
		}

		numTilePossibilities(freq, "");
		
		return count - 1 ; 

	}

	public static void numTilePossibilities(int[] freq, String ans) {

		//System.out.println(ans);
		count++ ;
		
		for (int i = 0; i < freq.length; i++) {
			if (freq[i] > 0) { // A
				
				freq[i]-- ;
				numTilePossibilities(freq, ans + (char)(i + 'A')) ;
				freq[i]++ ;
			}

		}

	}

}




