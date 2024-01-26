package com.scaler.advanced.dsa3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class Contest4 {

	public static void main(String[] args) {
		//check();
		
		slidingMaximum();
	}

	private static void check() {
		String A = "]]][][[]]][]";
		int opening = 0;
		int closing = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < A.length(); i++) {
			if(A.charAt(i) == '[') {
				stack.push(A.charAt(i));
			}else {
				if(stack.size() == 0) {
					closing++;
				}else {
					stack.pop();
				}
			}
		}
		opening = stack.size();
		System.out.println(((closing+1)/2)+((opening+1)/2));
	}
	
	public static int[] slidingMaximum() {
		int[] A = {10,9,8,7,6,5,4,3,2,1};
		int B = 2;
        LinkedList<Integer> linkedList = new LinkedList<>();
        int[] ans = new int[A.length-B+1];
        int index = 1;
        for(int i=0; i<B; i++){
            while(linkedList.size() > 0 && A[linkedList.getLast()] <= A[i]){
                linkedList.removeLast();
            }
            linkedList.addLast(i);
        }
        ans[0] = A[linkedList.getFirst()];
        for(int i=B; i<A.length; i++){
            while(linkedList.size() > 0 && A[linkedList.getLast()] <= A[i]){
                linkedList.removeLast();
            }
            linkedList.addLast(i);

            if(linkedList.getFirst() <= i-B){
                linkedList.removeFirst();
            }
            ans[index] = A[linkedList.getFirst()];
            index++;
        }
        System.out.println(Arrays.toString(ans));
        return ans;
    }
}
