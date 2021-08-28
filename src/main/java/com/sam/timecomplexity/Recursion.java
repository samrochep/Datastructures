package com.sam.timecomplexity;

public class Recursion {
	
	public static void main(String args[]){
		System.out.println(sum(4));
	}
	
	//Time Complexity - O(Branches^Depth) -> O(2^N)(worst and best)
	//Space Complexity - O(N)
	public static int sum(int n) {
		if(n<=1){
			return 1;
		} else {
			return sum(n-1) + sum(n-1);
		}
	}

}
