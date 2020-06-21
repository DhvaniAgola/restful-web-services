package com.Algorithms.GraphTheory.extra;

import java.util.LinkedList;

public class PrimsAlgorithm {
	static class graph {
		LinkedList<Integer> ll[];

		graph(int n) {
			ll = new LinkedList[n];
			for (int i = 0; i < n; i++)
				ll[i] = new LinkedList<>();
		}
	}

	private static void addEdge(int[][] arr, graph g) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			g.ll[arr[i][0]].add(arr[i][1]);
			g.ll[arr[i][1]].add(arr[i][0]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		int arr[][] = { { 0, 1, 4 }, { 2, 0, 8 }, { 1, 3, 2 }, { 2, 4, 7 }, { 2, 5, 1 }, { 4, 5, 6 }, { 4, 3, 2 },
				{ 3, 7, 4 }, { 5, 7, 2 }, { 3, 6, 7 }, { 6, 8, 8 }, { 7, 8, 10 }, { 7, 6, 14 } };
		graph g = new graph(n);
		addEdge(arr, g);
		startPrims(g, n, arr, 0);
	}

	private static void startPrims(graph g, int n, int[][] arr, int start) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[n];
		boolean flag = false;
		for (int i = 0; i < arr.length; i++) {
			flag = false;
			for (int j = 0; i < visited.length; i++) {
				if (!visited[j]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				break;
			}
			for (int j = 0; j < arr.length; j++) {
//				if()
			}
		}
	}

}
