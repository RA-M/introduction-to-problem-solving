package com.scaler;

import java.util.HashMap;

public class LinkedListBasics {

	public static void main(String[] args) {
		
		LinkedListNode linkedListNode = new LinkedListNode(10);
		linkedListNode.next = new LinkedListNode(20);
		linkedListNode.next.next = new LinkedListNode(30); 
		linkedListNode.next.next.next = new LinkedListNode(40);
		
		insertIntoLinkedList(linkedListNode);
		printLinkedList(linkedListNode);
		
		findElementInLinkedList(linkedListNode);
		
	}
	
	private static void printLinkedList(LinkedListNode linkedListNode) {
		LinkedListNode temp = linkedListNode;
		while(temp != null) {
			System.out.println(temp.val);
			temp = temp.next;
		}
	}
	
	private static void insertIntoLinkedList(LinkedListNode linkedListNode) {
		int value = 50;
		int index = 2;
		LinkedListNode temp = linkedListNode;
		LinkedListNode newNode = new LinkedListNode(value);
		for (int i = 1; i < index; i++) {
			if(temp != null) {
				temp = temp.next;
			}
		}
		newNode.next = temp.next;
		temp.next = newNode;
	}

	private static void findElementInLinkedList(LinkedListNode linkedListNode) {
		LinkedListNode temp = linkedListNode;
		int element = 2;
		for (int i = 0; i < element; i++) {
			if(temp != null) {
				temp = temp.next;
			}
		}
		System.out.println("Element "+temp.val);
	}
	
	private static void compareLinkedList(LinkedListNode listNode1, LinkedListNode listNode2) {
		LinkedListNode temp1 = listNode1;
		LinkedListNode temp2 = listNode2;
		while (temp1 != null) {
			if(temp2 == null) {
				//Not Equal
			}
			if(temp1.val != temp2.val) {
				//not Equal
			}
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		if(temp2 != null) {
			//Not Equal
		}
		//Else Equal
	}
	
}
