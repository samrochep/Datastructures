package com.sam.problemsolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniqueCharactersInAString {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter String..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(isUniqueChars(br.readLine()));
	}
    
	//Time complexity - O(min(c,n))
	private static Boolean isUniqueChars(String str) {
		int strLength=str.length();
		if(strLength>256)
			return Boolean.FALSE;
		int[]charsIntArray=new int[256];
		//Arrays.fill(charsBooleanArray, Boolean.FALSE);
	    for(int i=0;i<strLength;i++) {
	    	int value = str.charAt(i);
	    	if(charsIntArray[value]>0)
	    		return Boolean.FALSE;
	    	else
	    		charsIntArray[value]++;
	    }
	    return Boolean.TRUE;
	}
	

}
