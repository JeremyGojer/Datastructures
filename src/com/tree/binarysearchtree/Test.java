package com.tree.binarysearchtree;

public class Test {

	public static void main(String[] args) {
		BST bst = new BST();
		
		bst.insert(75);
		bst.insert(43);
		bst.insert(98);
		bst.insert(35);
		bst.insert(56);
		bst.insert(89);
		bst.insert(100);
		bst.insert(54);
		bst.insert(95);
		
		bst.inorder();
		bst.inorderr();
//		bst.preorder();
//		bst.postorder();
//		bst.BFS();
//		bst.delete(75);
//		System.out.println("After deletion");
//		bst.inorder();
	}

}