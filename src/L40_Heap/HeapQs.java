package L40_Heap;

import java.util.ArrayList;

public class HeapQs {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();

		list.add(new ArrayList<Integer>());
		list.add(new ArrayList<Integer>());
		list.add(new ArrayList<Integer>());
		list.add(new ArrayList<Integer>());

		list.get(0).add(10);
		list.get(0).add(20);
		list.get(0).add(30);

		list.get(1).add(15);
		list.get(1).add(35);

		list.get(2).add(5);
		list.get(2).add(7);
		list.get(2).add(12);
		list.get(2).add(25);

		list.get(3).add(17);
		list.get(3).add(22);
		list.get(3).add(40);

		System.out.println(list);

		System.out.println(mergeTwoSortedLists(list));

		int[] arr = { 20, 50, 30, 45, 10, 5, 57, 40 };

		kLargestElements(arr, 3);

	}

	public static class Pair implements Comparable<Pair> {
		int no;
		int list;
		int idx;

		@Override
		public int compareTo(Pair o) {
			return o.no - this.no;
		}

	}

	public static ArrayList<Integer> mergeTwoSortedLists(ArrayList<ArrayList<Integer>> list) {

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		ArrayList<Integer> res = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {
			Pair np = new Pair();
			np.no = list.get(i).get(0);
			np.list = i;
			np.idx = 0;

			heap.add(np);
		}

		while (!heap.isEmpty()) {

			Pair rp = heap.remove();

			res.add(rp.no);

			rp.idx++;

			if (rp.idx < list.get(rp.list).size()) {
				rp.no = list.get(rp.list).get(rp.idx);
				heap.add(rp);
			}

		}

		return res;

	}

	public static void kLargestElements(int[] arr, int k) {

		Heap heap = new Heap();

		for (int i = 0; i < k; i++)
			heap.add(arr[i]);

		for (int i = k; i < arr.length; i++) {

			int weaker = heap.get();

			if (arr[i] > weaker) {
				heap.remove();
				heap.add(arr[i]);
			}

		}

		while (!heap.isEmpty())
			System.out.println(heap.remove());

	}
}
