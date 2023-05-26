package com.linkedlist.LinkedList;

import com.datastructures.LinkedList;

import LinkedListTricks.Node;

public class SinglyLinkedList implements LinkedList{
	Node head;
	static int count = 0;
	
	public SinglyLinkedList(Node head){
		this.head=head;
		Node it=head;
		if(checkCycle(it)) {
			breakCycle(it);
		}
		while(it!=null) {
			count++;
			it = it.getNext();
		}
	}
	
	public SinglyLinkedList(){
		
	}
	
	public Node getHead() {
		return head;
	}

	public boolean insert(int data) {
		boolean status = false;
		Node temp = new Node(data);

		temp.setNext(head);
		head = temp;
		count++;
		status = true;
		return status;
	}

	public boolean insert(int data,int pos) {
		boolean status = false;
		Node temp = new Node(data);
		if(pos==0) {
			status = insert(data);
		}
		else if(pos==count) {
			status = append(data);
		}
		else if(pos<0 || pos>count) {
			System.out.println("Index not available, max available position = "+count);
			return status;
		}
		else {
			Node it = head;
			while(pos--!=1) {
				it = it.getNext();
			}
			temp.setNext(it.getNext());
			it.setNext(temp);
			count++;
			status = true;
		}
		return status;
	}
	
	
	
	public boolean append(int data) {
		boolean status = false;
		Node temp = new Node(data);

		if(head==null) {
			head = temp;
		}
		else {
			Node it = head;
			while(it.getNext()!= null) {
				it = it.getNext();
			}
			it.setNext(temp);
		}
		count++;
		status = true;
		return status;
	}
	
	public void insertBeforeValue(int data,int value) {
		Node it = head;
		int pos=1;
		while(it!=null) {
			if(it.getData()==value) {
				break;
			}
			it=it.getNext();
			pos++;
		}
		if(pos<count+1) {
			insert(data,pos-1);
		}
		else {
			System.out.println("Value not found");
		}
	}
	
	public void insertAfterValue(int data,int value) {
		Node it = head;
		int pos=1;
		while(it!=null) {
			if(it.getData()==value) {
				break;
			}
			it=it.getNext();
			pos++;
		}
		if(pos<count+1) {
			insert(data,pos);
		}
		else {
			System.out.println("Value not found");
		}
	}

	public int delete() {
		int ret = -1;
		if(head==null) {
			return -1;
		}
		else {
			Node it = head;
			head = head.getNext();
			it.setNext(null);
			ret = it.getData();
			count--;
		}

		return ret;
	}
	
	public int delete(int pos) {
		int ret = -1;
		if(pos<0 || pos>=count) {
			System.out.println("Index not available, max available position = "+(count-1));
			return ret;
		}
		else if(pos==0) {
			ret = delete();
		}
		else if(pos==count-1) {
			ret =  deletelast();
		}
		else {
			Node it = head;
			while(pos--!=1) {
				it=it.getNext();
			}
			Node temp = it.getNext();
			it.setNext(temp.getNext());
			temp.setNext(null);
			ret = temp.getData();
			count--;
		}

		return ret;
	}
	
	public int deletelast() {
		int ret = -1;
		if(head==null) {
			return ret;
		}
		else {
			Node it = head;
			if(head.getNext()==null) {
				head = null;
				ret = it.getData();
			}
			else {
				while(it.getNext().getNext()!= null) {
					it = it.getNext();
				}
				ret = it.getNext().getData();
				it.setNext(null);
			}
			
			count--;
		}

		return ret;
	}
	
	public int deleteByValue(int val) {
		Node it = head;
		int pos = 0;
		while(it!=null) {
			if(it.getData()==val) {
				delete(pos);
				break;
			}
			it = it.getNext();
			pos++;
		}
		
		return val;
	}
	
	public void reverse() {
		Node itp = null;
		Node it = head;
		Node itn = it;
		
		while(it!=null) {
			itn = it.getNext();
			it.setNext(itp);
			itp=it;
			it=itn;
		}
		head= itp;
	}
	
	public void reverseDisplayImpl(Node it) {
		if(it!=null) {
			reverseDisplayImpl(it.getNext());
		}
		System.out.print(it+"<---");
	}
	
	public void reverseDisplay(){
		reverseDisplayImpl(head);
		System.out.println("head");
	}

	public void sortLL() {
		Node it1 = head;
		Node it2 = it1.getNext();
		while(it1.getNext()!=null) {
			while(it2!=null) {
				if(it1.getData()>it2.getData()) {
					int temp = it1.getData();
					it1.setData(it2.getData());
					it2.setData(temp);
				}
				it2=it2.getNext();
			}
			it1=it1.getNext();
			it2 = it1.getNext();
		}
	}
	
	public void sortedInsert(int data) {
		Node temp = new Node(data);
		if(head==null) {
			//when there are no nodes
			head=temp;
		}
		else {
			Node it = head;
			//For first node 
			if(it.getData()>data) {
				temp.setNext(head);
				head = temp;
			}
			else {//for other nodes
				while(it.getNext()!=null && it.getNext().getData()<=data) {
					
					it = it.getNext();
				}
				temp.setNext(it.getNext());
				it.setNext(temp);
			}
		}
		
	}
	
	public boolean Search(int data) {
		Node it = head;
		while(it!=null) {
			if(it.getData()==data) {
				return true;
			}
			it = it.getNext();
		}
		return false;
	}
	
	
	public boolean checkCycle(Node head) {
		Node its = head;
		Node itf = head;
		
		while(its!=null && itf!=null && itf.getNext()!=null ) {
			its = its.getNext();
			itf = itf.getNext().getNext();
			if(its==itf) {
				return true;
			}
		}
		return false;
	}
	
	public void breakCycle(Node head) {
		Node its = head;
		Node itf = head;
		while(its!=null && itf!=null && itf.getNext()!=null ) {
			its = its.getNext();
			itf = itf.getNext().getNext();
			if(its==itf) {
				break;
			}
		}
		if(itf==head) {
			itf= itf.getNext();
			while(itf.getNext()!=head) {
				itf=itf.getNext();
			}
			itf.setNext(null);
		}
		else {
			int L1=0,loopL=0;
			Node it1 = head;
			Node it2 = itf;
			it2 = it2.getNext();
			
			while(it1!=itf) {
				it1=it1.getNext();
				L1++;
			}
			while(it2!=itf) {
				it2=it2.getNext();
				loopL++;
			}
			it1 = head;
			if(L1!=loopL) {
				while(L1-loopL!=0) {
					it1=it1.getNext();
					L1--;
				}
			}
			it2=itf;
			while(it1!=itf) {
				it1=it1.getNext();
				it2=it2.getNext();
				if(it1==it2) {
					break;
				}
			}
			//break loop
			it1.setNext(null);
		}
	}
	
	public boolean checkCycle() {
		Node its = head;
		Node itf = head;
		
		while(its!=null && itf!=null && itf.getNext()!=null ) {
			its = its.getNext();
			itf = itf.getNext().getNext();
			if(its==itf) {
				return true;
			}
		}
		return false;
	}
	
	public String toString() {
		if(checkCycle()) {
			return "LinkedList has a cycle present";
		}
		
		String str = "head--->";
		Node it = head;
		while(it!=null) {
			str += it+"--->";
			it=it.getNext();
		}
		
		return str+"null";
	}
}
