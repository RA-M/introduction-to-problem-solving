package com.scaler;

public class TreeBasics {
	public static int sum = 0;
	
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(10);
		treeNode.left = new TreeNode(12);
		treeNode.right = new TreeNode(13);
		treeNode.left.left = new TreeNode(11);
		treeNode.right.left = new TreeNode(22);
		
		System.out.println("Pre Order Traverse");
		preOrderTraverse(treeNode);
		
		System.out.println();
		System.out.println("Post Order Traverse");
		postOrderTraverse(treeNode);
		
		System.out.println();
		System.out.println("In Order Traverse");
		inOrderTraverse(treeNode);
		
		System.out.println();
		System.out.println("Size of Tree :"+sizeOfTree(treeNode));
		
		System.out.println();
		System.out.println("Hight of Tree :"+hightOfTree(treeNode));
		
		System.out.println();
		sumOfLeftLeaves(treeNode);
		System.out.println("Sum Of Left Leaves :"+sum);
		
	}
	private static void preOrderTraverse(TreeNode treeNode) {
		if(treeNode == null) {
			return;
		}
		System.out.print(treeNode.val+" ");
		preOrderTraverse(treeNode.left);
		preOrderTraverse(treeNode.right);
	}
	
	private static void postOrderTraverse(TreeNode treeNode) {
		if(treeNode == null) {
			return;
		}
		postOrderTraverse(treeNode.left);
		postOrderTraverse(treeNode.right);
		System.out.print(treeNode.val+" ");
	}
	
	private static void inOrderTraverse(TreeNode treeNode) {
		if(treeNode == null) {
			return;
		}
		inOrderTraverse(treeNode.left);
		System.out.print(treeNode.val+" ");
		inOrderTraverse(treeNode.right);
	}
	
	private static int sizeOfTree(TreeNode treeNode) {
		if(treeNode == null) {
			return 0;
		}
		return sizeOfTree(treeNode.left)+sizeOfTree(treeNode.right)+1;
	}
	
	//On the basis of Node so that's why return 0
	//If it is on the basis of edges then return -1
	private static int hightOfTree(TreeNode treeNode) {
		if(treeNode == null) {
			return 0;
		}
		int leftHight = hightOfTree(treeNode.left);
		int rightHight = hightOfTree(treeNode.right);
		return Integer.max(leftHight, rightHight)+1;
	}
	
	private static void sumOfLeftLeaves(TreeNode treeNode) {
		if(treeNode == null) {
			return;
		}
		if(treeNode.left != null && treeNode.left.left == null && treeNode.left.right == null) {
			sum+= treeNode.left.val;
		}
		sumOfLeftLeaves(treeNode.left);
		sumOfLeftLeaves(treeNode.right);
	}
}
