package com.scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contest2 {

	public static void main(String[] args) {
		//solve();
		
		solve2();
	}

	public static int solve() {
		int[] A = {6,18,17,17,6,16,13,11,15,7};
		int B = 5;
		int start = 0;
		int end = B - 1;
		int max = 0;
		int average = 0;
		/*while (end < A.length) {
			for (int i = start; i <= end; i++) {
				average += A[start];
			}
			average = average/B;
			if (max < average) {
				max = average;
			}
			start++;
			end++;
		}*/
		int[] prefArr = new int[A.length];
		prefArr[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			prefArr[i] = prefArr[i-1]+A[i];
		}
		int sum = 0;
		while (end < prefArr.length) {
			if(start == 0) {
				sum = prefArr[end];
			}else{
				sum = prefArr[end]-prefArr[start-1];
			}
			average = sum/B;
			if (max < average) {
				max = average;
			}
			start++;
			end++;
		}
		System.out.println(max);
		return max;
	}

	public static int[] solve1() {
		int[] A = {1,2,3,14};
		int[][] B = {{1,2},
					 {0,4}};
        int start = 0;
        int end = 0;
        int[] ans = new int[5]; 
        int index = 0;
        int count = 0;
        for (int i = 0; i < B.length; i++) {
			start = B[i][0];
			end = B[i][1];
			count = 0;
            for (int j = start; j < end; j++) {
				if(A[j] % 7 == 0) {
					count ++;
				}
			}
            ans[index] = count;
			index++;
        }
        System.out.println(Arrays.toString(ans));
		return ans;
    }
	
	public static int[] solve2() {
		int[] A = {6,3,3,6,7,8,7,3,7};
		int[][] B = {{2,6},
					 {4,7},{6,7}};
        int start = 0;
        int end = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<B.length; i++){
            start = B[i][0];
            end = B[i][1];
            count = 0;
            for(int j=start; j<=end; j++){
                if(A[j] % 7 == 0){
                    count++;
                }
            }
            list.add(count);
            start++;
            end++;
        }
        System.out.println(Arrays.toString(list.stream().mapToInt(Integer::intValue).toArray()));
		return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
