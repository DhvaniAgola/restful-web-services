package com.Algorithms.GraphThory.extra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class NumberOfConnectedGraphsLab6 {
	static List<Integer> finallst = new ArrayList<>();

	static class graph {
		LinkedList<Integer> ll[];

		graph(int n) {
			ll = new LinkedList[n];
			for (int i = 0; i < n; i++) {
				ll[i] = new LinkedList<>();
			}
		}

	}

	static void createEdge(graph g, int u, int v) {
		g.ll[u].add(v);
		g.ll[v].add(u);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		List<Integer> lst = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			lst.add(i);
		}
		graph g = new graph(n);
		int m = scn.nextInt();
//		for (int i = 0; i < m; i++) {
//			int u = scn.nextInt();
//			int v = scn.nextInt();
//			createEdge(g, u, v);
//		}
		createEdge(g, 1, 2);
		createEdge(g, 2, 3);
		createEdge(g, 3, 4);
		createEdge(g, 2, 4);
		createEdge(g, 1, 3);
		createEdge(g, 2, 8);
		createEdge(g, 5, 7);
		createEdge(g, 6, 7);
		createEdge(g, 5, 6);
		int ans = traverseGraph(g, n, lst);
		int connectivity = 0;
		if (ans == 1)
			connectivity = 1;
		System.out.println(connectivity + " " + ans);
	}

	private static int traverseGraph(graph g, int n, List<Integer> lst) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[n];

		int count = 0;
		while (lst.size() > 0) {
			finallst.clear();
			int start = lst.get(0);
			visitNodes(g, n, start, lst, visited);
			System.out.println(finallst);
			count++;
		}
		return count;
	}

	private static void visitNodes(graph g, int n, int start, List<Integer> lst, boolean[] visited) {
		visited[start] = true;
		finallst.add(start);
		lst.remove(new Integer(start));
		for (int i : g.ll[start]) {
//			System.out.println(start + " : " + i);
			if (visited[i] == false) {
				visitNodes(g, n, i, lst, visited);
			}
		}
	}

}
