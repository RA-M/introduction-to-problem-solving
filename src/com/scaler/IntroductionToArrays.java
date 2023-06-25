package com.scaler;

import java.util.Arrays;

public class IntroductionToArrays {

	public static void main(String[] args) {
		//countGreterNo();
		
		//checkPairs();
		
		//solve();
		
		//sumOfMaxMinNo();
		
		//secondHighest();
		
		//minTimeSeconds();
		
		findSumLtoR();
	}
	
	//Count the number of elements that have at least 1 elements greater than itself
	public static void countGreterNo() {
		int A[] = {4,5};
		int max = A[0]; // 1
        int count = 1;
        
        for(int i = 1; i<A.length; i++){
            if(A[i] > max){
                max = A[i];   //5
                count = 1;
            }else if(A[i] == max) {
            	count++;
            }
        }
        System.out.println(A.length - count);
	}
	/*
	 Given an array A and an integer B. A pair(i, j) 
	 in the array is a good pair if i != j and (A[i] + A[j] == B). 
	 Check if any good pair exist or not.
	 Return 1 if good pair exist otherwise return 0.
	 //Check possible pairs and the check only above triangle
	 */
	public static void checkPairs() {
		int[] A = {6,6,3,4,11,1};
		int B = 12;
        int count = 0;
        for(int i=0; i<A.length; i++){
            for(int j=i+1; j<A.length; j++){
                if(A[i]+A[j] == B){
                    count = 1;
                    System.out.println(count);
                    return;
                }
            }
        }
        System.out.println(count);
    }
	/*
	 Given an array A of N integers. Also given are two 
	 integers B and C. Reverse the array A in the given range [B, C]
	 A = [1, 2, 3, 4]
	 B = 2
	 C = 3
	 o/p: [1, 2, 4, 3]
	 */
	public static int[] reverseArr(int[] A, int B, int C) {
        int temp = 0;
        while(B < C){
            temp = A[B];
            A[B] = A[C];
            A[C] = temp;
            B++;
            C--;
        }
        return A;
    }
	/*
	 Given an integer array A of size N and an integer B, 
	 you have to return the same array after rotating it 
	 B times towards the right. 
	 
	 A = [1, 2, 3, 4]
	 B = 2
	 o/p: [3, 4, 1, 2]
	 */
	public static void solve() {
		int[] A = {7, 4, 2, 10, 5};
		int B = 10;
        reverseArr(A, 0, A.length-1); //[4,3,2,1]
        if(B > A.length){			 //Check if B is greater that Array length
            B = B % A.length;        //then take modulus 
        }
        reverseArr(A, 0, B-1);       // reverse first part
        reverseArr(A, B, A.length-1);// reverse 2nd part
        System.out.println(Arrays.toString(A));
    }
	
	/*
	 Given an array A of size N. You need to find the 
	 sum of Maximum and Minimum element in the given array.
	 A = [-2, 1, -4, 5, 3]
	 o/p: Maximum Element is 5 and Minimum element is -4. (5 + (-4)) = 1.
	*/
	public static void sumOfMaxMinNo() {
		int[] A = {-2, 1, -4, 5, 3};
        int max = A[0];
        int min = A[0];
        for(int i=0; i<A.length; i++){
            if(A[i] > max){
                max = A[i];
            }else if(A[i] < min){
                min = A[i];
            }    
        }
        System.out.println(max + min);
    }
	
	/*
	  Given an array A and an integer B, find the number of occurrences of B in A.
	  A = [1, 2, 2], B = 2 
	  o/p: 2
	  
	  Check efficient algo (Binary Search)
	*/
	
	
	
	
	
	
	
	
	
	/*
	 You are given an integer array A. You have to find 
	 the second largest element/value in the array or report that no such element exists. 
	 */
	public static void secondHighest() {
		int[] A = {3, 4, 4, 4};
        if(A.length <= 1){
            System.out.println(-1);
        }
        int max = -1;
        int secondLargest = -1;
        for(int i = 0; i<A.length; i++){
            if(A[i] > max){
                secondLargest = max;
                max = A[i];                
            }else if(A[i] > secondLargest && A[i] != max){
            	secondLargest = A[i];
            }
        }
        System.out.println(secondLargest);
    }
	
	/*
	 Given an integer array A of size N. In one second, you can increase the value of one element by 1.
	 Find the minimum time in seconds to make all elements of the array equal.
	 A = [2, 4, 1, 3, 2]
	 o/p: 8
	 We can change the array A = [4, 4, 4, 4, 4]. The time required will be 8 seconds.
	*/
	public static void minTimeSeconds() {
		int[] A = {4, 5, 2, 6};
		int sum =0;
        int max =0;
        for(int i =0;i<A.length;i++)
        {
            sum+=A[i];
            if(A[i]>max)
            {
                max =A[i];
            }
        }
        System.out.println(max*A.length-sum);
	}
	
	
	public static void findSumLtoR() {
		int[] A = {1, 2, 3, 4, 5};
		int[][] B = {{0,3},{1,2}};
		int[] prefSumArr = new int[A.length];
		prefSumArr[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			prefSumArr[i] = prefSumArr[i-1] + A[i];
		}
		System.out.println(Arrays.toString(prefSumArr));
		for (int i = 0; i < B.length; i++) {
			int L = B[i][0];
			int R = B[i][1];
			if(L == 0) {
				System.out.println(prefSumArr[R]);
			}else {
				System.out.println(prefSumArr[R] - prefSumArr[L-1]);
			}
		}
        
	}
}
