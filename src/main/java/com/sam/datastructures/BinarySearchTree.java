package com.sam.datastructures;

public class BinarySearchTree {

	private Node root;

	public static class Node {
		Integer item;
		Node left;
		Node right;

		Node(Integer item) {
			this.item = item;
		}
	}

	BinarySearchTree(Integer item) {
		this.root = new Node(item);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public void add(Integer elementData) {
		insertNode(root, elementData);
	}

	private Node insertNode(Node current, Integer elementData) {
		if (current == null) {
			return new Node(elementData);
		}
		if (elementData<current.item) {
			current.left = insertNode(current.left, elementData);
		} else if (elementData>current.item) {
			current.right = insertNode(current.right, elementData);
		} else
			return current;
		return current;
	}

	public Boolean find(Integer elementData) {
		return containsNode(root, elementData);
	}

	private Boolean containsNode(Node current, Integer elementData) {
		if (current == null) {
			return Boolean.FALSE;
		}
		if (current.item == elementData) {
			return Boolean.TRUE;
		}
		return elementData < current.item ? containsNode(current.left, elementData)
				: containsNode(current.right, elementData);
	}

	public Boolean delete(Integer elementData) {
		root = deleteNode(root, elementData);
		return Boolean.TRUE;
	}

	private Node deleteNode(Node current, Integer elementData) {
		if (current == null)
			return null;
		if (current.item == elementData) {
			if (current.left == null && current.right == null)
				return null;
			if (current.left != null) {
				return current.left;
			}
			if (current.right != null) {
				return current.right;
			}
			int value = findSmallestValue(current.right);
			current.right = deleteNode(current.right, value);
			return current;
		} else if (elementData>current.item)
			current.right = deleteNode(current.right, elementData);
		else
			current.left = deleteNode(current.left, elementData);
		return current;
	}

	private int findSmallestValue(Node current) {
		return current.left == null ? current.item : findSmallestValue(current.left);
	}

	// left,root,right
	public void inOrderTraversal(Node current) {
		if (current == null)
			return;
		inOrderTraversal(current.left);
		System.out.print(current.item+" ");
		inOrderTraversal(current.right);
	}

	// root,left,right
	public void preOrderTraversal(Node current) {
		if (current == null)
			return;
		System.out.print(current.item+" ");
		preOrderTraversal(current.left);
		preOrderTraversal(current.right);
	}

	// left,right,root
	public void postOrderTraversal(Node current) {
		if (current == null)
			return;
		postOrderTraversal(current.left);
		postOrderTraversal(current.right);
		System.out.print(current.item+" ");
	}

}
