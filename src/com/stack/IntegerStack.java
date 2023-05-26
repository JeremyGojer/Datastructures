package com.stack;

import java.util.Iterator;

public class IntegerStack implements com.datastructures.Stack {

	int top = -1;
	int [] arr;
	
	public IntegerStack(int size) {
		arr = new int[size]; 
	}
	
	public IntegerStack() {
		arr = new int[10]; 
	}
	
	@Override
	public void push(int data) {
		if(isFull()) {
			System.out.println("Stack overflow for "+data);
		}
		else {
			arr[++top]=data;
		}
		
	}

	@Override
	public int pop() {
		int val = 0;
		if(isEmpty()) {
			System.out.println("Stack underflow");
		}
		else {
			val=arr[top--];
		}
		return val;
	}

	@Override
	public int peek() {
		int val = 0;
		if(isEmpty()) {
			System.out.println("Stack underflow");
		}
		else {
			val=arr[top];
		}
		return val;
	}

	@Override
	public boolean isEmpty() {
		return top==-1;
	}

	@Override
	public boolean isFull() {
		return top==arr.length-1;
	}
	
	@Override
	public String toString() {
		String str = "";
		
		for (int i = top; i > -1; i--) {
			str+= arr[i]+"\n";
		}
		
		return str;
	}

}
