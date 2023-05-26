package com.linkedlist.DoublyLinkedList;

public class Test {

	public static void main(String[] args) {
		
		DoublyLinkedList linkedlist = new DoublyLinkedList();
		linkedlist.insert(10);
		linkedlist.insert(20);
		linkedlist.insert(30);
		linkedlist.append(40);
		linkedlist.append(50);
		linkedlist.insert(60,3);
//		linkedlist.delete();

//		linkedlist.deletelast();
//		linkedlist.delete(2);	
								
		linkedlist.forwardprint();
		linkedlist.reverseprint();
		System.out.println(linkedlist);
		linkedlist.reverse();
		System.out.println(linkedlist);

	}

}
