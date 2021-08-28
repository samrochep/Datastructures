package com.sam.problemsolving;

import com.sam.datastructures.CustomStack;

public class StackWithMinOptimized extends CustomStack<Integer> {
	
	private CustomStack<Integer> minStack = new CustomStack<Integer>();
	public Boolean push(int value) {
		if(value<min())
			minStack.push(value);
		return super.push(value);	
	}
	
	public Integer pop() {
		int value = super.pop();
		if(value==min())
			minStack.pop();
		return value;
	}

	public int min() {
		if(this.size()==0)
			return Integer.MAX_VALUE;
		return minStack.peek();
	}
	
	public static void main(String args[]) {
		StackWithMin stackWithMin = new StackWithMin();
		stackWithMin.push(7);
		System.out.println("Minimum is===> "+stackWithMin.min());
		stackWithMin.push(6);
		System.out.println("Minimum is===> "+stackWithMin.min());
		stackWithMin.push(8);
		System.out.println("Minimum is===> "+stackWithMin.min());
		stackWithMin.push(3);
		System.out.println("Minimum is===> "+stackWithMin.min());
		stackWithMin.push(9);
		System.out.println("Minimum is===> "+stackWithMin.min());
		stackWithMin.pop();
		System.out.println("Minimum is===> "+stackWithMin.min());
		stackWithMin.pop();
		System.out.println("Minimum is===> "+stackWithMin.min());
	}
}
