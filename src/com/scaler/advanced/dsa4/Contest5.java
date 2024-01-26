package com.scaler.advanced.dsa4;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Contest5 {

	public static void main(String[] args) {
		//solve();
		pizzaz();
	}
	public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int s = 0;
        int e = 0;
        int emptySpaces = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(A[i][j] == 0){
                    emptySpaces++;
                }else if(A[i][j] == 1){
                    s=i;
                    e=j;
                }
            }
        }
        A[s][e] = 0;
        int count = isPossible(A, s, e, emptySpaces, -1);
        return count;
    }

    public int isPossible(int[][] grid, int i, int j, int target, int curr){
        if(i < 0 || j < 0 || i > grid.length-1 || j > grid[0].length-1 || grid[i][j] == -1){
            return 0;
        }
        if(grid[i][j] == 2 && curr == target){
            return 1;
        }
        int ans = 0;
        if(grid[i][j] == 0){
           grid[i][j] = 1;
           int up = isPossible(grid, i-1, j, target, curr+1);
           int down = isPossible(grid, i+1, j, target, curr+1);
           int left = isPossible(grid, i, j-1, target, curr+1);
           int right = isPossible(grid, i, j+1, target, curr+1);
           grid[i][j] = 0;
           ans = up+down+left+right;
        }
        return ans;
    }

    
    public static long solve() {
    	int[] A = {25,24,9,6,23,20,4,10};
        Queue<Long> heap = new PriorityQueue<>();
        for(int i=0; i<A.length; i++){
            heap.add((long)A[i]);
        }
        long cost = 0;
        long sum = 0;
        while(heap.size() > 0){
            long min1 = heap.remove();
            long min2 = heap.remove();
            sum = min1 + min2;
            cost += sum;
            if(heap.size() != 0){
                heap.add(sum);
            }
        }
        System.out.println(cost);
        return cost;
    }
    
	public static int pizzaz() {
		int[] A = {25,24,9,6,23,20,4,10};
		int B = 16;
		PriorityQueue<Integer> boxes = new PriorityQueue<>();
		for (int box = 0; box < A.length; box++) {
			boxes.add(A[box]);
		}
		int count = 0;
		int sum =0;
		while(boxes.size() > 0){
			int min1 = boxes.poll();
			sum = sum + min1;
			if(sum <= B) {
				count++;
			}
		}
		System.out.println(count);
		return count;
	}
}
