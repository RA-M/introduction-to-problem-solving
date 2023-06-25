package com.scaler;

import java.util.Arrays;

public class BitManipulations {

	public static void main(String[] args) {
		
		/*int ans = 1;
		for (int i = 1; i <= 4; i++) {
			ans = ((ans%7) * (3%7)) % 7;
			
		}
		System.out.println(ans);*/
		
		
		//anyBaseToDecimal();
		
		//decimalToAnyBase();
		
		//singleNumber();
		
		//findMinimumValue();
		
		//convertArr();
		
		//meth();
		
		//checkBthBitIsSet();
		
		//numOfSetBits();
		
		//setBit();
		
		//unsetBthBit();
		
		//count1sn();
		
		//findMagicNo();
		
		//reverseBits();
		
		//modOfArray();
		
		//reverseBit1();
		
		solve4();
		
		//solve1();
		
		//solve2();
	}
	
	/*
	 You are given a number A. You are also given a base B. A is a number on base B.
	 You are required to convert the number A into its corresponding value in decimal number system.
	 A = 1010
	 B = 2 
	 O/P: 10
	 
	 A = 22 
	 B = 3
	 O/P: 8
	 */
	private static void anyBaseToDecimal() {
		int A = 1010;
		int B = 2;
		int ans = 0;
		int power = 1;
		while(A > 0) {
			int rem = A % 10;
			A = A/10;
			ans += (rem * power);
			power *= B;
		}
		System.out.println(ans);
	}
	
	private static void decimalToAnyBase() {
		int A = 4;
		int B = 2;
		int ans = 0;
		int power = 1;
		while(A > 0) {
			int rem = A % B;
			A = A / B;
			ans += (rem * power);
			power *= 10;
		}
		System.out.println(ans);
	}
	/*
	 Given an array of integers A, every element appears twice except for one. Find that integer that occurs once.

NOTE: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 
	 */
	public static void singleNumber() {
		int[] A = {1, 2, 2};
        int ans = 0;
        for(int i=0; i<A.length; i++){
            ans = ans ^ A[i];
        }
        System.out.println(ans);
    }
	
	
	private static void findMinimumValue() {
		System.out.println(4 ^ 9);
	}
	
	private static void convertArr() {
		int[] A = {1};
		int temp = 0;
		int ans = 0;
		for (int i = 0; i < A.length; i++) {
			ans = ans ^ A[i];
		}
		if(ans % 2 == 0) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}

	private static void meth() {
		int[] B = { 1, 0, 1 };
		int A = 3;
		int possibleSubArraysForThisIndex = 0;
		int result = 0;
		for (int i = 0; i < A; i++) {
			if (B[i] == 1) {
				possibleSubArraysForThisIndex = i + 1;
			}
			result = result + possibleSubArraysForThisIndex;
		}
		System.out.println(result);
	}
	
	//=============================================================================
	//BitManipulation 2
	
	/*
	 You are given two integers A and B.
	 Return 1 if B-th bit in A is set
	 Return 0 if B-th bit in A is unset
	Note:
	 The bit position is 0-indexed, which means that the least significant bit (LSB) has index 0. 
	 */
	private static void checkBthBitIsSet() {
		int A = 45;
		int B = 1;
		if(((A >> B) & 1) == 1){
			System.out.println("Bth Bit is set :"+1);
		}else {
			System.out.println("Bth Bit is unset :"+0);
		}
	}
	
	/*
	 Write a function that takes an integer and returns the number of 1 bits 
	 present in its binary representation. 
	 */
	//TC: O(logn)
	private static void numOfSetBits() {
		int A = 45;
		int count = 0;
		while(A > 0) {
			if((A & 1) == 1) {
				count ++;
			}
			A = (A >> 1);
		}
		System.out.println(count);
	}
	
	/*
	 You are given two integers A and B.
	 Set the A-th bit and B-th bit in 0, and return output in decimal Number System.

	Note:
	 The bit positions are 0-indexed, which means that the least significant bit (LSB) has index 0. 
	 */
	private static void setBit() {
		int n = 0;
		int A = 3;
		int B = 5;
		n = (n | (1 << A));
		n = (n | (1 << B));
		
		System.out.println(n);
		
		
		/*if (A != B) {
			System.out.println((1 << A));
			System.out.println((1 << B));
            System.out.println((1 << A) + (1 << B));
        }else {
        	System.out.println((1 << A));
        }*/
	}
	
	private static void unsetBthBit() {
		int A = 4;
		int B = 1;
		
		if(((A >> B) & 1) == 1) {
			System.out.println((A ^ (1 << B)));
		}else {
			System.out.println(A);
		}
	}
	
	private static void count1sn() {
		int A = 3;
		int count = 0;
		while(A > 0) {
			if((A&1) == 1) {
				count++;
			}
			A = (A >> 1);
		}
		System.out.println(count);
	}
	
	/*
	  
	 */
	private static void findMagicNo() {
		int sum = 0;
		int A = 10;
		int power = 1;
		while(A > 0) {
			if((A & 1) == 1) {
				sum = sum + (int)Math.pow(5, power);
			}
			power++;
			A = (A >> 1);
		}
		System.out.println(sum);
	}
	
	private static void reverseBits() {
		long A = 3;
		long N = 0;
		int i = 0;
		long one = 1;
		while(A > 0) {
			if((A & 1) == 1) {
				N = (N | (one << (31 - i)));
			}
			i++;
			A = (A >> 1);
		}
		System.out.println(N);
	}
	
	private static void modOfArray() {
		int[] A = {4, 3, 5, 3, 5, 3, 2, 1};
		/*int B = 47;
		long ans = 0;
		int power = 1;
		for (int i = A.length-1; i >= 0; i--) {
			ans = (ans + A[i]*power) % B;
			power = (power * 10) % B;
		}
		System.out.println(ans);*/
		int cost = 0;
		int multiple = 1;
		for (int i = 0; i < A.length; i++) {
			cost = cost+A[i]*multiple;
		}
	}
	
	private static void reverseBit1() {
		long num = 0;
		long A = 3;//0011
		int i = 0;
		long one = 1;
		while(A > 0) {
			if((A & 1) == 1) {
				num = num | (one << (31 - i));
			}
			i++;
			A = (A >> 1);
		}
		System.out.println(num);
	}
//==================================================================================
	//Contest
//==================================================================================
	public int solve2(int[] A) {
        //{3,5,4,7,7}
        long product = 1;
        if(A.length == 0 || A.length == 1){
            return 0;
        }
        for(int i=0; i<A.length-1; i++){
            if(A[i] < A[i+1]){
                product = (product)%(long) 1000000007 * ((long)A[i+1])%(long) 1000000007 ;
            }
        }
        if(product == 1) {
        	return 0;
        }
        product = product % (long) 1000000007;
    return (int)product;
    }
	public static String solve4() {
		final int[] A = {1,7,5,3,9};
		final int B = 2;
        Arrays.sort(A);
        //
        for(int i=1; i<A.length; i++){
            if(A[i] - A[i-1] != B){
                return "No";
            }
        }
    return "Yes";
    }
	public static void solve2() {
		int A = 21;
		int B = 1;
		int C = 3;
        int bit = 0;
        
        for (int i = B; i < C; i++) {
			if((A & (1 << i)) != 0) {
				A = (A ^ (1<<i));
			}
		}
        System.out.println(A);
    }
}
