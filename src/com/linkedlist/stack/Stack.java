package com.linkedlist.stack;

import com.datastructures.Node;

public class Stack<T>{
	Node<T> top;
	int size = -1;
	int length = 0;

	public Stack(int size) {
		top = null;
		this.size = size;
	}
	
	public Stack() {
		top = null;
	}
	
	public void push(T data) {
		if(!isFull()) {
			Node<T> temp = new Node<>(data);
			temp.setNext(top);
			top=temp;
			length++;
		}
		else {
			System.out.println("Stack overflow for "+data);
		}
	}

	public T pop() {
		if(!isEmpty()) {
			Node<T> it = top;
			top = top.getNext();
			it.setNext(null);
			length--;
			return it.getData();
		}
		else {
			System.out.println("Stack underflow");
			return null;
		}
	}


	public T peek() {
		if(!isEmpty()) {
			return top.getData();
		}
		else {
			System.out.println("Stack underflow");
			return null;
		}
	}


	public boolean isEmpty() {
		return top==null;
	}


	public boolean isFull() {
		
		return length==size;
	}
	
	public int length() {
		return this.length;
	}
	
	public String toString() {
		String str = "";
		Node<T> it = top;
		while(it!=null) {
			str+=it.getData()+"\n";
			it=it.getNext();
		}
		return str;
	}
	
	
}
