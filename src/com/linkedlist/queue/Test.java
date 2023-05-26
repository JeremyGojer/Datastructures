package com.linkedlist.queue;

public class Test {

	public static void main(String[] args) {
		CirQueue<String> q = new CirQueue<>();
		q.enqueue("Hello");
		q.enqueue("Hafcac");
		q.enqueue("qwuhasd");
		q.dequeue();
		q.dequeue();
		q.dequeue();
		
		
		System.out.println(q);

	}

}