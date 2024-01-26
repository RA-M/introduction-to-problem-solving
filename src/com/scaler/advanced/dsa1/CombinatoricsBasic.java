package com.scaler.advanced.dsa1;

import java.util.Arrays;

public class CombinatoricsBasic {

	public static void main(String[] args) {
		//excelColomTitle();
		//getExcelColomNumber();
		
		//calculateNCRwithModeM();
		
		//calculateNCRWithModP();
		
		test();
	}
	
	private static void factorial(int num) {
		int ans = 1;
		int temp = 1;
		while(temp <= num) {
			ans = ans * temp;
			temp++;
		}
		System.out.println(ans);
	}
	
	 //Excel Column Title
	/*
	 Given a positive integer A, return its corresponding column title as it appears in an Excel sheet.
	 For example:

	    1 -> A
	    2 -> B
	    3 -> C
	    ...
	    26 -> Z
	    27 -> AA
	    28 -> AB  
	 */
	private static void excelColomTitle() {
		int num = 28;
		int rem = 0;
		char ch;
		StringBuffer sb = new StringBuffer();
		while(num > 0){
			rem = (num-1)%26;
			ch = (char) (rem+'A');
			//sb.append(String.valueOf(ch));
			sb.insert(0, ch);
			num = (num-1)/26;
		}
		//System.out.println(sb.reverse());
		System.out.println(sb);
	}
	
	
	/*
	 *  Compute nCr % m
	 Given three integers A, B, and C, where A represents n, B represents r, and C represents m, 
	 find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
	 x! means factorial of x i.e. x! = 1 * 2 * 3... * x. 
	 */
	private static void calculateNCRwithModeM() {
		int A = 6;
		int B = 2;
		int C = 13;
		int[][] twoDArr = new int[A+1][B+1];
		
		for (int i = 0; i < twoDArr.length; i++) {
			for (int j = 0; j < twoDArr[0].length; j++) {
				if(j==0) {
					twoDArr[i][j] = 1;
				}else if(i != 0){
					twoDArr[i][j] = (twoDArr[i-1][j]+twoDArr[i-1][j-1])%C;
				}
			}
		}
		print2DArr(twoDArr);
		System.out.println(twoDArr[A][B]);

	}
	private static void print2DArr(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			System.out.println(Arrays.toString(A[i]));
		}
	}
	
	//Compute nCr % p
	/*
	 Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
	 x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
	 NOTE: For this problem, we are considering 1 as a prime. 
	 */
	public static int calculateNCRWithModP() {
		int A = 5;
		int B = 2;
		int C = 13;
        long nFact = getFactorial(A, C);
        long nMinusRFact = getFactorial(A-B, C);
        long rFact = getFactorial(B, C);
        int mod = C;
        long ncrPower = getFastPower((int)nMinusRFact, mod-2, mod);
        long rPower = getFastPower((int)rFact, mod-2, mod);

        long ans = (((nFact * ncrPower) %mod) * rPower)%mod;
        System.out.println(ans);
        return (int)ans;
    }
    public static long getFastPower(int num, int power, int mod){
        if(power == 0){
            return 1;
        }
        long ans = 0;
        long temp = getFastPower(num, power/2, mod);
        if(power%2 == 0){
            ans = (temp*temp)%mod;
        }else{
            ans = (((temp*temp)%mod) * num)%mod;
        }
        return ans;
    }
    public static long getFactorial(int num, int mod){
        long fact = 1;
        for(int i=1; i<=num; i++){
            fact = (fact * i) % mod;
        }
        return fact;
    }
    
    // Excel Column Number
    private static void getExcelColomNumber() {
    	String str = "AB";
    	int asciiVal = 0;
    	int possition = 0;
    	int ans = 0;
    	int power = 1;
    	for (int i = str.length()-1; i>=0; i--) {
			asciiVal = (int)str.charAt(i);
			possition = asciiVal-64;
			ans = ans + (possition * power);
			power = power * 26;
		}
    	System.out.println(ans);
	}
    
    private static void test() {
    	int num = 15;
    	int count = 0;
    	for (int i = 1; i*i <= num; i++) {
			int temp = (num - (i*(i-1)/2));
			if(temp%i == 0) {
				count++;
			}
		}
    	System.out.println(count);
	}
    
}
