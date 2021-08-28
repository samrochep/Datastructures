package com.sam.problemsolving;

public class SingleLinkedListNode<E> {
	
	private E elementData;
	private SingleLinkedListNode<E> next;
	private SingleLinkedListNode<E> head;
	
	public SingleLinkedListNode<E> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<E> head) {
		this.head = head;
	}

	SingleLinkedListNode(E elementData) {
		this.elementData = elementData;
	}
	
    SingleLinkedListNode(E elementData,SingleLinkedListNode<E> next) {
    	this.elementData = elementData;
    	this.next=next;
	}
	
	public SingleLinkedListNode() {
		// TODO Auto-generated constructor stub
	}

	public E getElementData() {
		return elementData;
	}
	public void setElementData(E elementData) {
		this.elementData = elementData;
	}
	public SingleLinkedListNode<E> getNext() {
		return next;
	}
	public void setNext(SingleLinkedListNode<E> next) {
		this.next = next;
	}

}
