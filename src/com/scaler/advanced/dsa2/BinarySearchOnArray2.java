package com.scaler.advanced.dsa2;

public class BinarySearchOnArray2 {

	public static void main(String[] args) {
		//squareRootOfInteger();
		
		searchElementInRotatedArray();
	}
	
	private static void squareRootOfInteger() {
		int num = 10;
		int left = 0;
		int right = 10;
		int ans = 0;
		while(left <= right) {
			int mid = left + (right-left)/2;
			if((mid*mid) == num) {
				System.out.println(mid);
				return;
			}else if((mid*mid) < num) {
				ans = mid;
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(ans);
	}
	
	/*
	 Given a sorted array of integers A of size N and an integer B, 
	 where array A is rotated at some pivot unknown beforehand.
	 For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
	 Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
	 You can assume that no duplicates exist in the array.
	 NOTE: You are expected to solve this problem with a time complexity of O(log(N)). 
	 */
	private static void searchElementInRotatedArray() {
		int[] arr = {5,6,7,8,9,1,2,3};
		int num = 3;
		int left = 0;
		int right = arr.length-1;
		int mid = 0;
		while(left <= right) {
			mid = left+(right-left)/2;
			int targetPart = getElementPart(arr, num);
			int midPart = getElementPart(arr, arr[mid]);
			if(arr[mid] == num) {
				System.out.println(mid);
				return;
			}
			if(targetPart == 2 && midPart == 1) {
				left = mid+1;
			}else if(targetPart == 1 && midPart == 2) {
				right = mid-1;
			}else {
				if(arr[mid] < num) {
					left = mid+1;
				}else {
					right = mid-1;
				}
			}
		}
	}
	private static int getElementPart(int[] arr, int num) {
		if(arr[0] > num) {
			return 2;
		}
		return 1;
	}
	
	private static int getGCD(int a, int b) {
		if(b == 0) {
			return a;
		}
		return getGCD(b, a%b);
	}
}
