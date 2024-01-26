/**
 * 
 */
package com.scaler.advanced.dsa.hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * @author Karuna
 *
 */
public class GeometryAndStringProblems {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/*Integer[] numberArray = new Integer[]{3, 2, 5, 1, 4, 2};
        TreeSet<Integer> tSetNumbers = new TreeSet<Integer>( Arrays.asList(numberArray) );
        System.out.println("TreeSet contains: " + tSetNumbers);*/
        
        //countRightTriangle();
		
		//countOfTriangles();
		
		//wondowString();
		
		//wordStringTest();
		
		//containsDuplicate();
        
        //flipAndFindNearest();
        
        //solve();
		
		longestSubstring();
	}
	private static void countRightTriangle() {
		int[] A = {1, 1, 2};
		int[] B = {1, 2, 1};
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				if(j == i) {
					continue;
				}
				for (int k = 0; k < A.length; k++) {
					if(k == i || k == j) {
						continue;
					}
					if(A[i] == A[k] && B[i] == B[j]) {
						count++;
					} 
				}
			}
		}
		System.out.println(count);
	}
	
	private static void countOfTriangles() {
		int[] A = {1, 1, 2};
		int[] B = {1, 2, 1};
		HashMap<Integer, Integer> hashMapA = new HashMap<>();
		HashMap<Integer, Integer> hashMapB = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			hashMapA.put(A[i], hashMapA.containsKey(A[i]) ? hashMapA.get(A[i])+1 : 1);
		}
		for (int i = 0; i < B.length; i++) {
			hashMapB.put(B[i], hashMapB.containsKey(B[i]) ? hashMapB.get(B[i])+1 : 1);
		}
		int ans = 0;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < A.length; i++) {
			count1 = hashMapA.get(A[i])-1;
			count2 = hashMapB.get(B[i])-1;
			ans += count1*count2;
		}
		System.out.println(ans);
	}
	
	
	private static void wondowString() {
		String A = "ADOBECODEBANC";
		String B = "ABC";
		HashMap<Character, Integer> hashMapA = new HashMap<>();
		HashMap<Character, Integer> hashMapB = new HashMap<>();
		for (int i = 0; i < B.length(); i++) {
			hashMapB.put(B.charAt(i), hashMapB.containsKey(B.charAt(i)) ? hashMapB.get(B.charAt(i))+1 : 1);
		}
		int i = 0;
		int j = 0;
		int match = 0;
		boolean flag = false;
		int length = 0;
		int ansLength = Integer.MAX_VALUE;
		int start = 0;
		while(j < A.length()) {
			hashMapA.put(A.charAt(j), hashMapA.containsKey(A.charAt(j)) ? hashMapA.get(A.charAt(j))+1 : 1);
			if (hashMapB.containsKey(A.charAt(j))) {
				if (hashMapA.get(A.charAt(j)) <= hashMapB.get(A.charAt(j))) {
					match++;
				}
			}
			while(match == B.length()) {
				flag = true;
				length = j-i+1;
				if (length < ansLength) {
					ansLength = length;
					start = i;
				}
				char remove = A.charAt(i);
				if (hashMapB.containsKey(remove)) {
					if (hashMapA.get(remove) <= hashMapB.get(remove))
						match--;
				}
				hashMapA.put(remove, hashMapA.get(remove) - 1);
				i++;
			}
			j++;
		}
		int end = start + ansLength - 1;
		System.out.println((flag) ? A.substring(start, end + 1) : "");
	}

	private static void wordStringTest() {
		String A = "ADOBECODEBANC";
		String B = "ABC";
		HashMap<Character, Integer> hashMapB = new HashMap<>();
		HashMap<Character, Integer> hashMapA = new HashMap<>();
		for (int i = 0; i < B.length(); i++) {
			hashMapB.put(B.charAt(i), hashMapB.containsKey(B.charAt(i)) ? hashMapB.get(B.charAt(i))+1 : 1);
		}
		int i = 0;
		int j = 0;
		int match = 0;
		int length = 0;
		int ansLength = Integer.MAX_VALUE;
		int start = 0;
		boolean flag = false;
		while(j < A.length()) {
			hashMapA.put(A.charAt(j), hashMapA.containsKey(A.charAt(j)) ? hashMapA.get(A.charAt(j))+1 : 1);
			if(hashMapB.containsKey(A.charAt(j))) {
				if(hashMapA.get(A.charAt(j))  <= hashMapB.get(A.charAt(j))) {
					match++;
				}
			}
			while(match == B.length()) {
				flag = true;
				length = j-i+1;
				if(length < ansLength) {
					ansLength = length;
					start = i;
				}
				char remove = A.charAt(i);
				if(hashMapB.containsKey(remove)) {
					if(hashMapA.get(remove) <= hashMapB.get(remove)) {
						match--;
					}
				}
				hashMapA.put(remove, hashMapA.get(remove)-1);
				i++;
			}
			j++;
		}
		System.out.println((flag) ? A.substring(i-1, j) : "");
	}
	
	private static void flipAndFindNearest() {
		String A = "10010";
		int[][] B = {{1, 2},
					 {2, 3}};
		TreeSet<Integer> treeSet = new TreeSet<Integer>();
		for (int i = 0; i < A.length(); i++) {
			if(A.charAt(i) == '1') {
				treeSet.add(i);
			}
		}
		int type = 0;
		int index = 0;
		int floor = 0;
		int ceil = 0;
		int minDistance = 0;
		for (int i = 0; i < B.length; i++) {
			type = B[i][0];
			index = B[i][1];
			if(type == 1) {
				if(A.charAt(index) == '0') {
					treeSet.add(index);
				}else {
					treeSet.remove(index);
				}
			}else {
				floor = treeSet.lower(index) != null ? treeSet.lower(index) : 0;
				ceil = treeSet.higher(index) != null ? treeSet.higher(index) : Integer.MAX_VALUE;
				minDistance = Integer.min(index-floor, ceil-index);
				if(minDistance == index-floor) {
					System.out.println(floor);
				}else {
					System.out.println(ceil);
				}
			}
		}
	}
	public static int[] solve() {
		String A = "10010"; 
		int[][] B = {{1,3},
					 {1,3},
					 {2,4},
					 {2,2},
					 {1,1},
					 {2,3},
					 {1,5},
					 {1,5}};
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) == '1'){
                treeSet.add(i+1);
            }
        }
        
        int type = 0;
        int index = 0;
        int floor = 0;
        int ceil = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<B.length; i++){
            type = B[i][0];
            index = B[i][1];
            if(type == 1){
                if(treeSet.contains(index)) {
                	treeSet.remove(index);
                }else {
                	treeSet.add(index);
                }
            }else{
                floor = treeSet.floor(index) != null ? treeSet.floor(index) : Integer.MIN_VALUE;
				ceil = treeSet.ceiling(index) != null ? treeSet.ceiling(index) : Integer.MAX_VALUE;
                
                if(floor == Integer.MIN_VALUE && ceil == Integer.MAX_VALUE){
                	list.add(-1);
                }
                else if (floor != Integer.MIN_VALUE && (index - floor <= ceil - index)){
                	list.add(floor);
                }
                else{
                	list.add(ceil);
                }
            }
        }
        System.out.println(list);
        return list.stream().mapToInt(Integer :: intValue).toArray();
    }
	
	private static void longestSubstring() {
		String A = "abcabcbb";
		int i = 0;
		int j = 0;
		int length = 0;
		HashSet<Character> hashSet = new HashSet<>();
		boolean flag = false;
		while(j < A.length()) {
			if(!hashSet.contains(A.charAt(j))) {
				hashSet.add(A.charAt(j));
				length = Integer.max(length, j-i+1);
			}else {
				//length = Integer.max(length, j-i);
				while(hashSet.contains(A.charAt(j))) {
					flag = true;
					hashSet.remove(A.charAt(i));
					i++;
				}
				hashSet.add(A.charAt(j));
			}
			j++;
		}
		System.out.println((flag) ? length : A.length());
	}
	
	private static void countOfRectangles() {
		int[] A = {};
		int[] B = {};
		HashSet<String> hashSet = new HashSet<>();
		for (int i = 0; i < A.length; i++) {
			hashSet.add(String.valueOf(A[i])+String.valueOf(B[i]));
		}
		int count = 0;
		for (int i = 0; i < B.length; i++) {
			for (int j = i+1; j < B.length; j++) {
				if(A[i] != A[j] && (B[i] != B[j])) {
					String xAxis = String.valueOf(A[i]) + String.valueOf(B[j]);
					String yAxis = String.valueOf(A[j]) + String.valueOf(B[i]);
					if(hashSet.contains(xAxis) && hashSet.contains(yAxis)) {
						count++;
					}
				}
			}
		}
		System.out.println(count/2);
	}
	
}
