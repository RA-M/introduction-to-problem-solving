package com.scaler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Context3 {

	public static void main(String[] args) {
		String S = "aabccxxpx";
		//canBecomePalindrome(S);
		
		canWeFormPalindrome();
		
		//System.out.println(foo(5));

	}
	
	
	private static void canWeFormPalindrome() {
		String str = "aabccxxpx";
		int[] freqArr = new int[26];
		for (int i = 0; i < str.length(); i++) {
			freqArr[str.charAt(i)-'a']++;
		}
		int oddNoCount = 0;
		for (int i = 0; i < freqArr.length; i++) {
			if(freqArr[i] % 2 == 1) {
				oddNoCount++;
			}
		}
		if(oddNoCount <= 1) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}

	public static int canBecomePalindromeUtil(String A) {
		HashSet<Character> hashSet = new HashSet<>();
        char[] ch = A.toCharArray();
        for(char c : ch){
            hashSet.add(c);
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        /*for(char c : ch){
            if(hashMap.containsKey(c)){
                hashMap.put(c, hashMap.get(c)+1);    
            }else{
                hashMap.put(c, 1);
            }
        }*/
        
		for (int i = 0; i < A.length(); i++) {
			Integer k = hashMap.get(A.charAt(i));
			hashMap.put(A.charAt(i), (k == null) ? 1 : k + 1);
		}
        
        int count1 = 0;
        int count2 = 0;
        for(Map.Entry<Character, Integer> map : hashMap.entrySet()){
            if(map.getValue() %2 == 0){
                count1++;
            }else{
                count2++;
            }
        }
        if(A.length() %2 == 0){
            if(count1 == hashSet.size() && count2 == 0){
                return 1;
            }
        }else{
            if(count1 == hashSet.size()-1 && count2 == 1){
                return 1;
            }
        }
        return 0;
	}

	// Function to determine whether
	// string S can be converted to
	// a palindromic string or not
	public static void canBecomePalindrome(String S) {
		if (canBecomePalindromeUtil(S) == 1)
			System.out.print("Yes");
		else
			System.out.print("No");
	}

	
	public static int foo(int x) {
		if(x <= 2) {
			return x;
		}
		return foo(x-1)+foo(x-2)+foo(x-3);
	}
}
