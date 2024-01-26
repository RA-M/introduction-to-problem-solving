package com.scaler.module2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Practice {

	public static void main(String[] args) {
		//finishMaxJobs();
		
		//permutations();
		
		//graph();
		
		redundantBraces();
		
	}
	
	private static void finishMaxJobs() {
		int[] A = {3, 2, 6};
		int[] B = {9, 8, 9};
		List<Pair> list = new ArrayList<>();
		for (int i = 0; i < B.length; i++) {
			list.add(new Pair(A[i], B[i]));
		}
		//Collections.sort(list, new SortByEndTime());
		Collections.sort(list, Comparator.comparingInt(a->a.endTime));
		//{2, 8, 6};
		//{8, 9, 9};
		int ans = 1;
		int lastEndTime = list.get(0).endTime; // 8
		for (int i = 1; i < list.size(); i++) {
			if(list.get(i).startTime >= lastEndTime) {
				ans++;
				lastEndTime = list.get(i).endTime;
			}
		}
		System.out.println(ans);
	}
	
	private static void permutations() {
		String str = "112";
		char[] arr = str.toCharArray();
		boolean[] visited = new boolean[arr.length];
		char[] ans = new char[arr.length];
		permutation1(arr, ans, 0, visited);
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		ans = new char[arr.length];
		System.out.println("Uniquee");
		uniquePermutations(map, arr.length, 0, ans);
	}
	
	private static void permutation1(char[] arr, char[] ans, int index, boolean[] visited) {
		if(index == arr.length) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				ans[index] = arr[i];
				permutation1(arr, ans, index+1, visited);
				visited[i] = false;
			}
		}
	}
	
	private static void uniquePermutations(Map<Character, Integer> map, int n, int index, char[] ans) {
		if(index == n) {
			System.out.println(Arrays.toString(ans));
			return;
		}
		for(Character key : map.keySet()) {
			if(map.get(key) > 0) {
				ans[index] = key;
				map.put(key, map.get(key)-1);
				uniquePermutations(map, n, index+1, ans);
				map.put(key, map.get(key)+1);
			}
		}
	}
	
	private static void graph() {
		int A = 5;
		int[][] B = {{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3}};
		List<Integer>[] graph = new ArrayList[A+1];
		
		for (int i = 1; i <= A; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int[] edge : B) {
			int node1 = edge[0];
			int node2 = edge[1];
			graph[node1].add(node2);
		}

		boolean[] visited = new boolean[A+1];
		boolean[] path = new boolean[A+1];
		Arrays.fill(visited, false);
		Arrays.fill(path, false);
		
		for (int i = 1; i <= A; i++) {
			if(!visited[i] && dfs(visited, path, i, graph)) {
				System.out.println("Cycle present");
				//break;
				return;
			}
		}
		System.out.println("Cycle not present");
	}
	private static boolean dfs(boolean[] visited, boolean[] path, int node, List<Integer>[] graph) {
		visited[node] = true;
		path[node] = true;
		for (int nbr : graph[node]) {
			if(path[nbr]) {
				return true;
			}
			if(!visited[nbr] && dfs(visited, path, nbr, graph)) {
				return true;
			}
		}
		path[node] = false;
		return false;
	}
	
	private static void redundantBraces() {
		String A = "(a+(a+b))";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if(ch == '(' || ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				stack.push(ch);
			}else if(ch == ')'){
				char top = stack.peek();
				if(top == '(') {
					System.out.println("redendant");
					return;
				}else {
					while(top != '(') {
						stack.pop();
						top = stack.peek();
					}
					stack.pop();
				}
			}
		}
		System.out.println("not redendant");
	}
	

}
class Pair{
	int startTime;
	int endTime;
	public Pair(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}

class SortByEndTime implements Comparator<Pair>{
	@Override
	public int compare(Pair o1, Pair o2) {
		if(o1.endTime < o2.endTime) {
			return -1;
		}
		return 1;
	}
}
