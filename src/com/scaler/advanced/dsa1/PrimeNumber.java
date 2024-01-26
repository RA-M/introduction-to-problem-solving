package com.scaler.advanced.dsa1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeNumber {

	public static void main(String[] args) {
		//countOfFactors();
		
		checkIfPrimeNumbersFrom1ToN();
		
		//countOfDevisors();
		
		//numberOfOpenDoors();
		
	}
	
	private static void countOfFactors() {
		int num = 7;
		int count = 0;
		for (int i = 1; i*i<= num; i++) {
			if(num%i == 0) {
				if(i == num/i) {
					count++;
				}else {
					count+=2;
				}
			}
		}
		System.out.println(count);
	}
	
	private static void checkIfPrimeNumbersFrom1ToN() {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		boolean[] isPrime = new boolean[arr.length+1];
		Arrays.fill(isPrime, Boolean.TRUE);
		isPrime[0] = false;
		isPrime[1] = false;
		for (int i = 2; i*i<=isPrime.length; i++) {
			if(isPrime[i] = true) {
				for (int j = i*i; j < isPrime.length; j+=i) {
					isPrime[j]=false;
				}
			}
		}
		System.out.println(Arrays.toString(isPrime));
	}

	
	/*
	 * Count of divisors
	 Given an array of integers A, find and return the count of divisors of each element of the array.
	 NOTE: The order of the resultant array should be the same as the input array. 
	 */
	private static void countOfDevisors() {
		int[] arr = {2,3,4,5};
		int[] resArr = new int[arr.length];
		int count = 0;
		for (int i = 0; i < resArr.length; i++) {
			count = 0;
			for (int j = 1; j*j <= arr[i]; j++) {
				if(arr[i]%j == 0) {
					if(j == arr[i]/j) {
						count++;
					}else {
						count+=2;
					}
				}
			}
			resArr[i] = count;
		}
		System.out.println(Arrays.toString(resArr));
	}
	
	/*
	 Number Of Open Doors 
	 */
	private static void numberOfOpenDoors() {
		int num = 90;
		int ans = 0;
		for (int i = 0; i*i <= num; i++) {
			ans = i;
			if(i*i == num) {
				ans = i;
			}
		}
		System.out.println(ans);
		
		ans = (int) Math.sqrt(num);
		System.out.println(ans);
	}
	
	
}
