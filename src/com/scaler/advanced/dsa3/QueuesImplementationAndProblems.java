package com.scaler.advanced.dsa3;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueuesImplementationAndProblems {

	private static int capacity = 4;
	private static int[] arr = new int[capacity];
	private static int size = 0;
	private static int front = -1;
	private static int rear = -1;

	public static void main(String[] args) {

		//queuesImplementationUsingArray();
		
		perfectNumber();
	}

	private static void queuesImplementationUsingArray() {
		enqueue(5);
		enqueue(6);
		enqueue(7);
		enqueue(8);
		dequeue();
		enqueue(9);
		System.out.println(front());
	}

	private static void enqueue(int num) {
		if (size == capacity) {
			System.out.println("Queue is full");
			return;
		}
		rear = (rear + 1) % capacity;
		arr[rear] = num;
		size++;
	}

	private static int dequeue() {
		if (size == 0) {
			return -1;
		}
		front = (front + 1) % capacity;
		size--;
		return arr[front];
	}

	private static int front() {
		if (size == 0) {
			System.out.println("Queue is empty");
			return -1;
		}
		return arr[(front + 1) % capacity];
	}
	
	
	private static void slidingWindowMaximum() {
		int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
		int B = 3;
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < A.length; i++) {
			queue.size();
			queue.poll();
			while (!queue.isEmpty() && queue.peek() < A[i]) {
				queue.remove();
				queue.add(A[i]);
			}
			queue.add(A[i]);
		}
	}
	
	private static void perfectNumber() {
		int A = 4;
		if(A == 1) {
			System.out.println("11");
		}
		if(A == 2) {
			System.out.println("22");
		}
		
		Queue<String> queue = new LinkedList<>();
		queue.offer("1");
		queue.offer("2");
		int count = 2;
		String ans = "";
		while(true) {
			String num = queue.poll();
			
			queue.offer(num+"1");
			count++;
			if(count == A) {
				ans = num+"1";
				break;
			}
			
			queue.offer(num+"2");
			count++;
			if(count == A) {
				ans = num+"2";
				break;
			}
		}
		System.out.println(ans+new StringBuilder(ans).reverse());
	}
	
}

