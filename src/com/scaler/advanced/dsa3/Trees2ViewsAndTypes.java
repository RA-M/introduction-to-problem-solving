package com.scaler.advanced.dsa3;

import java.util.LinkedList;
import java.util.Queue;

public class Trees2ViewsAndTypes {

	public static void main(String[] args) {
		TreeNode2 node = new TreeNode2(3);
		node.left = new TreeNode2(9);
		node.right = new TreeNode2(20);
		node.right.left = new TreeNode2(15);
		node.right.right = new TreeNode2(7);
		
		//levelOrderTraverse(node);
		
		rightViewOfBinaryTree(node);
		
	}
	
	private static void levelOrderTraverse(TreeNode2 node) {
		Queue<TreeNode2> queue = new LinkedList<TreeNode2>();
		queue.add(node);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 1; i <= size; i++) {
				TreeNode2 current = queue.poll();
				System.out.print(current.value+" ");
				if(current.left != null) {
					queue.add(current.left);
				}
				if(current.right != null) {
					queue.add(current.right);
				}
			}
			System.out.println();
		}
	}
	
	private static void rightViewOfBinaryTree(TreeNode2 node) {
		Queue<TreeNode2> queue = new LinkedList<>();
		queue.add(node);
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 1; i <= size; i++) {
				TreeNode2 current = queue.poll();
				if(i == size) {
					System.out.println(current.value);
				}
				if(current.left != null) {
					queue.add(current.left);
				}
				if(current.right != null) {
					queue.add(current.right);
				}
			}
		}
	}

}

class TreeNode2{
	int value;
	TreeNode2 left;
	TreeNode2 right;
	public TreeNode2(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}
