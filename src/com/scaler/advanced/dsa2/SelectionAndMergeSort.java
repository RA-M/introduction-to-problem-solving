package com.scaler.advanced.dsa2;

import java.util.Arrays;

public class SelectionAndMergeSort {

	static int count = 0;
	
	public static void main(String[] args) {
		//selectionSort();
		
		//kthSmallestElement();
		
		//mergeTwoSortedArr();
		
		//inversionCount();
		
		mergeSort();
	}
	private static void selectionSort() {
		int[] arr = {2,1,4,6,3,0,5};
		int min = 0;
		int minIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			min = arr[i];
			minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if(min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = min;
			arr[minIndex] = temp;
		}
		System.out.println(Arrays.toString(arr));
		
	}
	/*
	 Find the Bth smallest element in given array A .
	 NOTE: Users should try to solve it in less than equal to B swaps. 
	 */
	private static void kthSmallestElement() {
		int[] arr = {2, 1, 4, 3, 2};
		int k = 3;
		int min = 0;
		int minIndex = 0;
		int ans = 0;
		for (int i = 0; i < k; i++) {
			min = arr[i];
			minIndex = i;
			for (int j = i+1; j < arr.length; j++) {
				if(min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			int temp = arr[i];
			arr[i] = min;
			arr[minIndex] = temp;
			ans = arr[i];
		}
		System.out.println(ans);
	}
	
	/*
	 Given two sorted integer arrays A and B, merge B and A as one sorted array and return it as an output. 
	 */
	private static void mergeTwoSortedArr() {
		int[] A = {4, 7, 9};
		int[] B = {2, 11, 19};
		int aIndex = 0;
		int bIndex = 0;
		int[] ansArr = new int[A.length+B.length];
		int index = 0;
		while(aIndex < A.length && bIndex < B.length) {
			if(A[aIndex] < B[bIndex]) {
				ansArr[index] = A[aIndex];
				aIndex++;
			}else {
				ansArr[index] = B[bIndex];
				bIndex++;
			}
			index++;
		}
		while(aIndex < A.length) {
			ansArr[index] = A[aIndex];
			aIndex++;
			index++;
		}
		while(bIndex < B.length) {	
			ansArr[index] = B[bIndex];
			bIndex++;
			index++;
		}
		System.out.println(Arrays.toString(ansArr));
	}
	
	
	private void mergeTwoSortedSubArrays() {
		int[] A = {8,1,3,6,11,2,4,9,7,6};
		int l = 2;
		int y = 5;
		int r = 7;
		
	}
	
	
	private static void inversionCount() {
		int[] arr = {28,18,44,49,41,14};
		int left = 0;
		int right = arr.length-1;
		mergeSortForInversion(arr, left, right);
		System.out.println(count);
	}
	private static int[] mergeSortForInversion(int[] arr, int left, int right) {
		if(left == right) {
			int[] bres = new int[1];   // Base case: Array of length 1, already sorted
	        bres[0] = arr[left];
	        return bres;
		}
		int mid = (left+right)/2;
		int[] A = mergeSortForInversion(arr, left, mid);
		int[] B = mergeSortForInversion(arr, mid+1, right);
		int[] ans = mergeTwoSortedArrForInversion(A,B);
		return ans;
	}
	private static int[] mergeTwoSortedArrForInversion(int[] A, int[] B) {
		int[] ansArr = new int[A.length+B.length];
		int aIndex = 0;
		int bIndex = 0;
		int index = 0;
		while(aIndex < A.length && bIndex < B.length) {
			if(A[aIndex] <= B[bIndex]){
				ansArr[index] = A[aIndex];
				aIndex++;
			}else {
				count += A.length - aIndex;
				count = count % 1000000007;
				ansArr[index] = B[bIndex];
				bIndex++;
			}
			index++;
		}
		while(aIndex < A.length) {
			ansArr[index] = A[aIndex];
			aIndex++;
			index++;
		}
		while(bIndex < B.length) {
			ansArr[index] = B[bIndex];
			bIndex++;
			index++;
		}
		return ansArr;
	}
	
	
	private static void mergeSort() {
		int[] arr = {4,3,5,7,2,1};
		mergeSortAlgo(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
	private static void mergeSortAlgo(int[] arr, int left, int right) {
		if(left == right) {
			return;
		}
		int mid = (left+(right-1))/2;
		mergeSortAlgo(arr, left, mid);
		mergeSortAlgo(arr, mid+1, right);
		mergeArr(arr, arr.length, left, mid+1, right);
	}
	private static void mergeArr(int[] arr, int length, int left, int mid, int right) {
		int[] newArr = new int[right-left+1];
		int aIndex = left;
		int bIndex = mid;
		int index = 0;
		while(aIndex < mid && bIndex <= right) {
			
		}
	}
	
	
}
