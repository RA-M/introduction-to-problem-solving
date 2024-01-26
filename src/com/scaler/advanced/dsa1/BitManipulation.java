package com.scaler.advanced.dsa1;

import java.util.Arrays;

public class BitManipulation {

	public static void main(String[] args) {
		singleNumber();
		
		sumOfXORofAllPairs();
		
		minXORValue();
	}
	
	public static boolean checkBit(int num, int index){
		return (((num >> index) & 1) == 1) ? true : false;
	}
	/*
	 Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.
	 NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
	 */
	public static int singleNumber() {
		int[] A = {};
        int ans = 0;
        for(int i=0; i<A.length; i++){
            ans = ans ^ A[i];
        }
        return ans;
    }
	
	/*
	 Given an array A of N integers. Find the sum of bitwise XOR all pairs of numbers in the array.
	 Since the answer can be large, return the remainder after the dividing the answer by 109+7. 
	 */
	private static void sumOfXORofAllPairs() {
		int[] arr = {};
		long sum = 0;
		long count = 0;
		for (int i = 0; i < 31; i++) {
			count = 0;
			for (int j = 0; j < arr.length; j++) {
				if(checkBit(arr[j], i)) {
					count++;
				}
			}
			sum = (sum + (count * (arr.length-count)) * (1<<i)) % 1000000007;
		}
		System.out.println(sum);
	}
	/*
	 Given an integer array A of N integers, find the pair of integers in the 
	 array which have minimum XOR value. Report the minimum XOR value. 
	 */
	private static void minXORValue() {
		int[] arr = {};
		int ans = Integer.MAX_VALUE;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length-1; i++) {
			if((arr[i] ^ arr[i+1]) < ans) {
				ans = arr[i] ^ arr[i+1];
			}
		}
		System.out.println(ans);
	}
	
	/*
	 * . SUBARRAY OR
	 You are given an array of integers A of size N.
	 The value of a subarray is defined as BITWISE OR of all elements in it.
	 Return the sum of value of all subarrays of A % 10^9 + 7. 
	 */
	private static void subArrayOR() {
		int[] arr = {};
		int ans = 0;
		int n = arr.length;
		int totalSubArray = (n * (n+1))/2;
		int count = 0;
		int zeroVal = 0;
		int mod = 1000000007;
		for (int i = 0; i < 31; i++) {
			count = 0;
			zeroVal = 0;
			for (int j = 0; j < arr.length; j++) {
				if(!checkBit(arr[j], i)) {
					count++;
				}else {
					zeroVal += (count * (count+1))/2;
					count = 0;
				}
			}
			zeroVal += (count * (count+1))/2;
			ans += (totalSubArray-zeroVal) * (1<<i);
		}
		System.out.println(ans % mod);
	}

}
