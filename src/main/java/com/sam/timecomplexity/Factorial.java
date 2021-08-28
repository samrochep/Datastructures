package com.sam.timecomplexity;

public class Factorial {
	
	public static void main(String args[]){
		System.out.println(findFactorial(4));
	}
	
	//Time Complexity - O(N)	
	  // worst case - O(N)
      // best case - omega(N))
	//Space Complexity - O(N)
	public static int findFactorial(int n) {
		if(n<0){
			return -1;
		}
		else if(n==0){
			return 1;
		} else {
			return n*findFactorial(n-1);
		}
	}
}
