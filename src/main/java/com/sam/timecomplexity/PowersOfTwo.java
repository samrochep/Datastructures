package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowersOfTwo {
	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println("Enter Number..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		printThePowersOfTwo(Integer.parseInt(br.readLine()));
	}
    //Time complexity - O(logN)(worst and best)
	//Space complexity - O(LogN)
	private static int printThePowersOfTwo(int n) {
		if(n<0){
			return 0;
		} else if(n==1){
			System.out.println(1);
			return 1;
		} else {
			int prevValue = printThePowersOfTwo(n/2);
			int currentValue = prevValue*2;
			System.out.println(currentValue);
			return currentValue;
		}
	}
}
