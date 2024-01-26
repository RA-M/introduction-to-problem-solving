package com.scaler.module2;

import java.util.HashSet;
import java.util.Set;

public class AIntroductionToProblemSolving {

	public static void main(String[] args) {
		//countOfFactors();
		
		lengthOfLongestSubstring();
	}
	
	private static void countOfFactors() {
		int A = 7;
		int count = 0;
		for (int i = 1; i*i < A; i++) {
			if(A%i == 0) {
				if(i == A/i) {
					count++;
				}else {
					count+=2;
				}
			}
		}
		System.out.println("Count of factors: "+count);
	}
	
	
	public static int lengthOfLongestSubstring() {
		String A= "abcda";
	    HashSet<Character> hashSet = new HashSet<>();
        int i = 0;
        int j = 0;
        int length = 0;
        boolean flag = false;
        while(j < A.length()){
            if(!hashSet.contains(A.charAt(j))){
                hashSet.add(A.charAt(j));
                length = Integer.max(length, j-i+1);
            }else{
                while(hashSet.contains(A.charAt(j))){
                    flag = true;
                    hashSet.remove(A.charAt(i));
                    i++;
                }
                hashSet.add(A.charAt(j));
            }
            j++;
        }
        return (flag) ? length : A.length();
    }
	
	
	private void longestSubstring() {
		String A = "abcda";
		Set<Character> set = new HashSet<>();
		int i = 0;
		int j = 0;
		int length = 0;
		while(j < A.length()) {
			if(!set.contains(A.charAt(j))) {
				set.add(A.charAt(j));
				length = Math.max(length, j-i+1);
			}else {
				while(set.contains(A.charAt(j))) {
					set.remove(A.charAt(i));
					i++;
				}
				set.add(A.charAt(j));
			}
			j++;
		}
	}
}
