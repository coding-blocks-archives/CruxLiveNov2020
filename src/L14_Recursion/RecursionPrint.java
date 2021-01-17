package L14_Recursion;

import java.util.List;

public class RecursionPrint {

	public static void main(String[] args) {

		// subsequences("abc", "");
		// KPC("145", "") ;
		// permutation2("abc", "");
		// coinToss(3, "", false);
		// System.out.println(climbingStairs(0, 4, ""));

		// lexicoCounting(0, 1000);

		// List<String> list = new ArrayList<String>();
		// validParenthesis(0, 0, 3, "", list);
		// System.out.println(list);

		palindromePartitioning("abbcbc", "");
	}

	public static void subsequences(String ques, String ans) { // abc ""

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0); // a
		String roq = ques.substring(1); // bc

		subsequences(roq, ans); // bc , ""
		subsequences(roq, ans + ch); // bc , a

	}

	public static String getCode(char ch) {
		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "stu";
		else if (ch == '8')
			return "vwx";
		else if (ch == '9')
			return "yz";
		else if (ch == '0')
			return "@#";
		else
			return "";
	}

	public static void KPC(String ques, String ans) { // 145 ""

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0); // 1
		String roq = ques.substring(1); // 45

		String code = getCode(ch); // abc

		for (int i = 0; i < code.length(); i++) {
			KPC(roq, ans + code.charAt(i));
		}

	}

	public static void permutation(String ques, String ans) { // abc ""

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			String roq = ques.substring(0, i) + ques.substring(i + 1);
			permutation(roq, ans + ques.charAt(i));
		}

	}

	public static void permutation2(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0); // a
		String roq = ques.substring(1); // bc

		for (int i = 0; i <= ans.length(); i++) {

			permutation2(roq, ans.substring(0, i) + ch + ans.substring(i));

		}

	}

	public static void coinToss(int n, String ans, boolean isLastHeadIncluded) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (isLastHeadIncluded == true) {
			coinToss(n - 1, ans + "T", false);
		} else {
			coinToss(n - 1, ans + "H", true);
			coinToss(n - 1, ans + "T", false);
		}

	}

	public static int climbingStairs(int curr, int n, String ans) {

		// +ve bc
		if (curr == n) {
			System.out.println(ans);
			return 1;
		}

		// -ve bc
		if (curr > n) {
			return 0;
		}

//		int c1 = climbingStairs(curr+1, n, ans + "1");
//		int c2 = climbingStairs(curr+2, n, ans + "2");
//		int c3 = climbingStairs(curr+3, n, ans + "3");

		int c = 0;
		for (int jump = 1; jump <= 3; jump++) {
			c = c + climbingStairs(curr + jump, n, ans + jump);
		}

		return c;

	}

	public static void lexicoCounting(int curr, int n) {

//		if(curr > n) // nbc
//			return ;

		System.out.println(curr);

		int i = 0;

		if (curr == 0)
			i = 1;

		while (i <= 9) {
			lexicoCounting(curr * 10 + i, n);
			i++;
		}

	}

	public static void validParenthesis(int open, int close, int n, String ans, List<String> list) {

		if (open == n && close == n) { // +ve bc
			// System.out.println(ans);
			list.add(ans);
			return;
		}

		if (open > n || close > open) { // -ve bc
			return;
		}

		validParenthesis(open + 1, close, n, ans + "(", list);
		validParenthesis(open, close + 1, n, ans + ")", list);

	}

	public static void palindromePartitioning(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 1; i <= ques.length(); i++) {

			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if (isPalindrome(part))
				palindromePartitioning(roq, ans + part + "  ");

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
