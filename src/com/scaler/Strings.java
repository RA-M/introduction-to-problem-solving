package com.scaler;

import java.util.Arrays;

public class Strings {

	static int maxLenght = 0;
	static int start = 0;
	static int end = 0;
	static int ans = 0;
	public static void main(String[] args) {
		//integerCountSort();
		
		longestPalindrome();
		
		//isalpha();
		
		//occurrencesOfBob();
		
		//binaryStringAddition();
		
		//longestCommonPrefix();
		
		//toLowerCase();
		
		//toUpperCase();
		
		//toggleString();
		
		//sortArrCountSortAlgo();
		
		changeCharacter();
	}
	
	public static int[] integerCountSort() {
		int[] A = {888,417,136,979,360,711,569,649,693,763,586,259,715,892,366,309,170,72,992,483,245,5,421,66,466,368,109,774,716,89,630,154,68,749,857,699,68,539,467,69,531,888,46,364,700,827,181,44,470,145,859,819,245,618,957,737,232,394,435,447,729,209,291,117,824,939,646,242,936,145,369,799,593,583,142,660,156,84,776,866,482,229,722,848,838,809,241,559,342,830,173,910,158,251,829,422,268,148,616,998,949,770,284,760,135,608,722,506,685,359,992,95,927,882,470,60,71,99,354,851,124,100,348,187,467,775,378,237,193,903,685,785,378,261,362,463,389,420,59,95,510,628,99,89,315,611,118,494,632,663,366,389,555,965,183,294,328,262,12,99,182,908,167,98,15,370,693,661,956,649,784,281,911,740,379,962,504,61,154,654,841,245,383,278,194,888,102,552,493,758,442,127,866,204,989,57,637,353,860,896,531,433,209,314,753,86,240,625,365,66,506,732,435,205,653,764,241,813,121,872,627,313,396,385,992,534,344,503,587,298,976,298,715,540,222,593,675,290,40,879,426,560,718,137,573,360,414,537,944,413,801,238,33,831,779,66,781,890,454,258,753,502,871,602,810,952,776,847,197,600,349,946,616,554,823,612,655};
        int[] freqArr = new int[10^5];
        int freqIndex = 0;
        for(int i=0; i<A.length; i++){
            freqIndex =  A[i];
            freqArr[freqIndex]++;
        }
        int[] ansArr = new int[A.length];
        int k = 0;
        for(int i=0; i<freqArr.length; i++){
            for(int j=0; j<freqArr[i]; j++){
                ansArr[k] = i;
                k++;
            }
        }
        System.out.println(Arrays.toString(ansArr));
        return ansArr;
    }
	
	public String solve(String A) {
        StringBuilder sb = new StringBuilder();
        for(int i=A.length()-1; i>=0; i--){
            sb.append(A.charAt(i));
        }
        return sb.toString();
    }
	
	private static void longestPalindrome() {
		String str = "abb";
		for (int i = 0; i < str.length(); i++) {
			expand(str, i, i);
		}
		for (int j = 0; j < str.length()-1; j++) {
			expand(str, j, j+1);
		}
		System.out.println(str.substring(start, end));
	}
	private static void expand(String str, int i, int j) {
		while(i>=0 && j<str.length() && str.charAt(i) == str.charAt(j)) {
			i--;
			j++;
		}
		ans = (j-i-1);
		if(maxLenght < ans) {
			maxLenght = ans;
			start = i+1;
			end = j;
		}
	}
	
	public static int isalpha() {
		char[] A = {'S','c','a','l','e','r','A','c','a','d','e','m','y','2','0','2','0'};
	       for(int i=0; i<A.length; i++){
	           if(A[i] >= 'a' && A[i] <= 'z' && A[i] >= 97 && A[i] <= 122 && A[i] >= 48 && A[i] <= 59){
	               System.out.println(0);
	        	   return 0;
	           }
	       }
	       System.out.println(1);
	       return 1;
	    }
	
	/*
	 Find the number of occurrences of bob in string A consisting of lowercase English alphabets. 
	 */
	public static int occurrencesOfBob() {
		String A = "bobabtbobl";
		int i=0;
        int j=3;
        int count = 0;
        while(j <= A.length()){
            if(A.substring(i,j).equals("bob")){
                count++;
            }
            i++;
            j++;
        }
        System.out.println(count);
        return count;
    }
	
