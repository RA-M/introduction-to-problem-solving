package com.scaler.advanced.dsa2;

import java.util.ArrayList;
import java.util.Arrays;

public class Contest2 {

	public static void main(String[] args) {

		//System.out.println(Arrays.toString(solve(10,50)));
		
		//func(0, 0, 2, 2);
		//System.out.println(count);
		
		
		howManyOnesInRange();
	}
	private static void howManyOnesInRange() {
		int[] A = {0, 1, 1, 1, 0, 0};
		for (int i = 1; i < A.length; i++) {
			A[i] = A[i-1]+A[i];
		}
		int start = 3;
		int end = 5;
 		if(start == 0) {
 			System.out.println(A[end]);
 		}else{
 			System.out.println(A[end]-A[start-1]);
 		}
	}
	
	public static int[] solve(int A, int B) {
        boolean[] isPrimeArr = new boolean[B+2];
        ArrayList<Integer> arrList = new ArrayList<>(); 
        Arrays.fill(isPrimeArr, Boolean.TRUE);
        
        isPrimeArr[0] = false;
        isPrimeArr[1] = false;
        for(int i=2; i*i < isPrimeArr.length; i++){
            if(isPrimeArr[i]){
                for(int j=i*i; j<isPrimeArr.length; j+=i){
                    isPrimeArr[j] = false;
                }
            }
        }
        
        for (int j = A; j < isPrimeArr.length; j++) {
			if(isPrimeArr[j]) {
				if(j%10 == 3){
                    arrList.add(j);
                }
			}
		}
        return arrList.stream().mapToInt(i -> i).toArray();
    }

	static int count = 0;
	private static void func(int sr,int sc, int dr, int dc) {
		if(sr > dr || sc > dc) {
			return;
		}
		if(sr == dr && sc == dc) {
			count++;
			return;
		}
		func(sr, sc+1, dr, dc);
		func(sr+1, sc, dr, dc);
	}
}
