package L41_HashMap;

import java.util.HashMap;

public class HashMapOps {

	public static void main(String[] args) {

//		int[] one = { 20, 30, 50, 50, 60, 20, 30, 20 };
//		int[] two = { 20, 80, 20, 90, 20, 20, 30 };
//
//		intersection(one, two);

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };

		longestConsecutiveSeq(arr);
	}

	public static void intersection(int[] one, int[] two) {

		HashMap<Integer, Integer> map = new HashMap<>();

		// traversal on first array
		for (int key : one) {

//			if (map.containsKey(key)) {
//				int of = map.get(key);
//				int nf = of + 1;
//				map.put(key, nf);
//			} else {
//				map.put(key, 1);
//			}

			map.put(key, map.getOrDefault(key, 0) + 1);

		}

		for (int key : two) {

			if (map.containsKey(key) && map.get(key) > 0) {

				System.out.println(key);
				map.put(key, map.get(key) - 1);

			}

		}

	}

	public static void longestConsecutiveSeq(int[] arr) {

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int key : arr) {

			if (map.containsKey(key - 1)) {
				map.put(key, false);
			} else {
				map.put(key, true);
			}

			if (map.containsKey(key + 1))
				map.put(key + 1, false);
		}

		int max = 0;
		int sp = 0;

		for (int key : map.keySet()) {

			if (map.get(key)) {

				int count = 0;

				while (map.containsKey(key + count))
					count++;

				if (count > max) {
					max = count;
					sp = key;
				}

			}

		}

		for (int i = sp; i < sp + max; i++)
			System.out.println(i);

	}
}
