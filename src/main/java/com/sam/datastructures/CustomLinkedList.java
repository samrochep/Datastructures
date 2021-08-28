package com.sam.datastructures;

import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class CustomLinkedList<E> {
	
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	private static class Node<E> {
		E elementData;
		Node<E> next;
		Node<E> prev;
		Node(E elementData,Node<E> prev,Node<E> next) {
			this.elementData=elementData;
			this.next=next;
			this.prev=prev;
		}
		
	}
	
	public void addFirst(E elementData) {
		linkFirst(elementData);
	}


	public void addLast(E elementData) {
		linkLast(elementData);
	}
    

	public Boolean add(E elementData) {
		linkLast(elementData);
		return true;
	}
    
    public void add(int index,E elementData) {
    	rangeCheck(index);
    	
    	if(index == this.size)
    		linkLast(elementData);
    	else 
    	    linkBefore(elementData,node(index));
		
	}


	public E get(int index) {
		rangeCheck(index);
		Node<E>node = node(index);
		return node!=null?node.elementData:null;
    }
    
    public E getFirst() {
    	if(this.head==null) {
    		throw new NoSuchElementException();
    	}
    	return this.head.elementData;
    }
    
    public E getLast() {
    	if(this.tail==null) {
    		throw new NoSuchElementException();
    	}
    	return this.tail.elementData;
    }
    
    public E removeFirst() {
    	return unlinkFirst();
    }


	public E removeLast() {
    	return unlinkLast();
    }
    

	public E remove(int index) {
		rangeCheck(index);
		return unlink(node(index));
    }


	public Boolean remove(Object o) {
		if(o==null){
			for(Node<E> node = this.head;node!=null;node=node.next) {
				if(node.elementData==null) {
					unlink(node);
	    			return Boolean.TRUE;
				}
			}
		} else {
			for(Node<E> node = this.head;node!=null;node=node.next) {
	    		if(o.equals(node.elementData)) {
	    			unlink(node);
	    			return Boolean.TRUE;
	    		}
	    	}
		}
    	return Boolean.FALSE;
    }
    
    public E set(int index,E elementData) {
    	rangeCheck(index);
    	E oldValue=null;
    	Node<E> node = node(index);
    	if(node!=null) {
    		oldValue = node.elementData;
    		node.elementData=elementData;
    	}
    	return oldValue;
    }
    
    private void linkFirst(E elementData) {
		final Node<E> first = this.head;
		final Node<E> newNode = new Node<E>(elementData,null,first);
		this.head = newNode;
		if(first==null)
			this.tail=newNode;
		else
			first.prev=newNode;
		size++;
		
	}
    
    private void linkLast(E elementData) {
    	final Node<E> last = this.tail;
    	final Node<E> newNode = new Node<E>(elementData,last,null);
		this.tail=newNode;
		if(last==null)
			this.head=newNode;
		else
			last.next=newNode;
		size++;	
	}
    
    private void rangeCheck(int index) {
		if(index>=this.size || index<0){
	    	throw new IndexOutOfBoundsException("Index: "+index+",Size "+this.size);
	    }
	}
   
    private Node<E> node(int index) {
    	//this.size>>1 is equivalent to (this.size)/Math.power(2,1)
		if(index<(this.size>>1)) {
			Node<E> x = this.head;
			for(int i=0;i<index;i++)
				x = x.next;
			return x;
		} else {
			Node<E> x = this.tail;
			for(int i=size-1;i>index;i--)
				x = x.prev;
			return x;
		}
	}
    
    private void linkBefore(E elementData, Node<E> successor) {
    	final Node<E> predecessor = successor.prev;
    	final Node<E> newNode = new Node<E>(elementData,predecessor,successor);
    	successor.prev=newNode;
    	if(predecessor==null) 
    		this.head=newNode;
    	else
    		predecessor.next=newNode;
    	size++;
	}
    
    private E unlinkFirst() {
    	E elementData = null;
    	if(this.head!=null) {
    		final Node<E> first = this.head;
        	elementData = first.elementData;
        	final Node<E> next = first.next;
        	first.elementData=null;
        	first.next = null;
        	this.head = next;
        	if(next==null)
        		this.tail=null;
        	else 
        		next.prev=null;
        	size--;
    	}
    	return elementData;	
	}
    
    private E unlinkLast() {
    	E elementData = null;
    	if(this.tail!=null) {
    		final Node<E> last = this.tail;
        	elementData = last.elementData;
        	final Node<E> prev = this.tail.prev;
        	last.elementData=null;
        	last.next = null;
        	this.tail = prev;
        	if(prev==null)
        		this.head=null;
        	else 
        		prev.next=null;
        	size--;
    	}
    	return elementData;	
	}

    private E unlink(Node<E> node) {
    	E elementData = null;
    	if(node!=null) {
    		final Node<E> prev = node.prev;
    		final Node<E> next = node.next;
    		if(prev==null) 
    			this.head=next;
    		else {
    			prev.next=next;
    			node.prev=null;
    		}
    		if(next==null) 
    			this.tail=prev;
    		else {
    			next.prev = prev;
    			node.next=null;
    		}
    		elementData = node.elementData;
    		node.elementData=null;
    		size--;
    	}
    	return elementData;
	}
    
    public void printElements(){
    	for(Node<E> node = this.head;node!=null;node=node.next) {
			System.out.println(node.elementData);
		}
    }


}
