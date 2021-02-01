package L29_StackQueueQs;

import java.util.LinkedList;
import java.util.Queue;

import L28_Inheritance.DynamicQueue;

public class QueueQs {

	public static void main(String[] args) throws Exception {

		DynamicQueue q = new DynamicQueue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);

//		q.display();
//		displayReverse(q, 0);
//		System.out.println();
//		q.display();

//		q.display();
//		actualReverse(q);
//		q.display();
		
		int[] arr = {10,-1,-8,6,30,40,50,60} ;
		
		firstNegativeWindow(arr, 3);
	}

	public static void displayReverse(DynamicQueue q, int count) throws Exception {
		if (q.size() == count)
			return;

		int temp = q.dequeue();
		q.enqueue(temp);

		displayReverse(q, count + 1);

		System.out.print(temp + " ");

	}

	public static void actualReverse(DynamicQueue q) throws Exception {

		if (q.isEmpty())
			return;

		int temp = q.dequeue();

		actualReverse(q);

		q.enqueue(temp);

	}

	public static void firstNegativeWindow(int[] arr, int k) {
		
		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < k; i++) {
			if (arr[i] < 0)
				q.add(i);
		}

		if(q.isEmpty())
			System.out.println("0 -> " + (k-1) + " : 0");
		else
			System.out.println("0 -> " + (k-1) + " : " + arr[q.peek()]);

		for (int i = k; i < arr.length; i++) {
			
			// remove
			if (!q.isEmpty() && q.peek() == i - k)
				q.remove();

			// add
			if (arr[i] < 0)
				q.add(i);

			// ans
			if(q.isEmpty())
				System.out.println((i-k+1) + " -> " + i + " : 0");
			else
				System.out.println((i-k+1) + " -> " + i + " : " +arr[q.peek()]);

		}

	}
}
