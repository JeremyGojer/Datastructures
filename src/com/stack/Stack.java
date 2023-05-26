package com.stack;

public class Stack<T>{

	int top = -1;
	Object [] arr;
	
	public Stack(int size) {
		arr = new Object[size]; 
	}
	
	public Stack() {
		arr = new Object[10]; 
	}
	
	
	public void push(T data) {
		if(isFull()) {
			System.out.println("Stack overflow for "+data);
		}
		else {
			arr[++top]=data;
		}
		
	}

	
	public T pop() {
		T val = null;
		if(isEmpty()) {
			System.out.println("Stack underflow");
		}
		else {
			val=(T) arr[top--];
		}
		return val;
	}

	
	public T peek() {
		T val = null;
		if(isEmpty()) {
			System.out.println("Stack underflow");
		}
		else {
			val=(T) arr[top];
		}
		return val;
	}

	
	public boolean isEmpty() {
		return top==-1;
	}

	
	public boolean isFull() {
		return top==arr.length-1;
	}
	
	
	public String toString() {
		String str = "";
		
		for (int i = top; i > -1; i--) {
			str+= arr[i]+"\n";
		}
		
		return str;
	}

}
