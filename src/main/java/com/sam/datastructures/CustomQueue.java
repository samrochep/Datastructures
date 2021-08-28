package com.sam.datastructures;

public class CustomQueue {

	private int size;
	private int front;
	private int rear;
	private int capacity;

	private Integer elements[];

	public CustomQueue(int capacity) {
		this.capacity = capacity;
		elements = new Integer[this.capacity];
		this.front = 0;
		this.size = 0;
		this.rear = this.size - 1;
	}

	public void enqueue(int element) {
		if (isFull(this)) {
			System.out.println("Queue is full");
			return;
		}
		this.size++;
		this.rear = this.size - 1;
		this.elements[this.rear] = element;
		System.out.println("Element " + element + " Enqueued to Queue");
	}

	public int dequeue() {
		if (isEmpty(this)) {
			System.out.println("Queue is Empty");
			return -1;
		}
		int element = this.elements[this.front];
		for (int i = 0; i < this.size-1; i++) {
			this.elements[i] = this.elements[i + 1];
		}
		this.elements[--this.size] = null;
		this.rear = this.size - 1;
		System.out.println("Element " + element + " Dequeued from Queue");
		return element;
	}

	public Boolean isFull(CustomQueue queue) {
		return queue.size == queue.capacity;
	}

	public Boolean isEmpty(CustomQueue queue) {
		return queue.size == 0;
	}

	public int front() {
		if (isEmpty(this)) {
			System.out.println("Queue is Empty");
			return -1;
		}
		return this.elements[this.front];
	}

	public int rear() {
		if (isEmpty(this)) {
			System.out.println("Queue is Empty");
			return -1;
		}
		return this.elements[this.rear];
	}

	public int size() {
		return this.size;
	}
	
	public void printElements(){
    	for(int i=0;i<this.size;i++) {
          System.out.println(elements[i]);
    	}
    }

}
