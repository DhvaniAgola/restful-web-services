package com.Algorithms.GraphTheory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RoadsAndLibraries {
	static class graph {
		LinkedList<Integer> ll[];

		graph(int n) {
			ll = new LinkedList[n];
			for (int i = 0; i < n; i++)
				ll[i] = new LinkedList<>();
		}
	}

	static List<List<Integer>> Flist = new ArrayList<>();

	private static void addEdges(graph g, int[][] roads) {
		// TODO Auto-generated method stub
		for (int i = 0; i < roads.length; i++) {
			g.ll[roads[i][0] - 1].add(roads[i][1] - 1);
			g.ll[roads[i][1] - 1].add(roads[i][0] - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		int m = 6;
		int cLib = 2;
		int cRoad = 5;
		int roads[][] = { { 1, 3 }, { 3, 4 }, { 2, 4 }, { 1, 2 }, { 2, 3 }, { 5, 6 } };

		long cost = findAllSubgraphs(n, cLib, cRoad, roads);
		System.out.println(Flist);
		System.out.println("minimum cost : " + cost);
	}

	static List<Integer> lstTemp = new ArrayList<>();

	private static long findAllSubgraphs(int n, int c_lib, int c_road, int cities[][]) {
		// TODO Auto-generated method stub
		graph g = new graph(n);
		addEdges(g, cities);
		List<Integer> lst = new ArrayList<>();
		for (int i = 0; i < n; i++)
			lst.add(i);
		long cost = 0;
		Flist.clear();
		while (lst.size() > 0) {
			lstTemp.clear();
			findJoinNodes(g, lst.get(0));
			List<Integer> lsttemptemp = new ArrayList<>();
			lsttemptemp.addAll(lstTemp);
			Flist.add(lsttemptemp);
			lst.removeAll(lstTemp);
		}
		if (c_road <= c_lib) {
			for (int i = 0; i < Flist.size(); i++)
				cost += ((Flist.get(i).size() - 1) * c_road + c_lib);
		} else {
			for (int i = 0; i < Flist.size(); i++)
				cost += (Flist.get(i).size() * c_lib);
		}

		return cost;
	}

	private static void findJoinNodes(graph g, Integer s) {
		if (!lstTemp.contains(s))
			lstTemp.add(s);
		for (int i : g.ll[s]) {
			if (!lstTemp.contains(i)) {
				findJoinNodes(g, i);
			}
		}
	}

}
