package com.scaler;

public class Recursion {

	public static void main(String[] args) {
		String ansStr = "";
		String str = "RAM";
		//System.out.println(printReverseString(str, ansStr, str.length()-1));
		
		
		//sumOfAllDigits();
		
		//printDescendingOrder(10);
		
		//findPower();
		
		//powerMod();
		
		//power1();
		
		isMagicNumber();
	}
	
	public static String printReverseString(String str, String ansStr, int end){
		ansStr += str.charAt(end);
		if(end == 0) {
			return ansStr;
		}
		
        return printReverseString(str, ansStr, end-1);
    }

	public static void sumOfAllDigits() {
		int A = 123;
        int sum = 0;
        int nextNum = A % 10;
        System.out.println(sumOfDigits(A/10, nextNum, sum));
    }
    public static int sumOfDigits(int A, int nextNum, int sum){
        sum += nextNum;
        if(A == 0){
            return sum;
        }
        return sumOfDigits(A/10, A%10, sum);
    }
    
    public static void printDescendingOrder(int A) {
        if(A == 0){
            return;
        }
        System.out.print(A+" ");
        printDescendingOrder(A-1);
        //System.out.println();
    }
    
    /*
    Implement pow(A, B).
	 In other words, given A and B Find (A^B). 
    */
    private static void findPower() {
    	int A = -1;
    	int B = 1;
    	int C = 20;
    	System.out.println(findPower(A, B) % C);
	}
    private static int findPower(int A, int B) {	
    	//2*2*2
    	if(B == 0) {
    		return 1;
    	}
    	return findPower(A, B-1) * A;
	}
    
    /*
    Implement pow(A, B).
	 In other words, given A and B Find (A^B). 
    */
    private static void power1() {
    	System.out.println(power1(2,5));
	}
    private static int power1(int A, int B) {
    	if(B == 0) {
    		return 1;
    	}
    	int power = power1(A, B/2);
    	if(B % 2 == 0) {
    		return power * power;
    	}else {
    		return power * power * A;
    	}
	}
    
    private static void powerMod() {
    	System.out.println(powerMod(-1,1,20));
	}
    private static int powerMod(int A, int B, int C) {
    	if(B == 0) {
    		return 1;
    	}
    	long power = (long)powerMod(A, B/2, C);
    	if(B % 2 == 0) {
    		return (int)((power * power)%C);
    	}else {
    		return (int)(((power * power)%C * (A%C)) % C);
    	}
	}
    
    /*
     Given a number A, check if it is a magic number or not.
	 A number is said to be a magic number if the sum of its digits is calculated 
	 till a single digit recursively by adding the sum of the digits after every addition. 
	 If the single digit comes out to be 1, then the number is a magic number. 
     */
    private static void isMagicNumber() {
    	int A = 1234;
    	 int a=magicNumber(A);
         while(a>=10)
         {
             a=magicNumber(a);
         }
         System.out.println(a==1 ? 1 :0); 
	}
    private static int magicNumber(int n) {
    	if(n == 0) {
    		return 0;
    	}
    	int num = n%10 + magicNumber(n/10);
    	System.out.println(num);
    	return num;
	}
}
