package com.scaler;

import java.util.Arrays;

public class IntroductionProblemSolving {

	public static void main(String[] args) {

		//System.out.println(sumOfNumbers(100));
		//System.out.println(countOfFactors(10));
		
		/*if(primeNo(19) == 0) {
			System.out.println("Prime No");
		}else {
			System.out.println("Not Prime");
		}*/
		
		
		//squareRootOfNum(4);
		//count();
		
		//isPerfectNo();
		
		//countOfPrimes();
		
		
		//countOfFactors();
		
		//countOfEvenNumbers();
		
		//isPrimeNumber();
		
		//squareRootOfNumber();
		
		perfectNumber();
	}
	
	/*eg: N = 5; then need to do 1+2+3+4+5  
	 	Observation
	 	reverse numbers 
	 	
	 	s = 1+2+3+4+5+...+(n-1)+n
	 +	s = n+(n-1)+(n-2)+ ....5+4+3+2+1
	 	-------------
	   2s = (n+1)+(n+1)+(n+1)+......+(n+1)
	 	
	 	2s = n * (n+1)
	 	s = (n*(n+1)) / 2
	 */
	
	public static int sumOfNumbers(int n) {
		int sum = n * (n+1)/2;
		return sum;
	}
	
	
	
   /*
    countOfFactors
     
	if n is 10 then 
	factors are 
	  n=10
	i      n/i
	1		10 (10/1) (10 is perfectly divisible by 1)
	2		5	(10/2)(10 is perfectly divisible by 2)
	//3     -   	  (10 is not divisible by 1)
	//4     -       	not
	5   	2   (10 is perfectly divisible by 5)
	10 		1	(10 is perfectly divisible by 10)

	there there is factors are repeating 
	in first half there are all factors
	 
	means 
	i <= n/i
	i*i <= n

   */
	public static int countOfFactors(int n) {
		int factorsCount = 0;
		for (int i = 1; i*i <= n; i++) 
		{
			if(n % i == 0) 
			{
				if(i == n/i)  //checks if i=10 and (100/10) = 10 there are only one factor which is (10) 
				{ 	
					factorsCount++;
				}
				else 
				{
					factorsCount += 2;
				}
			}
			if(factorsCount > 2) {
				break;
			}
		}
		return factorsCount;
	}
	
	public static int primeNo(int A) {
		/*if(countOfFactors(n) == 2) {
			System.out.println("Prime No");
		}else {
			System.out.println("Not Prime");
		}*/
		if(A <= 2){
            return 1;
        } 
        for(long i = 2;i*i<=A;i++){
            if(A%i == 0){
                return 1;
            }
        }
        return 0;
		
	}
	public static void squareRootOfNum(int n) {
		boolean flag = false;
		for (int i = 1; i*i <= n; i++) {
			if(i*i == n) {
				flag = true;
				System.out.println("Squar Root is : "+i);
				break;
			}
		}
		if(!flag) {
			System.out.println("Squar Root is : "+-1);
		}
	}
	public static void count() {
		int count = 0;
		int a = 135;
		int b = 246;
		
		for (int i = 135; i <= 246; i++) {
			count++;
		}
		System.out.println(count);
	}
	
	public static void isPerfectNo() {
		int n = 2;
		int temp = 1;
		for(int i = 2; i*i<=n; i++) { 
			if(n % i == 0) {  
				temp = temp + i + n/i;			// 1+2+(10/2)  
			}
		}
		if(n == temp) {
			System.out.println(n+" : is Perfect No");
		}else {
			System.out.println(n+" : is not Perfect No");
		}
	}
	//Count of primes
	//You will be given an integer n. You need to return the count of prime numbers less than or equal to n.
	public static void countOfPrimes(){
		int n = 19;
		int countOfPrimes = 0;
		for (int i = 2; i <= n; i++) {
			int count = 0;
			for (int j = 1; j*j <= i; j++) {
				if(i % j == 0) {
					if(j == i/j) {
						count++;
					}else {
						count +=2;
					}
				}
			}
			if(count == 2) {
				countOfPrimes++;
			}
		}
		System.out.println("countOfPrimes :"+countOfPrimes);
	}
	
	
//======================================================================================================

	private static void countOfFactors() {
		int n = 10;
		int countOfFactors = 0;
		for (int i = 1; i*i < n; i++) {
			if(n%i == 0) {
				if(i == n/i) {
					countOfFactors++;
				}else {
					countOfFactors+=2;
				}
			}
		}
		System.out.println(countOfFactors);
	}
	
	
	private static void countOfEvenNumbers() {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		int[] prefArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2 == 0) {
				prefArr[i] = 1;
			}else {
				prefArr[i] = 0;
			}
		}
		for (int i = 1; i < prefArr.length; i++) {
			prefArr[i] = prefArr[i-1]+prefArr[i];
		}
		System.out.println(Arrays.toString(prefArr));
		
		System.out.println(prefArr[8] - prefArr[0]);
	}
	
	
	private static void isPrimeNumber() {
		int A = 29;
		if(A == 1){
			System.out.println("not prime");
            return;
        } 
        if(A == 2 || A == 3) {
        	System.out.println("prime");
            return;
        }
        if(A%2 == 0 || A%3 == 0) {
        	System.out.println("not prime");
            return;
        }
        for(long i = 5;i*i<=A;i=i+6)
        {
            if(A%i == 0 || A%(i+2) == 0){
            	System.out.println("not prime");
                return;
            }
        }
        System.out.println("prime");
        return;
	}
	
	private static void squareRootOfNumber() {
		int n = 20;
		if(n == 1) {
			System.out.println("1");
		}
		for (int i = 2; i*i <= n; i++) {
			if(i*i == n) {
				System.out.println(i);
				break;
			}
		}
		System.out.println(-1);
	}
	
	
	private static void perfectNumber() {
		int a = 100;
		int ans = 0;
		for (int i = 2; i*i <= a; i++) {
			if(a%i == 0) {
				ans = ans + i + a/i;
			}
		}
		if(ans == a) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}
	
}
