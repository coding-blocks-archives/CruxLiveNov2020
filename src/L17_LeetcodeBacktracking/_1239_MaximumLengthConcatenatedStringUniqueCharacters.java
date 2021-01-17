package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class _1239_MaximumLengthConcatenatedStringUniqueCharacters {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();

		list.add("abcdefghijklmnopqrstuvwxyz");
//		list.add("iq");
//		list.add("ue");

		System.out.println(maxLength(list));

	}

	static int max;

	public static int maxLength(List<String> arr) {

		max = 0;

		userRespect(arr, 0, "");

		return max;
	}

	public static void userRespect(List<String> arr, int vidx, String ans) {

		if (distinctChars(ans)) {

			// System.out.println(ans);
			if (ans.length() > max)
				max = ans.length();
		} else
			return;

		for (int i = vidx; i < arr.size(); i++) {
			userRespect(arr, i + 1, ans + arr.get(i));
		}

	}

	public static boolean distinctChars(String str) {

		int[] freq = new int[26];

		for (int i = 0; i < str.length(); i++) {

			char ch = str.charAt(i);

			if (freq[ch - 'a'] > 0)
				return false;

			freq[ch - 'a']++;

		}

		return true;

	}

}
