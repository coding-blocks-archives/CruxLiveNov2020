package L29_StackQueueQs;

import java.util.Stack;

import L28_Inheritance.DynamicStack;

public class StackQs {

	public static void main(String[] args) throws Exception {

		DynamicStack ds = new DynamicStack();
		ds.push(10);
		ds.push(20);
		ds.push(30);
		ds.push(40);
		ds.push(50);

//		System.out.println("--- Display Reverse ---");
//		ds.display(); // 50 40 30 20 10
//		displayReverse(ds); // 10 20 30 40 50
//		System.out.println();
//		ds.display(); // 50 40 30 20 10 : stack content is still the same

//		System.out.println("--- Actual Reverse ---");
//		ds.display(); // 50 40 30 20 10
//		actualReverse(ds, new DynamicStack());
//		ds.display(); // 10 20 30 40 50

//		int[][] arr = { { 0, 1, 1, 1 }, { 1, 0, 1, 0 }, { 0, 0, 0, 0 }, { 1, 1, 1, 0 } };
//
//		celebrityProblem(arr);

		int[] arr = { 50, 30, 20, 40, 100, 45, 5, 60, 15, 8 };
		nextGreaterElement1(arr);
		
//		int[] arr = {80,50,70,30,20,40,90,10,5,35} ;
//		stockSpan(arr);

	}

	public static void displayReverse(DynamicStack s) throws Exception {

		if (s.isEmpty())
			return;

		int temp = s.pop();

		displayReverse(s);

		System.out.print(temp + " ");

		s.push(temp);

	}

	public static void actualReverse(DynamicStack s, DynamicStack extra) throws Exception {

		if (s.isEmpty()) {
			actualReverseHelper(s, extra);
			return;
		}

		extra.push(s.pop());

		actualReverse(s, extra);

	}

	public static void actualReverseHelper(DynamicStack s, DynamicStack extra) throws Exception {

		if (extra.isEmpty())
			return;

		int temp = extra.pop();

		actualReverseHelper(s, extra);

		s.push(temp);

	}

	public static void celebrityProblem(int[][] arr) {

		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {
			s.push(i);
		}

		while (s.size() != 1) {

			int a = s.pop();
			int b = s.pop();

			// a knows b : a can't be a celeb
			if (arr[a][b] == 1) {
				s.push(b);
			}
			// a doesn't know b : b can't be a celeb
			else {
				s.push(a);
			}
		}

		int candidate = s.pop();

		for (int i = 0; i < arr.length; i++) {

			if (i != candidate) {

				if (arr[candidate][i] == 1 || arr[i][candidate] == 0) {
					System.out.println("No celeb");
					return;
				}
			}
		}

		System.out.println("Celeb is " + candidate);
	}

	public static void nextGreaterElement(int[] arr) {

		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[i] > s.peek()) {
				System.out.println(s.pop() + " -> " + arr[i]);
			}

			s.push(arr[i]);
		}

		while (!s.isEmpty()) {
			System.out.println(s.pop() + " -> -1");
		}

	}

	public static void stockSpan(int[] arr) {

		Stack<Integer> s = new Stack<Integer>();

		int[] ans = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				s.pop();
			}

			if (s.isEmpty())
				ans[i] = i + 1;
			else
				ans[i] = i - s.peek();

			s.push(i);

		}
		
		for(int val : ans)
			System.out.print(val + " ");
		System.out.println();

	}

	public static void nextGreaterElement1(int[] arr) {

		int[] ans = new int[arr.length] ;
		
		Stack<Integer> s = new Stack<Integer>();

		for (int i = 0; i < arr.length; i++) {

			while (!s.isEmpty() && arr[i] > arr[s.peek()]) {
				ans[s.pop()] =  arr[i];
			}

			s.push(i);
		}

		while (!s.isEmpty()) {
			ans[s.pop()] = -1 ;  
		}
		
		for(int i = 0 ; i < ans.length ; i++)
			System.out.println(arr[i] + " -> " + ans[i]);

	}

	
}
