package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class hashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int arr[] = { 38, 52, 145, 16, 179, 4, -1 };
		int ans[] = new int[n];
		for (int i = 0; i < ans.length; i++)
			ans[i] = -1;
		for (int i = 0; i < arr.length; i++) {
			lst.clear();
			if (arr[i] == -1)
				break;
			else
				findLocation(arr[i], ans, n, i);
			System.out.println(lst);
		}
	}

	static List<Integer> lst = new ArrayList<>();
	static List<Integer> lstF = new ArrayList<>();
	static List<Integer> lsttemp = new ArrayList<>();

	private static void findLocation(int arr, int[] ans, int n, int i) {
		// TODO Auto-generated method stub
		int index = arr % n;
		int lastdigit;
		lst.add(index);
		lstF.add(index);
		if (ans[index] == -1) {
			ans[index] = arr;
			lsttemp.add(arr);
		} else {
			while (arr > 9) {
				lastdigit = arr % 10;
				arr = removeLastDigit(arr);
				index = arr % n;
				if (lastdigit % 2 == 0) {
					index = lst.get(lst.size() - 1) - index;
					if (index < 0)
						index += n;
					lst.add(index);
					lstF.add(index);
					if (ans[index] == -1) {
						ans[index] = arr;
						lsttemp.add(arr);
						break;
					}
				} else {
					index = lst.get(lst.size() - 1) + index;
					index = index % n;
					lst.add(index);
					lstF.add(index);
					if (ans[index] == -1) {
						ans[index] = arr;
						lsttemp.add(arr);
						break;
					}
				}

			}
			if (lsttemp.size() <= i) {
				int last = lstF.get(lstF.size() - 2);
				while (true) {
					if (last < index) {
						lst.add(index);
						lstF.add(index);
						if (ans[index] == -1) {
							ans[index] = arr;
							break;
						}
						index--;
					} else {
						lst.add(index);
						lstF.add(index);
						if (ans[index] == -1) {
							ans[index] = arr;
							break;
						}
						index++;
					}
				}
			}

		}

	}

	private static int removeLastDigit(int arr) {
		// TODO Auto-generated method stub
		return arr / 10;
	}

}
