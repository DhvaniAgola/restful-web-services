package com.Algorithms.GraphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Kruskal {

	static class mst {
		LinkedList<Integer> ll[];

		mst(int n) {
			ll = new LinkedList[n];
			for (int i = 0; i < n; i++)
				ll[i] = new LinkedList<>();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nodes = 5;
		int edges = 7;
		int weights[][] = { { 1, 2, 20 }, { 1, 3, 50 }, { 1, 4, 70 }, { 1, 5, 90 }, { 2, 3, 30 }, { 3, 4, 40 },
				{ 4, 5, 60 } };

		mst m = new mst(nodes);
		java.util.Arrays.sort(weights, new java.util.Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Double.compare(a[2], b[2]);
			}
		});

		int ans = runKrushkal(weights, nodes, m);
		System.out.println(ans);
	}

	static boolean flag = false;

	private static int runKrushkal(int[][] weights, int nodes, mst m) {
		// TODO Auto-generated method stub
		int sum = 0;
		List<Integer> lst = new ArrayList<>();
		for (int i = 0; i < weights.length; i++) {
			int a = weights[i][0] - 1;
			int b = weights[i][1] - 1;
			flag = false;
			boolean visited[] = new boolean[nodes];
			checkCycle(m, a, b, visited);
			if (!flag) {
				sum += weights[i][2];
				createMst(m, a, b);
			}
		}
		return sum;
	}

	private static void checkCycle(mst m, int a, int b, boolean[] visited) {
		// TODO Auto-generated method stub
		boolean visitedTemp[] = new boolean[visited.length];
		visited[a] = true;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				visitedTemp[i] = true;
			else
				visitedTemp[i] = false;
		}
		if (a == b)
			flag = true;
		for (int i : m.ll[a]) {
			if (!visited[i]) {
				checkCycle(m, i, b, visitedTemp);
				for (int j = 0; j < visited.length; j++) {
					if (visited[j])
						visitedTemp[j] = true;
					else
						visitedTemp[j] = false;
				}
			}
		}
	}

	private static void createMst(mst m, int a, int b) {
		// TODO Auto-generated method stub
		m.ll[a].add(b);
		m.ll[b].add(a);
	}

}
