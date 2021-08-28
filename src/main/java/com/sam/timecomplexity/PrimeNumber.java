package com.sam.timecomplexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		int status = 0;
		while (status != -1) {
			System.out.println("Enter -1 to terminate..");
			System.out.println("Enter 0 to continue..");
			BufferedReader statusbBr = new BufferedReader(new InputStreamReader(System.in));
			status = Integer.parseInt(statusbBr.readLine());
			if(status==0) {
				System.out.println("Enter Number..");
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				System.out.println(isPrime(Integer.parseInt(br.readLine())));
			}		
		}

	}
	//Time Complexity O(squareroot(n))(worst and best)
	private static Boolean isPrime(int n) {
		Boolean result = Boolean.TRUE;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				result = Boolean.FALSE;
				break;
			}
		}
		return result;
	}

}
