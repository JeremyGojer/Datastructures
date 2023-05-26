package com.linkedlist.CircularLinkedList;

import com.datastructures.LinkedList;

public class CircLinkedList implements LinkedList {
	Node head;
	Node tail;
	static int count=0;
	
	public boolean insert(int data) {
		Node temp = new Node(data);
		if(head==null) {
			head = tail = temp;
			temp.setNext(temp);
		}
		else {
			temp.setNext(head);
			head = temp;
			tail.setNext(head);
		}
		count++;
		return true;
	}
	
	public boolean append(int data) {
		Node temp = new Node(data);
		if(head==null) {
			head = tail = temp;
			temp.setNext(temp);
		}
		else {
			temp.setNext(head);
			tail.setNext(temp);
			tail=tail.getNext();
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
		else if(pos<0 || pos>count) {
			return false;
		}
		else {
			Node temp = new Node(data);
			Node it = head;
			while(pos--!=1) {
				it = it.getNext();
			}
			temp.setNext(it.getNext());
			it.setNext(temp);
			count++;
			return true;
		}
	}
	
	public int delete() {
		int ret = -1; 
		if(head==null) {
			
		}
		else {
			if(head==tail) {
				head.setNext(null);
				head = tail = null;
			}
			else {
				ret = head.getData();
				tail.setNext(head.getNext());
				head.setNext(null);
				head = tail.getNext();
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
			if(head==tail) {
				head.setNext(null);
				head = tail = null;
			}
			else {
				Node it = head;
				while(it.getNext()!=tail) {
					it = it.getNext();
				}
				ret = tail.getData();
				it.setNext(head);
				tail.setNext(null);
				tail=it;
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
		else if(pos<0 || pos>count-1) {
			
		}
		else {
			Node it = head;
			while(pos--!=1) {
				it = it.getNext();
			}
			Node it2 = it.getNext();
			it.setNext(it2.getNext());
			ret = it2.getData();
			it2.setNext(null);
			count--;
		}
		return ret;
	}
	
	public void reverse() {
		Node it=head,itn=head;
		Node itp=tail;
		do {
			itn = it.getNext();
			it.setNext(itp);
			itp=it;
			it=itn;
		}while(it!=head);
		tail = head;
		head = tail.getNext();
	}
	
	public String toString() {
		String str = "";
		Node it = head;
		do {
			str += it+"-->";
			it = it.getNext();
		}while(it!=head);
		
		return str;
	}
}
