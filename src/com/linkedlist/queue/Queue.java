package com.linkedlist.queue;

import com.datastructures.Node;

public class Queue<T>{
	Node<T> front,rear;

	public void enqueue(T data) {
		Node<T> temp = new Node<>(data);
		if(isEmpty()) {
			front=rear=temp;
		}
		else {
			rear.setNext(temp);
			rear=temp;
		}
	}

	public T dequeue() {
		
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return null;
		}
		else {
			Node<T> it = front;
			front = front.getNext();
			it.setNext(null);
			return it.getData();
		}
	}
	
	public boolean isEmpty() {
		return front==null;
	}
	
	public String toString() {
		String str="";
		Node<T> it = front;
		if(isEmpty()) {
			str += "Queue is Empty";
		}
		while(it!=null) {
			str += it + "-";
			it = it .getNext();
		}
		
		return str;
	}
	
}
