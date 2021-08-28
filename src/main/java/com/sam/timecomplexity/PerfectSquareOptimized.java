package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectSquareOptimized {

	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println("Enter Number..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(isPerfectSquare(n,1,n));
	}
	
	//Time Complexity - O(log N)(worst and best)
	//Space Complexity - O(log N)
	public static Boolean isPerfectSquare(int n, int min, int max) {
	
		if(max<min) {
			return Boolean.FALSE;
		}
		int midPoint = (min+max)/2;
		int midPointSquare=midPoint*midPoint;
		if(midPointSquare==n) {
			return Boolean.TRUE;
		} else if(midPointSquare<n){
			return isPerfectSquare(n, midPoint+1,max);
		} else {
			return isPerfectSquare(n, min ,midPoint-1);
		}

	}

}
