package DynamicProgramming;

public class gameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r = 3;
		int c = 3;
		char arr[][] = { { '#', '@', '#' }, { '#', '@', '@' }, { '@', '#', '@' } };
		getLife(arr, 4, r, c);
	}

	private static void getLife(char[][] arr, int repeat, int r, int c) {
		// TODO Auto-generated method stub
		char arr2[][] = new char[r][c];
		int neigh = 0;
		int ans = 0;
		while (repeat-- > 0) {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					neigh = checkNeightbour(arr, r, c, i, j);
					if (arr[i][j] == '@') {
						if (neigh <= 1 || neigh >= 4)
							arr2[i][j] = '#';
						else if (neigh == 2 || neigh == 3)
							arr2[i][j] = '@';
					} else {
						if (neigh == 3)
							arr2[i][j] = '@';
						else
							arr2[i][j] = '#';
					}
				}
			}
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (arr2[i][j] == '@')
						arr[i][j] = '@';
					else
						arr[i][j] = '#';
				}
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				System.out.print(arr2[i][j]);
				if (arr2[i][j] == '@')
					ans++;

			}
			System.out.println();
		}
		System.out.println(ans);
	}

	private static int checkNeightbour(char[][] arr, int r, int c, int i, int j) {
		// TODO Auto-generated method stub
		int count = 0;
		if (i > 0) {
			if (j > 0) {
				if (arr[i - 1][j - 1] == '@')
					count++;
			}
			if (arr[i - 1][j] == '@')
				count++;
			if (j < c - 1) {
				if (arr[i - 1][j + 1] == '@')
					count++;
			}
		}
		if (j > 0) {
			if (arr[i][j - 1] == '@')
				count++;
		}
		if (j < c - 1) {
			if (arr[i][j + 1] == '@')
				count++;
		}
		if (i < r - 1) {
			if (j > 0) {
				if (arr[i + 1][j - 1] == '@')
					count++;
			}
			if (arr[i + 1][j] == '@')
				count++;
			if (j < c - 1) {
				if (arr[i + 1][j + 1] == '@')
					count++;
			}
		}

		return count;
	}

}
