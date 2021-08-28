package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Modulo {

	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println("Enter Number 1..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		System.out.println("Enter Number 2..");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		int b = Integer.parseInt(br2.readLine());
		System.out.println(findReminder(a,b));

	}
	//Time Complexity - O(1)(worst and best)
	//Space Complexity - O(1)
	private static int findReminder(int a, int b) {
		if(b<=0){
			return -1;
		}
		int quotient = a/b;
		return a-(quotient*b);
	}

}
