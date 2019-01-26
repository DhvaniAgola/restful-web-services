package com.Algorithms.GraphThory.extra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FindAllPosiblePaths {
	static List<Integer> Flist = new ArrayList<>();

	static class Graph {
		LinkedList<Integer> LL[];
		int nodes;

		Graph(int nodes) {
			this.nodes = nodes;
			LL = new LinkedList[this.nodes];
			for (int i = 0; i < nodes; i++) {
				LL[i] = new LinkedList<>();
			}
		}
	}

	static void createEdges(Graph g, int u, int v) {
		g.LL[u].add(v);
		g.LL[v].add(u);
	}

	static void posiblePaths(Graph g, int nodes, int node1, int node2) {
		boolean visited[] = new boolean[nodes];
		List<Integer> lst = new ArrayList<>();
		visiteAllPosivlePaths(g, visited, lst, node1, node2);
	}

	private static void visiteAllPosivlePaths(Graph g, boolean[] visited, List<Integer> lst, int node1, int node2) {
		// TODO Auto-generated method stub
		boolean v2[] = new boolean[visited.length];
		List<Integer> lstTemp = new ArrayList<>();
		visited[node1] = true;
		for (int i = 0; i < v2.length; i++) {
			if (visited[i])
				v2[i] = true;
			else
				v2[i] = false;
		}

		lst.add(node1);
		lstTemp.addAll(lst);
		if (node1 == node2) {

			calculateValue(lst);
			return;
		}

		for (int i : g.LL[node1]) {
			System.out.println(node1 + " :: " + i);
			if (v2[i] == false) {
				visiteAllPosivlePaths(g, v2, lstTemp, i, node2);
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
		int nodes = scn.nextInt();
		int edges = scn.nextInt();
		Graph g = new Graph(nodes);
		for (int i = 0; i < edges; i++) {
			int u = scn.nextInt();
			int v = scn.nextInt();
			createEdges(g, u, v);
		}
		int node1 = scn.nextInt();
		int node2 = scn.nextInt();
		posiblePaths(g, nodes, node1, node2);
		for (int j : Flist) {
			System.out.println(j);
		}
	}

}
