package L12_Recursion;

import java.util.ArrayList;
import java.util.List;

public class RecursionGet {

	public static void main(String[] args) {

		// System.out.println(subsequencesAscii("ab").size());
		// System.out.println(keypadCombination("45"));
		// System.out.println(permutation("abc"));

		// System.out.println(coinToss(3));

		// System.out.println(climbingStairs(0, 3));

		// System.out.println(mazePath(0, 0, 2, 2));

		System.out.println(diffWaysAddParenthesis("2+6-5*8+9-5"));

	}

	public static ArrayList<String> subsequences(String str) { // abc

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0); // a
		String ros = str.substring(1); // bc

		ArrayList<String> rr = subsequences(ros); // [ _ , b , c , bc ]

		ArrayList<String> mr = new ArrayList<>(); // [ ]

		for (String val : rr) {
			mr.add(val); // ch NO
			mr.add(ch + val); // ch YES
		}

		return mr;

	}

	public static ArrayList<String> subsequencesAscii(String str) { // abc

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0); // a
		String ros = str.substring(1); // bc

		ArrayList<String> rr = subsequencesAscii(ros); // [ _ , b , c , bc ]

		ArrayList<String> mr = new ArrayList<>(); // [ ]

		for (String val : rr) {
			mr.add(val); // ch NO
			mr.add(ch + val); // ch YES
			mr.add((int) ch + val); // ch ASCII
		}

		return mr;

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

	public static ArrayList<String> keypadCombination(String str) { // 145

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0); // 1
		String ros = str.substring(1); // 45

		// smaller prob
		ArrayList<String> rr = keypadCombination(ros); // [jl, jm , jn , jo, kl, km, kn, ko]

		// self work
		ArrayList<String> mr = new ArrayList<String>();

		String code = getCode(ch); // abc

		for (String val : rr) {

			for (int i = 0; i < code.length(); i++) {

				mr.add(code.charAt(i) + val);

			}
		}

		return mr;

	}

	public static ArrayList<String> permutation(String str) { // abc

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0); // a
		String ros = str.substring(1); // bc

		ArrayList<String> rr = permutation(ros); // [ bc , cb ]

		// self work
		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {

			for (int i = 0; i <= val.length(); i++) {

				mr.add(val.substring(0, i) + ch + val.substring(i));
			}

		}

		return mr;

	}

	public static ArrayList<String> coinToss(int n) { // 3

		if (n == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> rr = coinToss(n - 1); // [ HH , HT , TH , TT ]

		ArrayList<String> mr = new ArrayList<String>();

		for (String val : rr) {
			mr.add("H" + val);
			mr.add("T" + val);
		}

		return mr;
	}

	public static ArrayList<String> climbingStairs(int curr, int n) {

		// +ve bc
		if (curr == n) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		if (curr > n) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();

		for (int jumps = 1; jumps <= 3; jumps++) {

			ArrayList<String> rr = climbingStairs(curr + jumps, n);

			for (String val : rr) {
				mr.add(jumps + val);
			}

		}

		return mr;
	}

	public static ArrayList<String> mazePath(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add(" +\n");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<String>();

		ArrayList<String> rrh = mazePath(cr, cc + 1, er, ec);

		for (String val : rrh) {
			mr.add("H" + val);
		}

		ArrayList<String> rrv = mazePath(cr + 1, cc, er, ec);

		for (String val : rrv) {
			mr.add("V" + val);
		}

		return mr;

	}

	public static List<Integer> diffWaysAddParenthesis(String str) {

		List<Integer> mr = new ArrayList<Integer>();

		// operator is not present
		if (str.indexOf('+') == -1 && str.indexOf('-') == -1 && str.indexOf('*') == -1) {
			mr.add(Integer.parseInt(str));
			return mr;
		}

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);
			if (ch == '+' || ch == '-' || ch == '*') {

				// ith char is an operator : + - *
				List<Integer> rr1 = diffWaysAddParenthesis(str.substring(0, i)); // ith index pahle waali string
				List<Integer> rr2 = diffWaysAddParenthesis(str.substring(i + 1)); // i+1 index ke baad ki saari string
																					// aa gyi

				for (int val1 : rr1) {

					for (int val2 : rr2) {

						if (ch == '+') {
							mr.add(val1 + val2);
						} else if (ch == '*') {
							mr.add(val1 * val2);
						} else if (ch == '-') {
							mr.add(val1 - val2);
						}
					}

				}

			}
		}

		return mr;

	}
}
