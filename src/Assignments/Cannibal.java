package Assignments;

public class Cannibal {
	//
	public static void main(String[] args) {
		String str = "babbaaa";
		System.out.println(cannibal(str,str.length()));

	}
	
	public static int cannibal(String s,int n) {
		int res = 0;
		int [] ch = new int[26];
		
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			if(c>='a' && c<='z') {
				ch[c-'a']++;
			}
		}
		for (int i = 0; i < ch.length; i++) {
			if(ch[i]>=2) {
				ch[i]=ch[i]-2;
				i=-1;
				res++;
			}
		}
		return res;
	}
}
