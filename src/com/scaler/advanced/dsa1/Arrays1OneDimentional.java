package com.scaler.advanced.dsa1;

import java.util.Arrays;

public class Arrays1OneDimentional {

	public static void main(String[] args) {
		//maxSumContiguousSubArray();
		
		//continuousSumQuery();
		
		//continuousSumQueryWithInitialValues();
		
		//trap();
		
		maximumAbsoluteDifference();
		
		//addOneToNumber();
		
		//flip();

		//incrementNumber();
	}
	
	/*Find the maximum sum of contiguous non-empty subarray within an array A of length N.*/
	/*Kadane’s Algorithm*/
	
	private static void maxSumContiguousSubArray() {
		int[] arr = {};
		int sum = 0;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			ans = Integer.max(ans, sum);
			if(sum < 0) {
				sum = 0;
			}
		}
		System.out.println(ans);
	}
	
	/*
	 There are A beggars sitting in a row outside a temple. Each beggar initially has an empty pot. 
	 When the devotees come to the temple, they donate some amount of coins to these beggars. 
	 Each devotee gives a fixed amount of coin(according to their faith and ability) 
	 to some K beggars sitting next to each other. 
	 
	 Given the amount P donated by each devotee to the beggars ranging from L to R index, 
	 where 1 <= L <= R <= A, find out the final amount of money in each beggar's pot at the end of the day, 
	 provided they don't fill their pots by any other means.
	 For ith devotee B[i][0] = L, B[i][1] = R, B[i][2] = P, Given by the 2D array B
	 */
	private static void continuousSumQuery() {
		int[] arr = new int[5];
		int[][] B = {{1, 2, 10},
						   {2, 3, 20},
						   {2, 5, 25}};
		int start = 0;
		int end = 0;
		int value = 0;
		for (int i = 0; i < B.length; i++) {
			start = B[i][0];
			end = B[i][1];
			value = B[i][2];
			
			arr[start-1] += value;
			if(end < arr.length) {
				arr[end] -= value;
			}
		}
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i-1]+arr[i];
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*private static void continuousSumQueryWithInitialValues() {
		int[] arr = {0,2,0,4,1,-3,0};
		int[][] B = {{2, 4, 5},
					 {1, 3, -2},
					 {3, 6, 7}};
		int start = 0;
		int end = 0;
		int value = 0;
		for (int i = 0; i < B.length; i++) {
			start = B[i][0];
			end = B[i][1];
			value = B[i][2];
			
			arr[start] += value;
			if(end < arr.length-1) {
				arr[end+1] -= value;
			}
		}
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i-1]+arr[i];
		}
		System.out.println(Arrays.toString(arr));
	}*/

	/*
	 Given a vector A of non-negative integers representing an elevation 
	 map where the width of each bar is 1, compute how much water it is 
	 able to trap after raining. 
	 */
	private static void trap() {
		int[] arr = {0, 1, 0, 2};
		int[] lMax = new int[arr.length];
		int[] rMax = new int[arr.length];
		int ans = 0;
		lMax[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			System.out.println(arr[i] + " "+ lMax[i-1]);
			lMax[i] = Math.max(arr[i], lMax[i-1]);
		}
		
		rMax[arr.length-1] = arr[arr.length-1];
		for (int i = arr.length-2; i >= 0; i--) {
			System.out.println(arr[i]+" "+rMax[i+1]);
			rMax[i] = Math.max(arr[i], rMax[i+1]);
		}
		
		for (int i = 0; i < arr.length; i++) {
			ans += Math.min(lMax[i], rMax[i])-arr[i];
		}
		System.out.println(ans);
	}
	
	/*
	 You are given an array of N integers, A1, A2, AN
	 Return the maximum value of f(i, j) for all 1 <= i, j <= N. f(i, j) 
	 is defined as |A[i] - A[j]| + |i - j|, where |x| denotes absolute value of x.
	 */
	private static void maximumAbsoluteDifference() {
		int[] arr = {1, 3, -1};
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]+i > max) {
				max = arr[i]+i;
			}
			if(arr[i]+i < min) {
				min = arr[i]+i;
			}
		}
		ans = Integer.max(ans, max-min);
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]-i > max) {
				max = arr[i]-i;
			}
			if(arr[i]-i < min) {
				min = arr[i]-i;
			}
		}
		ans = Integer.max(ans, max-min);
		System.out.println(ans);
	}
	
	
	
	private static void addOneToNumber() {
		int[] arr = {1,2,3};
		arr[arr.length-1]++;
		System.out.println(Arrays.toString(arr));
	}
	
	
	private static void flip() {
		String str = "0111000100010";
		int currentSum = 0;
		int maxSum = 0;
		int r = 0;
		int l = 0;
		int[] ansArr = new int[2];
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '1') {
				currentSum--;
			}else {
				currentSum++;
			}
			if(maxSum < currentSum) {
				maxSum = currentSum;
				ansArr[0] = l+1;
				ansArr[1] = r+1;
			}
			
			if(currentSum < 0) {
				currentSum = 0;
				l = i+1;
				r = i+1;
			}else {
				r+=1;
			}
		}
		if(maxSum == 0) {
			System.out.println("Empty Arr");
			return;
		}else {
			System.out.println(Arrays.toString(ansArr));
		}
	}
	
	private static void incrementNumber() {
		int[] arr = {0};
		int leadingZero = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				break;
			}else {
				leadingZero++;
			}
		}
		if(arr.length == 1) {
			leadingZero = 0;
		}
		for (int i = arr.length-1; i>=0 ; i--) {
			if(arr[i] != 9) {
				arr[i]++;
				System.out.println(Arrays.toString(Arrays.copyOfRange(arr, leadingZero, arr.length)));
				return;
			}
			arr[i] = 0;
		}
		
		int[] newNumber = new int[arr.length + 1-leadingZero];
		newNumber[0] = 1;
		System.out.println(Arrays.toString(newNumber));
		return;
	}
	
}
