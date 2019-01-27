/*Description : 
 * Input : Number of vertices, number of edges, pairs of vertices for edges
 * Output : Print all disjoint graphs : vertices and edges for each graph
 * 			last line prints two integers : first integer is 0 for disjoint graph otherwise 1; second integer is number of disjoint graphs
 */

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

	static void createEdge(graph g, int[][] edges) {
		for (int i = 0; i < edges.length; i++) {
			g.ll[edges[i][1]].add(edges[i][0]);
			g.ll[edges[i][0]].add(edges[i][1]);
		}
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
//		createEdge(g, 1, 2);
//		createEdge(g, 2, 3);
//		createEdge(g, 3, 4);
//		createEdge(g, 2, 4);
//		createEdge(g, 1, 3);
//		createEdge(g, 2, 8);
//		createEdge(g, 5, 7);
//		createEdge(g, 6, 7);
//		createEdge(g, 5, 6);

		int edges[][] = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 2, 4 }, { 1, 3 }, { 2, 8 }, { 5, 7 }, { 6, 7 }, { 5, 6 } };
		createEdge(g, edges);
		int ans = traverseGraph(g, n, lst, edges);
		int connectivity = 0;
		if (ans == 1)
			connectivity = 1;
		System.out.println(connectivity + " " + ans);
	}

	private static int traverseGraph(graph g, int n, List<Integer> lst, int[][] edges) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[n];

		int count = 0;
		while (lst.size() > 0) {
			finallst.clear();
			int start = lst.get(0);
			visitNodes(g, n, start, lst, visited);
			System.out.print(finallst + " : ");
			for (int i = 0; i < edges.length; i++) {
				if (finallst.contains(edges[i][0]))
					System.out.print("(" + edges[i][0] + ", " + edges[i][1] + "), ");
			}
			System.out.println();
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
