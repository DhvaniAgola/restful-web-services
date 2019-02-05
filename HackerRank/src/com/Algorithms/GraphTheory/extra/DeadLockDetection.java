package com.Algorithms.GraphTheory.extra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

class graph {
	LinkedList<Integer> ll[];

	graph(int n) {
		ll = new LinkedList[n];
		for (int i = 0; i < n; i++)
			ll[i] = new LinkedList<>();
	}
}

public class DeadLockDetection {

	static void addEdge(graph g, int arr[][], HashMap<Integer, Integer> map) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i][1] != -1)
				g.ll[map.get(arr[i][1])].add(map.get(arr[i][0]));
			if (arr[i][2] != -1)
				g.ll[map.get(arr[i][0])].add(map.get(arr[i][2]));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
//		int n = scn.nextInt();

		int index = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int in[][] = { { 101, 7, 8 }, { 101, 9, -1 }, { 102, -1, 7 }, { 101, -1, 9 }, { 103, -1, 9 } };
		for (int i = 0; i < in.length; i++) {
			for (int j = 0; j < 3; j++) {
//				in[i][j] = scn.nextInt();
				if (!map.containsKey(in[i][j])) {
					map.put(in[i][j], index);
					index++;
				}
			}
		}

		graph g = new graph(map.size());
		addEdge(g, in, map);
		String ans = detectDeadlock(g, in, map);
		System.out.println(ans);
	}

	static String str = "NO";

	private static String detectDeadlock(graph g, int[][] in, HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
//		String str = "";
		int val;
		for (int i : map.keySet()) {
			str = "NO";
			val = map.get(i);
			boolean visited[] = new boolean[map.size()];
			str = detectCycle(val, val, g, in, map, visited);
			if (str.equalsIgnoreCase("YES"))
				break;
		}
		return str;
	}

	private static String detectCycle(int s, int e, graph g, int[][] in, HashMap<Integer, Integer> map,
			boolean visited[]) {
		// TODO Auto-generated method stub
		visited[s] = true;
		boolean vTemp[] = new boolean[visited.length];
		for (int i = 0; i < visited.length; i++) {
			if (visited[i])
				vTemp[i] = true;
			else
				vTemp[i] = false;
		}
		for (int i : g.ll[s]) {
			if (i == e) {
				str = "YES";
				return str;
			}
			if (!visited[i]) {

				detectCycle(i, e, g, in, map, vTemp);
				for (int j = 0; j < visited.length; j++) {
					if (visited[j])
						vTemp[j] = true;
					else
						vTemp[j] = false;
				}
			}
		}
		return str;
	}

}
