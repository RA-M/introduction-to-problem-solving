package com.scaler;

import java.util.Arrays;

public class Arrays2DMatrix {

	public static void main(String[] args) {
		/*int[][] arr = {{1,2,3,4},
					   {1,2,3,4},
					   {1,2,3,4},
					   {1,2,3,4}};
		int row = 0;
		int col = 0;
		for (int i = 0; i < arr.length; i++) {
			row = 0;
			col = i;
			while(row < arr.length && col >= 0) {
				System.out.print(arr[row][col]);
				row++;
				col--;
			}
			System.out.println();
		}
		for (int i = 1; i < arr.length; i++) {
			row = i;
			col = arr.length-1;
			while(row < arr.length && col >= 0) {
				System.out.print(arr[row][col]);
				row++;
				col--;
			}
			System.out.println();
		}
		*/
		
		//columnSum();
		//rowWiseSum();
		
		//sumOfMainDiagonalElements();
		//rightToLeftDiagonalSum();
		
		//rightToLeftAllDiagonals();
		
		//transposeOfArr();
		
		//metho();
		
		//scalarMultiplication();
		
		//matrixAddition();
		
		makeRowColZero();
		
	}
	
	private static void print2DArr(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.println(Arrays.toString(A[i]));
		}
	}
	
	/*
	 You are given a 2D integer matrix A, return a 1D integer array containing column-wise sums of original matrix.
	 * */
	private static void columnSum() {
		int[][] arr = {{1,2,3,4},
				   	   {5,6,7,8},
				   	   {9,2,3,4}};
		for (int j = 0; j < arr[0].length; j++) { // Columns 
			int sum = 0;
			for (int i = 0; i < arr.length; i++) {  // Rows
				sum+=arr[i][j];
			}
			System.out.println(sum);
		}
	}
	
	private static void rowWiseSum() {
		int[][] arr = {{1,2,3,4},
			   	   {5,6,7,8},
			   	   {9,2,3,4}};
		for (int i = 0; i < arr.length; i++) {
			int sum = 0;
			for (int j = 0; j < arr[0].length; j++) {
				sum+=arr[i][j];
			}
			System.out.println(sum);
		}
	}
	/*
	 You are given a N X N integer matrix. You have to find the sum of all the main diagonal elements of A.
	Main diagonal of a matrix A is a collection of elements A[i, j] such that i = j.
	 * */
	private static void sumOfMainDiagonalElements() {
		int[][] arr = {{1,2,3,4},
			   	   	   {5,6,7,8},
			   	   	   {9,2,3,4},
			   	   	   {9,2,3,4}};
		int i=0;
		int j=0;
		int sum = 0;
		while (i < arr.length && j < arr[0].length) {
			sum += arr[i][j];
			i++;
			j++;
		}
		System.out.println(sum);
	}

	/*
	 You are given a N X N integer matrix. You have to find the sum of all the minor diagonal elements of A.
	Minor diagonal of a M X M matrix A is a collection of elements 
	A[i, j] such that i + j = M + 1 (where i, j are 1-based). 
	
	Rigth to Left
	 */
	private static void rightToLeftDiagonalSum() {
		int[][] arr = {{1,2,3,4},
		   	   	   	   {5,6,7,8},
		   	   	   	   {9,2,3,4},
		   	   	   	   {9,2,3,4}};
		int i=0;
		int j=arr.length-1;
		int sum = 0;
		while(i >= 0 && j>=0) {
			sum += arr[i][j];
			i++;
			j--;
		}
		System.out.println(sum);
	}
	
	/*
	 Give a N * N square matrix A, return an array of its anti-diagonals. Look at the example for more details.
	  
	 */
	private static void rightToLeftAllDiagonals() {
		int[][] arr = {{1,2,3,4},
	   	   	   	   	   {5,6,7,8},
	   	   	   	   	   {9,2,3,4},
	   	   	   	   	   {9,2,3,4}};
		int row = 0;
		int col = 0;
		int[][] ansArr = new int[2*arr.length-1][arr.length];
		for (int i = 0; i< arr.length; i++) {
			row = 0;
			col = i;
			while(row < arr.length && col >= 0) {
				ansArr[i][row] = arr[row][col];
				row++;
				col--;
			}
		}
		for (int i = 1; i < ansArr.length; i++) {
			row = i;
			col = arr.length-1;
			while(row < arr.length && col >= 0) {
				ansArr[row+col][row-i] = arr[row][col];
				row++;
				col--;
			}
		}
		for (int i = 0; i < ansArr.length; i++) {
			System.out.println(Arrays.toString(ansArr[i]));
		}
	}
	/*
	 You are given a matrix A, you have to return another matrix which is the transpose of A. 
	 O/P: [1, 5, 9, 9]
		  [2, 6, 2, 2]
		  [3, 7, 3, 3]
		  [4, 8, 4, 4]
	 */
	private static void transposeOfArr() {
		int[][] A = {{1,2,3,4},
	   	   	   	     {5,6,7,8},
	   	   	   	     {9,2,3,4},
	   	   	   	     {9,2,3,4}};
		int temp = 0;
        int transpose[][] = new int[A[0].length][A.length];
        for(int i=0;i<A[0].length; i++){
            for(int j=0;j<A.length; j++){
                //temp = A[i][j];
                //A[i][j] = A[j][i];
                //A[j][i] = temp;
                transpose[i][j] = A[j][i];
            }   
        }
        for (int i = 0; i < transpose.length; i++) {
			System.out.println(Arrays.toString(transpose[i]));
		}
	}
	private static void metho() {
		int[][] A = {{1,2,3,4},
					 {5,6,7,8},
  	   	   	     	 {9,2,3,4},
  	   	   	     	 {9,2,3,4}};
		int temp = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = i+1; j < A.length; j++) {
				temp = A[i][j];
				A[i][j] = A[j][i];
				A[j][i] = temp;
			}
		}
		/*for (int i = 0; i < A.length; i++) {
			System.out.println(Arrays.toString(A[i]));
		}*/
		int left = 0;
		int rigth = 0;
		for (int i = 0; i < A.length; i++) {
			left = 0;
			rigth = A.length-1;
			while(left < rigth) {
				temp = A[i][left];
				A[i][left] = A[i][rigth];
				A[i][rigth] = temp;
				left++;
				rigth--;
			}
		}
		System.out.println();
		for (int i = 0; i < A.length; i++) {
			System.out.println(Arrays.toString(A[i]));
		}
	}
	
	/*
	 You are given a matrix A and and an integer B, you have to perform 
	 scalar multiplication of matrix A with an integer B. 
	 */
	private static void scalarMultiplication() {
		int[][] A = {{7},
				 	 {10}};
		int B = 4;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				A[i][j] = A[i][j] * B;
			}
		}
		for (int i = 0; i < A.length; i++) {
			System.out.println(Arrays.toString(A[i]));
		}
	}
	
	/*
	 You are given two matrices A & B of equal dimensions and you 
	 have to check whether two matrices are equal or not. 
	 */
	private static void checkIfMatrixAreEquals() {
		int[][] A = {{1,2,3,4},
				 	 {5,6,7,8},
	   	   	     	 {9,2,3,4},
	   	   	     	 {9,2,3,4}};
		
		int[][] B = {{1,2,3,4},
				 	 {5,6,7,8},
	   	   	     	 {9,2,3,4},
	   	   	     	 {9,2,3,4}};
		for(int i=0; i<A.length; i++){
            for(int j=0; j<A[0].length; j++){
                if(A[i][j] != B[i][j]){
                    //return 0;
                }
            }
        }
	//return 1;	
	}
	/*
	 You are given two matrices A & B of same size, 
	 you have to return another matrix which is the sum of A and B.
	 */
	private static void matrixAddition() {
		int[][] A = {{1,2,3,4},
			 	 {5,6,7,8},
  	   	     	 {9,2,3,4},
  	   	     	 {9,2,3,4}};
	
		int[][] B = {{1,2,3,4},
			 	 {5,6,7,8},
  	   	     	 {9,2,3,4},
  	   	     	 {9,2,3,4}};
		int[][] ansArr = new int[A.length][A[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				ansArr[i][j] = A[i][j] + A[i][j];
			}
		}
		print2DArr(ansArr);
	}
	/*
	 You are given a 2D integer matrix A, make all the elements in a 
	 row or column zero if the A[i][j] = 0. Specifically, make entire ith row and jth column zero. 
	 */
	private static void makeRowColZero() {
		int[][] A = {{1,2,3,4},
			 	 	 {5,6,7,0},
			 	 	 {9,2,3,4},
			 	 	 {9,2,0,4}};
		
		int[] rows = new int[A.length];
		int[] columns = new int[A[0].length];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if(A[i][j] == 0) {
					rows[i] = 1;
					columns[j] = 1;
				}
			}
		}
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if(rows[i] == 1 || columns[j] == 1) {
					A[i][j] = 0;
				}
			}
		}
		print2DArr(A);
	}
}
