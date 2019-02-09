package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	static int count = 1;

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		String str = "";
//		for (int i = 0; i < arr.length; i++)
		List<Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		lst.add(4);
		makeCombinations(arr, str, 0, lst);
	}

	private static void makeCombinations(int[] arr, String str, int index, List<Integer> lst) {
		// TODO Auto-generated method stub

		String strTemp = str;
		List<Integer> lsttemp = new ArrayList<>();
		lsttemp.addAll(lst);
		for (int i = 0; i < lsttemp.size() && str.length() < 4; i++) {
			strTemp += lst.get(i);
			int temp = lst.get(i);
			lsttemp.remove(new Integer(temp));
			makeCombinations(arr, strTemp, i, lsttemp);
			strTemp = str;
			lsttemp.clear();
			lsttemp.addAll(lst);
		}

		if (strTemp.length() == 4)
			System.out.println(count++ + " : " + strTemp);
		str = "";
	}

}
