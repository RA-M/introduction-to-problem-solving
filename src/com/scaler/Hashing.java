package com.scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Hashing {

	public static void main(String[] args) {
		//numOfFrequesncy();
		
		//firstRepeat();
		
		checkSubArraySumZero();
		
		//findColorFullNumner();
		
		//longestSubArrayZeroSum();
		
		//distinctNumbersInWindow();
		
		//countPairSum();
		
		//solve();
		
		//commonElements();
		
	}
	/*
	 Given an array A. You have some integers given in the array B.
	 For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies. 
	 */
	public static int[] numOfFrequesncy() {
		int[] A = {6,3,3,6,7,8,7,3,7};
		int[] B = {10,9,8};
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<A.length; i++){
            if(map.containsKey(A[i])){
                map.put(A[i], map.get(A[i])+1);
            }else{
                map.put(A[i], 1);
            }
        }
        int[] resArr = new int[B.length];
        for(int j=0; j<B.length; j++){
            resArr[j] = (map.get(B[j]) != null) ? map.get(B[j]) : 0;
        }
        System.out.println(Arrays.toString(resArr));
        return resArr;
    }
	/*
	 Given an integer array A of size N, find the first repeating element in it.
	 We need to find the element that occurs more than once and whose index of the first occurrence is the smallest.
	 If there is no repeating element, return -1. 
	 */
	public static int firstRepeat() {
		int ans = -1;
		int[] A = {8,15,1,10,5,19,19,3,5,6,6,2,8,2,12,16,3};
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>(); 
        for(int i=0; i<A.length; i++){
            if(hashMap.containsKey(A[i])){
                hashMap.put(A[i], hashMap.get(A[i])+1);
            }else{
                hashMap.put(A[i], 1);
            }
        }
        for(int j=0; j<A.length; j++){
            if(hashMap.containsKey(A[j]) && hashMap.get(A[j]) > 1){
                ans = A[j];
                break;
            }
        }
        System.out.println(ans);
		return ans;
    }
	
	/*
	 Given an array of integers A, find and return whether the given array contains a non-empty 
	 subarray with a sum equal to 0.
	 If the given array contains a sub-array with sum zero return 1, else return 0. 
	 */
	public static int checkSubArraySumZero() {
		  int[] A = {1,2,3,4,5,-5};
		  long sum = A[0];
		  HashSet<Long> hashSet = new HashSet<Long>();
		  hashSet.add(sum);
	      for(int i=1; i<A.length; i++){
	    	  sum = sum + A[i];
	          if(sum == 0 || !hashSet.add(sum)) {
	        	  System.out.println(1);
	        	  return 1;
	          }
	      }
	      System.out.println(0);
	      return 0;
	  }
	public int solve(int[] A) {
        HashSet<Integer> hashSet = new HashSet<Integer>();
        int count = 0;
        for(int i=0; i<A.length; i++){
            if(hashSet.add(A[i])){
                count++;
            }
        }
        return count;
    }

	/*
	 Given a number A, find if it is COLORFUL number or not.
	 If number A is a COLORFUL number return 1 else, return 0.
	 What is a COLORFUL Number:
	 A number can be broken into different consecutive sequence of digits. 
	 The number 3245 can be broken into sequences like 3, 2, 4, 5, 32, 24, 45, 324, 245 and 3245. 
	 This number is a COLORFUL number, since the product of every consecutive sequence of digits is different 
	 */
	
	private static void findColorFullNumner() {
		int A = 234;
		//[2, 3, 6, 23, 36, 236]
		HashSet<Integer> set=new HashSet<>();
        while(A>0){
            int temp=A;
            int product=1;
            while(temp>0){
             product*=temp%10;
             if(!set.add(product)) {
            	 System.out.println(0);
            	 return;
             } 
             temp/=10;
            }
            A/=10;
        }
        System.out.println(1);
	}
	
	
	private void method() {
		int[] A = {6,3,3,6,7,8,7,3,7};
		int k = 5;
		HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < A.length; i++) {
			if(hashMap.containsKey(A[i])) {
				hashMap.put(A[i], hashMap.get(A[i])+1);
			}else {
				hashMap.put(A[i], 1);
			}
		}
		for (int i = 0; i < A.length; i++) {
			int a = A[i];
			int b = k-a;
			if(a != b && hashMap.containsKey(b)) {
				System.out.println("true");
				return;
			}
			if(a == b && hashMap.get(b) > 1) {
				System.out.println("true");
				return;
			}
		}
		System.out.println("false");
	}
	
	/*
	 Given an array A of N integers.
	 Find the length of the longest subarray in the array which sums to zero.
	 Note :	
	 while we A[i] multiple times, it may cross the range of integer, so wisely select data type for any operations. 
	 */
	private static void longestSubArrayZeroSum() {
		int[] A = {9,-20,-11,-8,-4,2,-12,14,1};
		long[] prefSum = new long[A.length];
		prefSum[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			prefSum[i] = prefSum[i - 1] + A[i];
		}
		HashMap<Long, Integer> hashMap = new HashMap<Long, Integer>();
		hashMap.put((long) 0, -1);
		int ans = 0;
		for (int j = 0; j < A.length; j++) {
			if (hashMap.containsKey(prefSum[j])) {
				ans = Integer.max(ans, j - hashMap.get(prefSum[j]));
			} else {
				hashMap.put(prefSum[j], j);
			}
		}
		System.out.println(ans);
	}
	
	
	private static void distinctNumbersInWindow() {
		int[] arr = {1, 2, 1, 3, 4, 3};
		int B = 3;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < B; i++) {
			if(hashMap.containsKey(arr[i])) {
				hashMap.put(arr[i], hashMap.get(arr[i])+1);
			}else {
				hashMap.put(arr[i], 1);
			}
		}
		System.out.println(hashMap.size() + " ");
		int start = 0;
		int end = B;
		while (end<arr.length) {
			if(hashMap.get(arr[start]) == 1) {
				hashMap.remove(arr[start]);
			}else {
				hashMap.put(arr[start], hashMap.get(arr[start])-1);
			}
			
			if(hashMap.containsKey(arr[end])) {
				hashMap.put(arr[end], hashMap.get(arr[end])+1);
			}else {
				hashMap.put(arr[end], 1);
			}
			System.out.println(hashMap.size() + " ");
			start++;
			end++;
		}
	}
	
	/*
	 You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such 
	 that A[i] + A[j] = B and i != j.
	 Since the answer can be very large, return the remainder after dividing the count with 109+7.
	 Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once. 
	 */
	private static void countPairSum() {
		int[] A = {1, 2, 1, 2};
		int B = 3;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
        int count = 0;
        for(int num : A){
            int k = B-num;
            if(hashMap.containsKey(k)){
                count += hashMap.get(k);
            }
            if(hashMap.containsKey(num)){
                hashMap.put(num, hashMap.get(num)+1);
            }else{
                hashMap.put(num, 1);
            }
        }
		System.out.println(count%1000000007);
	}

	public static int solve() {
		int A = 10;
		int B = 20;
		int C=30;
        String str1 = String.valueOf(A);
        String str2 = String.valueOf(B);
        String str3 = String.valueOf(C);
        String ans = "";
        for (int i = 0; i < 3; i++) {
        	
		}
        
        System.out.println(ans);
        return Integer.parseInt(ans);
    }
	
	public static int[] commonElements() {
		int[] A = {1,2,2,1};
		int[] B = {2,3,1,2};
	      HashMap<Integer, Integer> hashMap = new HashMap<>();
	      for(int num : A){
	          if(hashMap.containsKey(num)){
	              hashMap.put(num, hashMap.get(num)+1);
	          }else{
	              hashMap.put(num, 1);
	          }
	      }
	      int[] ansArr = new int[A.length];
	      int i = 0;
	      for(int num : B){
	          if(hashMap.containsKey(num)){
	              ansArr[i] = num;
	              i++;
	              if(hashMap.get(num) == 1){
	                  hashMap.remove(num);
	              }else{
	                  hashMap.put(num, hashMap.get(num)-1);
	              }
	          }
	      }
	      System.out.println(Arrays.toString(ansArr));
	      return ansArr;
	  }
	

	private void colorFullNo() {
		int A = 1234;
		HashSet<Integer> hashSet = new HashSet<>();
		while(A > 0) {
			int temp = A;
			int product = 1;
			while(temp > 0) {
				int rem = temp%10;
				product = product * rem;
				if(!hashSet.add(product)) {
					//Not a Colorfull no
				}
				temp = temp/10;
			}
			A = A/10;
		}
		//Colorfull
	}
}
