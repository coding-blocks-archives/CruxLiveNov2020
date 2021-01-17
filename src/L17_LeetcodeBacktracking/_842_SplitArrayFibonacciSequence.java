package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.List;

public class _842_SplitArrayFibonacciSequence {

	public static void main(String[] args) {

		List<Integer> main = new ArrayList<>() ;
		List<Integer> temp = new ArrayList<>();

		splitIntoFibonacci("1101111", temp, main);

		System.out.println(main);

	}

	public static void splitIntoFibonacci(String ques, List<Integer> temp, List<Integer> main) {

		if (ques.length() == 0) {

			// ensure that fibonacci sequence is of >= 3 length
			if (temp.size() >= 3 && main.size() == 0)
				main.addAll(temp);

			return;
		}

		for (int i = 1; i <= ques.length() && i <= 10; i++) {

			String part = ques.substring(0, i); // "234"
			String roq = ques.substring(i);

			if (isInRange(part)) {
				
				int num = Integer.parseInt(part); // 234

				if (isFibonacciSeq(temp, num) && noLeadingZeros(part)) {
					temp.add(num);
					splitIntoFibonacci(roq, temp, main);
					temp.remove(temp.size() - 1);
				}
			}
		}

	}

	public static boolean isInRange(String str) {

		if (str.length() >= 11)
			return false;

		return Long.parseLong(str) <= Math.pow(2, 31) - 1;
	}

	// true : no leading zeros
	// false : leading zeros
	public static boolean noLeadingZeros(String str) {

		if (str.length() <= 1)
			return true;

		return str.charAt(0) != '0';

	}

	public static boolean isFibonacciSeq(List<Integer> temp, int num) {

		if (temp.size() <= 1)
			return true;

		int lastNum = temp.get(temp.size() - 1);
		int lastSecondNum = temp.get(temp.size() - 2);

		return lastNum + lastSecondNum == num;

	}

}
