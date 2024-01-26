package com.scaler.advanced.dsa3;

import java.util.PriorityQueue;
import java.util.Queue;

public class Heaps1 {

	public static void main(String[] args) {
		int[] A = {1, 2, 3, 4, 5};
		Queue<Integer> heap = new PriorityQueue<>();
		
		for (int i = 0; i < A.length; i++) {
			heap.add(A[i]);
		}
		int cost = 0;
		while (heap.size() > 0) {
			int min1 = heap.remove();
			int min2 = heap.remove();
			cost += min1+min2;
			if(heap.size() != 0) {
				heap.add(min1+min2);
			}
		}
		System.out.println(cost);
	}

}
