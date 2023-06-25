package com.scaler;

import java.util.Arrays;

public class ArraysPrefixSum {

	public static void main(String[] args) {

		//findSumLtoR();
		
		//findEquiIndex();
		
		//countOfEvenNos();
		
		//findProductArray();
		
	}
	/*
	 You are given an integer array A of length N.
You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query.
	A = [1, 2, 3, 4, 5]
	B = [[0, 3], [1, 2]]
o/p: [10, 5]
	 */
	public static void findSumLtoR() {
		int[] A = {1, 2, 3, 4, 5};
		int[][] B = {{0,3},{1,2}};
		int[] prefSum = new int[A.length];
		prefSum[0] = A[0];
		for(int i=1; i<A.length;i++) {
			prefSum[i] = prefSum[i-1] + A[i];
		}
		for (int i = 0; i < B.length; i++) {
			int L = B[i][0];
			int R = B[i][1];
			if(L == 0) {
				System.out.println(prefSum[R]);
			}else {
				System.out.println(prefSum[R] - prefSum[L-1]);
			}
		}
	}
	
	/*
	 You are given an array A of integers of size N.
	Your task is to find the equilibrium index of the given array
	The equilibrium index of an array is an index such that the sum 
	of elements at lower indexes is equal to the sum of elements at higher indexes.
	If there are no elements that are at lower indexes or at higher 
	indexes, then the corresponding sum of elements is considered as 0.
	A = [-7, 1, 5, 2, -4, 3, 0]
	o/p: 3
	*/
	public static void findEquiIndex() {
		int[] arr = {-7, 1, 5, 2, -4, 3, 0};
		int[] prefSum = new int[arr.length];
		prefSum[0] = arr[0];
		for(int i = 1; i<arr.length; i++) {
			prefSum[i] = prefSum[i-1] + arr[i];
		}
		int leftSum = 0;
		int rightSum = 0;
		for (int i = 0; i < prefSum.length; i++) {
			if(i == 0) {
				leftSum = 0;
			}else {
				leftSum = prefSum[i-1];
			}
			rightSum = prefSum[prefSum.length-1] - prefSum[i];
			if(leftSum == rightSum) {
				System.out.println(i);
			}
		}
	}
	
	/*
	You are given an array A of length N and Q queries given by the 2D array B of size Q×2.
	Each query consists of two integers B[i][0] and B[i][1].
	For every query, your task is to find the count of even numbers in the range from A[B[i][0]] to A[B[i][1]].
	A = [1, 2, 3, 4, 5]
	B = [   [0, 2] 
        [2, 4]
        [1, 4]   ]
    o/p: [1, 1, 2]
	 */
	public static void countOfEvenNos() {
		int[] arr = {6, 3, 3, 6, 7, 8, 7, 3, 7};
		int[][] B = {{2,6},{4,7},{6,7}};
		int[] prefArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				arr[i] = 1;
			}else {
				arr[i] = 0;
			}
		}
		prefArr[0] = arr[0];
		for (int i = 1; i < prefArr.length; i++) {
			prefArr[i] = prefArr[i-1]+arr[i];
		}
		int leftStart = 0;
		int rigthEnd = 0;
		for (int i = 0; i < B.length; i++) {
			leftStart = B[i][0];
			rigthEnd = B[i][1];
			if(leftStart == 0) {
				System.out.println(prefArr[rigthEnd]);
			}else {
				System.out.println(prefArr[rigthEnd] - prefArr[leftStart-1]);
			}
		}
	}
	
	
	/*
	Given an array of integers A, find and return the product array of the same size where the 
	ith element of the product array will be equal to the product of all the elements divided by
	the ith element of the array.
	Note: It is always possible to form the product array with integer (32 bit) values. 
	Solve it without using the division operator.
	Input 1:
    A = [1, 2, 3, 4, 5]
	Output 1:
    [120, 60, 40, 30, 24]
	*/
	public static void findProductArray() {
		int[] arr = {1, 2, 3, 4, 5};
		int totalProd = 1;
		for (int i = 0; i < arr.length; i++) {
			totalProd = totalProd * arr[i];
		}
		int[] productArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			productArr[i] = totalProd / arr[i];
		}
		System.out.println(Arrays.toString(productArr));
	}
	
}
