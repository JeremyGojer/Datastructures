package com.queue;

public class CirQueue {
	int f;
	int r;
	int [] queue;
	public int size=10;
	
	public CirQueue() {
		f=r=-1;
		queue = new int[size];
	}
	
	public CirQueue(int size) {
		f=r=-1;
		this.size=size;
		queue = new int[size];
	}

	public void enqueue(int data) {
		
		if(isFull()) {
			System.out.println("Queue full for "+data);
			return;
		}
		if(r==-1) {
			f=0;
		}
//		r = (r+1)%size;
//		queue[r]=data;
		queue[++r%size]=data;
	}

	public int dequeue() {
		int data = -1;
		if(r!=-1) {
//			data = f%size;
//			f++;
			data = queue[f++%size];
			if(r+1==f) {
				r=f=-1;
			}
		}
		return data;
	}
	
	public boolean isFull() {
//		return (queue.length-1==r && f==0) || (f%size)==(r%size)+1;
		return r-f == size-1;
	}
	
	public String toString() {
		String str = "";
		if(r!=-1) {
			System.out.println(f+"--"+r);
			for (int i = f; i <= r;i++) {
				System.out.println(f+"---"+r+"---"+i);
				str += queue[i%size]+"|";
			}
		}
		else {
			str += "Queue is empty";
		}
		return str;
	}
}