package Assignments;

class Node{
	int coeff;
	int exp;
	Node next;
	
	public Node(int coeff,int exp) {
		this.coeff=coeff;
		this.exp = exp;
		this.next = null;
	}
	
	public Node getNext() {
		return next;
	}
	
	public void setNext(Node next) {
		this.next = next;
	}
	
	public void setCoeff(int coeff) {
		this.coeff = coeff;
	}
	
	public int getCoeff() {
		return coeff;
	}
	
	public int getExp() {
		return exp;
	}
	
	public void setExp(int exp) {
		this.exp = exp;
	}
	
	public String toString() {
		if(exp==1)	return coeff+"x";
		if(exp==0) return coeff+"";
		return coeff+"x^"+exp;
	}
}

public class Polynomial {

	public static void main(String[] args) {
		Node a1 = new Node(1, 2);
		Node a2 = new Node(2, 1);
		Node a3 = new Node(1, 0);
		
		a1.next = a2;
		a2.next = a3;
		
		Node b1 = new Node(3, 3);
		Node b2 = new Node(4, 2);
		Node b3 = new Node(6, 1);
		Node b4 = new Node(7, 0);
		
		b1.next = b2;
		b2.next = b3;
		b3.next = b4;
		
		display(a1);
		display(b1);
		//Node res = addition(b1, a1);
		//display(res);
		Node mul = multiply(a1, b1);
		display(mul);
		
	}
	
	public static void display(Node it) {
		if(it==null) return;
		while(it.next!=null) {
			System.out.print(it+" + ");
			it = it.getNext();
		}
		System.out.println(it);
	}
	
	public static Node addition(Node it1,Node it2) {
		Node res = null;
		Node it = null;
		while(it1 != null && it2 != null) {
			if(it1.exp == it2.exp) {
				Node temp = new Node(it1.coeff+it2.coeff,it1.exp);
				if(it==null) {
					res = temp;
					it = res;
				}
				else {
					while(res.next!=null) {
						res= res.next;
					}
					res.next = temp;
				}
				it1 = it1.next;
				it2 = it2.next;
			}
			else if(it1.exp>it2.exp) {
				Node temp = new Node(it1.coeff,it1.exp);
				if(it==null) {
					res = temp;
					it = res;
				}
				else {
					while(res.next!=null) {
						res= res.next;
					}
					res.next = temp;
				}
				it1 = it1.next;
			}
			else {
				Node temp = new Node(it2.coeff,it1.exp);
				if(it==null) {
					res = temp;
					it = res;
				}
				else {
					while(res.next!=null) {
						res= res.next;
					}
					res.next = temp;
				}
				it2 = it2.next;
			}
		}
		while(it1!=null) {
			Node temp = new Node(it1.coeff,it1.exp);
			if(it==null) {
				res = temp;
				it = res;
			}
			else {
				while(res.next!=null) {
					res= res.next;
				}
				res.next = temp;
			}
			it1=it1.next;
		}
		while(it2!=null) {
			Node temp = new Node(it2.coeff,it2.exp);
			if(it==null) {
				res = temp;
				it = res;
			}
			else {
				while(res.next!=null) {
					res= res.next;
				}
				res.next = temp;
			}
			it2=it2.next;
		}
		return it;
	}
	
	public static Node multiply(Node it1,Node it2) {
		Node res = null;
		Node it = null;
		Node t = it2;
		while(it1!=null) {
			it2 = t;
			while(it2!=null) {
				Node temp = new Node(it1.coeff*it2.coeff,it1.exp+it2.exp);
				
				if(it==null) {
					res = temp;
					it = res;
				}
				else {
					it = addition(it, temp);
				}
				it2 = it2.next;
			}
			it1=it1.next;
		}
		return it;
	} 
	
	
}
