package com.scaler.advanced.dsa3;

public class LinkedList1Introduction {

	public static void main(String[] args) {
		//createLinkedList();
		
		//removeNthFromEnd();
		
		//removeDuplicatesFromSortedLinkedList();
		
		//reverseLinkedList();
		
		//lPalin();
		
		//swapListNodesInPairs();
		
		kReverseLinkedList();
	}
	public static void printLinkedList(ListNode A) {
		ListNode temp = A;
		while(temp != null) {
			System.out.print(temp.value+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static ListNode createLinkedList() {
		ListNode node = new ListNode(1);
		ListNode temp = node;
		for (int i = 2; i <= 5; i++) {
			ListNode newNode = new ListNode(i);
			temp.next = newNode;
			temp = temp.next;
		}
		//ListNode newNode = new ListNode(5);
		//temp.next = newNode;
		//printLinkedList(node);
		return node;
	}
	/*
	 Given a linked list A, remove the B-th node from the end of the list and return its head. 
	 For example, Given linked list: 1->2->3->4->5, and B = 2. After removing the second node 
	 from the end, the linked list becomes 1->2->3->5. NOTE: If B is greater than the size of 
	 the list, remove the first node of the list. NOTE: Try doing it using constant additional space. 
	 */
	private static void removeNthFromEnd() {
		ListNode A = createLinkedList();
		System.out.println("Before remove element");
		printLinkedList(A);
		int B = 7;
		ListNode temp = A;
		int size = 0;
		while(temp != null) {
			size++;
			temp = temp.next;
		}
		System.out.println("Size of LinkedList :"+size);
		int xFromStart = size-B+1;
		if(B == size || xFromStart <= 0) {
			A = A.next;
			System.out.println("After remove element");
			printLinkedList(A);
			return;
		}
		System.out.println(xFromStart);
		temp = A;
		for (int i = 1; i < xFromStart-1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		System.out.println("After remove element");
		printLinkedList(A);
	}
	
	private static void removeDuplicatesFromSortedLinkedList() {
		ListNode A = createLinkedList();
		printLinkedList(A);
		
		ListNode temp = A;
		while(temp.next != null) {
			if(temp.value == temp.next.value) {
				if(temp.next != null) {
					temp.next = temp.next.next;
				}
			}else {
				temp = temp.next;
			}
		}
		printLinkedList(A);
	}
	
	private static void reverseLinkedList() {
		ListNode A = createLinkedList();
		ListNode temp = A;
		ListNode current = temp;
		ListNode previous = null;
		while(current != null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		A = previous;
		printLinkedList(A);
	}
	
	public static int lPalin() {
		ListNode A = createLinkedList();
		printLinkedList(A);
		ListNode fast = A.next;
		ListNode slow = A;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// reverse the second half

		ListNode prev = null;
		ListNode temp = null;
		ListNode curr = slow;

		while (curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}

		// compare the first list value with the second list
		while (prev.next != null) {
			if (A.value != prev.value)
				return 0;
			prev = prev.next;
			A = A.next;
		}

		return 1;
        
    }
	
	
	private static void swapListNodesInPairs() {
		ListNode A = createLinkedList();
		ListNode head = A;
		ListNode tail = A;
		while(head!=null)
		{
			if (head.next != null) {
				tail = head.next;
				int val1 = tail.value;
				tail.value = head.value;
				head.value = val1;
				head = tail.next;
			} else {
				break;
			}
		}
	}
	
	
	private static void kReverseLinkedList() {
		ListNode A = createLinkedList();
		printLinkedList(A);
		int k = 2;
		ListNode current = A;
		ListNode prev = null;
		ListNode temp = null;
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;
		
		while(current != null) {
			prev = null;
			for (int i = 0; i < k; i++) {
				if(current.next != null) {
					temp = current.next;
				}else {
					temp = null;
				}
				current.next = prev;
				prev = current;
				current = temp;	
			}
			tail.next = prev;
			while(tail.next != null) {
				tail = tail.next;
			}
		}
		printLinkedList(dummy.next);
	}
	
	private void palindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode temp = slow;
		ListNode prev = null;
		ListNode curr = slow;
		while(curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		while(prev != null) {
			if(prev.value != head.value) {
				return;
			}
			prev = prev.next;
			curr = curr.next;
		}
	}
	
}

class ListNode {
	int value;
	ListNode next;
	ListNode(int value) {
		this.value = value;
		next = null;
	}
}