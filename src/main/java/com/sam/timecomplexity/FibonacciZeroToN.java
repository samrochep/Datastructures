package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciZeroToN {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter Number..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=1;i<n;i++) {
			System.out.println(fib(i));
		}	
	}

	//Time Complexity - O(2^N) (worst and best)
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
