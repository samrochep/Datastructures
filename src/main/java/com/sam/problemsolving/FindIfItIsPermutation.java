package com.sam.problemsolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindIfItIsPermutation {
	public static void main(String[] args) throws NumberFormatException, IOException {
		System.out.println("Enter String 1..");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br1.readLine();
		System.out.println("Enter String 2..");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String str2 = br2.readLine();
		System.out.println(findIfPermutations(str1,str2));
		System.out.println(findIfPermutationsOptimized(str1,str2));
	}

	//Time complexity - O(NLogN)
	private static Boolean findIfPermutations(String str1, String str2) {
		if(str1.length()!=str2.length())
			return Boolean.FALSE;
		return sort(str1).equals(sort(str2));
			
	}

	private static String sort(String str) {
		char[] characters = str.toCharArray();
		//internaly uses quick sort which takes nlogn times
		Arrays.sort(characters);
		return new String(characters);
	}
	//Time complexity - O(n)
	private static Boolean findIfPermutationsOptimized(String str1, String str2) {
		int str1Length = str1.length();
		int str2Length = str2.length();
		if(str1Length!=str2Length)
			return Boolean.FALSE;
		
		int[]charsCount=new int[256];
		
		for(int i=0;i<str1Length;i++) {
			 charsCount[str1.charAt(i)]++;
		}
		
		for(int i=0;i<str2Length;i++) {
			int intChar = str2.charAt(i);
			charsCount[intChar]--;
			if(charsCount[intChar]<0)
				return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
	}
}
