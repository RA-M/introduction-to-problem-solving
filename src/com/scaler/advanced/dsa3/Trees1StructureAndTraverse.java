package com.scaler.advanced.dsa3;

import java.util.Stack;

public class Trees1StructureAndTraverse {

	public static void main(String[] args) {

	}
	private static void iterativeInOrderTraverse() {
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = null;
		while(!stack.empty() || current != null) {
			while(current != null) {
				stack.push(current.left);
				current = current.left;
			}
			current = stack.pop();
			System.out.println(current.value);
			current = current.right;
		}
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
