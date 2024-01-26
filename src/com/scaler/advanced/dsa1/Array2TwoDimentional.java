package com.scaler.advanced.dsa1;

public class Array2TwoDimentional {

	public static void main(String[] args) {
		// sunOfAllSubMatrices();

		//subMatrixSumQueries();
		
		//maximumSubmatrixSum();
		
		searchElementIn2DSortedMatrix();
	}

	/*
	 * Given a 2D Matrix A of dimensions N*N, we need to return the sum of all
	 * possible submatrices.
	 */
	private static void sunOfAllSubMatrices() {
		int[][] arr = { { 1, 2 }, { 3, 4 } };
		int r = arr.length;
		int c = arr[0].length;

		long sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sum += (arr[i][j]) * (i + 1) * (j + 1) * (arr.length - i) * (arr[0].length - j);
			}
		}
		System.out.println(sum);
	}

	private static void subMatrixSumQueries() {
		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[] B = { 1, 2 };
		int[] C = { 1, 2 };
		int[] D = { 2, 3 };
		int[] E = { 2, 3 };

		int row = A.length;
		int col = A[0].length;
		long[][] prefSum = new long[row][col];
		// For creating Prefix Sum Array
		// 1) First Move all element to prefSum array
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				prefSum[i][j] = A[i][j];
			}
		}
		// 2) Do row wise sum
		for (int i = 0; i < row; i++) {
			for (int j = 1; j < col; j++) {
				prefSum[i][j] += prefSum[i][j - 1];
			}
		}
		// 3) Do column wise sum
		for (int j = 0; j < col; j++) {
			for (int i = 1; i < row; i++) {
				prefSum[i][j] += prefSum[i - 1][j];
			}
		}
		// (a1,b1) (a2,b2)

		int mod = 1000000007;
		for (int i = 0; i < B.length; i++) {
			int a1 = B[i] - 1;
			int b1 = C[i] - 1;

			int a2 = D[i] - 1;
			int b2 = E[i] - 1;

			long sum = 0;

			if (a1 == 0 && b1 == 0) {
				sum = (prefSum[a2][b2]) % mod;
			} else if (a1 == 0) {
				sum = (prefSum[a2][b2] - prefSum[a2][b1 - 1]) % mod;
			} else if (b1 == 0) {
				sum = (prefSum[a2][b2] - prefSum[a1 - 1][b2]) % mod;
			} else {
				sum = (prefSum[a2][b2] - prefSum[a1 - 1][b2] - prefSum[a2][b1 - 1] + prefSum[a1 - 1][b1 - 1]) % mod;
			}
			System.out.println(sum);
		}

		// System.out.println(prefSum[a2][b2]-prefSum[a2][b1-1]-prefSum[a1-1][b2]+prefSum[a1-1][b1-1]);

	}

	private static void maximumSubmatrixSum() {
		int[][] arr = {{-5,-4,-3},
						{-1,2,3},
						{2,2,4}};
		long[][] sufixSumArr = new long[arr.length][arr[0].length];
		int row = sufixSumArr.length;
		int col = sufixSumArr[0].length;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				sufixSumArr[i][j] = arr[i][j];
			}
		}
		
		for (int i=row-1; i>=0 ; i--) {
			for (int j=col-2; j>=0; j--) {
				sufixSumArr[i][j] += sufixSumArr[i][j+1];
			}
		}
		
		for (int j=col-1; j>=0; j--) {
			for (int i=row-2; i>=0 ; i--) {
				sufixSumArr[i][j] += sufixSumArr[i+1][j];
			}
		}
		long ans = arr[row-1][col-1];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				ans = Math.max(ans, sufixSumArr[i][j]);
			}
		}
		System.out.println(ans);
	}
	
	
	
	private static void searchElementIn2DSortedMatrix() {
		int[][] arr = {{2,8,8,8},
			     		{2,8,8,8},
			    	    {2,8,8,8}};
		int num = 8;
		int row = arr.length;
		int col = arr[0].length;
		int i = 0;
		int j = col-1;
		int ans = -1;
		while(i < row && j >= 0) {
			 if(arr[i][j] == num) {
				 ans = ((i+1) * 1009 +j+1);
				 j--;
			 }else if(arr[i][j] < num) {
				 if(ans != -1) {
					 System.out.println(ans);
					 break;
				 }
				 i++;
			 }else {
				 j--;
			 }
		}
		System.out.println(ans);
	}
	
}
