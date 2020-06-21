package PCTPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	static class graph {
		LinkedList<Integer> ll[];

		graph(int n) {
			ll = new LinkedList[n];
			for (int i = 0; i < ll.length; i++)
				ll[i] = new LinkedList<>();
		}
	}

	private static void insertEdges(graph g, int[][] edges) {
		// TODO Auto-generated method stub
		for (int i = 0; i < edges.length; i++) {
			g.ll[edges[i][0]].add(edges[i][1]);
//			g.ll[edges[i][1]].add(edges[i][0]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		graph g = new graph(n);
		int edges[][] = { { 1, 0 }, { 0, 2 }, { 2, 3 }, { 0, 3 }, { 4, 6 }, { 6, 5 } };
		insertEdges(g, edges);
		getAllGraphComponents(g, edges, n);
		System.out.println("no of connected component : " + Flst.size());
		for (int i = 0; i < Flst.size(); i++)
			System.out.println(Flst.get(i));
	}

	static List<List<Integer>> Flst = new ArrayList<>();

	private static void getAllGraphComponents(graph g, int[][] edges, int n) {
		// TODO Auto-generated method stub
		List<Integer> lstNodes = new ArrayList<>();

		boolean visited[] = new boolean[n];
		for (int i = 0; i < n; i++)
			lstNodes.add(i);
		while (lstNodes.size() != 0) {

			List<Integer> lst = new ArrayList<>();
			Arrays.fill(visited, false);
			traverseGraph(g, lstNodes.get(0), visited, lst);
			boolean check = checkTheGraph(lst, lstNodes.get(0));
			if (check) {
				Flst.add(lst);
				lstNodes.removeAll(lst);
			} else
				lstNodes.remove(new Integer(lstNodes.get(0)));
		}
	}

	private static boolean checkTheGraph(List<Integer> lst, int node) {
		// TODO Auto-generated method stub
		for (int i = 0; i < Flst.size(); i++) {
			for (int j = 0; j < lst.size(); j++) {
				if (Flst.get(i).contains(lst.get(j))) {
					Flst.get(i).add(node);
					return false;
				}
			}
		}
		return true;
	}

	private static void traverseGraph(graph g, Integer s, boolean[] visited, List<Integer> lst) {
		// TODO Auto-generated method stub
		visited[s] = true;
		lst.add(s);
		for (int i : g.ll[s]) {
			if (!visited[i]) {
				traverseGraph(g, i, visited, lst);
			}
		}
	}

}
