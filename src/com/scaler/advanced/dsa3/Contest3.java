package com.scaler.advanced.dsa3;

public class Contest3 {

	public static void main(String[] args) {

	}
	
	private int removePalendromicSubsquence() {
		String A = "";
		int i = 0;
        int j = A.length()-1;
        //A = baaab
        //ab
        //babbabaaa  - 2
        int ans = 0;
        while(i < j){
            if(A.charAt(i++) != A.charAt(j--)){
                return 2;
            }
        }
        return 1;
	}

}
