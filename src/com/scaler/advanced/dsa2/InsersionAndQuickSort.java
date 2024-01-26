package com.scaler.advanced.dsa2;

import java.util.Arrays;

public class InsersionAndQuickSort {

	public static void main(String[] args) {
		//insertionSort();
		
		//uniqueElements();
		
		//maxNumOfChuncks();
		
		//waveArray();
		
		quickSortArr();
	}
	
	private static void insertionSort() {
		int[] arr = {4,3,2,9,6,1};
		for (int i = 1; i < arr.length; i++) {
			for (int j = i-1; j >= 0; j--) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}else {
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 You are given an array A of N elements. You have to make all elements unique. 
	 To do so, in one step you can increase any number by one.
	 Find the minimum number of steps. 
	 */
	private static void uniqueElements() {
		int[] arr = {4,3,3,6,1,2,1,2};
		for (int i = 1; i < arr.length; i++) {
			for (int j = i-1; j >= 0; j--) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}else {
					break;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		int count = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i-1] == arr[i]) {
				count++;
				arr[i]++;
			}else if(arr[i-1] > arr[i]) {
				count += (arr[i-1] + 1) - arr[i];
				arr[i] += (arr[i-1] + 1) - arr[i];
			}
		}
		System.out.println("Count : "+count+" Unique Arr: "+Arrays.toString(arr));
	}
	
	/*
	 Given an array of integers A of size N that is a permutation of [0, 1, 2, ..., (N-1)], 
	 if we split the array into some number of "chunks" (partitions), and individually sort each chunk. 
	 After concatenating them in order of splitting, the result equals the sorted array.
	 What is the most number of chunks we could have made? 
	 */
	private static void maxNumOfChuncks() {
		int[] arr = {2, 0, 1, 3, 4};
		int count = 0;
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			if(max == i) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	private static void waveArray() {
		int[] arr = {1, 2, 3, 4};
		for (int i = 1; i < arr.length; i++) {
			for (int j = i-1; j >= 0; j--) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}else {
					break;
				}
			}
		}
		for (int i = 0; i < arr.length-1; i+=2) {
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	
	
	private static void quickSortArr() {
		int[] arr = {3,2,1,4,6};
		int start = 0;
		int end = arr.length-1;
		quickSort(arr, start, end);
		System.out.println(Arrays.toString(arr));
	}
	private static void quickSort(int[] arr, int start, int end) {
		if(start >= end) {
			return;
		}
		int pivotIndex = partition(arr, start, end);
		quickSort(arr, start, pivotIndex-1);
		quickSort(arr, pivotIndex+1, end);
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int j = start;
		for (int i = start; i <= end; i++) {
			if(arr[i] < pivot) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}
		int temp = arr[end];
		arr[end] = arr[j];
		arr[j] = temp;
		return j;
	}
	

}
