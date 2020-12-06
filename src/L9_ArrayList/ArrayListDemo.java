package L9_ArrayList;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {

		// create a new Al
		ArrayList<Integer> list = new ArrayList<>();

		// size
		// Time : constant
		System.out.println(list.size());

		// print
		System.out.println(list);

		// add : last
		// Time : constant
		list.add(10);
		list.add(20);
		list.add(30);

		System.out.println(list);
		System.out.println(list.size());

		// add at a particular index
		// range : 0 -> size()
		// time : worst : n shifting ops & best : no shifting
		list.add(1, 50);
		System.out.println(list);

		list.add(3, 100);
		System.out.println(list);

		// get
		// range : 0 -> size-1
		// time : constant
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		System.out.println(list.get(list.size() - 1));

		// set
		// range : 0 -> size-1
		// time : constant
		list.set(2, 70);
		System.out.println(list);
		list.set(list.size() - 1, 200);
		System.out.println(list);

		// remove
		// range : 0 -> size-1
		// time : worst : n elements shifting & best : no shifting
		list.remove(2);
		System.out.println(list);

		// print
		// index
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

		// enhanced for loop
		for (int val : list) {
			System.out.println(val);
		}

	}

}
