package Assignments;

public class Day4 {

	public static void main(String[] args) {
		System.out.println(Q1("Hello"));
	}
	
	public static String Q1(String str) {
		String ret = "";
		int j=str.length()-1;
		for(int i=0;i<str.length()/2;i++,j--) {
			ret+=str.charAt(i);
			ret+=str.charAt(j);
		}
		if(str.length()%2==1) {
			ret+=str.charAt(str.length()/2);
		}
		return ret;
	}

}
