package com.scaler.module2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class IntroductionToArrays {

	public static void main(String[] args) {
		//countOfElements();
		
		//reverseArr();
		
		//rotateArr();
		
		//secondLargest();
		
		//rangeSumQuery();
		
		//leadersInArr();
		
		//minMaxClosest();
		
		//linkedListPalindrome();
		
		//inOrderTree();
		
		//equilibrium();
		
		//reorderList();
		
		partitionList();
	}
	/*Given an array A of N integers. 
	Count the number of elements that have at least 1 elements greater than itself.*/
	private static void countOfElements() {
		int[] A = {1,2,3,6,6,4,5};
		int max = Integer.MIN_VALUE;
		int count = 0;
		for (int i = 0; i < A.length; i++) {
			if(max < A[i]) {
				max = A[i];
				count = 1;
			}else if(A[i] == max) {
				count++;
			}
		}
		System.out.println(A.length-count);
	}

	private static void reverseArr() {
		int[] A = {1,2,3,4};
		int i=0;
		int j=A.length-1;
		while(i < j) {
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
			i++;
			j--;
		}
		System.out.println(Arrays.toString(A));
	}
	
	private static void rotateArr() {
		int[] A = {1,2,3,4};
		int k = 2;
		reverseArr(A, 0, A.length-1);
		if(k > A.length) {
			k = k % A.length;
		}
		reverseArr(A, 0, k-1);
		reverseArr(A, k, A.length-1);
		System.out.println(Arrays.toString(A));
	}
	private static void reverseArr(int[] A, int i, int j){
		while(i < j) {
			int temp = A[i];
			A[i] = A[j];
			A[j] = temp;
			i++;
			j--;
		}
	}
	
	private static void secondLargest() {
		List<Integer> list = Arrays.asList(1,2,3);
		System.out.println(list.stream().sorted(Collections.reverseOrder()).skip(1).findFirst().get());
	}
	
	private static void rangeSumQuery() {
		int[] A = {1,2,3,4};
		for (int i = 1; i < A.length; i++) {
			A[i] = A[i-1] + A[i];
		}
		
		int l = 1;
		int r = 2;
		int sum = 0;
		if(l == 0) {
			sum = A[r];
		}else {
			sum = A[r] - A[l-1];
		}
		System.out.println(sum);
	}
	
	
	private static void leadersInArr() {
		int[] A = {16, 17, 4, 3, 5, 2};
		//17, 5,2
		List<Integer> list = new ArrayList<Integer>();
		int leader = A[A.length-1];
		list.add(leader);
		for (int i = A.length-2; i >= 0; i--) {
			if(A[i] > leader) {
				leader = A[i];
				list.add(leader);
			}
		}
		System.out.println(list);
	}
	
	private static void minMaxClosest() {
		int[] A = {1, 4, 3, 0, 2};
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			if(min > A[i]) {
				min = A[i];
			}else if(max < A[i]) {
				max = A[i];
			}
		}
		System.out.println(min + " "+max);
		int minIndex = -1;
		int maxIndex = -1;
		int ans = A.length;
		for (int i = 0; i < A.length; i++) {
			if(min == A[i]) {
				minIndex = i;
				if(maxIndex != -1) {
					int indexSum = (maxIndex > minIndex) ? maxIndex-minIndex+1 : minIndex-maxIndex+1;
					if(ans > indexSum) {
						ans = indexSum;
					}
				}
			}else if(max == A[i]){
				maxIndex = i;
				if(minIndex != -1) {
					int indexSum = (maxIndex > minIndex) ? maxIndex-minIndex+1 : minIndex-maxIndex+1;
					if(ans > indexSum) {
						ans = indexSum;
					}
				}
			}
		}
		System.out.println("ans :"+ans);
	}
	
	private static void linkedListPalindrome() {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next = new ListNode(60);
		//head.next.next.next.next = new ListNode(10);
		
		printLL(head);
		ListNode temp = head;
		
		ListNode dummy = new ListNode(-1);
		ListNode head2 = dummy;
		while(temp != null) {
			dummy.next = new ListNode(temp.value);
			temp = temp.next;
			dummy = dummy.next;
		}
		
		temp = reverseLL(head2.next);
		
		printLL(temp);
		printLL(head);
	}
	
	private static ListNode reverseLL(ListNode head) {
		ListNode curr = head;
		ListNode prev = null;
		ListNode temp = null;
		while(curr != null) {
			temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}
	
	private static void reorderList() {
		ListNode head = new ListNode(10);
		head.next = new ListNode(20);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(40);
		head.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next = new ListNode(60);
		printLL(head);
		
		ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
         
        ListNode curr = slow;
        ListNode prev = null;
        ListNode temp = slow;
        while(curr != null){
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;            
        }

        ListNode dummy = new ListNode(-1);
        ListNode ansList = dummy;
        ListNode reversedList = prev;
        while(head.next != null){
            dummy.next = new ListNode(head.value);
            dummy = dummy.next;
            head = head.next;
            dummy.next = new ListNode(reversedList.value);
            dummy = dummy.next;
            reversedList = reversedList.next;
        }
        if(reversedList != null){
            dummy.next = new ListNode(reversedList.value);
        }
        printLL(ansList.next);
	}
	
	private static void partitionList() {
		ListNode head = new ListNode(10);
		head.next = new ListNode(40);
		head.next.next = new ListNode(30);
		head.next.next.next = new ListNode(20);
		head.next.next.next.next = new ListNode(50);
		head.next.next.next.next.next = new ListNode(20);
		printLL(head);
		int B = 30;
		
		ListNode small = new ListNode(-1);
		ListNode smallHead = small;
		ListNode high = new ListNode(-1);
		ListNode highHead = high;
		while(head != null) {
			if(head.value < B) {
				small.next = new ListNode(head.value);
				small = small.next;
			}else {
				high.next = new ListNode(head.value);
				high = high.next;
			}
			head = head.next;
		}
		high.next = null;
		small.next = highHead.next;
		printLL(smallHead.next);
	}
	
	private static void printLL(ListNode print) {
		System.out.println();
		while(print != null) {
			System.out.print(print.value+" ");
			print = print.next;
		}
	}
	
	
	
	private static void inOrderTree() {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(4);
		head.right = new TreeNode(2);
		
		
	}
	
	
	private static void equilibrium() {
		int[] A = {1,2,3};
	}
	
	private TreeNode construct(int[] A, int[] B, int iStartIdx, int iEndIdx, int pStartIdx, int pEndIdx) {
		if(iStartIdx > iEndIdx) {
			return null;
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		TreeNode root = new TreeNode(B[pEndIdx]);
		int index = map.get(B[pEndIdx]);
		int leftCount = index - iStartIdx;
		root.left = construct(A, B, iStartIdx, index-1, pStartIdx, pStartIdx+leftCount-1);
		root.right = construct(A, B, index+1, iEndIdx, pStartIdx+leftCount, pEndIdx-1);
		return root;
	}
	
	private static void verticalOrder() {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(4);
		head.right = new TreeNode(2);
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<VerticalPar> queue = new LinkedList<>();
		queue.add(new VerticalPar(head, 0));
		while(!queue.isEmpty()) {
			VerticalPar pair = queue.poll();
			TreeNode node = pair.node;
			int level = pair.level;
			
			List<Integer> list = map.getOrDefault(level, new ArrayList<>());
			list.add(node.value);
			map.put(level, list);
			
			if(node.left != null) {
				queue.add(new VerticalPar(node.left, level-1));
			}
			
			if(node.right != null) {
				queue.add(new VerticalPar(node.right, level+1));
			}
			
		}
	}
}

class ListNode{
	int value;
	ListNode next;
	public ListNode(int value) {
		this.value = value;
		this.next = null;
	}
}

class TreeNode{
	int value;
	TreeNode left;
	TreeNode right;
	public TreeNode(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
class VerticalPar{
	TreeNode node;
	int level;
	public VerticalPar(TreeNode node, int level) {
		this.node = node;
		this.level = level;
	}
}
