package com.sam.problemsolving;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringCompression {

	public static void main(String[] args) throws IOException {
		System.out.println("Enter String..");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(compressString(br.readLine()));
		System.out.println(compressStringWithStringBuilder(br.readLine()));
		System.out.println(compressStringWithStringBuilderOptimized(br.readLine()));
	}
	//time complexity - O(n+k^2)
	//n-length of string
	//k-length of unique chars in string
	private static String compressString(String str) {
		int strLength = str.length();
		int consequitiveCount=0;
		String compressedString="";
		for(int i=0;i<strLength;i++) {
			consequitiveCount++;
			if(i+1>=strLength ||str.charAt(i)!=str.charAt(i+1)) {
				compressedString=compressedString+str.charAt(i)+consequitiveCount;
				consequitiveCount=0;
			}
		}
		
		return compressedString.length()<=strLength?compressedString:str;
	}
	
	    //time complexity - O(n)(time complexity has been reduced because of using string builder)
		private static String compressStringWithStringBuilder(String str) {
			int strLength = str.length();
			int consequitiveCount=0;
			StringBuilder compressedString=new StringBuilder();
			for(int i=0;i<strLength;i++) {
				consequitiveCount++;
				if(i+1>=strLength ||str.charAt(i)!=str.charAt(i+1)) {
					compressedString=compressedString.append(str.charAt(i)).append(consequitiveCount);
					consequitiveCount=0;
				}
			}
			
			return compressedString.length()<=strLength?compressedString.toString():str;
		}
		//finding the compression length before appending strings
		//advantages
		//1-no need of appending strings if the compression length is greater than the string length
		//2-we will know the stringbuilder capacity while initializing string builder
		//so the string builder need not double its size whenever the length equals size
		//time complexity - O(n)
		private static String compressStringWithStringBuilderOptimized(String str) {
			int strLength = str.length();
			int consequitiveCount=0;
			int compressionLength = findCompressionLength(str);
			if(compressionLength>strLength)
				return str;
			StringBuilder compressedString=new StringBuilder(compressionLength);
			for(int i=0;i<strLength;i++) {
				consequitiveCount++;
				if(i+1>=strLength ||str.charAt(i)!=str.charAt(i+1)) {
					compressedString=compressedString.append(str.charAt(i)).append(consequitiveCount);
					consequitiveCount=0;
				}
			}
			
			return compressedString.length()<=strLength?compressedString.toString():str;
		}
		private static int findCompressionLength(String str) {
			int strLength = str.length();
			int consequitiveCount=0;
			int compressionLength=0;
			for(int i=0;i<strLength;i++) {
				consequitiveCount++;
				if(i+1>=strLength ||str.charAt(i)!=str.charAt(i+1)) {
					compressionLength=String.valueOf(consequitiveCount).length()+1;
					consequitiveCount=0;
				}
			}
			return compressionLength;
		}

}
