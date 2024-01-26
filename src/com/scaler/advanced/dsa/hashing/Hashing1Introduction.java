package com.scaler.advanced.dsa.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Hashing1Introduction {

	public static void main(String[] args) {

		//longestConsicutiveSequence();
		
		//closestDuplicates();
		
		//longestSubarrWithZeroSum();
		
		//sortArrInGivenOrder();
		
		colorFullNumber();
	}
	
	private static void longestConsicutiveSequence() {
		int[] A = {100,4,200,1,3,2};
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			hashSet.add(A[i]);
		}
		int length = 1;
		int ans = 0;
		for (Integer num : hashSet) {
			if(!hashSet.contains(num-1)) {
				length = 1;
				int nextNumber = num+1;
				while (hashSet.contains(nextNumber)) {
					length++;
					nextNumber++;
				}
				ans = Integer.max(ans, length);
			}
		}
		System.out.println(ans);
	}

	private static void closestDuplicates() {
		int[] A = {1,1};
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		int ans = Integer.MAX_VALUE;
		int diff = 0;
		for (int i = 0; i < A.length; i++) {
			if(hashMap.containsKey(A[i])) {
				diff = Math.abs(i - hashMap.get(A[i]));
				ans = Integer.min(ans, diff);
				hashMap.put(A[i], i);
			}else {
				hashMap.put(A[i], i);
			}
		}
		System.out.println(ans);
	}
	
	private static void longestSubarrWithZeroSum() {
		int[] A = {9,-20,-11,-8,-4,2,-12,14,1};
		HashMap<Long, Integer> hashMap = new HashMap<>();
		for (int i = 1; i < A.length; i++) {
			A[i] = A[i-1]+A[i];
		}
		long diff = 0;
		long ans = 0;
		hashMap.put(ans, -1);
		for (int i = 0; i < A.length; i++) {
			if(hashMap.containsKey((long)A[i])) {
				diff = Math.abs(i-hashMap.get((long)A[i]));
				ans = Integer.max((int)ans, (int) diff);
			}else {
				hashMap.put((long)A[i], i);
			}
		}
		System.out.println(ans);
	}
	
	private static void sortArrInGivenOrder() {
		int[] A = {15,5,10,6,14};
		int[] B = {8,16,6,2,13,1,12,3,14};
		//6 14 5 10 15
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			hashMap.put(A[i], hashMap.containsKey(A[i]) ? hashMap.get(A[i])+1 : 1);
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < B.length; i++) {
				while (hashMap.containsKey(B[i]) && hashMap.get(B[i]) != 0) {
					list.add(B[i]);
					hashMap.put(B[i], hashMap.get(B[i])-1);
				}
		}
		Arrays.sort(A);
		for (int i = 0; i < A.length; i++) {
			if(hashMap.get(A[i]) != 0) {
				list.add(A[i]);
			}
		}
		int[] arr = list.stream().mapToInt(Integer::intValue).toArray();
		System.out.println(Arrays.toString(arr));
	}
	
	private static void colorFullNumber() {
		int num = 99;
		ArrayList<Integer> list = new ArrayList<>();
		while(num > 0) {
			list.add(num%10);
			num = num/10;
		}
		Collections.reverse(list);
		HashSet<Long> hashSet = new HashSet<>();
		long prod = 1;
		for (int i = 0; i < list.size(); i++) {
			prod = 1;
			for (int j = i; j < list.size(); j++) {
				prod = prod * list.get(j);
				if(hashSet.contains(prod)) {
					System.out.println(0);
					return;
				}else {
					hashSet.add(prod);
				}
			}
		}
		System.out.println(1);
	}
}
