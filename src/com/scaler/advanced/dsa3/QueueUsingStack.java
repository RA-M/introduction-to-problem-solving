package com.scaler.advanced.dsa3;

import java.util.Stack;

public class QueueUsingStack {

	private static Stack<Integer> stack1 = new Stack<>();
	private static Stack<Integer> stack2 = new Stack<>();
	
	public static void main(String[] args) {

		push(10);
		push(20);
		push(30);
		push(40);
		
		System.out.println(peek());
		
		pop();
		
		System.out.println(peek());
		
		push(50);
		pop();
		pop();
		pop();
		pop();
		System.out.println(empty());
	}
	
	static void push(int X) {
		stack1.push(X);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    static int pop() {
        if(stack2.isEmpty()) {
        	while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
        }
        return stack2.pop();
    }
    
    /** Get the front element of the queue. */
    static int peek() {
    	if(stack2.isEmpty()) {
        	while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
        }
        return stack2.peek();
    }
    
    /** Returns whether the queue is empty. */
    static boolean empty() {
        if(stack1.isEmpty() && stack2.isEmpty()) {
        	return true;
        }
        return false;
    }

}
