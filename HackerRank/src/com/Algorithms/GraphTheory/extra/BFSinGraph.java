package com.Algorithms.GraphTheory.extra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BFSinGraph {
	static List<Integer> lstFinal = new ArrayList<>();

	static class graph {
		LinkedList<Integer> ll[];

		graph(int n) {
			ll = new LinkedList[n];
			for (int i = 0; i < ll.length; i++)
				ll[i] = new LinkedList<>();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int v = 8;
		int e = 7;
		int edges[][] = { { 0, 1 }, { 0, 4 }, { 4, 1 }, { 1, 2 }, { 3, 4 }, { 3, 2 }, { 4, 5 }, { 3, 5 }, { 3, 6 },
				{ 2, 6 }, { 5, 7 }, { 7, 6 } };
		graph g = new graph(v);
		insertEdges(g, edges);
		startBFS(g, 0, v);
		System.out.println(lstFinal);
	}

	private static void startBFS(graph g, int s, int v) {
		// TODO Auto-generated method stub
		List<Integer> lst = new ArrayList<>();
		boolean visited[] = new boolean[v];
		lst.add(s);
		visited[s] = true;
		lstFinal.add(s);
		for (int i = 0; i < lst.size(); i++) {
			s = lst.get(i);
			for (int j : g.ll[s]) {
				if (!visited[j]) {
					visited[j] = true;
					lst.add(j);
					lstFinal.add(j);
				}

			}
		}

	}

	private static void insertEdges(graph g, int[][] edges) {
		// TODO Auto-generated method stub
		for (int i = 0; i < edges.length; i++) {
			g.ll[edges[i][0]].add(edges[i][1]);
			g.ll[edges[i][1]].add(edges[i][0]);
		}
	}

}
