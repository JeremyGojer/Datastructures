package com.linkedlist.LinkedList;

public class Test {

	public static void main(String[] args) {
		
		SinglyLinkedList linkedlist = new SinglyLinkedList();
		linkedlist.insert(10);
		linkedlist.insert(20);
		linkedlist.insert(30);
		linkedlist.append(40);
		linkedlist.append(50);
		linkedlist.append(90);
		linkedlist.insert(60,2);
		linkedlist.delete();
		linkedlist.deletelast();
		linkedlist.reverse();
		
		linkedlist.insertBeforeValue(70,50);
		linkedlist.insertAfterValue(80,70);
		linkedlist.deleteByValue(50);
		linkedlist.sortLL();
		linkedlist.sortedInsert(30);
		linkedlist.sortedInsert(20);
		linkedlist.sortedInsert(40);
		linkedlist.sortedInsert(10);
		linkedlist.sortedInsert(50);
		linkedlist.sortedInsert(24);
		linkedlist.sortedInsert(18);
		
		linkedlist.reverseDisplay();
		System.out.println(linkedlist);
		
	}

}
