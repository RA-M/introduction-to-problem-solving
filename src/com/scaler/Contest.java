package com.scaler;

import java.util.Arrays;

public class Contest {

	public static void main(String[] args) {

		solve2();
		
		
		/*int[] A = {13,11,15,7,15,2};
		int[][] B = {{0,2}};
		for (int i = 0; i < A.length; i++) {
			if (countOfFactors(A[i]) >= 3) {
				A[i] = 1;
			} else {
				A[i] = 0;
			}
		}
		for (int i = 1; i < A.length; i++) {
			A[i] = A[i - 1] + A[i];
		}
		int[] ansArr = new int[B.length];
		for (int i = 0; i < B.length; i++) {
			int start = B[i][0];
			int end = B[i][1];
			if (start == 0) {
				ansArr[i] = A[end];
			} else {
				ansArr[i] = A[end] - A[start - 1];
			}
		}
		System.out.println(Arrays.toString(ansArr));*/
	}

	public static int countOfFactors(int num) {
		int countOfFactors = 0;
		for (int i = 1; i * i <= num; i++) {
			if (num % i == 0) {
				if (i * i == num) {
					countOfFactors++;
				} else {
					countOfFactors += 2;
				}
			}
		}
		return countOfFactors;
	}

	
//============================================================================================================
//Contest-1 Re-attempt
	
	public static void solve() {
		int[] A = {10,47,39,43};
        long sum = 0;
        for(int i=1; i<A.length; i++){
            if(A[i] > A[i-1]){
                sum += A[i];
            }
        }
        System.out.println((int) (sum % 1000000007));
    }
	
	public static int solve1() {
		int[] A = {8,7,11,9,14};
        //8,7,11,9,14
        int count = 0;
        int numOfElement = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] % 7 == 0){
                for(int j=0; j<A.length; j++){
                    if(A[j] > A[i]){
                        count ++;
                    }
                    if(count == 2){
                        numOfElement++;
                        count=0;
                        break;
                    }
                }
            }
        }
        System.out.println(numOfElement);
        return numOfElement;
    }
	public static void solve2() {
		int A = 1;
		int power = (int)Math.pow(2, A);
        for(int i=1; i<=power; i++){
        	//System.out.print((i & (i >> 1))+" ");
            if((i & (i >> 1)) <= 0){
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }
}
