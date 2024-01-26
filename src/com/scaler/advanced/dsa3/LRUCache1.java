package com.scaler.advanced.dsa3;

import java.util.HashMap;
import java.util.Map;

public class LRUCache1 {
	
	private static Map<Integer, Node1> map = new HashMap<>();
	
	private static int capacity = 0;
	private static Node1 head = null;
	private static Node1 tail = null;
	
	public LRUCache1(int capacity) {
		this.capacity = capacity;
		this.head = new Node1(-1, -1);
		this.tail = new Node1(-1, -1);
		this.head.next = tail;
		this.tail.prev = head;
	}
	
	private static void insertIntoCache(int key, int value) {
		Node1 node = search(key);
		if(node == null) {
			if(map.size() == capacity) {
				removeFromHead();
			}
			addToTail(key, value);
		}else {
			remove(node);
			addToTail(key, value);
		}
	}
	
	private static int get(int key) {
		Node1 node = search(key);
		int value = -1;
		if(node != null) {
			value = node.value;
			remove(node);
			addToTail(node.key, node.value);
		}
		return value;
	}
	
	private static Node1 search(int key) {
		if(map.containsKey(key)) {
			return map.get(key);
		}
		return null;
	}
	
	private static void remove(Node1 node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
		node.next = null;
		node.prev = null;
		map.remove(node.key);
	}
	
	// 1  2  3  4  [tail]
	private static void addToTail(int key, int value) {
		Node1 newNode = new Node1(key, value);
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev.next = newNode;
		tail.prev = newNode;
		map.put(key, newNode);
	}
	
	private static void removeFromHead() {
		remove(head.next);
	}
}

class Node1{
	int key;
	int value;
	Node1 next;
	Node1 prev;
	Node1(int key, int value){
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}