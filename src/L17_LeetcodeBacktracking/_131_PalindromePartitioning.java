package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class _131_PalindromePartitioning {

	public static void main(String[] args) {
	
		List<List<String>> main = new ArrayList<List<String>>() ;
		List<String> temp = new ArrayList<String>() ;
		
		palindromePartitioning("aab", temp, main);
		
		System.out.println(main);

	}
	
	public static void palindromePartitioning(String ques, List<String> temp , List<List<String>> main) {

		if (ques.length() == 0) {
			main.add(new ArrayList<String>(temp)) ;
			return;
		}

		for (int i = 1; i <= ques.length(); i++) {

			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if (isPalindrome(part)) {
				
				temp.add(part) ;
				palindromePartitioning(roq, temp, main);
				temp.remove(temp.size()-1) ;
				
			}
		}

	}

	public static boolean isPalindrome(String str) {

		int i = 0;
		int j = str.length() - 1;

		while (i <= j) {

			if (str.charAt(i) != str.charAt(j)) {
				return false;
			}

			i++;
			j--;
		}

		return true;

	}


}
