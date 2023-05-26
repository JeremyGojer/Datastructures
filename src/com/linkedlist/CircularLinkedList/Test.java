package com.linkedlist.CircularLinkedList;

public class Test {

	public static void main(String[] args) {
		
		CircLinkedList linkedlist = new CircLinkedList();
		linkedlist.insert(10);
		linkedlist.insert(20);
		linkedlist.insert(30);
		linkedlist.append(40);
		linkedlist.append(50);
		linkedlist.insert(60,2);
//		linkedlist.delete();
//		linkedlist.deletelast();
//		linkedlist.delete(1);
		System.out.println(linkedlist);
		linkedlist.reverse();
		//linkedlist.reverseDisplay();
		//System.out.println();
		//linkedlist.deleteByValue(50);
//		linkedlist.insertBeforeValue(70,50);
//		linkedlist.insertAfterValue(80,70);
		//linkedlist.sortLL();
		System.out.println(linkedlist);
	}

}
