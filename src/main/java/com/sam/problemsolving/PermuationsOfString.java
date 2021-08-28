package com.sam.problemsolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PermuationsOfString {

	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter String..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		findPermutations(br.readLine(),"");
	}

	//Time Complexity - O(N^2*N!) (worst and best)
	//Space Complexity - O(N!)
	private static void findPermutations(String str,String prefix) {
		int strLength = str.length();
		if(strLength==0) {
			System.out.println(prefix);
		}
		for(int i=0;i<strLength;i++) {
			String remSubString = str.substring(0,i)+str.substring(i+1);
			findPermutations(remSubString,prefix+str.charAt(i));
		}
	}

}
