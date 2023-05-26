package Assignments;

import com.linkedlist.stack.Stack;

public class InfixConversion {
	//This works for single digit operands only

	public static void main(String[] args) {

		String exp = "(2+3)*(7-2)+6";
		//String exp = "7-9*8";
		System.out.println(postfix(exp));
		System.out.println(solvePostfix(postfix(exp)));
		System.out.println(prefix(exp));
		System.out.println(solvePrefix(prefix(exp)));
	}

	public static String postfix(String str) {
		String ret = "";

		Stack<Character> st = new Stack<>();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);

			if(c>='0' && c<='9') {
				ret += c;
			}
			else {
				if(c==')') { //closing bracket found pop everything until opening bracket occurs  
					while(!st.isEmpty() && st.peek()!='(') {
						ret += st.pop();
					}
					st.pop(); //Removes '('
				}
				else if(st.isEmpty() || precedence(c)>precedence(st.peek())) {
					st.push(c); //pushes higher precedence operator in stack
				}
				else {
					if(st.peek()=='(') {
						//every operator is to ignore precedence of '(' until ')' occurs
					}
					else {
						// if lower precedence operator occurs pop everything until the precedence of operator at peek is lower
						while(!st.isEmpty() && precedence(c)<=precedence(st.peek())) {
							if(st.peek()!='(') // avoid brackets in result
								ret += st.pop();
						}
					}
					st.push(c);
				}
			}
		}
		while(!st.isEmpty()) {
			ret+=st.pop(); // pop remaining operators 
		}

		return ret;
	}
	
	public static String prefix(String str) {
		String ret = "";
		for (int i = 0; i < str.length(); i++) {
			ret = str.charAt(i) + ret;
		}
		str = ret;
		ret = "";

		Stack<Character> st = new Stack<>();
		for(int i=0;i<str.length();i++) {
			char c = str.charAt(i);

			if(c>='0' && c<='9') {
				ret += c;
			}
			else {
				if(c=='(') {
					while(!st.isEmpty() && st.peek()!=')') {
						ret += st.pop();
					}
					st.pop(); //Removes ')'
				}
				else if(st.isEmpty() || precedence(c)>precedence(st.peek())) {
					st.push(c); //pushes higher precedence operator in stack
				}
				else {
					if(st.peek()==')') {
						//every operator is to ignore precedence of ')' until '(' occurs
					}
					else {
						// if lower precedence operator occurs pop everything until the precedence of operator at peek is lower
						while(!st.isEmpty() && precedence(c)<=precedence(st.peek())) {
							if(st.peek()!=')') // avoid brackets in result
								ret += st.pop();
						}
					}
					st.push(c);
				}
			}
		}
		while(!st.isEmpty()) {
			ret+=st.pop(); // pop remaining operators 
		}
		
		str = "";
		for(int i=0;i<ret.length();i++) {
			str = ret.charAt(i) + str;
		}
		
		return str;
	}

	public static int precedence(char a) {

		switch(a) {
		case '+':return 1;
		case '-':return 1;
		case '*':return 2;
		case '/':return 2;
		case '!':return 3;
		case '(':return 4;
		case ')':return 4;
		case '^':return 5;
		}
		return 999;
	}

	public static int math(int a,int b,char op) {
		switch(op) {
		case '+':return a+b;
		case '-':return a-b;
		case '*':return a*b;
		case '/':return a/b;
		}
		return 0;
	}

	public static int solvePostfix(String str) {
		int a=0,b=0;
		Stack<Integer> num = new Stack<>();
		Stack<Character> op = new Stack<>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c>='0' && c<='9') {
				num.push(Integer.parseInt(c+""));
			}
			else {
				if(true) {
					a = num.pop();
					b = num.pop();
					//a = math(a,b,op.pop());
					a = math(b,a,c);
					num.push(a);
				}
				op.push(c);
			}
		}
		return a;
	}
	
	public static int solvePrefix(String str) {
		int a=0,b=0;
		Stack<Integer> num = new Stack<>();
		Stack<Character> op = new Stack<>();
		for (int i = str.length()-1; i > -1 ; i--) {
			char c = str.charAt(i);
			if(c>='0' && c<='9') {
				num.push(Integer.parseInt(c+""));
			}
			else {
				if(true) {
					a = num.pop();
					b = num.pop();
					a = math(a,b,c);
					num.push(a);
				}
				op.push(c);
			}
		}
		return a;
	}
}