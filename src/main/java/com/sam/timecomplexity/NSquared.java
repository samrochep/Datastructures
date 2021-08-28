package com.sam.timecomplexity;

public class NSquared {
	
	public static void main(String args[]) {
		int [] intArray= new int[]{1,2,3,4};
		sumOfPair(intArray);
		int [] intArray2= new int[]{1,2,3,4,5};
		sumOfPair2(intArray2);
		sumOfPair3(intArray,intArray2);
	}
   //Time Complexity O(N^2)(worst and best)
   //Space Complexity O(N)
	public static void sumOfPair(int[]array) {
		int arrayLength = array.length;
		int counter = 0;
		for(int i=0;i<arrayLength;i++) {//--N 
			for(int j=0;j<arrayLength;j++) {//--N 
				counter++;
				System.out.println("counter-"+counter+",("+i+","+j+")");			
			}
		}
	}
	
	//Time Complexity O(N^2)(worst and best)
	//Space Complexity O(N)
	public static void sumOfPair2(int[]array) {
		int arrayLength = array.length;
		int counter = 0;
		for(int i=0;i<arrayLength;i++) { 
			for(int j=i;j<arrayLength;j++) {
				counter++;
				System.out.println("counter-"+counter+",("+i+","+j+")");			
			}
		}
	}
	
	//Time Complexity O(N*M)(worst and best)
	//Space Complexity O(N+M)
	public static void sumOfPair3(int[]array1,int[]array2) {
		int array1Length = array1.length;
		int array2Length = array2.length;
		int counter = 0;
		for(int i=0;i<array1Length;i++) { 
			for(int j=0;j<array2Length;j++) {
				counter++;
				System.out.println("counter-"+counter+",("+i+","+j+")");			
			}
		}
	}
	
	// Time Complexity O(N*M)(worst and best)
	// Space Complexity O(N+M)
	public static void sumOfPair4(int[] array1, int[] array2) {
		int array1Length = array1.length;
		int array2Length = array2.length;
		int counter = 0;
		for (int i = 0; i < array1Length; i++) {
			for (int j = 0; j < array2Length; j++) {
				for (int k = 0; k < 1000; k++) {
					counter++;
					System.out.println("counter-" + counter + ",(" + i + "," + j + ")");
				}
			}
		}
	}
	
	

}
