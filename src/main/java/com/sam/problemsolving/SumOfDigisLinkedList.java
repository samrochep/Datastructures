package com.sam.problemsolving;

public class SumOfDigisLinkedList {
    
	private static LinkedListHelperClass <Integer> helper = new LinkedListHelperClass<Integer>();
	
	public static void main(String[] args) {
		SingleLinkedListNode<Integer> node1 = helper.createLinkedList(new Integer []{9,9,3,4});
		SingleLinkedListNode<Integer> node2 = helper.createLinkedList(new Integer []{5,6,7});
		int node1Size = helper.size(node1);
		int node2Size = helper.size(node2);
		if(node1Size<node2Size)
			node1 = helper.addLeadingNodes(node1, 0, node2Size-node1Size);
		else if(node1Size>node2Size)
			node2 = helper.addLeadingNodes(node2, 0, node1Size-node2Size);
		SumResultWrapper result = addLists(node1,node2);
		if(result.getCarry()>0) {
			result.setResult(helper.insertBefore(result.getResult(), result.getCarry()));
		}
		SingleLinkedListNode<Integer> resultNode = result.getResult();
		helper.printElements(resultNode);
	}

	private static SumResultWrapper addLists(SingleLinkedListNode<Integer> node1, 
			SingleLinkedListNode<Integer> node2) {
		if(node1==null && node2==null) {
			return new SumResultWrapper();
		}	
		SumResultWrapper prevResult = addLists(node1==null?null:node1.getNext(),
				node2==null?null:node2.getNext());
		int sum = 0;
		if(node1!=null)
			sum+=node1.getElementData();
		if(node2!=null)
			sum+=node2.getElementData();
		if(prevResult!=null)
			sum+=prevResult.getCarry();	
		
		return new SumResultWrapper(new SingleLinkedListNode<Integer>
		(sum%10,prevResult.getResult()),sum/10);	
	}

}
