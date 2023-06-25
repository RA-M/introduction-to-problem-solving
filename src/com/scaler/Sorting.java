package com.scaler;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sorting {

	public static void main(String[] args) {
		//bubleSort();
		
		//NobelInteger();
		
		//System.out.println(noOfFactors(20));
		
		//sortOnTheBasisOfFactors();
		
		//largestNumber();
		
		//solve(49,14,66);
		
		numberAndDigit();
	}
	
	private static void bubleSort() {
		int[] arr = {2,3,1,0};
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if(arr[j-1] > arr[j]) {
					temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
		
		for (int i = 0; i < arr.length/2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		
		/*
		 Given an integer array A of size N. You can remove any element from the array in one operation.
		 The cost of this operation is the sum of all elements in the array present before this operation.

		 Find the minimum cost to remove all elements from the array. 
		 */
		
		int cost = 0;
        for(int j=0; j<arr.length; j++){
            cost += (arr[j] * (j+1));
        }
		
		System.out.println(Arrays.toString(arr));
	}

	/*
	 Given an integer array A, find if an integer p exists in the array 
	 such that the number of integers greater than p in the array equals p. 
	 */
	private static void NobelInteger() {
		int[] arr = {-4,7,5,3,5,-4,2,-1,-9,-8,-3,0,9,-7,-4,-10,-4,2,6,1,-2,-3,-1,-8,0,-8,-7,-3,5,-1,-8,-8,8,-1,-3,3,6,1,-8,-1,3,-9,9,-6,7,8,-6,5,0,3,-4,1,-10,6,3,-8,0,6,-9,-5,-5,-6,-3,6,-5,-4,-1,3,7,-6,5,-8,-5,4,-3,4,-6,-7,0,-3,-2,6,8,-2,-6,-7,1,4,9,2,-10,6,-2,9,2,-4,-4,4,9,5,0,4,8,-3,-9,7,-8,7,2,2,6,-9,-10,-4,-9,-5,-1,-6,9,-10,-1,1,7,7,1,-9,5,-1,-3,-3,6,7,3,-4,-5,-4,-7,9,-6,-2,1,2,-1,-7,9,0,-2,-2,5,-10,-1,6,-7,8,-5,-4,1,-9,5,9,-2,-6,-2,-9,0,3,-10,4,-6,-6,4,-3,6,-7,1,-3,-5,9,6,2,1,7,-2,5};
		Arrays.sort(arr);
		int temp = 0;
		for (int i = 0; i < arr.length/2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length-1-i];
			arr[arr.length-1-i] = temp;
		}
		int count = 0;
		if(arr[0] == 0) {
			count++;
		}
		
		int countGreater = 0;
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] != arr[i-1]) {
				countGreater = i;
			}
			if(countGreater == arr[i]) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	/*
	 You are given an array A of N elements. Sort the given array in increasing 
	 order of number of distinct factors of each element, i.e., element having 
	 the least number of factors should be the first to be displayed and the 
	 number having highest number of factors should be the last one. If 2 
	 elements have same number of factors, then number with less value should come first. 
	 */
	private static void sortOnTheBasisOfFactors() {

		int[] arr = {7,36,16,3,1,35,17};
		
		Integer premitiveArr[] = new Integer[arr.length];
		for (int i = 0; i < premitiveArr.length; i++) {
			premitiveArr[i] = arr[i];
		}
		Arrays.sort(premitiveArr, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				int aFactCount = noOfFactors(a);
				int bFactCount = noOfFactors(b);
				if(aFactCount == bFactCount) {
					return a-b;
				}else {
					return aFactCount-bFactCount;
				}
			}
		});
		for (int i = 0; i < premitiveArr.length; i++) {
			arr[i] = premitiveArr[i];
		}
		System.out.println(Arrays.toString(arr));
		
	}
	private static int noOfFactors(int n) {
		int countOfFactors = 0;
		for (int i = 1; i*i <= n; i++) {
			if(n % i == 0) {
				if(i == n/i) {
					countOfFactors++;
				}else {
					countOfFactors+=2;
				}
			}
		}
		return countOfFactors;
	}
	/*
	 Given an array A of non-negative integers, arrange them such that they form the largest number.
	 Note: The result may be very large, so you need to return a string instead of an integer. 
	 */
	private static void largestNumber() {
		int[] arr= {3, 30, 34, 5, 9};
		Integer[] premInt = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++) {
			premInt[i] = arr[i];
		}
		Arrays.sort(premInt, new Comparator<Integer>(){
			@Override
			public int compare(Integer arg0, Integer arg1) {
				String strA = String.valueOf(arg0) + String.valueOf(arg1);
				String strB = String.valueOf(arg1) + String.valueOf(arg0);
				System.out.println(strA.compareTo(strB));
				return strA.compareTo(strB);
			}
			
		});
		if(arr[0] == 0) {
			System.out.println("0");
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = premInt.length-1; i >= 0; i--) {
			sb.append(premInt[i]);
		}
		System.out.println(sb.toString());
	}
	/*
	 Given an integer array A of size N. Return 1 if the array can be arranged to 
	 form an arithmetic progression, otherwise return 0.
	 A sequence of numbers is called an arithmetic progression if the difference 
	 between any two consecutive elements is the same. 
	 */
	public int solve(int[] A) {
        Arrays.sort(A);
        int diff = A[1] - A[0];
        for(int i=1; i<A.length-1; i++){
            if(A[i+1] - A[i] != diff){
                return 0;
            }
        }
        return 1;
    }
	
	
	public static void solve(int A, int B, int C) {
        String str = "";
        if(A < B && A < C){
            str += String.valueOf(A);
        }else if(B < C && B < A){
            str += String.valueOf(B);
        }else if(C < B && C < A){
            str += String.valueOf(C);
        }

        if(A < B && A > C){
            str += String.valueOf(A);
        }else if(B < C && B > A){
            str += String.valueOf(B);
        }else if(C < B && C > A){
            str += String.valueOf(C);
        }

        if(A > B && A > C){
            str += String.valueOf(A);
        }else if(B > C && B > A){
            str += String.valueOf(B);
        }else if(C > B && C > A){
            str += String.valueOf(C);
        }
        System.out.println(Integer.parseInt(str));
    }
	
	
	public static int numberAndDigit() {
		int A = 10;
        int count = 0;
        int num = A;
        int rem = 0;
        while(num > 0){
            rem = num % 10;
            num = num/10;
            if(rem == 0) {
            	continue;
            }
            if(A %(rem) == 0){
                count++;
            }
        }
        System.out.println(count);
        return count;
    }
}
