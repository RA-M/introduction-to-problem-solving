package com.scaler.advanced.dsa4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graphs1 {

	private static List<Integer>[] graph;
	
	public static void main(String[] args) {

		int n = 4; //No of Nodes
		int e = 5; //No of Edges
		List<NodeEdgeInfo> infoList = new ArrayList<>();
		infoList.add(new NodeEdgeInfo(0, 1));
		infoList.add(new NodeEdgeInfo(0, 2));
		infoList.add(new NodeEdgeInfo(1, 2));
		infoList.add(new NodeEdgeInfo(2, 3));
		infoList.add(new NodeEdgeInfo(3, 1));
		
		Integer[] arr = {};
		
		graph = new ArrayList[n];
		
		for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
		
		for (NodeEdgeInfo info : infoList) {
			int node = info.node;
			int edge = info.edge;
			graph[node].add(edge);
		}
		
		System.out.println(graph);
		
		depthFirstTraversal(n, e);
 	}
	
	//DFS
	private static void depthFirstTraversal(int n, int e) {
		boolean[] visited = new boolean[n];
		Arrays.fill(visited, false);
		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				dfs(graph, i, visited);
			}
		}
	}
	
	private static void dfs(List<Integer>[] graph, int src, boolean[] visited) {
		System.out.println(src);
		visited[src] = true;
		for (int nbr : graph[src]) {
			if(!visited[nbr]) {
				dfs(graph, nbr, visited);
			}
		}
	}

}

class NodeEdgeInfo{
	int node;
	int edge;
	public NodeEdgeInfo(int node, int edge) {
		this.node = node;
		this.edge = edge;
	}
}