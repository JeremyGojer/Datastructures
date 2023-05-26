package Assignments;

public class Day1 {

	public static void main(String[] args) {
		int [] arr = new int[]{2,3,4,5,6,7,8,1,84,147,8,74,79,479,889};
		System.out.println(Q1(arr,4));
		System.out.println(Q2(arr,3));
		System.out.println(Q3(arr));
		int [] brr = Q4(arr);
		for(int i:brr) {
			System.out.print(i+"-");
		}
	}
	
	public static int Q1(int [] arr,int val) {
		int i = 0;
		for(i=0;i<arr.length;i++) {
			if(val == arr[i]) {
				break;
			}
		}
		if(i>=arr.length) {
			i = -1;
			System.out.println("Not found");
		}
		return i;
	}
	
	public static int Q2(int [] arr,int largest) {
		int[] larr = new int[largest];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				shift(larr,arr[i]);
				max=larr[0];
			}
		}
		return larr[0];
	}
	public static void shift(int [] arr,int val) {
		int i=0;
		for(i=0;i<arr.length-1;i++) {
			if(arr[i+1]>val) {
				break;
			}
		}
		for(int j=1;j<i+1;j++) {
			arr[j-1]=arr[j];
		}
		arr[i]=val;
	}
	
	public static int Q3(int [] arr) {
		int p=0,q=0;
		
		for(int i=0;i<arr.length-1;i++) {
			if(arr[i+1]>arr[i]) {
				q++;
			}
			else {
				q=0;
			}
			if(q>p) {
				p=q;
			}
		}
		return p+1;
	}
	
	public static int [] Q4(int [] arr) {
		int [] res = new int[arr.length];
		res[0]=arr[0];
		res[arr.length-1]=arr[arr.length-1];
		for(int i=1;i<arr.length-1;i++) {
			res[i]=arr[arr.length-1-i];
		}
		return res;
	}
}
