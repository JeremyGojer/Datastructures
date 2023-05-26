package com.datastructures;

public interface LinkedList {
	public boolean insert(int data);
	
	public boolean append(int data);
	
	public boolean insert(int data,int pos);
	
	public int delete();
	
	public int deletelast();
	
	public int delete(int pos);
	
	public void reverse();
}	
