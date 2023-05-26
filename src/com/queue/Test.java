package com.queue;

public class Test {

	public static void main(String[] args) {
		
		CirQueue q = new CirQueue(5);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
//		q.enqueue(60);
		q.dequeue();
//		q.dequeue();
//		q.dequeue();
//		q.dequeue();
//		q.dequeue();
//		System.out.println(q);
		q.enqueue(70);
		q.enqueue(80);
		q.enqueue(90);
		
		System.out.println(q);

	}

}
