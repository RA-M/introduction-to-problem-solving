package com.scaler.advanced.dsa1;

public class AdvanceContest1 {

	public static void main(String[] args) {
		//maxSubArraySumIncreasingArr();
		
		//solve();
		
		luckyNumbers();
	}
	//Max sum of increasing subArray
	public static long maxSubArraySumIncreasingArr() {
		int[] A = {1,2,3,4,5};
		int ans = A[0];
		int sum = A[0];
		for (int i = 1; i < A.length; i++) {
			if(A[i-1] < A[i]) {
				sum += A[i];
			}else {
				sum = A[i];
			}
			ans = Math.max(sum, ans);
		}
        System.out.println(ans);
        return ans;
    }

	//
	private static void solve() {
		int num = 11;
		int last = -1;
		int ans = 0;
		for (int i = 0; i < 31; i++) {
			if(checkBit(num, i)) {
				if(last == -1) {
					last = i;
				}else {
					ans = Math.max(ans, i-last);
					last = i;
				}
			}
		}
		System.out.println(ans);
	}
	private static boolean checkBit(int num, int index) {
		if(((num >> index) & 1) == 1) {
			return true;
		}else{
			return false;
		}
	}
	
	/*
	 *  Lucky Numbers
	 A lucky number is a number that has exactly 2 distinct prime divisors.
	 You are given a number A, and you need to determine the count of lucky numbers 
	 between the range 1 to A (both inclusive). 
	 */
	private static void luckyNumbers() {
		int num = 10;
		int[] arr = new int[num+1];
		for (int i = 2; i < arr.length; i++) {
			if(arr[i] == 0) {
				for (int j = i; j < arr.length; j+=i) {
					arr[j]++;
				}
			}
		}
		int count =0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 2) {
				count++;
			}
		}
		System.out.println(count);
	}
}
