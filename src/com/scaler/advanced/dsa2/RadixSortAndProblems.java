package com.scaler.advanced.dsa2;

import java.util.Arrays;
import java.util.Comparator;

public class RadixSortAndProblems {

	//Inversion Pair Explained
	static int ans=0;
	
	public static void main(String[] args) {
		//countSort();
		
        //sortByTensPlace();
		
		//inversionCount();
		
		//bClosestPoint();
		
		//sumTheDifference();
		
		largestNumber();
	}
	private static void countSort() {
		int[] arr = {1,2,3,5,4,4,4,4};
		int[] freqArr = new int[5+1];
		for (int i = 0; i < arr.length; i++) {
			freqArr[arr[i]]++;
		}
		for (int i = 0; i < freqArr.length; i++) {
			for (int j = 1; j <= freqArr[i]; j++) {
				System.out.println(i);
			}
		}
	}
	
	public static void sortByTensPlace() {
		int[] arr = {123, 45, 678, 90, 234, 567, 89};
		
		
		System.out.println(Arrays.toString(arr));
	}

	
	private static void inversionCount() {
		int[] arr = {1, 3, 2};
		System.out.println(inversionPairCount(arr, 0, arr.length-1));
	}
	private static int inversionPairCount(int[] arr, int left, int right) {
		if(left == right) {
			return 0;
		}
		int mid = (left+right)/2;
		ans += inversionPairCount(arr, left, mid);
		ans += inversionPairCount(arr, mid+1, right);
		ans += mergeTwoSortedSubArr(arr, left, mid+1, right);
		return ans;
	}
	private static int mergeTwoSortedSubArr(int[] arr, int left, int mid, int right) {
		int[] newArr = new int[right-left+1];
		int i = left;
		int j = mid;
		int k = 0;
		int count = 0;
		while(i < mid && j <= right) {
			if(arr[i] <= arr[j]) {
				newArr[k] = arr[i];
				k++;
				i++;
			}else {
				count += mid - i;
				newArr[k] = arr[j];
				k++;
				j++;
			}
		}
		while(i < mid) {
			newArr[k] = arr[i];
			k++;
			i++;
		}
		while(j <= right) {
			newArr[k] = arr[j];
			k++;
			j++;
		}
		k=0;
		for (int l = left; l <= right; l++) {
			arr[l] = newArr[k];
			k++;
		}
		return count;
	}
	
	/*
	 We have a list A of points (x, y) on the plane. Find the B closest points to the origin (0, 0).
	 Here, the distance between two points on a plane is the Euclidean distance.
	 You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in.)
	 NOTE: Euclidean distance between two points P1(x1, y1) and P2(x2, y2) is sqrt( (x1-x2)2 + (y1-y2)2 ). 
	 */
	private static void bClosestPoint() {
		int[][] A = {{1, 3},{-2,2}};
		int B = 1;
		
		Integer[][] arr = new Integer[A.length][2];
        for(int i =0;i<A.length;i++){
            arr[i][0] = A[i][0];
            arr[i][1] = A[i][1];
        }
        Arrays.sort(arr, new Comparator<Integer[]>(){
            public int compare(Integer[] arr1, Integer[] arr2){
                int x1 = arr1[0];
                int y1 = arr1[1];
                int x2 = arr2[0];
                int y2 = arr2[1];
                int d1 = (x1*x1)+(y1*y1);
                int d2 = (x2*x2)+(y2*y2);
                return d1-d2;
            }
        });
        int[][] ansArr = new int[B][2];
        for(int i=0; i<B; i++){
            ansArr[i][0] = arr[i][0];
            ansArr[i][1] = arr[i][1];
        }

        for (int i = 0; i < ansArr.length; i++) {
			System.out.println(Arrays.toString(ansArr[i]));
		}
	}
	
	/*
	 Given an integer array, A of size N.
	 You have to find all possible non-empty subsequences of the array of numbers and then,
 	 for each subsequence, find the difference between the largest and smallest number in that subsequence.
	 Then add up all the differences to get the number.
	 As the number may be large, output the number modulo 1e9 + 7 (1000000007).
	 NOTE: Subsequence can be non-contiguous. 
	 */
	private static void sumTheDifference() {
		int[] arr = {3, 5, 10};
		long ans = 0;
		int mod = 1000000007;
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			long a1 = fastPower(2, i, mod);
			long a2 = fastPower(2, arr.length-i-1, mod);
			ans = (ans + (arr[i] * (a1 - a2 + mod) % mod)) %mod;
		}
		System.out.println(ans);
	}
	private static long fastPower(int num, int power, int mod) {
		if(power == 0) {
			return 1;
		}
		long ans = 0;
		long temp = fastPower(num, power/2, mod);
		if(power % 2 == 0) {
			ans = (temp * temp)%mod;
		}else {
			ans = (((temp * temp)%mod) * num)%mod;
		}
		return ans;
	}
	
	/*
	 Given an array A of non-negative integers, arrange them such that they form the largest number.
	 Note: The result may be very large, so you need to return a string instead of an integer. 
	 */
	private static void largestNumber() {
		int[] arr = {2, 3, 9, 0};
		String[] strArr = new String[arr.length];
		for (int i = 0; i < strArr.length; i++) {
			strArr[i] = arr[i]+"";
		}
		/*Arrays.sort(strArr, new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				if(Long.parseLong(str1+str2) > Integer.parseInt(str2+str1)) {
					return -1;
				}else if(Integer.parseInt(str1+str2) == Integer.parseInt(str2+str1)) {
					return 0;
				}
				return 1;
			}
		});*/
		Arrays.sort(strArr, (a, b)->{
			if(Long.parseLong(a+b) > Long.parseLong(b+a)) {
				return -1;
			}else if(Long.parseLong(a+b) == Long.parseLong(b+a)) {
				return 0;
			}
			return 1;
		});
		System.out.println(Arrays.toString(arr));
	}
	
}
