package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PerfectSquare {

	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println("Enter Number..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(isPerfectSquare(Integer.parseInt(br.readLine())));
	}
	
	//Time Complexity 
    	// worst case - O(sqrt(N))
	    // best case - omega(sqrt(N))
	//Space Complexity - O(1)
	public static Boolean isPerfectSquare(int n) {
		for(int i=1;i*i<=n;i++) {
			if(i*i==n) {
				return Boolean.TRUE;
			}
		}
		return Boolean.FALSE;
	}
	

}
