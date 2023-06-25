package com.scaler;

import java.util.Arrays;

public class InterviewProblemsOnArray {

	public static void main(String[] args) {

		// sumOfAllEvenNosFromRange();

		// sumOfAllOddNosFromRange();

		//specialIndex();
		
		//majorityElement();
		
		repeatNumber();
	}

	/*
	 * You are given an array A of length N and Q queries given by the 2D array B of
	 * size Q*2. Each query consists of two integers B[i][0] and B[i][1]. For every
	 * query, the task is to calculate the sum of all even indices in the range
	 * A[B[i][0]…B[i][1]].
	 */
	private static void sumOfAllEvenNosFromRange() {
		int[] A = { 1, 2, 3, 4, 5 };
		int[][] B = { { 0, 2 }, { 1, 4 } };
		int[] prefSum = new int[A.length];
		int[] resultArr = new int[B.length];
		prefSum[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			if (i % 2 == 0) {
				prefSum[i] = prefSum[i - 1] + A[i];
			} else {
				prefSum[i] = prefSum[i - 1];
			}
		}

		for (int i = 0; i < B.length; i++) {
			int start = B[i][0];
			int end = B[i][1];
			if (start == 0) {
				resultArr[i] = prefSum[end];
			} else {
				resultArr[i] = prefSum[end] - prefSum[i - 1];
			}
		}
		System.out.println(Arrays.toString(resultArr));
	}

	public static void sumOfAllOddNosFromRange() {
		int[] A = { 1, 2, 3, 4, 5 };
		int[][] B = { { 0, 2 }, { 1, 4 } };
		int[] prefSum = new int[A.length];
		int[] resArr = new int[B.length];
		prefSum[0] = 0;
		for (int i = 1; i < A.length; i++) {
			if (i % 2 != 0) {
				prefSum[i] = prefSum[i - 1] + A[i];
			} else {
				prefSum[i] = prefSum[i - 1];
			}
		}
		for (int i = 0; i < B.length; i++) {
			int start = B[i][0];
			int end = B[i][1];
			if (start == 0) {
				resArr[i] = prefSum[end];
			} else {
				resArr[i] = prefSum[end] - prefSum[start - 1];
			}
		}
		System.out.println(Arrays.toString(resArr));
	}

	/*
	 * Given an array, arr[] of size N, the task is to find the count of array
	 * indices such that removing an element from these indices makes the sum of
	 * even-indexed and odd-indexed array elements equal.
	 * 
	 * Special Index
	 * 
	 * A=[2, 1, 6, 4] O/P: 1 Explanation 1: Removing arr[1] from the array modifies
	 * arr[] to { 2, 6, 4 } such that, arr[0] + arr[2] = arr[1]. Therefore, the
	 * required output is 1.
	 */
	private static void specialIndex() {
		int[] A = { 1, 2, 3, 4, 5, 6, 13, 1, 2, 3, 4, 5, 6 };
		int[] evenPrefSum = new int[A.length];
		evenPrefSum[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			if (i % 2 == 0) {
				evenPrefSum[i] = evenPrefSum[i - 1] + A[i];
			} else {
				evenPrefSum[i] = evenPrefSum[i - 1];
			}

		}

		int[] oddPrefSum = new int[A.length];
		oddPrefSum[0] = 0;
		for (int i = 1; i < A.length; i++) {
			if (i % 2 != 0) {
				oddPrefSum[i] = oddPrefSum[i - 1] + A[i];
			} else {
				oddPrefSum[i] = oddPrefSum[i - 1];
			}
		}

		/*
		 * sumOfEven[0, i-1] = psumOfEven[i-1]; sumOfEven[i+1, n-1] = psumOfEven[n-1] -
		 * psumOfEven[i];
		 * 
		 * sumOfOdd[0, i-1] = psumOfOdd[i-1]; psumOfOdd[i+1, n-1] = psumOfOdd[n-1] -
		 * psumOfOdd[i];
		 * 
		 * then
		 * 
		 * After removing ith index
		 * 
		 * sumOfEven = psumOfEven[i-1] + psumOfOdd[n-1] - psumOfOdd[i]; sumOfOdd =
		 * psumOfOdd[i-1] + psumOfEven[n-1] - psumOfEven[i];
		 * 
		 */

		int sumOfEvenIndex = 0;
		int sumOfOddIndex = 0;
		int count = 0;
		for (int i = 1; i < A.length; i++) {
			/*
			 * if(i != 0) { sumOfEvenIndex = sumOfEvenIndex + evenPrefSum[i-1]; }
			 */
			sumOfEvenIndex = evenPrefSum[i - 1] + oddPrefSum[A.length - 1] - oddPrefSum[i];

			/*
			 * if(i != 0) { sumOfOddIndex = sumOfOddIndex + oddPrefSum[i-1]; }
			 */
			sumOfOddIndex = oddPrefSum[i - 1] + evenPrefSum[A.length - 1] - evenPrefSum[i];

			if (sumOfEvenIndex == sumOfOddIndex) {
				count++;
			}
		}
		if (evenPrefSum[A.length - 1] == oddPrefSum[A.length - 1]) {
			count++;
		}
		System.out.println(count);
	}

	/*
	 Given an array of size N, find the majority element. The majority element is 
	 the element that appears more than floor(n/2) times.
	 You may assume that the array is non-empty and the majority element always exists in the array. 
	 */
	public static int majorityElement() {
		int[] A = {4, 2, 3, 4, 4, 7, 8};
		int element = A[0];
		int noOfTimes = 1;
		for (int i = 1; i < A.length; i++) {
			if (noOfTimes == 0) {
				element = A[i];
				noOfTimes = 1;
			} else if (element == A[i]) {
				noOfTimes++;
			} else {
				noOfTimes--;
			}
		}
		int candidate = element;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == candidate) {
				count++;
			}
		}
		System.out.println(candidate);
		if (count > A.length / 3) {
			return candidate;
		} 
		System.out.println(1);
		return 1;
	}
	
	
	private static void repeatNumber() {
		int[] arr = {1,1,1,2,3,5,7};
		if(arr.length == 0) {
			return;
		}
		int firstElement = 0;
		int firstCount = 0;
		int secondElement = 0;
		int secondCount = 0;
		firstElement = arr[0];
		firstCount = 1;
		secondElement = arr[1];
		secondCount = 1;
		for (int i = 0; i < arr.length; i++) {
			if(firstElement == arr[i]) {
				firstCount++;
			}else if(secondElement == arr[i]) {
				secondCount++;
			}else if(firstCount == 0) {
				firstElement = arr[i];
				firstCount = 1;
			}else if(secondCount == 0){
				secondElement = arr[i];
				secondCount = 1;
			}else {
				firstCount--;
				secondCount--;
			}
		}
		
		firstCount = 0;
		secondCount = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == firstElement) {
				firstCount++;
			}else if(arr[i] == secondElement) {
				secondCount++;
			}
		}
		if(firstCount > arr.length/3) {
			System.out.println(firstElement);
			return;
		}
		if(secondCount > arr.length/3) {
			System.out.println(secondElement);
			return;
		}
		System.out.println(-1);
	}
	
}
