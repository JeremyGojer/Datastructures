package com.graph.graph;

import com.linkedlist.queue.Queue;
import com.linkedlist.stack.Stack;

public class Graph {
	char [] vertices;
	int [][] mapmat;
	
	public Graph(int size) {
		vertices = new char[size];
		for (int i = 0; i < vertices.length; i++) {
			vertices[i] = (char) (i+'A');
		}
		
		mapmat = new int[size][size];
	}

	public void addEdge(char from,char to) {
		int s = from - 'A';
		int e = to - 'A';
		if(s<vertices.length && e<vertices.length) {
			if(mapmat[s][e] == 0) {
				mapmat[s][e] = 1;
			}
			else {
				System.out.println("Node already connected "+from+"-->"+to);
			}		
		}
		else {
			System.out.println("Invalid edge "+from+"-->"+to);
		}
	}
	
	public void addEdge(char from,char to,int weight) {
		int s = from - 'A';
		int e = to - 'A';
		if(weight<=0) {
			System.out.println("Invalid weight");
			return;
		}
		if(s<vertices.length && e<vertices.length) {
			if(mapmat[s][e] == 0) {
				mapmat[s][e] = weight;
				mapmat[e][s] = weight;
			}
			else {
				System.out.println("Node already connected "+from+"-->"+to);
			}		
		}
		else {
			System.out.println("Invalid edge "+from+"-->"+to);
		}
	}
	public void addUniEdge(char from,char to,int weight) {
		int s = from - 'A';
		int e = to - 'A';
		if(weight<=0) {
			System.out.println("Invalid weight");
			return;
		}
		if(s<vertices.length && e<vertices.length) {
			if(mapmat[s][e] == 0) {
				mapmat[s][e] = weight;
			}
			else {
				System.out.println("Node already connected "+from+"-->"+to);
			}		
		}
		else {
			System.out.println("Invalid edge "+from+"-->"+to);
		}
	}
	
	public void BFS(char start) {
		Queue<Character> que = new Queue<>();
		boolean [] visited = new boolean[vertices.length];
		char t=1;
		que.enqueue(start);
		while(!que.isEmpty()) {
			t = que.dequeue();
			
			if(!visited[t-'A']) {
				System.out.print(t + " ");
				visited[t-'A'] = true;
				
				for (int i = 0; i < vertices.length; i++) {
					if(mapmat[(int) (t-'A')][i] != 0) {
						que.enqueue((char) (i+'A'));
					}
				}
			}
		}
	}
	
	public void DFS(char start) {
		Stack<Character> que = new Stack<>();
		boolean [] visited = new boolean[vertices.length];
		char t=1;
		que.push(start);
		while(!que.isEmpty()) {
			t = que.pop();
			if(!visited[t-'A']) {
				System.out.print(t + " ");
				visited[t-'A'] = true;
				for (int i = 0; i < vertices.length; i++) {
					if(mapmat[(int) (t-'A')][i] != 0) {
						que.push((char) (i+'A'));
					}
				}
			}
		}
		System.out.println();
	}
	
	public void path(char start, char end) {
		Stack<Character> que = new Stack<>();
		boolean [] visited = new boolean[vertices.length];
		char t=1;
		que.push(start);
		
		while(!que.isEmpty() && t!=end) {
			t = que.pop();
			
			if(!visited[t-'A']) {
				System.out.print(t + " ");
				visited[t-'A'] = true;
				
				for (int i = 0; i < vertices.length; i++) {
					if(mapmat[(int) (t-'A')][i] != 0) {
						que.push((char) (i+'A'));
					}
				}
			}
		}
	}
	
	public String toString() {
		String str = "\n";
		str+="  | ";
		for (int i = 0; i < vertices.length; i++) {
			str += vertices[i]+" ";
		}
		str += "\n";
		for (int i = 0; i < vertices.length*2+4; i++) {
			str += "-";
		}
		str += "\n";
		for (int i = 0; i < mapmat.length; i++) {
			str += vertices[i]+" | ";
			for (int j = 0; j < mapmat.length; j++) {
				str += mapmat[i][j]+" ";
			}
			str += "\n";
		}
		return str;
	}

}
