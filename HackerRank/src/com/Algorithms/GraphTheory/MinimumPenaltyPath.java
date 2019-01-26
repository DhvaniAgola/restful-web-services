package com.Algorithms.GraphTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MinimumPenaltyPath {
	static List<Integer> finalList = new ArrayList<>();

	static class graph {
		LinkedList<Integer> ll[];

		graph(int n) {
			ll = new LinkedList[n];
			for (int i = 0; i < n; i++) {
				ll[i] = new LinkedList<>();
			}
		}
	}

	static void edge(int[][] edges, graph g) {
		for (int i = 0; i < edges.length; i++) {
			boolean bstatus = false;
			for (int j = 0; j < edges.length; j++) {
				if (i != j) {
					if ((edges[i][0] == edges[j][0] && edges[i][1] == edges[j][1])
							|| (edges[i][1] == edges[j][0] && edges[i][0] == edges[j][1])) {
						if (edges[i][2] < edges[j][2]) {
							edges[j][2] = edges[i][2];
						} else {
							edges[i][2] = edges[j][2];
						}
						bstatus = true;
						break;
					}
				}
			}
			g.ll[edges[i][0] - 1].add(edges[i][1] - 1);
			g.ll[edges[i][1] - 1].add(edges[i][0] - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		graph g = new graph(n);
		int m = scn.nextInt();
//		int edges[][] = new int[m][3];
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < 3; j++) {
//				edges[i][j] = scn.nextInt();
//			}
//		}
		int edges[][] = { { 1, 2, 1 }, { 1, 2, 1000 }, { 2, 3, 3 }, { 1, 3, 100 } };
		edge(edges, g);
		int A = scn.nextInt() - 1;
		int B = scn.nextInt() - 1;
		int result = beautifulPath(edges, n, A, B, g);
		System.out.println("Ans:" + result);
	}

	private static int beautifulPath(int edges[][], int n, int a, int b, graph g) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[n];
		List<Integer> lst = new ArrayList<>();
		traverseGraph(edges, a, b, g, lst, visited);
		int ans;
		if (finalList.size() == 0)
			ans = -1;
		else
			ans = Collections.min(finalList);
		return ans;
	}

	private static void traverseGraph(int edges[][], int a, int b, graph g, List<Integer> lst, boolean[] visited) {
		// TODO Auto-generated method stub
		boolean visitedtemp[] = new boolean[visited.length];
		List<Integer> lstTemp = new ArrayList<>();

		visited[a] = true;
		lst.add(a);
		lstTemp.addAll(lst);
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				visitedtemp[i] = true;
			else
				visitedtemp[i] = false;
		}
		if (a == b) {
			calculatePenalty(edges, lst);
			return;
		}
		for (int i : g.ll[a]) {
			if (visitedtemp[i] == false) {
				traverseGraph(edges, i, b, g, lstTemp, visitedtemp);
				for (int j = 0; j < visited.length; j++) {
					if (visited[j])
						visitedtemp[j] = true;
					else
						visitedtemp[j] = false;
				}
				lstTemp.clear();
				lstTemp.addAll(lst);
			}
		}
	}

	private static void calculatePenalty(int[][] edges, List<Integer> lst) {
		// TODO Auto-generated method stub
//		int sum = 0;
		int ORop = 0;
		for (int i = 0; i < lst.size() - 1; i++) {
			for (int j = 0; j < edges.length; j++) {
				if ((edges[j][0] == lst.get(i) + 1 && edges[j][1] == lst.get(i + 1) + 1)
						|| (edges[j][1] == lst.get(i) + 1 && edges[j][0] == lst.get(i + 1) + 1)) {
					ORop = ORop | edges[j][2];
					break;
				}
			}
		}
		finalList.add(ORop);
	}

}
