package L44_Graph;

import java.util.HashSet;

public class GraphClient {

	public static void main(String[] args) {

		Graph g = new Graph(7);

		g.addEdge(1, 2, 10);
		g.addEdge(2, 3, 20);
		g.addEdge(1, 4, 60);
		g.addEdge(3, 4, 30);
		g.addEdge(4, 5, 80);
		g.addEdge(5, 6, 90);
		g.addEdge(5, 7, 14);
		g.addEdge(6, 7, 13);

		g.display();

		System.out.println(g.containsEdge(1, 2));
		System.out.println(g.numEdges());

//		g.removeEdge(4, 5);
//		g.removeEdge(3, 4);
//		g.removeEdge(6, 7);
//		System.out.println(g.hasPath(1, 6, new HashSet<Integer>()));
//		g.printAllPaths(1, 6, new HashSet<Integer>(), "1");
//		
//		System.out.println(g.DFS(1, 6));
//		g.BFT(); 
//		g.DFT();

		System.out.println(g.isCyclic());
		System.out.println(g.isConnected());
		System.out.println(g.isTree());
		System.out.println(g.getCC());

	}

}
