package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Power {

	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println("Enter Number 1..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		System.out.println("Enter Number 2..");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		int b = Integer.parseInt(br2.readLine());
		System.out.println(findPower(a,b));

	}
	//Time Complexity - O(b)(worst and best)
	//Space Complexity - O(b)
	private static int findPower(int a, int b) {
		if(b<0){
			return 0;
		} else if(b==0){
			return 1;
		} else if(b==1){
			return a;
		} else {
			return a * findPower(a,b-1);
		}
	}

}
