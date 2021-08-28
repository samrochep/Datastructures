package com.sam.problemsolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OneEditAway {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter String 1..");
		BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br1.readLine();
		System.out.println("Enter String 2..");
		BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
		String str2 = br2.readLine();
		//System.out.println(isOneEditAway(str1, str2));
		System.out.println(isOneEditAwayAlternate(str1, str2));
	}

	// Time Complexity
	// n = length of longer String
	// m = length of shorter String
	// O(m)
	private static Boolean isOneEditAway(String str1, String str2) {
		int str1Length = str1.length();
		int str2Length = str2.length();
		if (str1Length == str2Length)
			return isOneReplaceAway(str1, str2);
		if (str1Length == str2Length + 1)
			return isOneInsertOrDeleteAway(str2, str1);
		if (str1Length + 1 == str2Length)
			return isOneInsertOrDeleteAway(str1, str2);
		return Boolean.FALSE;
	}

	private static Boolean isOneReplaceAway(String str1, String str2) {
		Boolean diffFound = Boolean.FALSE;
		int strLength = str1.length();
		for (int i = 0; i < strLength; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				if (diffFound)
					return Boolean.FALSE;
				diffFound = Boolean.TRUE;
			}
		}
		return Boolean.TRUE;
	}

	private static Boolean isOneInsertOrDeleteAway(String shorterString, String longerString) {
		int shorterStringIndex = 0;
		int longerStringIndex = 0;
		int shorterStringLength = shorterString.length();
		int longerStringLength = longerString.length();
		Boolean diffFound = Boolean.FALSE;
		while (shorterStringIndex < shorterStringLength && longerStringIndex < longerStringLength) {
			if (shorterString.charAt(shorterStringIndex) != longerString.charAt(longerStringIndex)) {
				if (diffFound)
					return Boolean.FALSE;
				diffFound = Boolean.TRUE;
			} else {
				shorterStringIndex++;
			}
			longerStringIndex++;
		}
		return Boolean.TRUE;
	}

	private static Boolean isOneEditAwayAlternate(String str1, String str2) {
		int str1Length = str1.length();
		int str2Length = str2.length();

		// length check
		if (Math.abs(str1Length - str2Length) > 1)
			return Boolean.FALSE;

		// find longer and shorter string
		String shorterString = str1Length < str2Length ? str1 : str2;
		String longerString = str1Length < str2Length ? str2 : str1;

		int shorterStringIndex = 0;
		int longerStringIndex = 0;
		int longerStringLength = longerString.length();
		int shorterStringLength = shorterString.length();
		Boolean diffFound = Boolean.FALSE;
		while (shorterStringIndex < shorterStringLength && longerStringIndex < longerStringLength) {
			if (shorterString.charAt(shorterStringIndex) != longerString.charAt(longerStringIndex)) {
				// second diff
				if (diffFound)
					return Boolean.FALSE;
				// first diff
				diffFound = Boolean.TRUE;

				if (shorterStringLength == longerStringLength) {
					shorterStringIndex++;
				}
			} else {
				shorterStringIndex++;

			}
			longerStringIndex++;
		}
		return Boolean.TRUE;
	}

}
