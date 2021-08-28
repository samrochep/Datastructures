package com.sam.timecomplexity;

public class Reverse {
	
	public static void main(String args[]) {
		int [] intArray= new int[]{1,2,3,4,5,6,7,8};
		System.out.println(reverseTheArray(intArray));
		for(int number:intArray) {
			System.out.println(number);
		}
	}
	//Time Complexity O(N/2)(worst and best)
	//Space Complexity O(N)
	public static int[] reverseTheArray(int[]array) {
		int arrayLength = array.length;
		int lastIndex = arrayLength-1;
		for(int i=0;i<arrayLength/2;i++) {
			int currentLastIndex = lastIndex-i;
			int temp = array[i];
			array[i] = array[currentLastIndex];
			array[currentLastIndex]=temp;
		}
		return array;
	}

}
