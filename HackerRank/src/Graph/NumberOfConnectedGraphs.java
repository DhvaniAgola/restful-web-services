package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class NumberOfConnectedGraphs {
	static class graph {
		LinkedList<Integer> ll[];

		graph(int n) {
			ll = new LinkedList[n];
			for (int i = 0; i < n; i++)
				ll[i] = new LinkedList<>();
		}

	}

	private static void insertEdges(graph g, int[][] edges) {
		// TODO Auto-generated method stub
		for (int i = 0; i < edges.length; i++) {
			g.ll[edges[i][0]].add(edges[i][1]);
			g.ll[edges[i][1]].add(edges[i][0]);
		}
	}

	static List<Integer> lstF = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 9;
		graph g = new graph(n);
		int edges[][] = { { 0, 1 }, { 1, 2 }, { 1, 4 }, { 4, 3 }, { 0, 3 }, { 5, 6 } };
		insertEdges(g, edges);

		for (int i = 0; i < n; i++)
			lstF.add(i);

		preCount(g, n);
		System.out.println(count);
	}

	static List<Integer> lst = new ArrayList<>();

	private static void preCount(graph g, int n) {
		// TODO Auto-generated method stub
		while (!lstF.isEmpty()) {
			boolean visited[] = new boolean[n];

			checkConnectivity(g, n, lstF.get(0), visited);
			lstF.removeAll(lst);
			count++;
		}
	}

	private static void checkConnectivity(graph g, int n, Integer s, boolean visited[]) {
		// TODO Auto-generated method stub
		visited[s] = true;
		lst.add(s);
//		List<Integer> lstTemp = new ArrayList<>();
//		lstTemp.addAll(lst);
		boolean vTemp[] = new boolean[visited.length];
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				vTemp[i] = true;
			else
				vTemp[i] = false;
		}
		for (int i : g.ll[s]) {
			if (!visited[i]) {
				checkConnectivity(g, n, i, vTemp);
				for (int j = 0; j < visited.length; j++) {
					if (visited[j])
						vTemp[j] = true;
					else
						vTemp[j] = false;
				}
//				lstTemp.clear();
//				lstTemp.addAll(lst);
			}
		}

	}

	static int count = 0;

}
