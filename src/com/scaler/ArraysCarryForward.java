package com.scaler;

import java.util.Arrays;

public class ArraysCarryForward {

	public static void main(String[] args) {
		//findLeaders();
		
		//findMinSubArrayLength();
		
		//findSubsequentAG();
		
		//countSubArrays();
		
		//findAmazingSubString();
		
		//findBulbSwitches();
		
		//solve();
		
		maxProfit();
	}
	/*
	 Given an integer array A containing N distinct integers, you have to find 
	 all the leaders in array A. An element is a leader if it is strictly greater 
	 than all the elements to its right side.
	 NOTE: The rightmost element is always a leader.
	 
	 A = [16, 17, 4, 3, 5, 2]
	 O/P: [17, 2, 5]
	 */
	public static void findLeaders() {
		int[] array = {93, 57, 83, 41, 100, 10, 79, 27, 94, 22, 4, 96, 48, 18, 89, 37, 21, 5, 46, 81, 15, 30, 47, 23, 34, 65, 55, 9, 36, 20, 54, 17, 7, 56, 78, 84, 87, 97, 16, 69, 28, 11, 44, 49, 8, 25, 98, 75, 53, 62, 19, 24, 80, 68, 50, 91, 1, 86, 77, 14, 72, 66, 42, 63, 73, 45, 31, 61, 85, 64, 35, 32, 92, 71, 74, 3, 99, 52, 90, 43, 6, 40, 38, 2, 12, 59, 29, 82, 76, 60, 67, 13, 70, 58, 39, 33, 95, 88, 51, 26 };
		int[] leaders = new int[array.length];
		int leader = array[array.length-1];
		leaders[0] = leader;
		int index = 1;
		for (int i = array.length-2; i >= 0; i--) {
			if(array[i] > leader) {
				leader = array[i];
				leaders[index] = leader;
				index++;
			}
		}
		int[] ans = new int[index];
		for (int i = 0; i < index; i++) {
			ans[i] = leaders[i];
		}
		System.out.println(Arrays.toString(ans));
	}
	
