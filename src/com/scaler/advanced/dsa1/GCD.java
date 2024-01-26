package com.scaler.advanced.dsa1;

public class GCD {

	public static void main(String[] args) {

		//System.out.println(getGCD(1,4));
		
		//pubG();
		
		deleteOne();
	}
	/*
	 Given 2 non-negative integers A and B, find gcd(A, B)
	 GCD of 2 integers A and B is defined as the greatest integer 'g' such that 'g' is a divisor 
	 of both A and B. Both A and B fit in a 32 bit signed integer.
	 Note: DO NOT USE LIBRARY FUNCTIONS. 
	 */
	private static int getGCD(int a, int b) {
		if(b == 0) {
			return a;
		}
		return getGCD(b, a%b);
	}
	
	/*
	 Pubg:
	 There are N players, each with strength A[i]. when player i attack player j, player j strength 
	 reduces to max(0, A[j]-A[i]). When a player's strength reaches zero, it loses the game, and the 
	 game continues in the same manner among other players until only 1 survivor remains.
	 Can you tell the minimum health last surviving person can have? 
	 */
	private static void pubG() {
		int[] arr = {3,2,4};
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			ans = getGCD(ans, arr[i]);
		}
		System.out.println(ans);
	}
	
	/*
	 Delete one
	 Given an integer array A of size N. You have to delete one element such that the 
	 GCD(Greatest common divisor) of the remaining array is maximum.
	 Find the maximum value of GCD. 
	 */
	
	private static void deleteOne() {
		int[] arr = {12, 15, 18};
		int[] gcdPrefSum = new int[arr.length];
		int[] gcdSufixSum = new int[arr.length];
		//Get GCD prefArray
		gcdPrefSum[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			gcdPrefSum[i] = getGCD(gcdPrefSum[i-1], arr[i]);
		}
		//Get GCD sufixSumArray
		gcdSufixSum[arr.length-1] = arr[arr.length-1];
		for (int i = arr.length-2; i >= 0; i--) {
			gcdSufixSum[i] = getGCD(gcdSufixSum[i+1], arr[i]);
		}
		//Check max GCD
		int ans = gcdSufixSum[1];
		int left = 0;
		int right = 0;
		for (int i = 1; i < arr.length-1; i++) {
			left = gcdPrefSum[i-1];
			right = gcdSufixSum[i+1];
			ans = Math.max(ans, getGCD(left, right));
		}
		System.out.println(ans);
	}
}
