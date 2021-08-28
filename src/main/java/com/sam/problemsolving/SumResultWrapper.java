package com.sam.problemsolving;

public class SumResultWrapper {
	
    private SingleLinkedListNode<Integer> result;
    private int carry;
    
    public SumResultWrapper(SingleLinkedListNode<Integer>result,int carry) {
    	this.result=result;
    	this.carry=carry;
    }
    
	public SumResultWrapper() {
		
	}

	public SingleLinkedListNode<Integer> getResult() {
		return result;
	}
	public void setResult(SingleLinkedListNode<Integer> result) {
		this.result = result;
	}
	public int getCarry() {
		return carry;
	}
	public void setCarry(int carry) {
		this.carry = carry;
	}
    
}
