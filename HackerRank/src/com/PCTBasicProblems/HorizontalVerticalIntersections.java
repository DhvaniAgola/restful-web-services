package com.PCTBasicProblems;

import java.util.Scanner;

public class HorizontalVerticalIntersections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int v = scn.nextInt();
		int h = scn.nextInt();
		int vert[][] = new int[v][3];
		int hor[][] = new int[h][3];
//		int vert[][] = { { 50, 0, 100 } };
//		int hor[][] = { { 50, 0, 75 }, { 50, 25, 100 } };
		for (int i = 0; i < v; i++) {
			for (int j = 0; j < 3; j++)
				vert[i][j] = scn.nextInt();
		}
		int temp;
		for (int i = 0; i < vert.length; i++) {
			if (vert[i][1] > vert[i][2]) {
				temp = vert[i][1];
				vert[i][1] = vert[i][2];
				vert[i][2] = temp;
			}
		}
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < 3; j++)
				hor[i][j] = scn.nextInt();
		}
		for (int i = 0; i < hor.length; i++) {
			if (hor[i][1] > hor[i][2]) {
				temp = hor[i][1];
				hor[i][1] = hor[i][2];
				hor[i][2] = temp;
			}
		}
		int ans = findIntersections(vert, hor);
		System.out.println(ans);
	}

	private static int findIntersections(int[][] vert, int[][] hor) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < vert.length; i++) {
			for (int j = 0; j < hor.length; j++) {
				if (vert[i][0] >= hor[j][1] && vert[i][0] <= hor[j][2]) {
					if (hor[j][0] >= vert[i][1] && hor[j][0] <= vert[i][2]) {
						count++;
					}
				}
			}
		}
		return count;
	}

}
