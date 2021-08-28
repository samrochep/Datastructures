package com.sam.datastructures;

public class CustomStack<E> {
	
	private static final int MAX=1000;
	private int topIndex;
	
	private Object elements[] = new Integer[MAX];
	
	public CustomStack(){
		topIndex=-1;
	}
	
	public Boolean push(E element) {
		if(topIndex>MAX){
			System.out.println("Stack Overflow");
			return Boolean.FALSE;
		} else {
			elements[++topIndex]=element;
			System.out.println(element+" Pushed to stack");
			return Boolean.TRUE;
		}
	}
	public E pop() {
		if(topIndex<0){
			System.out.println("Stack Underflow");
			return null;
		} else {
			E element = (E) elements[topIndex];
			elements[topIndex]=null;
			topIndex--;
			System.out.println("====== "+element+" Popped from stack");
			return element;
		}
	}
	
	public E peek() {
		if(topIndex<0){
			System.out.println("Stack Underflow");
			return null;
		} else {
			E element = (E) elements[topIndex];
			System.out.println("====== "+element+" Peeked from stack");
			return element;
		}
	}
	
    public void printElements(){
    	for(int i=0;i<=topIndex;i++) {
          System.out.println(elements[i]);
    	}
    }

	public int size() {
		return topIndex+1;
	}
	
	public E removeFromBottom() {
		if (topIndex < 0) {
			System.out.println("Stack Underflow");
			return null;
		} else {
			E element = (E) elements[0];
			//System.arraycopy(src, srcPos, dest, destPos, length);
		    int numberOfElementsToBeMoved = size()-(0+1);//size-index-1
		    System.arraycopy(elements, 1, elements, 0, numberOfElementsToBeMoved);
		    elements[topIndex--]=null;
			System.out.println("====== " + element + " Popped from stack");
			return element;
		}
	}
}
