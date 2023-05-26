package com.linkedlist.DoublyLinkedList;

public class Node {
	int data;
	Node prev,next;
	
	public Node(int data) {
		this.data = data;
		this.next = this.prev = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return data+"";
	}
	
	
}