	/*
	 Given an array A, find the size of the smallest subarray such that it 
	 contains at least one occurrence of the maximum value of the array
	 and at least one occurrence of the minimum value of the array.
	 */
	public static void findMinSubArrayLength() {
		int[] arr = {814, 761, 697, 483, 981};
		int max = arr[0];
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
			}else if(arr[i] < min) {
				min = arr[i];
			}
		}
		int maxIndex = -1;
		int minIndex = -1;
		int ans = arr.length;
		for (int i = arr.length-1; i >= 0; i--) {
			if(arr[i] == min) {
				minIndex = i;
				if(maxIndex != -1) {
					if(ans < maxIndex - minIndex+1){
	                       ans = ans; 
	                    }else{
	                        ans = maxIndex - minIndex+1;
	                    }
				}
			}else if(arr[i] == max) {
				if(arr[i] == max) {
					maxIndex = i;
					if(minIndex != -1) {
						if(ans < minIndex - maxIndex+1){
		                       ans = ans; 
		                    }else{
		                        ans = minIndex - maxIndex+1;
		                    }
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	/*
	 You have given a string A having Uppercase English letters.
	 You have to find how many times subsequence "AG" is there in the given string.
	 NOTE: Return the answer modulo 109 + 7 as the answer can be very large.
	 A = "ABCGAG"
	 O/P: 3
	 */
	public static void findSubsequentAG() {
		String str = "GAB";
		char[] ch = str.toCharArray();
		int count = 0;
		long agCount = 0;
		for (int i = ch.length-1; i >= 0; i--) {
			if(str.charAt(i) == 'G') {
				count++;
			}else if(ch[i] == 'A') {
				agCount+=count;
			}
		}
		System.out.println(agCount);
	}
	
	/*Given a string A = "amazon", find the number of subarrays starting with the character 'a'.*/

	public static void countSubArrays() {
		String A = "amazon";
        int count = 0;
        int countOfSubArrays = 0;
        
        for(int i=0;i<A.length();i++) {
            if(A.charAt(i) == 'a') {
                count++;
                countOfSubArrays = countOfSubArrays+ count;
            } else {
                countOfSubArrays = countOfSubArrays+ count;
            }
        }
        System.out.println(countOfSubArrays);
    } 
	
	/*
	 You are given a string S, and you have to find all the amazing substrings of S.
	 An amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).
	 Input
    ABEC

Output
    6

Explanation
    Amazing substrings of given string are :
    1. A
    2. AB
    3. ABE
    4. ABEC
    5. E
    6. EC
    here number of substrings are 6 and 6 % 10003 = 6. 
	 */
	public static void findAmazingSubString() {
		String str = "pGpEusuCSWEaPOJmamlFAnIBgAJGtcJaMPFTLfUfkQKXeymydQsdWCTyEFjFgbSmknAmKYFHopWceEyCSumTyAFwhrLqQXbWnXSn";
		int count = 0;
		int ansCount = 0;
		for (int i = 0; i < str.length(); i++) {
			if("AEIOU".contains(String.valueOf(str.charAt(i)))) {
				count++;
				ansCount = ansCount+count;
			}else {
				ansCount = ansCount+count;
			}
		}
		System.out.println(ansCount);
	}
	
	/*
	 NEED TO CHECK
	 Carry Forward Homework 8
	 
	 A wire connects N light bulbs.
Each bulb has a switch associated with it; however, 
due to faulty wiring, a switch also changes the state 
of all the bulbs to the right of the current bulb.
Given an initial state of all bulbs, find the minimum number 
of switches you have to press to turn on all the bulbs.
You can press the same switch multiple times.
Note: 0 represents the bulb is off and 1 represents the bulb is on.
	 */
	public static void findBulbSwitches() {
		int[] arr = {1, 1, 0, 1};
		int carryForward = 1;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != carryForward) {
				carryForward = arr[i];
				count++;
			}
		}
		System.out.println(count);
	}
	
	
	/*
	  
	 NEED TO CHECK
	 Carry Forward Homework 8
	  
	 You are given an integer array A of size N.
You have to perform B operations. In one operation, you can remove 
either the leftmost or the rightmost element of the array A.
Find and return the maximum possible sum of the elements that were 
removed after B operations.
NOTE: Suppose B = 4, and array A contains 10 elements, then
You can remove the first four elements or can remove the last four 
elements, or can remove 1 from front and 3 from the back, etc. You 
need to return the maximum possible sum of elements you can remove.
	 * */
	public static void solve() {
		int[] A = {2, 3, -1, 4, 2, 1};
		int B = 4;
        int maxsum=0;
        for(int i=0;i<B;i++){
            maxsum+=A[i];
        }
        int sum=maxsum;
        int temp=B;
        for(int i=A.length-1;i>=A.length-B;i--){
            sum=sum+A[i]-A[temp-1];
            if(maxsum<sum) {
            	maxsum=sum;
            }
            temp--;
        }
        System.out.println(maxsum);
    }
	
	/*
	 Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction 
(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
Return the maximum possible profit.
	 * */
	public static void maxProfit() {
		int[] A = {1, 4, 5, 2, 4};
        if(A.length == 0){
            //return 0;
        }
        int minPrice = A[0];
        int maxProfit = 0;
        int sp = A[0];
        for(int i=1; i<A.length; i++){
            minPrice = Math.min(minPrice, A[i]);
            sp = A[i] - minPrice;
            maxProfit = Math.max(maxProfit, sp);
        }
        System.out.println(maxProfit);
        
        /*if(A.length == 0 || A.length == 1){
            return 0;
        }
        
        int max = A[A.length - 1];
        
        int profit = 0;
        for(int i = A.length - 2; i >= 0; i--){
            if(A[i] > max){
                max = A[i];
            }
            // max stores the maximum value to the right of A[i]
            profit = Math.max(profit, max - A[i]);
        }*/
    }
	
}
