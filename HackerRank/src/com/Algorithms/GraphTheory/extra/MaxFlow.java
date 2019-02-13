package com.Algorithms.GraphTheory.extra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MaxFlow {
	static class graph {
		LinkedList<Integer> ll[];

		graph(int n) {
			ll = new LinkedList[n];
			for (int i = 0; i < n; i++)
				ll[i] = new LinkedList<>();
		}
	}

	private static void addEdge(graph g, int[][] edges) {
		// TODO Auto-generated method stub
		for (int i = 0; i < edges.length; i++)
			g.ll[edges[i][0]].add(edges[i][1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int edges[][] = { { 0, 1, 16 }, { 0, 2, 13 }, { 1, 3, 12 }, { 2, 1, 4 }, { 2, 4, 14 }, { 3, 2, 9 }, { 4, 3, 7 },
				{ 3, 5, 20 }, { 4, 5, 4 } };
		graph g = new graph(n);
		addEdge(g, edges);
		int max = preTraverseGraph(g, n, edges);
		System.out.println("max flow : " + max);
	}

	static List<List<Integer>> Flst = new ArrayList<>();
	static int arr[][];

	private static int preTraverseGraph(graph g, int n, int[][] edges) {
		// TODO Auto-generated method stub

		List<Integer> lst = new ArrayList<>();

		while (true) {
			boolean visited[] = new boolean[n];
			Flst.clear();
			lst.clear();

			traverse(g, edges, lst, visited, 0, 5);
			edges = arr;
			System.out.println("Selected Path : " + Flst);
			System.out.println("Recidual graph : ");
			for (int i = 0; i < edges.length; i++) {
				System.out.println(edges[i][0] + ", " + edges[i][1] + ", " + edges[i][2]);
			}
			System.out.println("edges : ");
			for (int i = 0; i < g.ll.length; i++) {
				System.out.println(i + " -> " + g.ll[i]);
			}
			if (Flst.isEmpty()) {
				break;
			}
			System.out.println("----------------------------");
		}
		int max = 0;
		for (int i = 0; i < edges.length; i++) {
			if (edges[i][1] == 0)
				max += edges[i][2];
		}
		return max;
	}

	private static void traverse(graph g, int[][] edges, List<Integer> lst, boolean[] visited, int s, int t) {
		// TODO Auto-generated method stub
		visited[s] = true;
		boolean vTemp[] = new boolean[visited.length];
		List<Integer> lstTemp = new ArrayList<>();
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				vTemp[i] = true;
			else
				vTemp[i] = false;
		}
		lst.add(s);
		lstTemp.addAll(lst);
		if (s == t) {
			Flst.add(lstTemp);
			maxFlow(g, edges, lstTemp);
			return;
		}
		for (int i = 0; i < g.ll[s].size(); i++) {
			int node = g.ll[s].get(i);
			boolean f = false;
			if (!visited[node] && Flst.isEmpty()) {
				for (int j = 0; j < edges.length; j++) {
					if (edges[j][0] == s && edges[j][1] == node && edges[j][2] > 0) {
						f = true;
					}
				}
				if (f) {
					traverse(g, edges, lstTemp, vTemp, node, t);
					for (int j = 0; j < visited.length; j++) {
						if (visited[j])
							vTemp[j] = true;
						else
							vTemp[j] = false;
					}
					lstTemp.clear();
					lstTemp.addAll(lst);
				}
			}
		}
	}

	private static void maxFlow(graph g, int[][] edges, List<Integer> lstTemp) {
		// TODO Auto-generated method stub
		int min = findMinWeight(edges, lstTemp);
		generateFlowRecidual(g, edges, lstTemp, min);

	}

	private static void generateFlowRecidual(graph g, int[][] edges, List<Integer> lstTemp, int min) {
		// TODO Auto-generated method stub
		boolean flag = false;
		boolean flag2 = false;
		for (int i = 0; i < edges.length; i++) {
			flag = false;
			for (int j = 0; j < lstTemp.size() - 1; j++) {
				if (lstTemp.get(j) == edges[i][0] && lstTemp.get(j + 1) == edges[i][1]) {
					flag = true;
					flag2 = false;
					for (int k = 0; k < edges.length; k++) {
						if (edges[k][1] == edges[i][0] && edges[k][0] == edges[i][1]) {
							flag2 = true;
							edges[k][2] += min;
							break;
						}
					}
					if (!flag2) {
						int newEdges[][] = new int[edges.length + 1][3];
						System.arraycopy(edges, 0, newEdges, 0, edges.length);
						newEdges[newEdges.length - 1][0] = edges[i][1];
						newEdges[newEdges.length - 1][1] = edges[i][0];
						newEdges[newEdges.length - 1][2] = min;
						edges = newEdges;
						g.ll[edges[i][1]].add(edges[i][0]);
					}
					edges[i][2] -= min;
					break;
				}
			}

		}
		arr = new int[edges.length][3];
		arr = edges;
	}

	private static int findMinWeight(int[][] edges, List<Integer> lstTemp) {
		// TODO Auto-generated method stub
		int min = 0;
		for (int i = 0; i < edges.length; i++) {
			if (edges[i][0] == lstTemp.get(0) && edges[i][1] == lstTemp.get(1)) {
				min = edges[i][2];
				break;
			}
		}

		for (int i = 0; i < lstTemp.size() - 1; i++) {
			for (int j = 0; j < edges.length; j++) {
				if (edges[j][0] == lstTemp.get(i) && edges[j][1] == lstTemp.get(i + 1)) {
					if (edges[j][2] < min)
						min = edges[j][2];
					break;
				}

			}
		}
		return min;
	}

}