	/*
	 You are given two lowercase strings A and B each of length N. 
	 Return 1 if they are anagrams to each other and 0 if not. 
	 */
	public int anagrams(String A, String B) {
        if(A.length() != B.length()){
            return 0;
        }
        int[] freqArrA = new int[26];
        for(int i=0; i<A.length(); i++){
            int index = A.charAt(i) - 'a';
            freqArrA[index]++;
        }
        int[] freqArrB = new int[26];
        for(int i=0; i<B.length(); i++){
            int index = B.charAt(i) - 'a';
            freqArrB[index]++;
        }
        for(int j=0; j<freqArrA.length; j++){
            if(freqArrA[j] != freqArrB[j]){
                return 0;
            }
        }
        return 1;
    }
	
	
	private static void binaryStringAddition() {
		String A = "1";
		String B = "1";
		int aLength = A.length()-1;
		int bLength = B.length()-1;
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		while(aLength >= 0 || bLength >= 0 || carry > 0) {
			int sum = 0;
			if(aLength >= 0) {
				sum += A.charAt(aLength) - '0';
				aLength--;
			}
			if(bLength >= 0) {
				sum += B.charAt(bLength) - '0';
				bLength--;
			}
			sum += carry;
			int rem = sum % 2;
			carry = sum /2;
			sb.append(rem);
		}
		System.out.println(sb.reverse().toString());
	}
	
	/*
	 Given the array of strings A, you need to find the longest string S, which is the prefix 
	 of ALL the strings in the array.
	 The longest common prefix for a pair of strings S1 and S2 is the longest string S 
	 which is the prefix of both S1 and S2.
	 Example: the longest common prefix of "abcdefgh" and "abcefgh" is "abc". 
	 
	 A = ["abab", "ab", "abcd"];
	 "ab"
	 */
	private static void longestCommonPrefix() {
		String[] A = {"abab", "ab", "abcd"};
		String result = A[0];
		for (int i = 1; i < A.length; i++) {
			result = findCommon(result, A[i]);
		}
		System.out.println(result);
	}
	private static String findCommon(String str1, String str2) {
		int minStr = Math.min(str1.length(), str2.length());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < minStr; i++) {
			if(str1.charAt(i) == str2.charAt(i)) {
				sb.append(str1.charAt(i));
			}else {
				break;
			}
		}
		return sb.toString();
	}
	
	
	
	
	
	
	
	//Practice
	public static void toLowerCase() {
		char[] ch = {'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'};
		for (int i = 0; i < ch.length; i++) {
			if(ch[i] >= 'A' && ch[i] <= 'Z') {
				ch[i] = (char) (ch[i] + 32);
			}
		}
		System.out.println(Arrays.toString(ch));
	}
	
	private static void toUpperCase() {
		char[] ch = {'S', 'c', 'a', 'L', 'e', 'r', '#', '2', '0', '2', '0'};
		for (int i = 0; i < ch.length; i++) {
			if(ch[i] >= 'a' && ch[i] <= 'z') {
				ch[i] = (char) (ch[i]-32);
			}
		}
		System.out.println(Arrays.toString(ch));
	}
	
	private static void toggleString() {
		String str = "Hello";
		char[] ch = str.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if(ch[i] >= 'a' && ch[i] <= 'z') {
				ch[i] = (char) (ch[i] - 32);
			}else if(ch[i] >= 'A' && ch[i] <= 'Z') {
				ch[i] = (char) (ch[i] + 32);
			}
		}
		System.out.println(Arrays.toString(ch));
	}
	
	
	/*
	 Given an array A. Sort this array using Count Sort Algorithm and return the sorted array. 
	 */
	private static void sortArrCountSortAlgo() {
		int[] arr = {1,1,6,6,2,3};
		int[] freqArr = new int[1000000];
		for (int i = 0; i < arr.length; i++) {
			freqArr[arr[i]]++;
		}
		//System.out.println(Arrays.toString(freqArr));
		int index = 0;
		for (int i = 0; i < freqArr.length; i++) {
			for (int j = 0; j < freqArr[i]; j++) {
				arr[index] = i;
				index++;
			}
		}
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 A = "abcabbccd"
	 B = 3 
	 O/P: 2
	 We can change both 'a' and one 'd' into 'b'.So the new string becomes "bbcbbbccb".
 	 So the minimum number of distinct character will be 2.
	 */
	private static void changeCharacter() {
		String str = "abcabbccd";
		int B = 3;
		int[] freqArr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			freqArr[str.charAt(i)-'a']++;
		}
		int total = 0;
		for (int i = 0; i < 26; i++) {
			if(freqArr[i] > 0) {
				total++;
			}
		}
		Arrays.sort(freqArr);
		int changes = 0;
		for (int i = 0; i < 26; i++) {
			if(B == 0) {
				break;
			}
			if(freqArr[i] != 0 && B-freqArr[i] >= 0) {
				B = B-freqArr[i];
				changes++;
			}
		}
	System.out.println(total-changes);	
	}

	
	
}
