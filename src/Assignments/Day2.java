package Assignments;

import com.linkedlist.LinkedList.SinglyLinkedList;

import LinkedListTricks.Node;


public class Day2 {

	public static void main(String[] args) {
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.insert(10);
		ll.insert(20);
		ll.insert(30);
		ll.insert(40);
		ll.insert(50);
		ll.insert(60);
		ll.insert(20);
		ll.insert(10);
		
//		SinglyLinkedList ll2 = new SinglyLinkedList();
//		ll2.insert(10);
//		ll2.insert(20);
//		ll2.insert(30);
//		ll2.insert(40);
//		ll2.insert(50);
//		ll2.insert(60);
		
		
		
		System.out.println(ll);
		System.out.println(length(ll));
		
		//removeDuplicates(ll);
		//System.out.println(findMiddle(ll));
		//MergeAlternate(ll, ll2);
		seggregate(ll, 40);
		//System.out.println(checkPalindrome(ll));
		
		//rotateFromK(ll, 2);
		//System.out.println(search(ll, 80));
		System.out.println(ll);
		
	}
	
	public static int length(SinglyLinkedList ll) {
		//Q3
		int l = 0;
		Node it = ll.getHead();
		while(it!=null) {
			it=it.getNext();
			l++;
		}
		return l;
	}
	
	public static void removeDuplicates(SinglyLinkedList ll) {
		//Q4
		Node p = ll.getHead();
		while(p!=null) {
			Node it=p.getNext();
			while(it!=null) {
				if(it.getData()==p.getData()) {
					ll.deleteByValue(it.getData());
					p = ll.getHead();
				}
				it = it.getNext();
			}
			p=p.getNext();
		}
	}
	
	public static Node findMiddle(SinglyLinkedList ll) {
		//Q5
		Node itm = ll.getHead();
		Node itf = ll.getHead();
		while(itf!=null && itf.getNext()!=null ) {
			itf=itf.getNext().getNext();
			itm=itm.getNext();
		}
		return itm;
	}
	
	public static void MergeAlternate(SinglyLinkedList ll1,SinglyLinkedList ll2) {
		//Q6
		Node it = ll1.getHead();
		Node it2 = ll2.getHead();
		
		while(it!=null && it2!=null) {
			Node temp = new Node(it2.getData());
			temp.setNext(it.getNext());
			it.setNext(temp);
			it=it.getNext().getNext();
			it2=it2.getNext();
		}
	}
	
	public static boolean checkCycle(SinglyLinkedList ll) {
		//Q7
		Node its = ll.getHead();
		Node itf = ll.getHead();
		
		while(its!=null && itf!=null && itf.getNext()!=null ) {
			its = its.getNext();
			itf = itf.getNext().getNext();
			if(its==itf) {
				return true;
			}
		}
		return false;
	}
	
	public static void seggregate(SinglyLinkedList ll, int data) {
		//Q8
		SinglyLinkedList ll2 = new SinglyLinkedList();
		while(ll.Search(data)) {
			ll2.insert(data);
			ll.deleteByValue(data);
		}
		Node it = ll.getHead();
		while(it!=null) {
			if(it.getData()>data) {
				ll2.append(it.getData());
			}
			else {
				ll2.insert(it.getData());
			}
			it = it .getNext();
		}
		
		System.out.println(ll2);
		
		Node it2 = ll2.getHead();
		while(it2!=null) {
			ll.delete();
			ll.append(it2.getData());
			it2=it2.getNext();
		}
		ll.insert(ll2.getHead().getData());
	}
	
	public static boolean checkPalindrome(SinglyLinkedList ll) {
		//Q9
		SinglyLinkedList ll2 = new SinglyLinkedList();
		Node it1=ll.getHead();
		while(it1!=null) {
			ll2.insert(it1.getData());
			it1 = it1.getNext();
		}
		it1=ll.getHead();
		Node it2=ll2.getHead();
		while(it1!=null) {
			if(it1.getData() != it2.getData()) {
				return false;
			}
			it1=it1.getNext();
			it2=it2.getNext();
		}
		return true;
	}
	
	public static void insertSorted(SinglyLinkedList ll,int data) {
		//Q11
		ll.sortedInsert(data);
	}
	
	public static void rotateFromK(SinglyLinkedList ll,int k) {
		//Q12
		while(k-->0) {
			int data = ll.deletelast();
			ll.insert(data);
		}
	}
	
	public static void LLLL(SinglyLinkedList ll) {
		//Q13
	}
	
	public static void reverse(SinglyLinkedList ll) {
		//Q14
		ll.reverse();
	}
	
	public static void insertSorted2(SinglyLinkedList ll,int data) {
		//Q15
		ll.sortedInsert(data);
	}
	
	public static boolean search(SinglyLinkedList ll,int data) {
		//Q17
		return ll.Search(data);
	}
}
