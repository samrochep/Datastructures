package com.sam.problemsolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringUrlify {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter String..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(urlify(br.readLine()));
	}
	//Time complexity - O(n)
	private static String urlify(String str) {
		int spaceCount=0;
		int strLength=str.length();
		char[] characters = str.toCharArray();
		for(int i=0;i<strLength;i++){
			if(characters[i]==' '){
				spaceCount++;
			}
		}
		//we are converting space to %20 so additional 2 chars needed==>spacecount*2
		int newSize = strLength + (spaceCount*2);
		char[] newArray = new char[newSize];
		int index = newSize-1;
		for(int i=strLength-1;i>=0;i--){
			if(characters[i]==' ') {
				newArray[index]='0';
				newArray[index-1]='2';
				newArray[index-2]='%';
				index=index-3;
			} else {
				newArray[index]=characters[i];
				index--;
			}
		}
		return new String(newArray);
	}

}
