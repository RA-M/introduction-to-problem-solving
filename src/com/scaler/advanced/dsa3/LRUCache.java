package com.scaler.advanced.dsa3;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	private static Map<Integer, Node> map = new HashMap<>();
	
	private static int capacity = 0;
	private static Node head;
	private static Node tail;

	public LRUCache(int capacity) {
		this.capacity= capacity;
		head = new Node(-1, -1);
		tail = new Node(-1, -1);
		head.next = tail;
		tail.prev = head;
	}
	
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(2);
		set(6, 1);
		set(2, 1);
		set(2, 2);
		//6 1 S 2 1 S 2 2 G 2 S 1 1 S 4 1 G 2
		System.out.println(get(2));
		
		set(1, 1);
		set(4, 1);
		
		System.out.println(get(2));
	}
	
	public static int get(int key) {
		Node node = search(key);
		int value = -1;
		if(node != null) {
			value = node.value;
			//remove the node and add to latest
			remove(node);
			addToTail(node.key, node.value);
		}
		return value;
	}

	public static void set(int key, int value) {
		Node node = search(key);
		//Miss case
		if(node == null) {
			if(map.size() == capacity) {
				removeFromHead();
			}
			addToTail(key, value);
		}else {	//HIT case
			remove(node);
			addToTail(key, value);
		}
	}
	
	private static void addToTail(int key, int value) {
		Node newNode = new Node(key, value);
		map.put(key, newNode);
		newNode.next = tail;
		newNode.prev = tail.prev;
		tail.prev = newNode;
		newNode.prev.next = newNode;
	}
	
	private static void remove(Node y) {
		y.prev.next = y.next;
		y.next.prev = y.prev;
		y.prev = null;
		y.next = null;
		map.remove(y.key);
	}
	
	private static void removeFromHead() {
		remove(head.next);
	}
	private static Node search(int key) {
		if (map.containsKey(key)) {
			return map.get(key);
		}
		return null;
	}
}
class Node{
	int key;
	int value;
	Node next;
	Node prev;
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}
