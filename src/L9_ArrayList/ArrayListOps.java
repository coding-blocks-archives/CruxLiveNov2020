package L9_ArrayList;

import java.util.ArrayList;

public class ArrayListOps {

	public static void main(String[] args) {

		// int[] one = { 10, 20, 30, 40, 40, 50, 50, 50, 60, 70 };
		// int[] two = { 10, 10, 10, 60, 70, 70, 70, 80 };
		//
		// System.out.println(intersection(one, two));

		int[] one = { 9, 9, 8, 7 };
		int[] two = { 6, 5 };

		System.out.println(sumTwoArrays(one, two));

	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		// logic ....
		int i = 0; // one
		int j = 0; // two

		while (i < one.length && j < two.length) {

			if (one[i] < two[j]) {
				i++;
			} else if (one[i] > two[j]) {
				j++;
			} else {

				res.add(one[i]);
				i++;
				j++;

			}

		}

		return res;

	}

	public static ArrayList<Integer> sumTwoArrays(int[] one, int[] two) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		// logic ...
		int i = one.length - 1;
		int j = two.length - 1;

		int carry = 0;

		while (i >= 0 || j >= 0) {

			int sum = carry;

			if (i >= 0)
				sum += one[i];

			if (j >= 0)
				sum += two[j];

			res.add(0, sum % 10);
			carry = sum / 10;

			i--;
			j--;

		}

		if (carry > 0)
			res.add(0, carry);

		return res;

	}
}
