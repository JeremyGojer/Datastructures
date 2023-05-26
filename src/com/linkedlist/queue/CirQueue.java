package com.linkedlist.queue;

import com.datastructures.Node;

public class CirQueue<T> {
	Node<T> front,rear;
	
	public void enqueue(T data) {
		Node<T> temp = new Node<>(data);
		if(isEmpty()) {
			front=rear=temp;
			temp.setNext(temp);
		}
		else {
			rear.setNext(temp);
			rear=temp;
			rear.setNext(front);
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
			rear.setNext(front);
			it.setNext(null);
			if(it==front) {
				front=rear=null;
			}
			return it.getData();
		}
	}
	
	public boolean isEmpty() {
		return front==null;
	}
	
	public String toString() {
		String str = "";
		if(isEmpty()) {
			return "Queue is empty";
		}
		Node<T> it = front;
		do {
			str+=it+"-";
			it=it.getNext();
		}while(it!=front);
		return str;
	}
}
