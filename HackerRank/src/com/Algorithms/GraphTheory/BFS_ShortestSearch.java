// Program is correct, but failed for some testcases due to timeout
package com.Algorithms.GraphTheory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BFS_ShortestSearch {
	static List<Integer> Flist = new ArrayList<>();
	static List<Integer> FFlist = new ArrayList<>();

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
		for (int i = 0; i < inputEdge.length; i++) {
			g.arrLL[inputEdge[i][0] - 1].add(inputEdge[i][1] - 1);
			g.arrLL[inputEdge[i][1] - 1].add(inputEdge[i][0] - 1);
		}
	}

	public static Integer[] bfs(int n, int m, int s, graph g) {
		Integer returnArr[] = new Integer[n - 1];
		FFlist.clear();
		for (int i = 0; i < n; i++) {
			if (i != (s - 1)) {
				boolean visited[] = new boolean[n];
				visited[s - 1] = false;
				List<Integer> lst = new ArrayList<>();
				Flist.clear();
				findAllPossibleWays(g, visited, lst, s - 1, i);
				if (Flist.size() == 0) {
					FFlist.add(-1);
				} else
					findMinimum(Flist);
			}
		}
		returnArr = FFlist.toArray(new Integer[0]);
		return returnArr;
	}

	private static void findMinimum(List<Integer> flist2) {
		// TODO Auto-generated method stub
		int min = Collections.min(flist2);
		FFlist.add(min * 6);
	}

	private static void findAllPossibleWays(graph g, boolean[] visited, List<Integer> lst, int s, int to) {
		boolean v2[] = new boolean[visited.length];
		List<Integer> lstTemp = new ArrayList<>();
		visited[s] = true;
		for (int i = 0; i < v2.length; i++) {
			if (visited[i])
				v2[i] = true;
			else
				v2[i] = false;
		}

		lst.add(s);
		lstTemp.addAll(lst);
		if (s == to) {
			calculateValue(lst);
			return;
		}

		for (int i : g.arrLL[s]) {
			if (v2[i] == false) {
				findAllPossibleWays(g, v2, lstTemp, i, to);
				for (int j = 0; j < v2.length; j++) {
					if (visited[j])
						v2[j] = true;
					else
						v2[j] = false;
				}
				lstTemp.clear();
				lstTemp.addAll(lst);
			}
		}
	}

	private static void calculateValue(List<Integer> lst) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 0; i < lst.size() - 1; i++) {
			sum++;
		}
		Flist.add(sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int noOfInput = scn.nextInt();
		for (int i = 0; i < noOfInput; i++) {
			int n = scn.nextInt();
			graph g = new graph(n);
			int m = scn.nextInt();
			int inputedge[][] = { { 1, 2 }, { 1, 3 }, { 1, 4 }, { 3, 4 }, { 2, 5 }, { 3, 5 }, { 4, 5 }, { 5, 6 },
					{ 4, 6 }, { 7, 6 }, { 8, 9 }, { 9, 10 }, { 10, 8 } };
			insertEdge(inputedge, g);

			int s = scn.nextInt();
			Integer[] ans = bfs(n, m, s, g);
			for (int j = 0; j < ans.length; j++)
				System.out.print(ans[j] + " ");
			System.out.println();
		}
	}

}
