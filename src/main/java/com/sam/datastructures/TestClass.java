package com.sam.datastructures;

public class TestClass {

	public static void main(String args[]) {
		// testStack();
		//testQueue();
		//testArrayList();
		//testLinkedList();
		//testHashMap();
		testBinarySearchTree();
	}

	private static void testBinarySearchTree() {
		BinarySearchTree bst = new BinarySearchTree(3);
		bst.add(5);
		bst.add(4);
		bst.add(1);
		bst.add(6);
		bst.add(2);
		BinarySearchTree.Node root = bst.getRoot();
		System.out.println(root.item);
		System.out.println(root.right.item);
		System.out.println(root.right.left.item);
		System.out.println(root.left.item);
		System.out.println(root.left.right.item);
		System.out.println("In order");
		bst.inOrderTraversal(bst.getRoot());
		System.out.println();
		System.out.println("Pre order");
		bst.preOrderTraversal(bst.getRoot());
		System.out.println();
		System.out.println("Post order");
		bst.postOrderTraversal(bst.getRoot());
	}

	private static void testStack() {
		CustomStack stack = new CustomStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		System.out.println("===Before Pop===");
		stack.printElements();
		stack.pop();
		System.out.println("===After Pop===");
		stack.printElements();
		System.out.println("===Before Peek===");
		stack.printElements();
		stack.peek();
		System.out.println("===After Peek===");
		stack.printElements();
	}

	private static void testQueue() {
		CustomQueue queue = new CustomQueue(5);
		queue.enqueue(1);
		System.out.println("Front element---> " + queue.front());
		System.out.println("Rear element---> " + queue.rear());
		System.out.println("Size---> " + queue.size());
		queue.enqueue(2);
		System.out.println("Front element---> " + queue.front());
		System.out.println("Rear element---> " + queue.rear());
		System.out.println("Size---> " + queue.size());
		queue.enqueue(3);
		System.out.println("Front element---> " + queue.front());
		System.out.println("Rear element---> " + queue.rear());
		System.out.println("Size---> " + queue.size());
		queue.enqueue(4);
		System.out.println("Front element---> " + queue.front());
		System.out.println("Rear element---> " + queue.rear());
		System.out.println("Size---> " + queue.size());
		queue.enqueue(5);
		System.out.println("Front element---> " + queue.front());
		System.out.println("Rear element---> " + queue.rear());
		System.out.println("Size---> " + queue.size());
		System.out.println("===Before Dequeue===");
		queue.printElements();
		queue.dequeue();
		System.out.println("===After Dequeue===");
		queue.printElements();
		System.out.println("Front element---> " + queue.front());
		System.out.println("Rear element---> " + queue.rear());
		System.out.println("Size---> " + queue.size());

	}

	private static void testArrayList() {
		// default capacity
		CustomArrayList<Integer> arrayList = new CustomArrayList<Integer>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		arrayList.add(4);
		arrayList.add(5);
		System.out.println("Printing arrayList");
		arrayList.printElements();
		System.out.println("Index 3== >" + arrayList.get(3));
		arrayList.remove(2);
		arrayList.printElements();

		// user given capacity
		CustomArrayList<Integer> arrayList2 = new CustomArrayList<Integer>(4);
		arrayList2.add(10);
		arrayList2.add(20);
		arrayList2.add(30);
		arrayList2.add(40);
		arrayList2.add(50);
		System.out.println("Printing arrayList2");
		arrayList2.printElements();
		System.out.println("Index 3== >" + arrayList2.get(3));
		arrayList2.remove(2);
		arrayList2.printElements();
		
		arrayList.remove(5);
	}
	
	private static void testLinkedList() {
		CustomLinkedList<String> linkedList = new CustomLinkedList<String>();
		//add
		linkedList.addFirst("A");
		linkedList.add("B");
		linkedList.add(null);
		linkedList.addLast("C");
		linkedList.add(1,"a");
		
		linkedList.addFirst("D");
		linkedList.add(null);
		linkedList.add("E");
		linkedList.addLast("F");
		linkedList.add(1,"d");
		
		System.out.println("=====After adding elements=== ");
		linkedList.printElements();
		
		//get
		System.out.println("Get first===> "+linkedList.getFirst());
		System.out.println("Get last===> "+linkedList.getLast());
		System.out.println("Get from index 5===> "+linkedList.get(5));
		
		//remove
		System.out.println("deleted===> "+linkedList.removeFirst());
		System.out.println("deleted===> "+linkedList.removeLast());
		System.out.println("deleted===> "+linkedList.remove(3));
		System.out.println("deleted===> "+linkedList.remove("a"));
		System.out.println("deleted===> "+linkedList.remove(null));
		
		System.out.println("====After removing elements===> ");
		linkedList.printElements();
	}
	
	private static void testHashMap() {
		CustomHashMap<String, Integer> studentsRankMap = new CustomHashMap<String, Integer>();
		studentsRankMap.put("Sam", 1);
		studentsRankMap.put("Samuel", 2);
		studentsRankMap.put("Roche", 3);
		studentsRankMap.put("Samuel Roche", 4);
		studentsRankMap.put("testcollision", 10);
		studentsRankMap.printElements();
		System.out.println("After replacing samuel's rank");
		studentsRankMap.put("Samuel", 5);
		studentsRankMap.printElements();
		
		System.out.println("Sam's Rank===> "+studentsRankMap.get("Sam"));
		System.out.println("Roche's Rank===> "+studentsRankMap.get("Roche"));
		
		CustomHashMap.CustomEntry<String, Integer> removedElement = studentsRankMap.remove("Roche");
		
		System.out.println("Removed key==> "+removedElement.getKey());
		System.out.println("Removed value==> "+removedElement.getValue());
		System.out.println("Roche's next object's key==> "+removedElement.getNext().getKey());
		System.out.println("Roche's next object's value==> "+removedElement.getNext().getValue());
		
		System.out.println("After Removing Roche");
		studentsRankMap.printElements();
	}
}
