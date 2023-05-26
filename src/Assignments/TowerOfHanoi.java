package Assignments;

import com.linkedlist.stack.Stack;

public class TowerOfHanoi {
	static int steps=0; 
	public static void main(String[] args) {

		Stack<Integer> a = new Stack<>();
		Stack<Integer> b = new Stack<>();
		Stack<Integer> c = new Stack<>();

		for (int i = 8; i > 0; i--) {
			a.push(i);
		}
		
		tower(a.length(),'a','b','c');
		System.out.println("from : \n"+a);
		towerImpl(a.length(),a,b,c);
		System.out.println("to : \n"+b);
		System.out.println("No of steps : "+steps);
		
	}

	//Steps are provided by this algorithm
		public static void tower(int n,char from,char to,char aux) {
			
			if(n==0) return;
			
			tower(n-1,from,aux,to);
			System.out.println("disc-"+n+"-from-"+from+"-to-"+to);
			tower(n-1,aux,to,from);
		}

	public static void towerImpl(int n,Stack<Integer> from,Stack<Integer> to,Stack<Integer> aux) {
		if(n==0) return;
		towerImpl(n-1,from,aux,to);
		to.push(from.pop());
		towerImpl(n-1,aux,to,from);
		steps++;
	}
}
