package com.scaler;

import java.util.Arrays;

public class InterviewProblemsTwo {

	public static void main(String[] args) {
		//lengthOfLongestConsecutiveOnes();
		
		//countIncreasingTriplets();
		
		//josephusProblem();
		
		multipleLeftRotation();
		
		//reverseArr();
	}
	
	private static void lengthOfLongestConsecutiveOnes() {
		String str = "11010110000000000";
		char[] chArr = str.toCharArray();
		int count = 0;
		for (int i = 0; i < chArr.length; i++) {
			if(chArr[i] == '1') {
				count++;
			}
		}
		if(count == chArr.length) {
			System.out.println(count);
			return;
		}
		if(count == 0) {
			System.out.println("0");
			return;
		}
		
		int ans = 0;
		for (int i = 0; i < chArr.length; i++) {
			if(chArr[i] == '0') {
				int leftOnes = 0;
				for (int j = i-1; j >= 0; j--) {
					if(chArr[j] == '1') {
						leftOnes++;
					}else {
						break;
					}
				}
				
				int rightOnes = 0;
				for (int j = i+1; j < chArr.length; j++) {
					if(chArr[j] == '1') {
						rightOnes++;
					}else {
						break;
					}
				}
				if(count == leftOnes+rightOnes) {
					ans = Integer.max(ans, leftOnes+rightOnes);
				}else {
					ans = Integer.max(ans, leftOnes+rightOnes+1);
				}
				
			}
		}
		System.out.println(ans);
	}
	
	/*
	 You are given an array A of N elements. Find the number of triplets i,j and k such that i<j<k and A[i]<A[j]<A[k] 
	 */
	private static void countIncreasingTriplets() {
		int[] arr = {0,1,2,6,9,7};
		int ans = 0;
		for (int i = 1; i < arr.length-1; i++) {
			int leftSmallCount = 0;
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					leftSmallCount++;
				}
			}
			int rightGreaterCount = 0;
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i] < arr[j]) {
					rightGreaterCount++;
				}
			}
			ans += (leftSmallCount*rightGreaterCount);
		}
		System.out.println(ans);
	}
	/*
	 There are A people standing in a circle. Person 1 kills their 
	 immediate clockwise neighbour and pass the knife to the next person 
	 standing in circle. This process continues till there is only 1 person 
	 remaining. Find the last person standing in the circle.
	 */
	private static void josephusProblem() {
		int n = 100;
		int closestPower = 1;
		while(closestPower * 2 <= n) {
			closestPower = closestPower*2;
		}
		int kills = n - closestPower;
		int ans = (kills*2) + 1;
		System.out.println(ans);
	}
	
	private static void multipleLeftRotation() {
		int[] A = {1,2,3,4,5};
		int[] B = {2,3};
		int[][] ansArr = new int[B.length][A.length];
		/*int index = 1;
		for (int i = 0; i < B.length; i++) {
			index = 0;
			for (int j = 0; j < A.length; j++) {
				if(j < A.length-B[i]) {
					ansArr[i][j] = A[B[i]+j];
				}else {
					ansArr[i][j] = A[index];
					index++;
				}
				
			}
		}*/
		
		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < A.length; j++) {
				ansArr[i][j] = A[(j+B[i]) % A.length];
			}
		}
		print2DArr(ansArr);
	}
	private static void print2DArr(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.println(Arrays.toString(A[i]));
		}
	}
	public static void reverseArr() {
		int[] arr = {1,2,3,4,5};
		int start = 0;
		int end = arr.length-1;
		int temp = 0;
		while(start < end) {
			temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
		System.out.println(Arrays.toString(arr));
	}
	
}
