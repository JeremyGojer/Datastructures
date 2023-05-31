package com.tree.binarysearchtree;

import com.linkedlist.queue.Queue;
import com.linkedlist.stack.Stack;

public class BST {
	
	Node root;
	
	public BST() {
		root = null;
	}
	
	//uses recursion
	public void insert(int data) {
		if(root==null) {
			Node temp = new Node(data);
			root = temp;
		}
		else {
			root = _insert(data,root); 
		}
	}

	private Node _insert(int data, Node it) {
		if(it!=null) {
			if(it.getData()>data) {
				it.setLeft(_insert(data,it.getLeft()));
			}
			else {
				it.setRight(_insert(data,it.getRight()));
			}
		}
		else {
			Node temp = new Node(data);
			it = temp;
		}
		return it;
	}
	
	public void inorder() {
		if(root!=null) {
			_inorder(root);
			System.out.println();
		}
		else {
			System.out.println("Tree is empty");
		}
		
	}
	public void inorderr() {
		if(root==null) {
			System.out.println("Tree is empty");
		}
		else {
			Node it = root;
			Stack<Node> stk = new Stack<>();
			stk.push(it);
			while(!stk.isEmpty()) {
				while(it.getLeft()!=null) {
					stk.push(it.getLeft());
					it = it.getLeft();
				}
				Node t = stk.pop();
				System.out.print(t.getData()+" ");
				if(t.getRight()!=null) {
					stk.push(t.getRight());
					it = t.getRight();
				}
			}
			System.out.println();
		}
		
	}
	
	private void _inorder(Node it) {
		if(it!=null) {
			_inorder(it.getLeft());
			System.out.print(it.getData()+" ");
			_inorder(it.getRight());
		}
	}
	
	public void preorder() {
		if(root!=null) {
			_preorder(root);
			System.out.println();
		}
		else {
			System.out.println("Tree is empty");
		}
	}

	private void _preorder(Node it) {
		if(it!=null) {
			System.out.print(it.getData()+" ");
			_preorder(it.getLeft());
			_preorder(it.getRight());
		}
	}
	
	public void postorder() {
		if(root!=null) {
			_postorder(root);
			System.out.println();
		}
		else {
			System.out.println("Tree is empty");
		}
	}

	private void _postorder(Node it) {
		if(it!=null) {
			_postorder(it.getLeft());
			_postorder(it.getRight());
			System.out.print(it.getData()+" ");
		}
	}
	
	public void BFS() {
		Node it = root;
		Queue<Node> queue = new Queue<>();
		if(it!=null) {
			queue.enqueue(it);
			while(!queue.isEmpty()) {
				Node tmp = queue.dequeue();
				System.out.print(tmp.getData()+" ");
				if(tmp.getLeft()!=null) {
					queue.enqueue(tmp.getLeft());
				}
				if(tmp.getRight()!=null) {
					queue.enqueue(tmp.getRight());
				}
			}
			System.out.println();
		}
		else {
			System.out.println("Tree is empty");
		}
	}
	
	public Node findNode(int data) {
		Node it = root;
		if(it!=null) {
			while(it!=null && it.getData()!=data) {
				if(it.getData()>data) {
					it = it.getLeft();
				}
				else {
					it = it.getRight();
				}
			}
		}
		if(it==null) {
			System.out.println("Not found");
		}
		return it;
	}
	
	public Node delete(int data) {
		Node it = root;
		Node p = it;
		if(it!=null) {
			while(it!=null && it.getData()!=data) {
				p = it;
				if(it.getData()>data) {
					it = it.getLeft();
				}
				else {
					it = it.getRight();
				}
			}
		}
		// if node is found
		if(it!=null) {
			//Node has no children
			if(it.getLeft()==null && it.getRight()==null) {
				if(p.getLeft()==it) {
					p.setLeft(null);
				}
				if(p.getRight()==it) {
					p.setRight(null);
				}
			}//Node has one right child
			else if(it.getLeft()==null && it.getRight()!=null) {
				if(p.getLeft()==it) {
					p.setLeft(it.getRight());
				}
				if(p.getRight()==it) {
					p.setRight(it.getRight());
				}
				it.setRight(null);
			}//Node has one left child
			else if(it.getRight()==null && it.getLeft()!=null) {
				if(p.getLeft()==it) {
					p.setLeft(it.getLeft());
				}
				if(p.getRight()==it) {
					p.setRight(it.getLeft());
				}
				it.setLeft(null);
			}//Node has two children
			else {
				Node itx = it.getRight(); //Take right node
				Node itf = itx;
				while(itx.getLeft() != null) {// Go left until a node who doesnt have a left child
					itf = itx;
					itx = itx.getLeft();
				}
				int temp = it.getData(); //Swap values with replacement
				it.setData(itx.getData());
				itx.setData(temp);
				itf.setLeft(itx.getRight()); //Set left of prev node with right of itx
				itx.setRight(null);
			}
		}
		
		return it;
	}
	
	
}