package com.scaler.advanced.dsa3;

public class Trie2 {

	public static void main(String[] args) {
		int[] A = {5, 17, 100, 11};
		int max = 100;
		int bitCount = Integer.toBinaryString(max).length();
		int ans = 0;
		TrieNode2 root = new TrieNode2(-1);
		for (int i = 0; i < A.length; i++) {
			insertIntoTrie(root, A[i], bitCount);
		}
		
		for (int i = 0; i < A.length; i++) {
			int xor = 0;
			TrieNode2 curr = root;
			for (int j = bitCount-1; j >= 0; j--) {
				if(checkBit(A[i], j) == 1) {
					if(curr.trieNodeArr[0] != null) {
						xor = (xor | (1<<j));
						curr = curr.trieNodeArr[0];
					}else {
						curr = curr.trieNodeArr[1];
					}
				}else {
					if(curr.trieNodeArr[1] != null) {
						xor = (xor | (1<<j));
						curr = curr.trieNodeArr[1];
					}else {
						curr = curr.trieNodeArr[0];
					}
				}
				ans = Integer.max(ans, xor);
			}
		}
		System.out.println(ans);
	}
	private static void insertIntoTrie(TrieNode2 node, int num, int bitCount) {
		TrieNode2 curr = node;
		for (int i = bitCount-1; i >= 0; i--) {
			int bit = checkBit(num, i);
			if(curr.trieNodeArr[bit] == null) {
				curr.trieNodeArr[bit] = new TrieNode2(bit);
			}
			curr = curr.trieNodeArr[bit];
		}
	}
	private static int checkBit(int num, int index) {
		return ((num >> index) & 1);
	}

}

class TrieNode2{
	int value;
	TrieNode2[] trieNodeArr;
	public TrieNode2(int value) {
		this.value = value;
		trieNodeArr = new TrieNode2[2];
	}
}
