package com.scaler.advanced.dsa4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Greedy {

	public static void main(String[] args) {
		//candy();
		
		//finishMaximumJobs();
		
		freeCars();
	}
	private static void candy() {
		int[] A = {1,2};
		int[] ans = new int[A.length];
		Arrays.fill(ans, 1);
		for (int i = 1; i < ans.length; i++) {
			if(A[i] > A[i-1]) {
				ans[i] = ans[i]+1;
			}
		}
		
		for (int i = A.length-2; i >= 0; i--) {
			if(A[i] > A[i+1] && ans[i] < ans[i+1]+1) {
				ans[i] = ans[i+1]+1;
			}
		}
		int sum = 0;
		for (int i = 0; i < ans.length; i++) {
			sum+=A[i];
		}
		System.out.println(sum);
	}
	
	private static void finishMaximumJobs() {
		int[] A = {1, 5, 7, 1};
		int[] B = {7, 8, 8, 8};
		List<StartEndPair> pairs = new ArrayList<>();

		for (int i = 0; i < A.length; i++) {
			StartEndPair startEndPair = new StartEndPair(A[i], B[i]);
			pairs.add(startEndPair);
		}

		Collections.sort(pairs, new SortByEndTime());
		
		int lastEndTime = pairs.get(0).endTime;
		int ans = 1;
		for (int i = 1; i < pairs.size(); i++) {
			if(pairs.get(i).startTime >= lastEndTime) {
				ans++;
				lastEndTime = pairs.get(i).endTime;
			}
		}
		System.out.println(ans);
	}

	
	private static void freeCars() {
		int[] A = {1,7,6,2,8,4,4,6,8,2};
		int[] B = {8,11,7,7,10,8,7,5,4,9};
		List<CarPairs> pairList = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			pairList.add(new CarPairs(A[i], B[i]));
		}
		Collections.sort(pairList, Comparator.comparingInt(a-> a.time));
		
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int time = 0;
		for (int i = 0; i < pairList.size(); i++) {
			if(time < pairList.get(i).time) {
				queue.add(pairList.get(i).value);
				time++;
			}else {
				int min = queue.peek();
				if(min < pairList.get(i).value) {
					queue.poll();
					queue.add(pairList.get(i).value);
				}
			}
		}
		long profit = 0;
		while(!queue.isEmpty()) {
			profit = (profit + queue.poll()) % 1000000007;
		}
		System.out.println(profit);
	}
}

class StartEndPair{
	int startTime;
	int endTime;
	public StartEndPair(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}

class SortByEndTime implements Comparator<StartEndPair>{

	@Override
	public int compare(StartEndPair arg0, StartEndPair arg1) {
		if(arg0.endTime < arg1.endTime) {
			return -1;
		}else {
			return 1;
		}
	}
}

class CarPairs{
	int time;
	int value;
	public CarPairs(int time, int value) {
		this.time = time;
		this.value = value;
	}
}
