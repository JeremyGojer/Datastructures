package Assignments;
import com.linkedlist.stack.*;

public class Day3 {
	public static void main(String[] args) {
		String name = "Romanov";
		System.out.println(reverseString(name));
		Stack<Integer> st = new Stack<>();
		st.push(10);
		st.push(20);
		st.push(30);
		st.push(40);
		st.push(50);
		System.out.println(st);
		reverseStack(st);
		System.out.println(st);
		
	}
	
	public static String reverseString(String str) {
		String ret = "";
		Stack<Character> st = new Stack<>();
		for(int i=0;i<str.length();i++) {
			st.push(str.charAt(i));
		}
		while(!st.isEmpty()) {
			ret += st.pop();
		}
		return ret;
	}
	
	public static void reverseStack(Stack<Integer> st) {
		Stack<Integer> aux = new Stack<>(); 
		
	}
}
