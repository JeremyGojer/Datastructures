package com.graph.graph;

public class Test {

	public static void main(String[] args) {
		Graph graph = new Graph(9);
		
		graph.addEdge('A', 'B', 4);
		graph.addEdge('B', 'C', 8);
		graph.addEdge('C', 'D', 7);
		graph.addEdge('D', 'E', 9);
		graph.addEdge('E', 'F', 10);
		graph.addEdge('F', 'G', 2);
		graph.addEdge('G', 'H', 1);
		graph.addEdge('H', 'A', 8);
		graph.addEdge('H', 'B', 11);
		graph.addEdge('H', 'I', 7);
		graph.addEdge('C', 'I', 2);
		graph.addEdge('I', 'G', 6);
		
		graph.DFS('A');
		graph.path('A', 'D');
		
		System.out.println(graph);
	}

}
