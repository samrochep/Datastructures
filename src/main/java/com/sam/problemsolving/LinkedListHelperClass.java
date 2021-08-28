package com.sam.problemsolving;

public class LinkedListHelperClass<E> {

	public SingleLinkedListNode<E> createLinkedList(E[] elementDataArray) {
		SingleLinkedListNode<E> node = null;
		for (int i=elementDataArray.length-1;i>=0;i--) {
			SingleLinkedListNode<E> newNode = new SingleLinkedListNode<E>(elementDataArray[i]);
			newNode.setNext(node);
			node=newNode;
		}
		return node;
	}

	public void printElements(SingleLinkedListNode<E> node) {
		while (node != null) {
			System.out.println(node.getElementData());
			node = node.getNext();
		}
	}
	
	public SingleLinkedListNode<E> addLeadingNodes(SingleLinkedListNode<E> node,E elementData,int padding) {
		SingleLinkedListNode<E> outputNode = node;
		while(padding-->0) {
			outputNode = insertBefore(outputNode,elementData);
		}
		return outputNode;
	}

	public SingleLinkedListNode<E> insertBefore(SingleLinkedListNode<E> outputNode,E elementData) {
		SingleLinkedListNode<E> node = new SingleLinkedListNode<E>(elementData);
		node.setNext(outputNode);
		return node;
	}
	
	public int size(SingleLinkedListNode<E> head) {
		int size = 0;
		while(head!=null) {
			size++;
			head=head.getNext();
		}
		return size;
	}
}
