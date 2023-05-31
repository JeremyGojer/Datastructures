package com.tree.binarysearchtree;

public class Node {
	int data;
	Node left;
	Node right;
	
	public Node(int data) {
		this.data = data;
		this.left = this.right = null;
	}
	
	public int getData() {
		return data;
	}
	
	public Node getLeft() {
		return left;
	}
	
	public Node getRight() {
		return right;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public void setLeft(Node left) {
		this.left = left;
	}
	
	public void setRight(Node right) {
		this.right = right;
	}

	public String toString() {
		return data+"";
	}
	
}
