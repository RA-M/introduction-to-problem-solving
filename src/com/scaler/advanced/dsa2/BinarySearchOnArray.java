package com.scaler.advanced.dsa2;

import java.util.Arrays;

public class BinarySearchOnArray {

	public static void main(String[] args) {
		//binarySearch();
		
		//singleElementInSortedArr();
		
		//peakElement();
		
		//searchForARange();
		
		matrixSearch();
	}
	
	private static void binarySearch() {
		int[] arr = {1, 4, 9};
		int num = 3;
		int left = 0;
		int rigth = arr.length-1;
		while(left <= rigth) {
			int mid = left+(rigth-left)/2;
			if(arr[mid] == num) {
				System.out.println(mid);
				return;
			}else if(arr[mid] < num) {
				left = mid+1;
			}else {
				rigth = mid-1;
			}
		}
		System.out.println(left);
	}
	
	/*
	 Given a sorted array of integers A where every element appears twice except for one element which appears once, 
	 find and return this single element that appears only once.
	 Elements which are appearing twice are adjacent to each other.
	 NOTE: Users are expected to solve this in O(log(N)) time. 
	 */
	private static void singleElementInSortedArr() {
		int[] arr = {1, 1, 7};
		int mid = 0;
		int firstOcc = 0;
		if(arr.length == 1) {
			System.out.println(arr[0]);
			return;
		}
		if(arr[0] != arr[1]) {
			System.out.println(arr[0]);
			return;
		}
		if(arr[arr.length-1] != arr[arr.length-2]) {
			System.out.println(arr[arr.length-1]);
			return;
		}
		
		int left = 2;
		int right = arr.length-3;
		
		while(left <= right) {
			mid = left+(right-left)/2;
			if(arr[mid] != arr[mid-1] && arr[mid] != arr[mid+1]) {
				System.out.println(arr[mid]);
				return;
			}
			firstOcc = mid;
			if(arr[mid] == arr[mid-1]) {
				firstOcc = mid-1;
			}
			if(firstOcc%2 == 0) {
				left = firstOcc+2;
			}else {
				right = firstOcc-1;
			}
		}
		System.out.println("num not present");
	}

	/*
	 Given an array of integers A, find and return the peak element in it.
	 An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.

	 NOTE:

	 It is guaranteed that the array contains only a single peak element.
	 Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements. 
	 */
	private static void peakElement() {
		int[] arr = {1,1000000000,1000000000};
		if(arr[0] > arr[1]) {
			System.out.println(arr[0]);
			return;
		}
		if(arr[arr.length-1] > arr[arr.length-2]) {
			System.out.println(arr[arr.length-1]);
			return;
		}
		int left = 1;
		int right = arr.length-2;
		int mid = 0;
		while(left <= right) {
			mid = left+(right-left)/2;
			if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]) {
				System.out.println(arr[mid]);
				return;
			}else if(arr[mid-1] > arr[mid]) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		System.out.println(arr[mid]);
	}
	
	private static void searchForARange() {
		int[] A = {4, 7, 7, 7, 8, 10, 10};
		int B = 3;
		int left = 0;
		int right = A.length-1;
		int mid = 0;
		int[] ansArr = new int[2];
		
		int firstOcc = -1;
		int secondOcc = -1;
		
		while(left <= right) {
			mid = left+(right-left)/2;
			if(A[mid] == B) {
				firstOcc = mid;
				right = mid-1;
			}else if(A[mid] < B) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		left = 0;
		right = A.length-1;
		while(left <= right) {
			mid = left+(right-left)/2;
			if(A[mid] == B) {
				secondOcc = mid;
				left = mid+1;
			}else if(A[mid] < B) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		ansArr[0] = firstOcc;
		ansArr[1] = secondOcc;
		System.out.println(Arrays.toString(ansArr));
	}
	
	
	//Brute force Approach
	private static void matrixSearch() {
		int[][] arr = {{1,   3,  5,  7},
			      	   {10, 11, 16, 20},
			    	   {23, 30, 34, 50}};
		int B = 51;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i][0] <= B && arr[i][arr[i].length-1] >= B) {
				if (binarySearchAlgo(arr[i], B)) {
					System.out.println("Element found");
					return;
				}
			}
		}
		System.out.println("Element not found");
		return;
	}
	private static boolean binarySearchAlgo(int[] arr, int B) {
		int left = 0;
		int right = arr.length;
		int mid = 0;
		while (left <= right) {
			mid = left+(right-left)/2;
			if(arr[mid] == B) {
				return true;
			}else if(arr[mid] < B) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return false;
	}
	
	private static void matrixSearchAlgo() {
		int[][] arr = {{}};
		int B = 10;
		int left = 0;
		int right = (arr.length*arr[0].length)-1;
		while(left <= right) {
			int mid = left+(right-left)/2;
			int i = mid/arr[0].length;
			int j = mid%arr[0].length;
			if(arr[i][j] == B) {
				System.out.println(1);
				return;
			}else if(arr[i][j] < B) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		System.out.println(0);
	}
}
