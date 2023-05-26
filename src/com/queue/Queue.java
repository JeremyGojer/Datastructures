package com.queue;

public class Queue implements com.datastructures.Queue{
	int f;
	int r;
	int [] queue;
	
	public Queue() {
		f=r=-1;
		queue = new int[10];
	}
	
	public Queue(int size) {
		f=r=-1;
		queue = new int[size];
	}

	public void enqueue(int data) {
		if(f==-1) {
			f=0;
		}
		if(r<queue.length-1) {
			queue[++r]=data;
		}
		else{
			System.out.println("Queue full for "+data);
		}	
	}

	public int dequeue() {
		int data = 0;
		if(r!=-1) {
			data = queue[f++];
			if(r+1==f) {
				r=f=-1;
			}
		}
		return data;
	}
	
	public String toString() {
		String str = "";
		if(r!=-1) {
			for (int i = f; i <= r; i++) {
				str += queue[i]+"|";
			}
		}
		else {
			str += "Queue is empty";
		}
		return str;
	}
	
}
