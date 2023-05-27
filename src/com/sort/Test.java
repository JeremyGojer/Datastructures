package com.sort;

public class Test {

	public static void main(String[] args) {
		int [] arr = new int[] {2,5,1,58,45,96,41,3,4,21,84,1484,7};
		int [] arr2 = new int[] {21,45,58,84,96,1484,1,2,3,5,7,41};
		showArray(arr2);
		//bubbleSort(arr);
		//insertionSort(arr);
		//selectionSort(arr);
		//quickSort(arr);
		join(arr2,0,arr2.length);
		showArray(arr2);
		//joinarr();
		
	}
	
	public static void bubbleSort(int [] arr) {
		
		for(int i=0;i<arr.length;i++) {
			for (int j = 1; j < arr.length-i; j++) {
				if(arr[j-1]>arr[j]) {
					int temp = arr[j];
					arr[j] = arr[j-1];
					arr[j-1] = temp;
				}
			}
		}
	}
	
	public static void insertionSort(int [] arr) {
		for (int i = 1; i < arr.length; i++) {
			int j=i;
			int n = arr[j];
			while(j>0 && arr[j-1]>n) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j]=n;
		}
	}
	
	public static void selectionSort(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min_ind = i;
			
			for (int j = i+1; j < arr.length; j++) {
				if(arr[j]<arr[min_ind]) {
					min_ind = j;
				}
			}
			int temp = arr[min_ind];
			arr[min_ind] = arr[i];
			arr[i] = temp;
		}
	}
	
	public static void showArray(int [] arr) {
		String str = "";
		for (int i = 0; i < arr.length; i++) {
			str += arr[i]+" ";
		}
		System.out.println(str);
	}

	public static void quickSort(int [] arr) {
		QuickSort(arr, 0, arr.length-1);
	}

	private static void QuickSort(int [] arr,int low,int high) {
		if(low<high) {
			int p = partition(arr,low,high);
			QuickSort(arr, low, p-1);
			QuickSort(arr, p+1, high);
		}
	}

	private static int partition(int[] arr, int low, int high) {
		int i=low;
		int j=high-1;
		int p =arr[high];
		while(i<=j) {
			if(arr[i]>p) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
			}
			else {
				i++;
			}
		}
		arr[high] = arr[i];
		arr[i] = p;
		
		return i;
	}

	public static void mergeSort(int [] arr) {
		MergeSort(arr,0,arr.length);
	}

	private static void MergeSort(int[] arr, int low, int high) {
		int mid= (low+high)/2;
		if(low<high) {
			MergeSort(arr, low, mid);
			MergeSort(arr, mid+1, high);
			join(arr,low,high);
		}
		
	}

	public static void join(int[] arr, int low, int high) {
		int mid = (low+high)/2;
		int i=low;
		int j=mid;
		
		int k=low;
		for (k = 0; k < high; k++) {
			if(arr[i]<arr[j]) {
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
				i++;
			}
			else {
				int temp = arr[k];
				arr[k] = arr[j];
				arr[j] = temp;
				j++;
			}
			if(j==high || i==mid) {
				break;
			}
		}
		k++;
		while(j<high) {
			int temp = arr[k];
			arr[k] = arr[j];
			arr[j] = temp;
			j++;
			k++;
		}
		while(i<mid) {
			int temp = arr[k];
			arr[k] = arr[i];
			arr[i] = temp;
			i++;
			k++;
		}
		showArray(arr);
	}
	
	public static void joinarr() {
		int [] arr1 = new int[] {1,3,5,10};
		int [] arr2 = new int[] {2,4,8,9};
		int [] arr = new int[8];
		
		int i=0,j=0,k=0;
		for (k = 0; k < arr.length; k++) {
			if(arr1[i]<arr2[j]) {
				arr[k] = arr1[i];
				i++;
			}
			else {
				arr[k] = arr2[j];
				j++;
			}
			if(j==arr2.length || i==arr1.length) {
				break;
			}
		}
		k++;
		while(j<arr2.length) {
			arr[k] = arr2[j];
			j++;
			k++;
		}
		while(i<arr2.length) {
			arr[k] = arr1[i];
			i++;
			k++;
		}
		showArray(arr);
		
	}
}
