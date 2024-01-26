package com.scaler.module2;

import java.util.Arrays;
import java.util.Stack;

public class MinStack {

	private static Stack<Integer> stack = new Stack<>();
	private static Stack<Integer> minStack = new Stack<>();

	public static void main(String[] args) {
		/*push(1);
		push(2);
		push(-2);
		push(3);
		System.out.println(getMin());
		pop();
		System.out.println(getMin());
		System.out.println(top());*/
		
		nearestSmaller();
	}

	public static void push(int x) {
		stack.push(x);
		if (minStack.isEmpty()) {
			minStack.push(x);
		} else {
			minStack.push(Math.min(stack.peek(), minStack.peek()));
		}
	}

	public static void pop() {
		if (stack.isEmpty()) {
			return;
		}
		stack.pop();
		minStack.pop();
	}

	public static int top() {
		if (stack.isEmpty()) {
			return -1;
		}
		return stack.peek();
	}

	public static int getMin() {
		if (stack.isEmpty()) {
			return -1;
		}
		return minStack.peek();
	}
	
	
	private static void nearestSmaller() {
		int[] A = {4, 5, 2, 10, 8};
		Stack<Integer> stack = new Stack<>();
		int[] ansArr = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			while(!stack.isEmpty() && stack.peek() >= A[i]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				ansArr[i] = -1;
			}else {
				ansArr[i] = stack.peek();
			}
			
			stack.push(A[i]);
		}
		System.out.println(Arrays.toString(ansArr));
	}

}
