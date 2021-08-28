package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter Number..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(fib(Integer.parseInt(br.readLine())));
	}

	//Time Complexity - O(Branches^Depth) -> O(2^N) (worst and best)
	//Space Complexity - O(N)
	private static int fib(int n) {
		if(n<=0) {
			return 0;
		}
		else if(n==1) {
			return 1;
		}
		return fib(n-1)+fib(n-2);
	}

}
