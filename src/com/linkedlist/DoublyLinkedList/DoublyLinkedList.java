package com.linkedlist.DoublyLinkedList;

import com.datastructures.LinkedList;

public class DoublyLinkedList implements LinkedList{
	Node head;
	Node tail;
	static int count=0;
	
	public boolean insert(int data) {
		Node temp = new Node(data);
		if(head==null) {
			head = temp;
			tail = temp;
		}
		else {
			temp.setNext(head);
			head.setPrev(temp);
			head=temp;
		}
		count++;
		return true;
	}
	public boolean append(int data) {
		Node temp = new Node(data);
		if(head==null) {
			head = temp;
			tail = temp;
		}
		else {
			temp.setPrev(tail);
			tail.setNext(temp);
			tail=temp;
		}
		count++;
		return true;
	}
	public boolean insert(int data,int pos) {
		if(pos==0) {
			return insert(data);
		}
		else if(pos==count) {
			return append(data);
		}
		else if(pos < 0 || pos > count) {
			return false;
		}
		else {
			Node temp = new Node(data);
			Node it = head;
			while(pos--!=1) {
				it = it.getNext();
			}
			temp.setPrev(it);
			temp.setNext(it.getNext());
			it.getNext().setPrev(temp);
			it.setNext(temp);
			count++;
			return true;
		}
	}
	
	public int delete() {
		int ret = 0;
		if(head==null) {
			
		}
		else {
			if(head.getNext()==null) {
				head = tail = null;
			}
			else {
				Node it = head;
				head = head.getNext();
				it.setNext(null);
				head.setPrev(null);
				ret = it.getData();
			}
			count--;
		}
		return ret;
	}
	
	public int deletelast() {
		int ret = 0;
		if(head==null) {
			
		}
		else {
			if(tail.getPrev()==null) {
				head = tail = null;
			}
			else {
				Node it = tail;
				tail = tail.getPrev();
				it.setPrev(null);
				tail.setNext(null);
				ret = it.getData();
			}
			count--;
		}
		return ret;
	}
	
	public int delete(int pos) {
		int ret = 0;
		if(pos==0) {
			ret = delete();
		}
		else if(pos==count-1) {
			ret = deletelast();
		}
		else if(pos < 0 || pos > count-1) {
			
		}
		else {
			Node it = head;
			while(pos--!=0) {
				it = it.getNext();
			}
			it.getPrev().setNext(it.getNext());
			it.getNext().setPrev(it.getPrev());
			it.setPrev(null);
			it.setNext(null);
			ret = it.getData();
			count--;
		}
		return ret;
	}
	
	public void reverse() {
		Node it=head;
		Node itp = null;
		Node itn=head;
		while(it!=null) {
			itn=it.getNext();
			it.setNext(itp);
			it.setPrev(itn);
			itp=it;
			it=itn;
		}
		tail = head;
		head = itp;
	}
	
	public void forwardprint() {
		Node it = head;
		System.out.println("Forward print");
		while(it!=null) {
			System.out.print(it+"--->");
			it = it.getNext();
		}
		System.out.println();
	}
	public void reverseprint() {
		Node it = tail;
		System.out.println("Reverse print");
		while(it!=null) {
			System.out.print("<---"+it);
			it = it.getPrev();
		}
		System.out.println();
	}
	@Override
	public String toString() {
		String str = "head--->";
		Node it = head;
		while(it != null) {
			str += "<---"+it+"--->";
			it = it.getNext();
		}
		return str+"<---tail";
	}
	
	
}
