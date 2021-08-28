package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumofDigits {
	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println("Enter Number..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(findSumofDigits(Integer.parseInt(br.readLine())));
	}
    
	//Time Complexity - O(log N (base 10))(worst and best)
	//Space Complexity - O(1)
	private static int findSumofDigits(int n) {
		int sum = 0;
		while(n>0) {
			sum+=n%10;
			n=n/10;
		}
		return sum;
	}

}
