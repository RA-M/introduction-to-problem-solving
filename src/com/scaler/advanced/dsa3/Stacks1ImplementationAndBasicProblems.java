package com.scaler.advanced.dsa3;

import java.util.Stack;

public class Stacks1ImplementationAndBasicProblems {

	private static int initialSize = 3;
	private static int[] arr = new int[initialSize];
	private static int topOfStack = -1;
	
	public static void main(String[] args) {
		//implementStack();
		
		//evaluateExpression();
		
		doubleCharacterTrouble();
	}

	private static void implementStack() {
		push(1);
		push(5);
		push(7);
		//push(3);
		//push(2);
		System.out.println("Pushed all elements:");
		printStack();
		
		pop();
		System.out.println();
		System.out.println("Pop");
		printStack();
		pop();
		System.out.println();
		System.out.println("Pop");
		printStack();
		pop();
		System.out.println();
		System.out.println("Pop");
		printStack();
		
		System.out.println();
		System.out.println("Top : "+topOrpeek());
		System.out.println();
		System.out.println("Is Empty: "+isEmpty());
	}
	
	private static void balancedParanthesis() {
		String A = "{([])}";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			if(ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			}else {
				
			}
		}
	}	
	
	private static void push(int n) {
		topOfStack++;
		if(topOfStack > arr.length-1) {
			growSize();
		}
		arr[topOfStack] = n;
	}
	private static void pop() {
		if(topOfStack != -1) {
			topOfStack--;
		}
	}
	private static int topOrpeek() {
		return (topOfStack == -1) ? -1 : arr[topOfStack];
	}
	private static boolean isEmpty() {
		return (topOfStack == -1);
	}
	private static void printStack() {
		for (int i = 0; i <= topOfStack; i++) {
			System.out.print(arr[i]+" ");
		}
	}
	
	public static void growSize() {
		// declares a temp[] array
		int temp[] = null;
		// initialize a double size array of array
		temp = new int[initialSize * 2];
		{
			for (int i = 0; i < initialSize; i++) {
				// copies all the elements of the old array
				temp[i] = arr[i];
			}
		}
		arr = temp;
	}
	

	private static void evaluateExpression() {
		String[] A = {"5"};
		Stack<String> stack = new Stack<>();
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			String str = A[i];
			if(!stack.empty() && (A[i] == "+" || A[i] == "-" || A[i] == "*" || A[i] == "/")) {
				int a2 = Integer.parseInt(stack.peek());
				stack.pop();
				int a1 = Integer.parseInt(stack.peek());
				stack.pop();
				ans = doCalculation(str, a1, a2);
				stack.push(String.valueOf(ans));
			}else {
				stack.push(A[i]);
			}
		}
		System.out.println(stack.peek());
	}
	private static int doCalculation(String operator,int num1, int num2) {
		int ans = 0;
		switch (operator) {
		case "+":
			ans = num1+num2;
			break;
		case "-":
			ans = num1-num2;
			break;
		case "*":
			ans = num1*num2;
			break;
		case "/":
			ans = num1/num2;
			break;
		default:
			break;
		}
		return ans;
	}
	
	private static void doubleCharacterTrouble() {
		String A = "abccbc";
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			if(!stack.empty() && stack.peek().equals(A.charAt(i))) {
				stack.pop();
			}else {
				stack.push(A.charAt(i));
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.empty()) {
			sb.append(stack.peek().toString());
			stack.pop();
		}
		System.out.println(sb.reverse());
	}
}