package com.scaler.advanced.dsa2;

public class BinarySearchOnArray3 {

	public static void main(String[] args) {

		//findNoOfPaintersRequired();
		
		//timeRequiredToPaint();
		
		//searchPair();
	}
	
	private static void findNoOfPaintersRequired() {
		int[] A = {5,1,3,1};
		int T = 2;
		int timeLimit = 20;
		int timeLeft = timeLimit;
		
		int painterCount = 1;
		for (int i = 0; i < A.length; i++) {
			if((A[i]*T) > timeLimit) {
				System.out.println("Time is exceeded no one can paint in timeLimit");
				return;
			}
			if((A[i]*T) <= timeLeft) {
				timeLeft = timeLeft - (A[i]*T);
			}else {
				painterCount++;
				timeLeft = timeLimit - (A[i]*T);
			}
		}
		System.out.println(painterCount);
	}

	private static void timeRequiredToPaint() {
		int[] A = {1, 10};
		int time = 5;
		int painters = 2;
		int sumOfAll = 0;
		for (int i = 0; i < A.length; i++) {
			sumOfAll+=A[i];
		}
		sumOfAll = sumOfAll*time;
		int ans = sumOfAll;
		int left = 1;
		int right = sumOfAll;
		while(left <= right) {
			int mid = left + (right-left)/2;
			int paintersRequired = paintersRequired(A, time, mid);
			if(paintersRequired == painters) {
				ans = mid;
				right = mid-1;
			}else if(paintersRequired < painters) {
				right = mid-1;
			}else {
				left = mid+1;
			}
		}
		System.out.println(ans%10000003);
	}
	
	private static int paintersRequired(int A[], int time, int timeLimit) {
		int paintersCount = 1;
		int timeLeft = timeLimit;
		for (int i = 0; i < A.length; i++) {
			if((A[i]*time) > timeLimit) {
				return -1;
			}
			if((A[i]*time) <= timeLeft) {
				timeLeft -= (A[i]*time);
			}else {
				paintersCount++;
				timeLeft = timeLimit-(A[i]*time);
			}
		}
		return paintersCount;
	}
	
}
