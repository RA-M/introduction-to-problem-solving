package com.scaler.advanced.dsa2;

import java.util.Arrays;

public class Recursion {

	static int i = 0;
	public static void main(String[] args) {
		//System.out.println(sunOfFirstNnaturalNumbers(5));
		
		/*for (int i = 0; i < 9; i++) {
			System.out.print(fibbSeries(i) + " ");
		}*/
	    
		//towerOfHanoi();
		
		generateAllParanthesis();
	}
	
	private static int sunOfFirstNnaturalNumbers(int num) {
		if(num <= 1) {
			return num;
		}
		return sunOfFirstNnaturalNumbers(num-1)+num;
	}

	private static int fibbSeries(int num) {
		if(num == 0) {
			return 0;
		}
		if(num == 1 || num == 2) {
			return 1;
		}
		return fibbSeries(num-1) + fibbSeries(num-2);
	}
	
	private static void towerOfHanoi() {
		int A = 10;
		int[][] ansArr = new int[(int)Math.pow(2,A)-1][3];
		toh(A, 1,3,2, ansArr);
		print2DArr(ansArr);
	}
	private static void toh(int A, int source, int dest, int help, int[][] ansArr) {
		if(A == 0) {
			return;
		}
		toh(A-1, source, help, dest, ansArr);
		ansArr[i][0] = A;
		ansArr[i][1] = source;
		ansArr[i][2] = dest;
		i++;
		toh(A-1, help, dest, source, ansArr);
	}
	private static void print2DArr(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.println(Arrays.toString(A[i]));
		}
	}
	
	
	private static void generateAllParanthesis() {
		int A = 4;
		String[] arr = new String[(int)Math.pow(A, 2)];
		getParanthesis(A, 0, 0, "", arr);
		System.out.println(Arrays.toString(arr));
		
	}
	public static void getParanthesis(int A, int opening, int closing, String str, String[] arr) {
		if(opening+closing == (2*A)) {
			arr[i] = str;
			i++;
			return;
		}
		if(opening < A) {
			getParanthesis(A, opening+1, closing, str+"(", arr);
		}
		if(closing < opening) {
			getParanthesis(A, opening, closing+1, str+")", arr);
		}
	}
	
}
