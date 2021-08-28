package com.sam.problemsolving;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

import com.sam.datastructures.CustomStack;

public class SetOfStackes {

	private List<CustomStack<Integer>> stakes = new ArrayList<CustomStack<Integer>>();
	private int capacity;

	public SetOfStackes(int capacity) {
		this.capacity = capacity;
	}

	public CustomStack<Integer> getLastStack() {
		if (stakes.size() == 0)
			return null;
		return stakes.get(stakes.size() - 1);
	}

	public Boolean push(int element) {
		Boolean result = Boolean.FALSE;
		CustomStack<Integer> stack = getLastStack();
		if (stack != null && stack.size() < capacity) {
			result = stack.push(element);
		} else {
			stack = new CustomStack<Integer>();
			result = stack.push(element);
			stakes.add(stack);
		}
		return result;
	}

	public int pop() {
		int poppedElement;
		CustomStack <Integer>stack = getLastStack();
		if (stack == null)
			throw new EmptyStackException();
		poppedElement = stack.pop();
		if (stack.size() == 0)
			stakes.remove(stack);
		return poppedElement;
	}

	public int popAt(int index) {
		return shift(index, Boolean.TRUE);
	}

	private int shift(int index, boolean removeFromTop) {
		int poppedElement;
		CustomStack<Integer> stack = stakes.get(index);
		if (stack == null)
			throw new EmptyStackException();
		if (removeFromTop)
			poppedElement = stack.pop();
		else
			poppedElement = stack.removeFromBottom();
		if (stakes.size() == 0)
			stakes.remove(index);
		else if (stakes.size() > index + 1) {
			int element = shift(index + 1, Boolean.FALSE);
			stack.push(element);
		}
		return poppedElement;
	}

	public void printElements() {
		for (int i = 0; i < stakes.size(); i++) {
			System.out.println("Stack " + i);
			stakes.get(i).printElements();
		}

	}

	public static void main(String args[]) {
		SetOfStackes setOfStakes = new SetOfStackes(3);
		setOfStakes.push(1);
		setOfStakes.push(2);
		setOfStakes.push(3);
		setOfStakes.push(4);
		setOfStakes.push(5);
		setOfStakes.push(6);
		setOfStakes.push(7);
		setOfStakes.push(8);
		setOfStakes.push(9);
		setOfStakes.push(10);
		setOfStakes.printElements();
		setOfStakes.pop();
		System.out.println("Set of Stackes after popping");
		setOfStakes.printElements();
		setOfStakes.pop();
		System.out.println("Set of Stackes after popping");
		setOfStakes.printElements();
		setOfStakes.popAt(0);
		System.out.println("Set of Stackes after popping at 1");
		setOfStakes.printElements();
	}

}
