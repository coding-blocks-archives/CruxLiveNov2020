package L41_HashMap;

import java.util.HashMap;

public class HashMapOps {

	public static void main(String[] args) {

		int[] one = { 20, 30, 50, 50, 60, 20, 30, 20 };
		int[] two = { 20, 80, 20, 90, 20, 20, 30 };

		intersection(one, two);
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

}
