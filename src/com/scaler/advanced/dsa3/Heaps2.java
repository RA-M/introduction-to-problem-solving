package com.scaler.advanced.dsa3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Heaps2 {

	public static void main(String[] args) {
		//kthLargest();
		
		athLargestElement();
	}
	
	private static void kthLargest() {
		int[] A = {15, 20, 99, 1};
		int B = 2;
		int[] ansArr = new int[A.length];
		PriorityQueue<Integer> heap = new PriorityQueue<>();
		for (int i = 0; i < A.length; i++) {
			heap.add(A[i]);
			if(heap.size() > B) {
				heap.poll();
			}
			if (heap.size() < B) {
				ansArr[i] = -1;
			}else {
				ansArr[i] = heap.peek();
			}
		}
		System.out.println(Arrays.toString(ansArr));
	}
	
	private static void athLargestElement() {
		int[] A = {15, 20, 99, 1,98};
		int k = 1;
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			queue.add(A[i]);
		}
		for (int i = k; i < A.length; i++) {
			if(A[i] > queue.peek()) {
				queue.poll();
				queue.add(A[i]);
			}
		}
		System.out.println(queue.peek());
	}

}
