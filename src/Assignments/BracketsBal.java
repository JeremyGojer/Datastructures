package Assignments;

import com.linkedlist.stack.Stack;

public class BracketsBal {

	public static void main(String[] args) {
		System.out.println(bracketBal("()"));
		System.out.println(findImbal("([{]})"));

	}

	public static boolean bracketBal(String str) {
		
		Stack<Character> chstk = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i); 
			if(c=='(') {
				chstk.push(')');
			}
			if(c=='{') {
				chstk.push('}');
			}
			if(c=='[') {
				chstk.push(']');
			}
			if(c==')') {
				if(chstk.isEmpty()) {
					return false;
				}
				if( chstk.peek()!=')') {
					return false;
				}
				chstk.pop();
			}
			if(c=='}') {
				if(chstk.isEmpty()) {
					return false;
				}
				if(chstk.peek()!='}') {
					return false;
				}
				chstk.pop();
			}
			if(c==']') {
				if(chstk.isEmpty()) {
					return false;
				}
				if(chstk.peek()!=']') {
					return false;
				}
				chstk.pop();
			}

		}
		if(!chstk.isEmpty()) {
			return false;
		}
		return true;
	}

	public static int findIndex(String str) {
		int i = 0;
		Stack<Character> chstk = new Stack<>();
		for (i = 0; i < str.length(); i++) {
			char c = str.charAt(i); 
			if(c=='(') {
				chstk.push(')');
			}
			if(c=='{') {
				chstk.push('}');
			}
			if(c=='[') {
				chstk.push(']');
			}
			if(c==')') {
				if(chstk.isEmpty()) {
					return i;
				}
				if( chstk.peek()!=')') {
					return i;
				}
				chstk.pop();
			}
			if(c=='}') {
				if(chstk.isEmpty()) {
					return i;
				}
				if(chstk.peek()!='}') {
					return i;
				}
				chstk.pop();
			}
			if(c==']') {
				if(chstk.isEmpty()) {
					return i;
				}
				if(chstk.peek()!=']') {
					return i;
				}
				chstk.pop();
			}

		}
		if(!chstk.isEmpty()) {
			return i;
		}
		return -1;
	}
	
	public static String findImbal(String str) {
		int ind = findIndex(str);
		if(ind == -1) return "No Imbal";
		String s = str.substring(0, ind);
		String e = str.substring(ind, str.length());
		
		return s+"^"+e;
	}

}
