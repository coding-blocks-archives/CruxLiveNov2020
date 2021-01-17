package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class _93_RestoreIPAddresses {

	public static void main(String[] args) {

		List<String> main = new ArrayList<String>();

		ipAddress("101023", "", 0, main);

		System.out.println(main);

	}

	public static void ipAddress(String ques, String ans, int dots, List<String> main) {

		if (ques.length() == 0) {

			if (dots == 4)
				main.add(ans.substring(0, ans.length() - 1));

			return;
		}

		if (ques.length() > (4 - dots) * 3)
			return;

		for (int i = 1; i <= 3 && i <= ques.length(); i++) {

			String part = ques.substring(0, i);
			String roq = ques.substring(i);

			if (isValidPart(part) && noLeadingZeros(part))
				ipAddress(roq, ans + part + ".", dots + 1, main);
		}

	}

	public static boolean isValidPart(String str) {

		int num = Integer.parseInt(str);

		return num <= 255;

	}

	// true : no leading zeros
	// false : leading zeros
	public static boolean noLeadingZeros(String str) {

		if (str.length() <= 1)
			return true;

		return str.charAt(0) != '0';

	}
}
