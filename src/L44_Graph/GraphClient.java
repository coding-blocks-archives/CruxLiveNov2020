package L44_Graph;

public class GraphClient {

	public static void main(String[] args) {

		Graph g = new Graph(7);

		g.addEdge(1, 2, 2);
		g.addEdge(2, 3, 3);
		g.addEdge(1, 4, 10);
		g.addEdge(3, 4, 1);
		g.addEdge(4, 5, 8);
		g.addEdge(5, 6, 5);
		g.addEdge(5, 7, 6);
		g.addEdge(6, 7, 4);

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

//		System.out.println(g.isCyclic());
//		System.out.println(g.isConnected());
//		System.out.println(g.isTree());
//		System.out.println(g.getCC());
		
//		g.kruskal() ;
//		g.prims();
		g.dijkstra(1);

	}

}
