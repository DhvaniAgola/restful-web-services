package com.PCTBasicProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueWordsCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "Prithviraj D Chavan Output chavan PrithviraJ d \n Input  Barack Obama InputOutput Output";
		String str[] = input.split("\n");
		List<String> lst = new ArrayList<>();
		for (int i = 0; i < str.length; i++) {
			lst.addAll(Arrays.asList(str[i].trim().split("\\s+")));
		}

		System.out.println(lst);
		for (int i = 0; i < lst.size() - 1; i++) {
			for (int j = i + 1; j < lst.size(); j++) {
				if (lst.get(i).equalsIgnoreCase(lst.get(j))) {
					lst.remove(j);
				}
			}

		}
		System.out.println(lst);
		System.out.println(lst.size());
	}

}
