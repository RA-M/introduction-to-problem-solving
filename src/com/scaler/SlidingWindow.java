package com.scaler;

import java.util.Arrays;

public class SlidingWindow {

	public static void main(String[] args) {
		//metho();
		
		//minimumSwap();
		
		//printBoundaryElement();
		
		//spriralPrinting();
		
		//arrangeInSpiralin2D();
		
		solve();
	}
	private static void print2DArr(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.println(Arrays.toString(A[i]));
		}
	}
	private static void metho() {
		int[] A = {7};
		int B = 1;
		int C = 8;
		int sum = 0;
        for(int i=0; i<B; i++) {
            sum+=A[i];
        }
        if(sum == C){
            //return 1;
        	System.out.println("if 1");
        }
        int start = 1;
        int end = B;
        while(end<A.length){
            sum=sum-A[start-1]+A[end];
            if(sum==C){
                //return 1;
            	System.out.println("While 1");
            }
            start++;
            end++;
        }
        System.out.println("0");
	}
	/*
	 Given an array of integers A and an integer B, find and return the minimum 
	 number of swaps required to bring all the numbers less than or equal to B together.
	 Note: It is possible to swap any two elements, not necessarily consecutive. 
	 A = [1, 12, 10, 3, 14, 10, 5]
 	 B = 8	
 	 O/P: 2
	 */
	public static void minimumSwap() {
		int[] A = {1,12,10,3,14,10,5};
		int B = 8;
        int goodCount = 0;
        for(int i=0;i<A.length; i++){
            if(A[i] <= B){
                goodCount++;
            }
        }
        if(goodCount == 0 || goodCount == 1){
        	System.out.println("0");
        }
        int badCOunt = 0;
        for(int i=0;i<goodCount; i++){
            if(A[i] > B){
                badCOunt++;
            }
        }
        int start = 1;
        int end = goodCount;
        int ans = badCOunt;
        while(end < A.length){
            if(A[start-1] > B){
                badCOunt--;
            }
            if(A[end] > B){
                badCOunt++;
            }
            if(badCOunt < ans){
                ans = badCOunt;
            }
            start++;
            end++;
        }
    System.out.println(ans);
    }

	private static void printBoundaryElement() {
		int[][] arr = {{1,2,3,4},
					   {1,2,3,4},
					   {1,2,3,4},
					   {1,2,3,4}};
		int i = 0;
		int j = 0;
		for (int k = 1; k < arr.length; k++) {
			System.out.println(arr[i][j]);
			j++;
		}
		for (int k = 1; k < arr.length; k++) {
			System.out.println(arr[i][j]);
			i++;
		}
		for (int k = 1; k < arr.length; k++) {
			System.out.println(arr[i][j]);
			j--;
		}
		for (int k = 1; k < arr.length; k++) {
			System.out.println(arr[i][j]);
			i--;
		}
	}
	private static void spriralPrinting() {
		int[][] arr = {{1,2,3,4},
				   	   {1,2,3,4},
				   	   {1,2,3,4},
				   	   {1,2,3,4}};
		int i = 0;
		int j = 0;
		int n = arr.length;
		while(n > 1) {
			for (int k = 1; k < n; k++) {
				System.out.print(arr[i][j]);
				j++;
			}
			for (int k = 1; k < n; k++) {
				System.out.print(arr[i][j]);
				i++;
			}
			for (int k = 1; k < n; k++) {
				System.out.print(arr[i][j]);
				j--;
			}
			for (int k = 1; k < n; k++) {
				System.out.print(arr[i][j]);
				i--;
			}
			i++;
			j++;
			n-=2;
		}
		if(n == 1) {
			System.out.print(arr[i][j]);
		}
	}
	private static void arrangeInSpiralin2D() {
		int num = 5;
		int i = 0;
		int j = 0;
		int count = 1;
		int[][] arr = new int[num][num];
		while(num > 1 ) {
			for (int k = 1; k < num; k++) {
				arr[i][j] = count;
				j++;
				count++;
			}
			for (int k = 1; k < num; k++) {
				arr[i][j] = count;
				i++;
				count++;
			}
			for (int k = 1; k < num; k++) {
				arr[i][j] = count;
				j--;
				count++;
			}
			for (int k = 1; k < num; k++) {
				arr[i][j] = count;
				i--;
				count++;
			}
			i++;
			j++;
			num-=2;
		}
		if(num == 1) {
			arr[i][j] = count;
		}
		print2DArr(arr);
	}
	
	/*public int solve() {
		int[] A = {}; 
		int B = 3;
        int n = A.length, sum = 0, ans = 0;
        for(int i = 0; i < B; i++){
            sum += A[i];
        }
        ans = sum;
        int s = 1, e = B, index = 0;
        while(e < n){
            sum = sum - A[s-1] + A[e];
            if(ans > sum){
                index = s;
                ans = sum;
            }
            s++; e++;
        }
        return index;
    }*/
	
	public static int solve() {
		int[] A = {3, 7, 90, 20, 10, 50, 40}; 
		int B = 3;
        int sum = 0;
        int ans = 0;
        for(int i=0; i<A.length; i++){
            sum += A[i];
        }

        int start = 1;
        int end = B;
        int index = 0;
        ans = sum;
        while(end < A.length){
            sum = sum - A[start-1] + A[end];
            if(ans > sum){
                index = start;
                ans = sum;
            }
            start++;
            end++;
        }
        System.out.println(index);
        return index;
    }
}
