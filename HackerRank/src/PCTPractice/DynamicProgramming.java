package PCTPractice;

import java.util.ArrayList;
import java.util.List;

public class DynamicProgramming {
	static int count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1, 2, 3 };
		int length = 3;
		String str = "";
		List<Integer> lst = new ArrayList<>();
		lst.add(1);
		lst.add(2);
		lst.add(3);
		lst.add(4);
//		makeCombinationsWithRepeatation(arr, length, str, 0);
		count = 0;
		makeCombinationsWithoutRepeatation(lst, length, "", 0);
	}

	private static void makeCombinationsWithoutRepeatation(List<Integer> lst, int length, String str, int index) {
		// TODO Auto-generated method stub
		List<Integer> lstTemp = new ArrayList<>();
		lstTemp.addAll(lst);
		String strTemp = str;
		if (strTemp.length() == length) {
			System.out.println(count + " : " + strTemp);
			count++;
		}
		for (int i = 0; i < lstTemp.size() && strTemp.length() < length; i++) {
			strTemp += lstTemp.get(i);
			lstTemp.remove(new Integer(lstTemp.get(i)));
			makeCombinationsWithoutRepeatation(lstTemp, length, strTemp, index + 1);
			lstTemp.clear();
			lstTemp.addAll(lst);
			strTemp = str;
		}

	}

	static void makeCombinationsWithRepeatation(int arr[], int length, String str, int index) {
		String strTemp = str;
		if (strTemp.length() == length) {
			System.out.println(count + " : " + strTemp);
			count++;
		}
		for (int i = 0; i < arr.length && index < length; i++) {
			strTemp += arr[i];
			makeCombinationsWithRepeatation(arr, length, strTemp, index + 1);
			strTemp = str;
		}
	}
}
