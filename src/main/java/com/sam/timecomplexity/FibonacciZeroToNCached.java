package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FibonacciZeroToNCached {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter Number..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] cache = new int[n];
		for(int i=1;i<n;i++) {
			System.out.println(fib(i,cache));
		}	
	}

	//Time Complexity - O(N)(worst and best)
	//Space Complexity - O(N)
	private static int fib(int n,int[] cache) {
		if(n<=0) {
			return 0;
		}
		else if(n==1) {
			cache[n]=1;
			return 1;
		} else if(cache[n]>0) {
			return cache[n];
		}
		cache[n] = fib(n-1,cache)+fib(n-2,cache);
		return cache[n];
	}

}
