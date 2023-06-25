package com.scaler;

import java.util.Arrays;

public class ArraysSubArray {

	public static void main(String[] args) {
		//subArraySum();
		
		//sumOfAllSubArraySums();
		
		//allSubArrays();
		
		//goodSubArrays();
		
		repeatedNumber();
	}
	/*
	 You are given an integer array C of size A. Now you need to find a subarray 
	 (contiguous elements) so that the sum of contiguous elements is maximum.
	 But the sum must not exceed B.
	 
	 B = 12
	 C = [2, 1, 3, 4, 5]
	 O/P: 12
	 * */
	private static void subArraySum() {
		int[] arr = {2, 4, 5, 3,1};
		int B = 10;
		int sum = 0;
		int maxSum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            sum = 0;
            if(arr[i] <= B) {
            	for(int j=i; j<arr.length; j++){
                    sum += arr[j];
                    if(sum>maxSum && sum<=B) {
                    	maxSum = sum;
                    }
                }
            }
        }
        System.out.println(maxSum);
	}
	/*
	 You are given an integer array A of length N.
You have to find the sum of all subarray sums of A.
More formally, a subarray is defined as a contiguous part 
of an array which we can obtain by deleting zero or more elements from either end of the array.
A subarray sum denotes the sum of all the elements of that subarray.
	 * */
	private static void sumOfAllSubArraySums() {
		int[] arr = {1, 2, 3};
		long totalSum = 0;
		for (int i = 0; i < arr.length; i++) {
			totalSum+= (long) arr[i] * (i+1) * (arr.length-i);;
		}
		System.out.println(totalSum);
	}

	private static void allSubArrays() {
		int[] A = {3562,42160,37854,48802,71740,61054,54878,20487};
		int n=A.length;
        int[][] result=new int[(n*(n+1))/2][];
        int counter=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                result[counter]=new int[j-i+1];
                int size=0;
                for(int k=i;k<=j;k++){
                    result[counter][size]=A[k];
                    size++;
                }
               counter++;
            }
        }
        for (int i = 0; i < result.length; i++) {
        	System.out.println(Arrays.toString(result[i]));
		}
		
	}
	
	/*
	 Given an array of integers A, a subarray of an array is said to be good if it fulfills any one of the criteria:
1. Length of the subarray is be even, and the sum of all the elements of the subarray must be less than B.
2. Length of the subarray is be odd, and the sum of all the elements of the subarray must be greater than B.
Your task is to find the count of good subarrays in A. 
	 */
	public static int goodSubArrays() {
		int[] A = {15,8,16};
		int B = 242;
        int sumOfSubArr = 0;
        int subArrLength = 0;
        int goodSubArrCount = 0;
        for(int i=0; i<A.length; i++){
        	subArrLength = 0;
            sumOfSubArr = 0;
            for(int j=i; j<A.length; j++){
                //subArrLength = 0;
                //sumOfSubArr = 0;
                //for(int k=i; k<=j; k++){
                    subArrLength++;
                    sumOfSubArr += A[j];
                //}
                if(subArrLength % 2 == 0 && sumOfSubArr < B){
                    goodSubArrCount++;
                }else if(subArrLength % 2 == 1 && sumOfSubArr > B){
                    goodSubArrCount++;
                }
            }
        }
        System.out.println(goodSubArrCount);
        return goodSubArrCount;
    }
	/*
	 You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
	If so, return the integer. If not, return -1.
	If there are multiple solutions, return any one.
	Note: Read-only array means that the input array should not be modified in the process of solving the problem
	 */
	public static int repeatedNumber() {
		int[] A = {1000441,1000441,1000994};
        int[] freqArr = new int[1000000009];
        for(int i=0; i<A.length; i++){
            freqArr[A[i]]++;
        }
        int max = 0;
        for(int j=0; j<freqArr.length; j++){
            if(max < freqArr[j]){
                max = freqArr[j];
            }
        }
        if(max > (A.length/3)){
            return max;
        }
        return -1;
    }
}
