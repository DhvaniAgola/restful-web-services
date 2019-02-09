package Graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class AllPossiblePaths {
	static class graph {
		LinkedList<Integer> ll[];

		graph(int n) {
			ll = new LinkedList[n];
			for (int i = 0; i < n; i++)
				ll[i] = new LinkedList<>();
		}
	}

	private static void addEdge(graph g, int[][] arr) {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.length; i++) {
			g.ll[arr[i][0]].add(arr[i][1]);
			g.ll[arr[i][1]].add(arr[i][0]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		graph g = new graph(n);
		int arr[][] = { { 0, 1 }, { 1, 2 }, { 3, 2 }, { 0, 3 }, { 2, 4 }, { 4, 5 }, { 3, 5 } };
		addEdge(g, arr);
		preTraverse(g, n, arr, 3, 4);
	}

	private static void preTraverse(graph g, int n, int[][] arr, int s, int e) {
		// TODO Auto-generated method stub
		boolean visited[] = new boolean[n];
		List<Integer> lst = new ArrayList<>();
		traverse(g, n, s, e, lst, visited);
		int min = Collections.min(value);
		for (int i = 0; i < lstF.size(); i++) {
			if (lstF.get(i).size() == (min))
				System.out.println(lstF.get(i));
		}
	}

	static List<List<Integer>> lstF = new ArrayList<>();
	static List<Integer> value = new ArrayList<>();

	private static void traverse(graph g, int n, int s, int e, List<Integer> lst, boolean[] visited) {
		// TODO Auto-generated method stub
		visited[s] = true;
		lst.add(s);
		List<Integer> lstTemp = new ArrayList<>();
		lstTemp.addAll(lst);
		boolean vTemp[] = new boolean[visited.length];
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				vTemp[i] = true;
			else
				vTemp[i] = false;
		}
		if (s == e) {
//			System.out.println(lst);
			lstF.add(lstTemp);
			value.add(lstTemp.size());
		}
		for (int i : g.ll[s]) {
			if (!visited[i]) {
				traverse(g, n, i, e, lstTemp, vTemp);
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
