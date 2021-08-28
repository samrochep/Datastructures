package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PowersOfTwoApproachTwo {
	
	public static void main(String args[]) throws NumberFormatException, IOException{
		System.out.println("Enter Number..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		printThePowersOfTwo(Integer.parseInt(br.readLine()),1);
	}
    //Time complexity - O(logN)(worst and best)
	//Space complexity - O(logN)
	private static void printThePowersOfTwo(int n,int number) {
		if(number<=n) {
			if(n<0){
				System.out.println("Negative value");
			} else {
				System.out.println(number); 
				int nextNumber = number*2;
				printThePowersOfTwo(n,nextNumber);
			}
		}	
	}

}
