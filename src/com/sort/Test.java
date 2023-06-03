package com.sort;

public class Test {

	public static void main(String[] args) {
		int [] arr = new int[] {2,5,1,58,45,96,41,3,4,21,84,1484,7,57};
		int [] arr2 = new int[] {84,96,1484,21,45,58,1,2,3,5,7,41};
		int [] arrt = new int[] {2,4,7,1,3,6,8};
		showArray(arr);
		//bubbleSort(arr);
		//insertionSort(arr);
		//selectionSort(arr);
		//quickSort(arr);
		//mergeSort(arr);
		//heapSort(arr);
		bucketSort(arr);

		showArray(arr);
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
		if(low<high-1) {
			MergeSort(arr, low, mid);
			MergeSort(arr, mid, high);
			join(arr,low,mid,high);
		}
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
	
	
	public static void join(int [] arr,int low,int mid,int high) {
		int [] temp = new int[arr.length];
		int i=low,j=mid,k=high;

		for (k = low; k < high; k++) {
			if(arr[i]<arr[j]) {
				temp[k] = arr[i];
				i++;
			}
			else {
				temp[k] = arr[j];
				j++;
			}
			if(j==high || i==mid) {
				break;
			}
		}
		k++;
		while(j<high && k<high) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		while(i<mid && k<high) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		for (int k2 = low; k2 < high; k2++) {
			arr[k2] = temp[k2];
		}
	}
	
	public static  void heapSort(int [] arr) {
		for(int i=arr.length;i>0;i--) {
			heapify(arr, i, 0);
			int temp = arr[i-1];
			arr[i-1] = arr[0];
			arr[0] = temp;
		}
	}
	
	public static void heapify(int[] arr,int n,int i) {
		int a = (2*i)+1;
		int b = (2*i)+2;
		if(b<n) {
			heapify(arr,n,a);
			heapify(arr,n,b);
		}
		int large = i;
		if(a<n && arr[large]<arr[a]) {
			large = a;
		}
		if(b<n && arr[large]<arr[b]) {
			large = b;
		}
		int temp = arr[i];
		arr[i] = arr[large];
		arr[large] = temp;
	}
	
	public static void bucketSort(int [] arr) {
		int max=arr[0];
		for (int i = 0; i < arr.length; i++) {
			if(max<arr[i]) {
				max=arr[i];
			}
		}
		int [] temp = new int[max+1];
		for (int i = 0; i < arr.length; i++) {
			temp[arr[i]]++;
		}
		int p=0;
		for (int i = 0; i < temp.length; i++) {
			while(temp[i]!=0) {
				arr[p++]=i;
				temp[i]--;
			}
		}
	}
}
