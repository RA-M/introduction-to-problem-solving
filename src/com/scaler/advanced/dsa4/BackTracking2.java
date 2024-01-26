package com.scaler.advanced.dsa4;

import java.util.ArrayList;
import java.util.List;

public class BackTracking2 {

	
	static List<List<String>> ansList = new ArrayList<>();
	public static void main(String[] args) {
		
		/*Time Complexity = O(N*N!)*/
		solveNQueens();
		
		/*Time Complexity = O(N!)*/
		
	}
	
	private static void solveNQueens() {
		int A = 4;
		char[][] ans = new char[A][A];
		for (int i = 0; i < ans.length; i++) {
			for (int j = 0; j < ans.length; j++) {
				ans[i][j] = '.';
			}
		}
		nQueens(ans, 0, A);
		System.out.println(ansList);
		String[][] array = ansList.stream().map(innerList -> innerList.toArray(new String[0])).toArray(String[][]::new);
	}
	private static void nQueens(char[][] ans, int row, int n) {
		if(row == n) {
			ansList.add(printQueen(ans));
			return;
		}
		for (int col = 0; col < n; col++) {
			if(isQueenSafe(ans, row, col, n)) {
				ans[row][col] = 'Q';
				nQueens(ans, row+1, n);
				ans[row][col] = '.';
			}
		}
	}

	private static boolean isQueenSafe(char[][] ans, int row, int col, int n) {
		for (int i = 0; i < row; i++) {
			if(ans[i][col] == 'Q') {
				return false;
			}
		}
		for (int i = row-1, j = col-1; i >= 0 && i >= 0; i--,j--) {
			if(i >= 0 && j >= 0 && ans[i][j] == 'Q') {
				return false;
			}
		}
		for (int i = row-1, j = col+1; i >= 0 && i < n; i--,j++) {
			if(i >=0 && j < n && ans[i][j] == 'Q') {
				return false;
			}
		}
		return true;
	}

	public static ArrayList<String> printQueen(char[][] ans){
        ArrayList<String> str = new ArrayList<>();

        for(int i = 0; i<ans.length; i++){
            String row = new String(ans[i]);
            str.add(row);
        }

        return str;
    }
	
}


/*[[., Q, null, null], 
 [null, null, ., Q], 
 [Q, ., null, null], 
 [null, null, Q, null]]*/
		 
		 
		 

