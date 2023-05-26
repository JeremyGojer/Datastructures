package com.stack;

public class Test {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<>(5);
		
		stack.push("Hello");
		stack.push("There");
		stack.push("This");
		stack.push("is");
		stack.push("a");
		stack.push("zone");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println("----------");
		
		System.out.println(stack);
	}

}
