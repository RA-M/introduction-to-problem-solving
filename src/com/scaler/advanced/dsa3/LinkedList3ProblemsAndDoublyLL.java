package com.scaler.advanced.dsa3;

public class LinkedList3ProblemsAndDoublyLL extends LinkedList1Introduction{

	public static void main(String[] args) {
		copyList();
	}
	
	private static void copyList() {
		ListNode A = createLinkedList();
		ListNode temp = A;
		ListNode newNode = null;
		while(temp != null) {
			newNode = new ListNode(temp.value);
			newNode.next = temp.next;
			temp.next = newNode;
			temp = temp.next.next;
		}
		printLinkedList(A);
		
		/*ListNode clonedHead = A.next;
		ListNode t1 = A;
		ListNode t2 = clonedHead;
		while (t2.next != null) {
			 t1.next = t1.next.next;
			 t2.next = t2.next.next;
			 t1 = t1.next;
			 t2 = t2.next;
		}
		t1.next = null;*/
		
		temp = A.next;
        while(temp.next!=null){
            temp.next = temp.next.next;
            temp = temp.next;
        }
        
		printLinkedList(A.next);
		printLinkedList(A);
	}

}
