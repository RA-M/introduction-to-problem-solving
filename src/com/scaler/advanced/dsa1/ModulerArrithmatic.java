package com.scaler.advanced.dsa1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ModulerArrithmatic {

	public static void main(String[] args) {
		//normalPowerFunction();
		
		//powerFunctionRecursion();
		
		//fastPower();
		
		//fastPwerWithMod();
		
		//pairSumDivisibleByB();
		
		//primeModuloInverse();
		
		rearrangeArray();
	}
	
//=============================================================================================
	//TC = O(n)
	//SC = O(1)
	private static void normalPowerFunction() {
		//a^n
		int a = 2;
		int n = 3;
		int ans = 1;
		for (int i = 0; i < n; i++) {
			ans = ans * a;
		}
		System.out.println(ans);
	}
//=============================================================================================
	//TC = O(n)
	//SC = O(n)
	private static void powerFunctionRecursion() {
		int a = 2;
		int n = 3;
		int ans = getPower(a, n);
		
		System.out.println(ans);
	}
	
	private static int getPower(int a, int n) {
		if(n == 0) {
			return 1;
		}
		int res = getPower(a, n-1);
		int ans = res * a;
		return ans;
	}
	
//=============================================================================================
	//TC = O(logn)
	//SC = O(logn)
	private static void fastPower() {
		int a = 2;
		int n = 3;
		int ans = getFastPower(a, n);
		
		System.out.println(ans);
	}
	private static int getFastPower(int a, int n) {
		if(n == 0) {
			return 1;
		}
		int ans = 1;
		int res = getFastPower(a, n/2);
		if(n % 2 == 0) {
			ans = res * res;
		}else {
			ans = res * res * a;
		}
		return ans;
	}
//=============================================================================================
	
	private static void fastPwerWithMod() {
		int a = 2;
		int n = 3;
		int m = 2;
		int ans = getFastPowerWithMod(a, n, m);
		
		System.out.println(ans);
	}

	private static int getFastPowerWithMod(int a, int n, int m) {
		if(n == 0) {
			return 1;
		}
		int ans = 0;
		int res = getFastPowerWithMod(a, n/2, m);
		if(n % 2 == 0) {
			ans = (res * res) % m;
		}else {
			ans = ((res * res)%m * a) % m;
		}
		return ans;
	}
//=============================================================================================	
	
	/*
	 Pair Sum divisible by B:
	 Given an array of integers A and an integer B, find and return the number of 
	 pairs in A whose sum is divisible by B.
	 Since the answer may be large, return the answer modulo (109 + 7).
	 Note: Ensure to handle integer overflow when performing the calculations. 
	 */
	private static void pairSumDivisibleByB() {
		int[] arr = {4, 7, 10, 5, 9};
		int B = 3;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i]%B)) {
				map.put(arr[i]%B, map.get(arr[i]%B)+1);	
			}else {
				map.put(arr[i]%B, 1);
			}
		}
		int ans = 0;
		int temp = 0;
		if(map.containsKey(0)) {
			temp = map.get(0);
			ans += (temp * (temp-1))/2;
		}
		if(B % 2 == 0 && map.containsKey(B/2)) {
			temp = map.get(B/2);
			ans += (temp * (temp-1))/2;
		}
		for (int i = 1; i < (B+1)/2; i++) {
			if(map.containsKey(i) && map.containsKey(B-i)) {
				ans += map.get(i) * map.get(B-i);
			}
		}
		System.out.println(ans);
	}
	
	
	/*
	  Prime Modulo Inverse  (Fermat's Little Theorem)

	 Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
	 A-1 mod B is also known as modular multiplicative inverse of A under modulo B. 
	 */
	private static void primeModuloInverse() {
		int A = 3;
		int B = 5;
		//We have to find out A inverse mod B so that's we are finding A^B-2 it is same A^-1 = A^B-2 
		//Thats why
		int power = B-2;
		System.out.println(getPower(A, power, B));
	}
	private static int getPower(int a, int power, int mod) {
		if(power == 0) {
			return 1;
		}
		long ans = 0;
		int num = getPower(a, power/2, mod);
		if(power % 2 == 0) {
			ans = (num*num)%mod;
		}else {
			ans = ((num*num)%mod * a)%mod;
		}
		return (int)ans;
	}
	
	
	/*
	 * Rearrange Array
	 Given an array A of size N. Rearrange the given array so that A[i] becomes A[A[i]] with O(1) extra space.
	 */
	private static void rearrangeArray() {
		int[] arr = {1,0};
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] * arr.length;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] += arr[arr[i]/arr.length]/arr.length;
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i]%arr.length;
		}
		System.out.println(Arrays.toString(arr));
	}
}
