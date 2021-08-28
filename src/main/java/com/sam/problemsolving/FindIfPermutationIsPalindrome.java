package com.sam.problemsolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindIfPermutationIsPalindrome {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter String..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.out.println(permutationsIsPalindrome(br.readLine()));
		System.out.println(permutationsIsPalindromeAlternate(br.readLine()));
	}

	// if there is more than one odd count of character then its not a
	// palindrome
	//Time complexity - O(n)
	private static Boolean permutationsIsPalindrome(String str) {
		int[] charsCount = new int[256];
		int strLength = str.length();

		for (int i = 0; i < strLength; i++)
			charsCount[str.charAt(i)]++;

		Boolean oddCountFound = Boolean.FALSE;
		for (int i = 0; i < strLength; i++) {
			if (charsCount[str.charAt(i)] % 2 == 1) {
				if (oddCountFound)
					return Boolean.FALSE;
				oddCountFound = Boolean.TRUE;
			}
		}
		return Boolean.TRUE;
	}

	// if there is more than one odd count of character then its not a
	// palindrome
	//Time complexity - O(n)
	private static Boolean permutationsIsPalindromeAlternate(String str) {
		int[] charsCount = new int[256];
		int strLength = str.length();
		int oddCount = 0;
		for (int i = 0; i < strLength; i++) {
			charsCount[str.charAt(i)]++;
			if (charsCount[str.charAt(i)] % 2 == 1)
				oddCount++;
			else
				oddCount--;
		}

		return oddCount <= 1;
	}

}
