package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Product {
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println("Enter Number 1..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		System.out.println("Enter Number 2..");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		int b = Integer.parseInt(br2.readLine());
		System.out.println(product(a,b));

	}
	//Time Complexity - O(b)(worst and best)
	//Space Complexity - O(1)
	private static int product(int a, int b) {
		int sum = 0;
		for(int i=0;i<b;i++) {
			sum+=a;
		}
		return sum;
	}

}
