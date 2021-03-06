package L41_HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HashMapDemo {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

		// put : O(1)
		map.put("Ram", 10);
		map.put("Mohan", 30);
		map.put("Sham", 15);
		map.put("Rohit", 50);

		System.out.println(map);

		map.put("Ram", 40);

		System.out.println(map);

		// get : O(1)
		System.out.println(map.get("Mohan"));
		System.out.println(map.get("Ram"));
		System.out.println(map.get("Amit"));

		// containsKey : O(1)
		System.out.println(map.containsKey("Mohan"));
		System.out.println(map.containsKey("Amit"));

		// remove : O(1)
		System.out.println(map.remove("Mohan"));
		System.out.println(map);
		System.out.println(map.remove("Amit"));
		System.out.println(map);

		// keys obtain
		// way 1
		Set<String> keys = map.keySet();
		for (String key : keys) {
			System.out.println(key + " -> " + map.get(key));
		}

		// way 2
		for (String key : map.keySet()) {
			System.out.println(key + " -> " + map.get(key));
		}

		// way 3
		ArrayList<String> list = new ArrayList<String>(map.keySet());
		for (String val : list) {
			System.out.println(val + " : " + map.get(val));
		}

	}

}
