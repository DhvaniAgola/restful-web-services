package com.DataStructure.Stacks;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class MaximumElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn=new Scanner(System.in);
		Stack<Integer> stc=new Stack<>();
		int N=scn.nextInt();
		int first,second;
		for(int i=0;i<N;i++)
		{
			first=scn.nextInt();
			if(first==1)
			{
				second=scn.nextInt();
				stc.push(second);
			}
			if(first==2&&!stc.isEmpty())
			{
				stc.pop();
			}
			if(first==3)
			{
				System.out.println(Collections.max(stc));
			}
		}


	}

}
