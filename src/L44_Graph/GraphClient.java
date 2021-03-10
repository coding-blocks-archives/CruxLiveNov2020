package L44_Graph;

public class GraphClient {

	public static void main(String[] args) {
		
		Graph g = new Graph(7) ;
		
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
		
		

	}

}
