package com.scaler.advanced.dsa3;

public class LinkedList2SortingAndDetectingLoop extends LinkedList1Introduction{

	public static void main(String[] args) {
		
		//addTwoNumbers();
		
		//mergeTwoSortedLinkedList();
		
		//sortALinkedList();
		
		deleteDuplicates();
	}
	
	
	public static void addTwoNumbers() {
		/*ListNode A = createLinkedList();
		ListNode B = createLinkedList();
		*/
		
		ListNode A = new ListNode(9);
		ListNode temp1 = A;
		for (int i = 1; i <= 7; i++) {
			temp1.next = new ListNode(9);
			temp1 = temp1.next;
		}
		ListNode B = new ListNode(9);
		temp1 = B;
		for (int i = 1; i <= 4; i++) {
			temp1.next = new ListNode(9);
			temp1 = temp1.next;
		}
		
		printLinkedList(A);
		printLinkedList(B);
		int num1 = 0;
		int num2 = 0;
		int sum = 0;
		int carry = 0;
		int nodeNum = 0;
		ListNode dummy = new ListNode(-1);
		ListNode newNode = null;
		ListNode temp = dummy;
		while(A != null || B != null) {
			num1 = (A != null) ? A.value : 0;
			num2 = (B != null) ? B.value : 0;
			sum = num1 + num2 + carry;
			nodeNum = sum%10;
			carry = sum/10;
			newNode = new ListNode(nodeNum);
			temp.next = newNode;
			temp = temp.next;
			if(A != null) {
				A = A.next;
			}
			if(B != null) {
				B = B.next;
			}
		}
		if(carry != 0) {
			newNode = new ListNode(carry);
			temp.next = newNode;
			temp = temp.next;
		}
		printLinkedList(dummy.next);
	}
	
	private static void mergeTwoSortedLinkedList() {
		ListNode A = new ListNode(1);
		A.next = new ListNode(3);
		A.next.next = new ListNode(5);
		
		ListNode B = new ListNode(4);
		
		ListNode dummy = new ListNode(-1);
		ListNode tail = dummy;
		ListNode head = dummy;
		ListNode t1 = A;
		ListNode t2 = B;
		
		while(t1 != null && t2 != null) {
			if(t1.value <= t2.value) {
				tail.next = t1;
				tail = tail.next;
				t1 = t1.next;
			}else {
				tail.next = t2;
				tail = tail.next;
				t2 = t2.next;
			}
		}
		if(t1 != null) {
			tail.next = t1;
		}
		if(t2 != null) {
			tail.next = t2;
		}
		printLinkedList(dummy.next);
	}
	//Sort a LinkedList using MergeSort recursion
	private static void sortALinkedList() {
		ListNode A = new ListNode(1);
		A.next = new ListNode(5);
		A.next.next = new ListNode(3);
		mergeSort(A);
		printLinkedList(A);
		
	}
	private static ListNode mergeSort(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode mid = getMiddle(head);
		
		ListNode h1 = head;
		ListNode h2 = mid.next;
		mid.next = null;
		
		h1 = mergeSort(h1);
		h2 = mergeSort(h2);
		return mergeTwoSortedLL(h1, h2);
	}
	private static ListNode mergeTwoSortedLL(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(-1);
		ListNode t1 = head1;
		ListNode t2 = head2;
		ListNode tail = dummy;
		while(t1 != null && t2 != null) {
			if(t1.value <= t2.value) {
				tail.next = t1;
				tail = tail.next;
				t1 = t1.next;
			}else {
				tail.next = t2;
				tail = tail.next;
				t2 = t2.next;
			}
		}
		if(t1 != null) {
			tail.next = t1;
		}
		if(t2 != null) {
			tail.next = t2;
		}
		return dummy.next;
	}
	private static ListNode getMiddle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}
	
	
	public static ListNode deleteDuplicates() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(2);
        ListNode temp = head;
        while(temp.next != null){
            if(temp.value == temp.next.value){
                temp.next = temp.next.next;
            }else {
            	temp = temp.next;
            }
        }
        printLinkedList(head);
        return head;
    }
}
