package L42_HashMapImplementation;

public class Client {

	public static void main(String[] args) {

		HashMap<String, Integer> map = new HashMap<>();

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

	}

}
