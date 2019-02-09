package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class graph {
	LinkedList<Integer> ll[];

	graph(int n) {
		ll = new LinkedList[n];
		for (int i = 0; i < n; i++)
			ll[i] = new LinkedList<>();
	}
}

public class checkCycle {
	private static void addEdges(graph g, int[][] edges) {
		// TODO Auto-generated method stub
		for (int i = 0; i < edges.length; i++) {
			g.ll[edges[i][0]].add(edges[i][1]);
//			g.ll[edges[i][1]].add(edges[i][0]);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		graph g = new graph(n);
		int edges[][] = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 0 }, { 1, 5 }, { 5, 2 } };
		addEdges(g, edges);
		preChecking(g, n);
		if (flag)
			System.out.println("Yes");
		else
			System.out.println("No");
		System.out.println(count);
		int t = 0;
		while (Flst.size() > 0) {
			t = Flst.get(0);
			count -= (t - 1);
			for (int j = 0; j < t; j++)
				Flst.remove(new Integer(t));
		}

		System.out.println(count);
	}

	static boolean flag = false;
	static int count = 0;

	private static void preChecking(graph g, int n) {
		// TODO Auto-generated method stub
		List<Integer> lst = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			flag = false;
			lst.clear();
			boolean visited[] = new boolean[n];
			checkCycleMethod(g, n, i, i, visited, lst);
			if (flag == true) {

//				break;
			}
		}
	}

	static List<Integer> Flst = new ArrayList<>();

	private static void checkCycleMethod(graph g, int n, int s, int e, boolean[] visited, List<Integer> lst) {
		// TODO Auto-generated method stub

		boolean vTemp[] = new boolean[visited.length];
		visited[s] = true;
		lst.add(s);
		List<Integer> lstTemp = new ArrayList<>();
		lstTemp.addAll(lst);
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				vTemp[i] = true;
			else
				vTemp[i] = false;
		}
		for (int i : g.ll[s]) {
			if (visited[i] && i == e && lstTemp.size() > 2) {// if (visited[i] && i == e && lstTemp.size() > 2) {
				flag = true;
				Flst.add(lst.size());
				System.out.println(lst);
				count++;

			}
			if (!visited[i]) {
				checkCycleMethod(g, n, i, e, vTemp, lstTemp);
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
