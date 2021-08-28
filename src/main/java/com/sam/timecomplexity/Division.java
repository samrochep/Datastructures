package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Division {
	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println("Enter Number 1..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		System.out.println("Enter Number 2..");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		int b = Integer.parseInt(br2.readLine());
		System.out.println(divide(a,b));

	}
	//Time Complexity 
	   //worst case- O(a/b)
	   //best case - omega(a/b)
	//Space Complexity - O(1)
	private static int divide(int a, int b) {
		int quotient = 0;
		int sum = b;
		while(sum<=a) {
			sum+=b;
			quotient++;
		}
		return quotient;
	}
}
