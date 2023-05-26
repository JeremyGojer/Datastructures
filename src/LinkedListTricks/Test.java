package LinkedListTricks;
import com.linkedlist.LinkedList.*;
public class Test {

	public static void main(String[] args) {
		
		
		
		Node n1 = new Node(10);
		Node n2 = new Node(20);
		Node n3 = new Node(30);
		Node n4 = new Node(40);
		Node n5 = new Node(50);
		Node n6 = new Node(60);
		Node n7 = new Node(70);
		Node n8 = new Node(80);
		Node n9 = new Node(90);
		Node n10 = new Node(100);
		Node n11 = new Node(110);
		
		Node head = n1;
		n1.setNext(n2);
		n2.setNext(n3);
		n3.setNext(n4);
		n4.setNext(n5);
		n5.setNext(n6);
		n6.setNext(n7);
		n7.setNext(n8);
		n8.setNext(n9);
		n9.setNext(n10);
		n10.setNext(n11);
		n11.setNext(n1);//n5 is node of intersection
		
		SinglyLinkedList ll = new SinglyLinkedList(head);
		System.out.println(ll.checkCycle());

		System.out.println(ll);
	}

}
