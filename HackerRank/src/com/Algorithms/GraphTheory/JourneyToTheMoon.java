package com.Algorithms.GraphTheory;

import java.util.LinkedList;
import java.util.Scanner;

public class JourneyToTheMoon {
	static int connectivityFlag = 0;

	static class Graph {
		LinkedList<Integer> arrLL[];
		int val;

		Graph(int val) {
			this.val = val;
			arrLL = new LinkedList[this.val];
			for (int i = 0; i < this.val; i++) {
				arrLL[i] = new LinkedList<>();
			}
		}
	}

	public static void addEdge(Graph g, int s, int d) {
		g.arrLL[s].add(d);
		g.arrLL[d].add(s);
	}

	public static int numberOfPairs(Graph g) {
		int count = 0;
		for (int i = 0; i < g.val; i++) {
			for (int j = i + 1; j < g.val; j++) {
				connectivityFlag = 0;

				boolean[] visited = new boolean[g.val];
				if (!g.arrLL[i].contains(j)) {
					checkConnectivity(i, j, g, visited);
				} else {
					connectivityFlag = 1;
				}

				if (connectivityFlag == 0) {
					count++;
				}

			}
		}

		return count;
	}

	public static void checkConnectivity(int i, int j, Graph g, boolean visited[]) {
		visited[i] = true;
		for (int m : g.arrLL[i]) {
			if (!visited[m]) {
				if (g.arrLL[m].contains(j)) {
					connectivityFlag = 1;
					return;
				} else

					checkConnectivity(m, j, g, visited);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int p = scn.nextInt();
		Graph gph = new Graph(n);
		for (int i = 0; i < p; i++) {
			int v1 = scn.nextInt();
			int v2 = scn.nextInt();
			addEdge(gph, v1, v2);
		}
		System.out.println(numberOfPairs(gph));
	}

}
