package L10_Strings;

import java.util.ArrayList;
import java.util.Scanner;

public class StringOps {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		String str = "The Sky is Blue";

		// System.out.println(substrings(str));
		// System.out.println(palindrome(str));
		// System.out.println(countPalindromicSubstrings(str));
		reverse(str);
	}

	public static ArrayList<String> substrings(String str) {

		ArrayList<String> list = new ArrayList<String>();

		for (int si = 0; si < str.length(); si++) {

			for (int ei = si + 1; ei <= str.length(); ei++) {

				list.add(str.substring(si, ei));

			}

		}

		return list;
	}

	public static boolean palindrome(String str) {

		int si = 0;
		int ei = str.length() - 1;

		while (si < ei) {

			if (str.charAt(si) != str.charAt(ei)) {
				return false;
			}

			si++;
			ei--;

		}

		return true;

	}

	public static int countPalindromicSubstrings(String str) {

		int count = 0;

		ArrayList<String> list = substrings(str);

		for (String val : list) {
			if (palindrome(val)) {
				count++;
			}

		}

		return count;
	}

	public static void reverse(String str) {

		String ans = "";

		while (true) {

			int idx = str.lastIndexOf(' ');
			String word = str.substring(idx + 1);
			ans = ans + word + " ";

			if (idx == -1) {
				break;
			} else {
				str = str.substring(0, idx);
			}

		}

		System.out.println(ans);

	}
}
