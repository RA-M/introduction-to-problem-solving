package com.scaler.advanced.dsa4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackTracking1 {

	static List<List<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) {
		//permutations();
		
		
		char[] charArr = {'a','a','c'};
		int[] freaArr = new int[26];
		for (int i = 0; i < charArr.length; i++) {
			freaArr[charArr[i]-'a']++;
		}
		char[] ans = new char[charArr.length];
		//uniquePermutations(freaArr, 0, ans);
		
		
		uniquePermutationsIntMain();
		
	}
	
	private static void permutations() {
		int[] A = {1,2,3};
		List<Integer> ansList = new ArrayList<>();
		boolean[] visited = new boolean[A.length];
		permuteRecursive(A, 0, ansList, visited);
		
		int[][] result = list.stream().map(list -> list.stream().mapToInt(Integer::intValue).toArray()).toArray(int[][] :: new);
		System.out.println(result);
	}

	private static void permuteRecursive(int[] A, int index, List<Integer> permutation, boolean[] visited){
        if(index == A.length){
            list.add(new ArrayList(permutation));
            return;
        }

        for(int i = 0; i < A.length; i++){
            if(!visited[i]){
                visited[i] = true;
                permutation.add(A[i]);
                permuteRecursive(A, index+1, permutation, visited);
                permutation.remove(index);
                visited[i] = false;
            }
        }
    }
	
	private static void uniquePermutations(int[] freqArr, int index, char[] ansArr) {
		if(index == ansArr.length) {
			System.out.println(Arrays.toString(ansArr));
			return;
		}
		for (int i = 0; i < freqArr.length; i++) {
			if(freqArr[i] > 0) {
				freqArr[i]--;
				ansArr[index] = (char)(i+'a');
				uniquePermutations(freqArr, index+1, ansArr);
				freqArr[index]++;
			}
		}
	}
	
	private static void uniquePermutationsIntMain() {
		int[] A = {1,1,2};
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.length; i++) {
			map.put(A[i], map.getOrDefault(A[i], 0)+1);
		}
		System.out.println(map);
		List<Integer> permutations = new ArrayList<>();
		uniquePermutatnsInteger(A.length, 0, permutations, map);
	}
	
	private static void uniquePermutatnsInteger(int n, int index, List<Integer> permutations, Map<Integer, Integer> map) {
		if(index == n) {
			System.out.println(permutations);
			list.add(new ArrayList<>(permutations));
			return;
		}
		for(int key : map.keySet()) {
			if(map.get(key) > 0) {
				permutations.add(key);
				map.put(key, map.get(key)-1);
				uniquePermutatnsInteger(n, index+1, permutations, map);
				permutations.remove(index);
				map.put(key, map.get(key)+1);
			}
		}
	}
}
