package com.scaler.advanced.dsa2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoPointers {

	public static void main(String[] args) {
		//subArrayWithGivenSum();
		int[] A = {1, 2, 3, 4, 5};
		int B = 5;
		//System.out.println(Arrays.toString(solve(A, B)));
		
		//subArraySum();
		
		//countOfSubArra();
		
		
		///pairWithGivenDiff();
		
		//countSumPairs();
		
		//containerWithMostWater();
		
		//pairsWithGivenSumDuplicateEmelents();
		
		//maxNumberOfOnes();
		
		//tripleSums();
		
		countOfRectangles();
		
	}
	/*Given an array of positive integers A and an integer B, find and return first continuous subarray which 
	 * sum is equal to B.
	  If the answer does not exist return an array with a single integer "-1".
	  First sub-array means the sub-array for which starting index in minimum.*/
	
	private static void subArrayWithGivenSum() {
		int[] A = {1, 2, 3, 4, 5};
		int B = 5;
		int[] prefArr = new int[A.length];
		prefArr[0] = A[0];
		for (int i = 1; i < A.length; i++) {
			prefArr[i] = prefArr[i-1]+A[i];
		}
		System.out.println(Arrays.toString(prefArr));
		
		int i = 0;
		int sum = 0;
		int start = 0;
		int end = 0;
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(0, -1);
		while(i<A.length) {
			if(hashMap.containsKey(prefArr[i]-B)) {
				start = hashMap.get(prefArr[i]-B)+1;
				end = i;
				break;
			}else {
				hashMap.put(prefArr[i], i);
			}
			i++;
		}
		System.out.println(start+" "+end);
		int[] ansArr = new int[end-start+1];
		int index = 0;
		for (int j = start; j <= end; j++) {
			ansArr[index] = A[j];
			index++;
		}
		System.out.println(Arrays.toString(ansArr));
	}

	public static  int[] solve(int[] A, int B) {
        int[] prefArr = new int[A.length];
        prefArr[0] = A[0];
        for(int i=1; i<A.length; i++){
            prefArr[i] = prefArr[i-1]+A[i];
        }

        int start = -1;
        int end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        hashMap.put(0, -1);
        for(int i=0; i<prefArr.length; i++){
            if(hashMap.containsKey(prefArr[i]-B)){
                start = hashMap.get(prefArr[i]-B)+1;
                end = i;
                break;
            }else{
                hashMap.put(prefArr[i], i);
            }
        }
        if(start == -1){
            int[] ansArr = new int[1];
            ansArr[0] = -1;
            return ansArr;   
        }
        int index = 0;
        int[] ansArr1 = new int[end-start+1];
        for(int i=start; i<=end; i++){
            ansArr1[index] = A[i];
            index++;
        }
        return ansArr1;
    }
	
	/*Given an array of positive integers A and an integer B, find and return first continuous subarray which 
	 * sum is equal to B.
	  If the answer does not exist return an array with a single integer "-1".
	  First sub-array means the sub-array for which starting index in minimum.*/
	private static void subArraySum() {
		int[] A = {1,2,3,4,5};
		int B = 5;
		long sum = 0;
		int start = -1;
		int end = -1;
		HashMap<Long, Integer> map = new HashMap<>();
		map.put(0L, -1);
		for (int i = 0; i < A.length; i++) {
			sum+=A[i];
			if(map.containsKey(sum-B)) {
				start = map.get(sum-B)+1;
				end = i;
				break;
			}
			map.put(sum, i);
		}
		for (int i = start; i <= end; i++) {
			System.out.println(A[i]);
		}
	}
	
	private static void countOfSubArra() {
		int[] A = {1,2,3,4,5};
		int B = 5;
		int[] prefArr = new int[A.length];
		prefArr[0] = A[0];
		for (int i = 1; i < prefArr.length; i++) {
			prefArr[i] = prefArr[i-1]+A[i];
		}
		int i = 0;
		int j = 1;
		int count = 0;
		if(prefArr[0] == B) {
			count++;
		}
		while(j < A.length) {
			if(prefArr[j] == B) {
				count++;
			}
			int diff = prefArr[j]-prefArr[i];
			if(diff == B) {
				count++;
				i++;
				j++;
			}else if(diff < B) {
				j++;
			}else {
				i++;
			}
		}
		System.out.println(count);
	}
	
	
	/*
	 Given an one-dimensional integer array A of size N and an integer B.
	 Count all distinct pairs with difference equal to B.
	 Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array 
	 and their absolute difference is B. 
	 */
	private static void pairWithGivenDiff() {
		int[] A = {1, 1, 1, 2, 2};
		int B = 0;
		Arrays.sort(A);
		int i=0;
		int j=1;
		int count = 0;
		HashSet<String> hashSet = new HashSet<>();
		while(j < A.length) {
			int diff = Math.abs(A[j]-A[i]);
			if(diff == B) {
				if(hashSet.add(A[i]+"-"+A[j])) {
					count++;
				}
				i++;
				j++;
			}else if(diff < B) {
				j++;
			}else {
				i++;
				if(i == j) {
					j++;
				}
			}
		}
		System.out.println(count);
	}
	
	private static void countSumPairs() {
		int[] A = {1,2,3,4,5};
		int B = 5;
		int i = 0;
		int j = A.length-1;
		int count = 0;
		while(i < j) {
			int sum = A[i]+A[j];
			if(sum == B) {
				count++;
				i++;
				j--;
			}else if(sum < B) {
				i++;
			}else {
				j--;
			}
		}
		System.out.println(count);
	}
	
	/*
	 Given n non-negative integers A[0], A[1], ..., A[n-1] , where each represents a point at coordinate (i, A[i]).
	 N vertical lines are drawn such that the two endpoints of line i is at (i, A[i]) and (i, 0).
	 Find two lines, which together with x-axis forms a container, such that the container contains the most water.
	 Note: You may not slant the container. 
	 */
	private static void containerWithMostWater() {
		int[] A = {1,5,4,3};
		int ans = 0;
		int i = 0;
		int j = A.length-1;
		while(i < j) {
			int base = j-i;
			int minVal = Integer.min(A[i], A[j]);
			ans = Integer.max(ans, base * minVal);
			if(A[i] < A[j]) {
				i++;
			}else {
				j--;
			}
		}
		System.out.println(ans);
	}
	
	
	private static void pairsWithGivenSumDuplicateEmelents() {
		int[] A = {1,2,3,3,4,6,7};
		int B = 3;
		int left = 0;
		int right = A.length-1;
		int count = 0;
		int ans = 0;
		while(left < right) {
			if(A[left]+A[right] == B) {
				if(A[left] == A[right]) {
					count = right-left+1;
					ans += (count*(count-1))/2;
					break;
				}else {
					int leftCount = 0;
					int leftEle = A[left];
					while(A[left] == leftEle) {
						leftCount++;
						left++;
					}
					
					int rightCount = 0;
					int rightEle = A[right];
					while(A[right] == rightEle) {
						rightCount++;
						right++;
					}
					ans+=(leftCount*rightCount);
				}
			}else if(A[left] + A[right] < B) {
				left++;
			}else {
				right--;
			}
		}
		System.out.println(ans);
	}
	
	private static void maxNumberOfOnes() {
		 int[] A = {0,1,1,1};
		 int B = 0;
		 int i = 0;
		 int j = 0;
		 int zeroCount = 0;
		 int ans = 0;
		 int startIndex = 0;
		 int endIndex = 0;
		 while(j < A.length) {
			 
			 if(A[j] == 0) {
				 zeroCount++;
			 }
			 
			 while(zeroCount > B) {
				 if(A[i] == 0) {
					 zeroCount--;
				 }
				 i++;
			 }
			 if(ans < j-i+1) {
				 ans = j-i+1;
				 startIndex = i;
				 endIndex = j;
			 }
			 j++;
		 }
		 System.out.println(startIndex+" "+endIndex);
	}
	
	private static void tripleSums() {
		int[] A = {-4,-8,-10,-9,-1,1,-2,0,-8,-2};
		//[-10, -9, -8, -8, -4, -2, -2, -1, 0, 1]
		int B = 0;
		Arrays.sort(A);
		int i = 0;
		int j = 1;
		int k = A.length-1;
		long current = Integer.MAX_VALUE;
		for (int l = 0; l < A.length; l++) {
			i = l;
			while(j < k) {
				int sum = A[i]+A[j]+A[k];
				if(Math.abs(sum-B) < Math.abs(current-B)) {
					current = sum;
				}
				if(sum == B) {
					System.out.println(sum);
					return;
				}else if(sum < B) {
					j++;
				}else {
					k--;
				}
			}
			j = l+1;
			k = A.length-1;
		}
		
		System.out.println(current);
	}
	
	
	private static void countOfRectangles() {
		int[] A = {1,2,3,4,5};
		int B = 5;
		int start = 0;
		int end = A.length - 1;
		long count1 = 0;
		long area = 0;
		while (start <= end) {
			area = 1l * A[start] * A[end];
			if (area >= B)
				end--;
			else {
				count1 = count1 + (end - start) * 2 + 1;
				start++;
			}
		}	
		System.out.println(count1);
	}
	
}
