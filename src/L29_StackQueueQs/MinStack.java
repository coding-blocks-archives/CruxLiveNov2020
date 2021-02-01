package L29_StackQueueQs;

import java.util.Stack;

public class MinStack {

	private Stack<Integer> s = new Stack<Integer>();
	private int min;

	public void push(int val) {
		if (s.isEmpty()) {
			s.push(val);
			min = val;
		} else if (val >= min) {
			s.push(val);
		} else {
			s.push(2 * val - min);
			min = val;
		}
	}

	public int peek() throws Exception {

		if (s.isEmpty()) {
			throw new Exception("Stack is Empty");
		} else if (s.peek() >= min) { // no encryption
			return s.peek();
		} else {
			return min;
		}
	}

	public int pop() throws Exception {

		if (s.isEmpty()) {
			throw new Exception("Stack is Empty");
		} else if (s.peek() >= min) { // no encryption

			return s.pop();

		} else {

			int rv = min;

			int topMostElement = s.pop();
			min = 2 * min - topMostElement;

			return rv;
		}

	}

	public int min() {
		return min;
	}

}
