package com.sam.problemsolving;

import com.sam.datastructures.CustomStack;

public class StackWithMin extends CustomStack<NodeWithMin> {
	
	public Boolean push(int value) {
		int newMin = Math.min(value, min());
		return super.push(new NodeWithMin(value,newMin));	
	}
	
	public NodeWithMin pop() {
		return super.pop();
	}

	public int min() {
		if(this.size()==0)
			return Integer.MAX_VALUE;
		return peek().getMin();
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
