package com.sam.datastructures;

import java.util.Arrays;

public class CustomArrayList<E> {
	
	private static final int DEFAULT_CAPACITY=10;
	
	private int size;
	
	private int capacity;
	
	private Object elements[];
	
	public CustomArrayList() {
		this(DEFAULT_CAPACITY);
	}

	public CustomArrayList(int capacity) {
		this.capacity=capacity;
		elements= new Object[capacity];
		size = 0;
	}
	
	public void add(E element) {
	    ensureCapacity();
	    elements[size++]=element;
	}
	
	public E get(int index) {
		rangeCheck(index);
	    return (E)elements[index];
	}
	
	public E remove(int index) {
	    E element = get(index);
	    //System.arraycopy(src, srcPos, dest, destPos, length);
	    int numberOfElementsToBeMoved = size-(index+1);//size-index-1
	    System.arraycopy(elements, index+1, elements, index, numberOfElementsToBeMoved);
	    elements[--size]=null;
	    return element;
	}

	private void ensureCapacity() {
		if(this.size==this.elements.length) {
			int newSize=this.size*2;
			this.capacity=newSize;
			this.elements=Arrays.copyOf(this.elements, newSize);
		}
	}
	
	private void rangeCheck(int index) {
		if(index>=this.size || index<0){
	    	throw new IndexOutOfBoundsException("Index: "+index+",Size "+this.size);
	    }
	}
	public void printElements(){
    	for(int i=0;i<this.size;i++) {
          System.out.println(elements[i]);
    	}
    }

}
