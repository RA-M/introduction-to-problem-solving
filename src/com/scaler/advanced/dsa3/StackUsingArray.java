package com.scaler.advanced.dsa3;

public class StackUsingArray {
	
	private static int initialSize = 3;
	private static int[] arr = new int[initialSize];
	private static int topOfStack = -1;
	
	public static void main(String[] args) {

	}

	private static void push(int x) {
		topOfStack++;
		if(topOfStack > arr.length-1) {
			growSize();
		}
		arr[topOfStack] = x;
	}
	private static void growSize() {
		int[] temp;
		temp = new int[initialSize * 2];
		{
			for (int i = 0; i < temp.length; i++) {
				temp[i] = arr[i];
			}
		}
		arr = temp;
	}
	
	private static void pop() {
		if(topOfStack != -1) {
			topOfStack--;
		}
	}
	
	private static int peek() {
		if(topOfStack == -1) {
			return -1;
		}
		return arr[topOfStack];
	}
	
	private static boolean isEmpty() {
		if(topOfStack != -1) {
			return false;
		}
		return true;
	}
}
