package L17_LeetcodeBacktracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1291_SequentialDigits {

	public static void main(String[] args) {

		System.out.println(sequentialDigits(1000, 13000));
	}

	public static List<Integer> sequentialDigits(int low, int high) {

		List<Integer> main = new ArrayList<Integer>();

		for (int i = 1; i <= 9; i++) {
			sequentialDigits(i, low, high, main);
		}

		Collections.sort(main);

		return main;

	}

	public static void sequentialDigits(int curr, int low, int high, List<Integer> main) {

		if (curr >= low && curr <= high)
			main.add(curr);

		if (curr > high)
			return;

		int ld = curr % 10;

		if (ld == 9)
			return;

		sequentialDigits(curr * 10 + (ld + 1), low, high, main);

	}
}
