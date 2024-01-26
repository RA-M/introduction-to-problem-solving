package com.scaler.advanced.dsa3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Stack2NearestSmallerGreaterElement {

	public static void main(String[] args) {
//		nearestSmallerElement();
		
		//largestRectangleInHistogram();
		
		maxMinFromAllSubArr();
	}
	
	private static void nearestSmallerElement() {
		int[] A = {4, 5, 2, 10, 8};
		Stack<Integer> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			//Remove all greater element from stack
			while(!stack.empty() && stack.peek() >= A[i]) {
				stack.pop();
			}
			//Update the ans
			if(stack.empty()) {
				list.add(-1);
			}else {
				list.add(stack.peek());
			}
			stack.push(A[i]);
		}
		System.out.println(list);
	}
	
	
	private static void largestRectangleInHistogram() {
		int[] A = {2, 1, 5, 6, 2, 3};
		int[] nearSmallerLeftSide = nearestSmallerLeftSideIndex(A);
		int[] nearSmallerRightSide = nearestSmallerRightSideIndex(A);
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			ans = Math.max(ans, A[i] * (nearSmallerRightSide[i] - nearSmallerLeftSide[i] -1));
		}
		System.out.println(ans);
	}
	private static int[] nearestSmallerLeftSideIndex(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int[] ansArr = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			while(!stack.empty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}
			if(stack.empty()) {
				ansArr[i] = -1;
			}else {
				ansArr[i] = stack.peek();
			}
			stack.push(i);
		}
		return ansArr;
	}
	private static int[] nearestSmallerRightSideIndex(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int[] ansArr = new int[A.length];
		for (int i = A.length-1; i >= 0; i--) {
			while(!stack.empty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}
			if(stack.empty()) {
				ansArr[i] = A.length;
			}else {
				ansArr[i] = stack.peek();
			}
			stack.push(i);
		}
		return ansArr;
	}
	
	
	private static void maxMinFromAllSubArr() {
		int[] A = {4, 7, 3, 8};
		int[] nearestSmallerLeft = nearestSmallerLeftSideValue(A);
		int[] nearestSmallerRight = nearestSmallerRightSideValue(A);
		int[] nearestGreterLeft = nearestGreterLeft(A);
		int[] nearestGreterRight = nearestGreterRight(A);
		long max = 0;
		long min = 0;
		long ans = 0;
		int mod = 1000000007;
		for (int i = 0; i < A.length; i++) {
			max = max + (A[i] * (i-nearestGreterRight[i]) * nearestGreterLeft[i]-1);
			min = min + (A[i] * (i-nearestSmallerLeft[i]) * nearestSmallerRight[i]-1);
			
			long x1 = (((long)i % mod) - ((long)nearestSmallerLeft[i] % mod) + mod) % mod;
			long x2 = (((long)nearestSmallerRight[i] % mod) - ((long)i % mod) + mod) % mod;
            long x3 = (((long)i % mod) - ((long)nearestGreterLeft[i] % mod) + mod) % mod;
            long x4 = (((long)nearestGreterRight[i] % mod) - ((long)i % mod) + mod) % mod;

            min = (((long)A[i] % mod) * (x1 % mod)) % mod;
            min = ((min % mod) * (x2 % mod)) % mod;
            
            max = (((long)A[i] % mod) * (x3 % mod)) % mod;
            max = ((max % mod) * (x4 % mod)) % mod;
            
            ans = ((ans % mod) + (max % mod)) % mod;
            ans = ((ans % mod) - (min % mod) + mod) % mod;
        }   

	        ans = ans % mod;
	        int res = (int)ans;
		System.out.println(res);
	}
	private static int[] nearestSmallerLeftSideValue(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int[] ansArr = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			while(!stack.empty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}
			if(stack.empty()) {
				ansArr[i] = -1;
			}else {
				ansArr[i] = stack.peek();
			}
			stack.push(i);
		}
		return ansArr;
	}
	private static int[] nearestSmallerRightSideValue(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int[] ansArr = new int[A.length];
		for (int i = A.length-1; i >= 0; i--) {
			while(!stack.empty() && A[stack.peek()] > A[i]) {
				stack.pop();
			}
			if(stack.empty()) {
				ansArr[i] = A.length;
			}else {
				ansArr[i] = stack.peek();
			}
			stack.push(i);
		}
		return ansArr;
	}
	private static int[] nearestGreterLeft(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int[] ansArr = new int[A.length];
		for (int i = 0; i < A.length; i++) {
			while(!stack.empty() && A[stack.peek()] <= A[i]) {
				stack.pop();
			}
			if(stack.empty()) {
				ansArr[i] = -1;
			}else {
				ansArr[i] = stack.peek();
			}
			stack.push(i);
		}
		return ansArr;
	}
	private static int[] nearestGreterRight(int[] A) {
		Stack<Integer> stack = new Stack<>();
		int[] ansArr = new int[A.length];
		for (int i = A.length-1; i >= 0; i--) {
			while(!stack.empty() && A[stack.peek()] < A[i]) {
				stack.pop();
			}
			if(stack.empty()) {
				ansArr[i] = A.length;
			}else {
				ansArr[i] = stack.peek();
			}
			stack.push(i);
		}
		return ansArr;
	}

}
