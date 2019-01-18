package com.Algorithms.GraphTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BFS_ShortestSearch {

	static class graph {
		int val;
		LinkedList<Integer> arrLL[];

		graph(int n) {
			this.val = n;
			arrLL = new LinkedList[this.val];
			for (int i = 0; i < this.val; i++) {
				arrLL[i] = new LinkedList<>();
			}
		}
	}

	public static void insertEdge(int inputEdge[][], graph g) {
//		g.arrLL[inputEdge[0][0] - 1].add(inputEdge[0][1] - 1);
//		g.arrLL[inputEdge[0][1] - 1].add(inputEdge[0][0] - 1);
		for (int i = 0; i < inputEdge.length; i++) {
			g.arrLL[inputEdge[i][0] - 1].add(inputEdge[i][1] - 1);
			g.arrLL[inputEdge[i][1] - 1].add(inputEdge[i][0] - 1);
		}
	}

	public static Integer[] bfs(int n, int m, int s, graph g) {
		int count = 0;
		List<Integer> lst = new ArrayList<>();
		Integer returnArr[] = new Integer[n - 1];
		for (int i = 0; i < n; i++) {
			if (i != (s - 1)) {
				count = 0;
				List<Integer> allways = new ArrayList<>();
				boolean visited[] = new boolean[n];
				visited[s - 1] = true;

				findAllPossibleWays(n, i, s - 1, g, count, visited, allways);
				if (allways.size() == 0) {
					lst.add(-1);
				} else
					lst.add(Collections.min(allways) * 6);
			}
		}
		returnArr = lst.toArray(new Integer[0]);
		return returnArr;
	}

	private static void findAllPossibleWays(int n, int to, int s, graph g, int count, boolean visited[],
			List<Integer> allways) {
		visited[s] = true;
		int tempCount = count;
		for (int i = 0; i < g.arrLL[s].size(); i++) {
			if (g.arrLL[s].get(i) == (to)) {
				tempCount = count;
				tempCount++;
				allways.add(tempCount);
			} else if (visited[g.arrLL[s].get(i)] != true) {
				tempCount = count;
				tempCount++;
				findAllPossibleWays(n, to, g.arrLL[s].get(i), g, tempCount, visited, allways);
			}
		}
		return;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int noOfInput = scn.nextInt();
//		BFS_ShortestSearch bfs=new BFS_ShortestSearch();
		for (int i = 0; i < noOfInput; i++) {
			int n = scn.nextInt();
			graph g = new graph(n);
			int m = scn.nextInt();
//			int inputedge[][] = new int[1][2];
			int inputedge[][] = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 }, { 2, 5 }, { 3, 5 }, { 4, 5 }, { 5, 6 },
					{ 4, 6 }, { 7, 6 } };
//			for (int j = 0; j < m; j++) {
//				inputedge[0][0] = scn.nextInt();
//				inputedge[0][1] = scn.nextInt();
			insertEdge(inputedge, g);

//			}
			int s = scn.nextInt();
			Integer[] ans = bfs(n, m, s, g);
			for (int j = 0; j < ans.length; j++)
				System.out.print(ans[j] + " ");
			System.out.println();
		}
	}

}
