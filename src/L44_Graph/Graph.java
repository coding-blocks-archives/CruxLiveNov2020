package L44_Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	HashMap<Integer, HashMap<Integer, Integer>> map;

	public Graph(int V) {
		map = new HashMap<>();

		for (int i = 1; i <= V; i++) {
			map.put(i, new HashMap<>());
		}

	}

	public void addEdge(int v1, int v2, int cost) {

		map.get(v1).put(v2, cost);
		// map.get(v2).put(v1, cost);

	}

	public boolean containsEdge(int v1, int v2) {
		return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);
	}

	public void removeEdge(int v1, int v2) {

		map.get(v1).remove(v2);
		map.get(v2).remove(v1);
	}

	public int numEdges() {

		int sum = 0;

		for (int key : map.keySet()) {
			sum += map.get(key).size();
		}

		return sum / 2;
	}

	public void display() {

		for (int key : map.keySet()) {
			System.out.println(key + " -> " + map.get(key));
		}
	}

	public boolean hasPath(int src, int dst, HashSet<Integer> visited) {

		// mark your src as visited
		visited.add(src);

		// if src and dst are = then you have found a path
		if (src == dst)
			return true;

		// check if path exists via nbrs
		for (int nbr : map.get(src).keySet()) {

			if (!visited.contains(nbr)) {

				boolean res = hasPath(nbr, dst, visited);

				if (res)
					return true;
			}

		}

		return false;

	}

	public void printAllPaths(int src, int dst, HashSet<Integer> visited, String str) {

		// mark your src as visited
		visited.add(src);

		// if src and dst are = then you will print
		if (src == dst)
			System.out.println(str);

		// check if path exists via nbrs
		for (int nbr : map.get(src).keySet()) {

			if (!visited.contains(nbr)) {

				printAllPaths(nbr, dst, visited, str + nbr);

			}

		}

		// undo
		visited.remove(src);

	}

	public boolean BFS(int src, int dst) {

		HashSet<Integer> visited = new HashSet<Integer>();

		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);

		while (!q.isEmpty()) {

			// remove
			int rn = q.remove();

			// second time if a node is being removed then you can ignore it
			if (visited.contains(rn))
				continue;

			// visited mark
			visited.add(rn);

			// rn = dst
			if (rn == dst)
				return true;

			// nbrs
			for (int nbr : map.get(rn).keySet()) {

				if (!visited.contains(nbr)) {
					q.add(nbr);
				}
			}

		}

		return false;

	}

	public boolean DFS(int src, int dst) {

		HashSet<Integer> visited = new HashSet<Integer>();

		Stack<Integer> s = new Stack<Integer>();
		s.push(src);

		while (!s.isEmpty()) {

			// remove
			int rn = s.pop();

			// second time if a node is being removed then you can ignore it
			if (visited.contains(rn))
				continue;

			// visited mark
			visited.add(rn);

			// rn = dst
			if (rn == dst)
				return true;

			// nbrs
			for (int nbr : map.get(rn).keySet()) {

				if (!visited.contains(nbr)) {
					s.push(nbr);
				}
			}

		}

		return false;

	}

	public void BFT() {

		HashSet<Integer> visited = new HashSet<Integer>();

		Queue<Integer> q = new LinkedList<Integer>();

		for (int src : map.keySet()) {

			if (visited.contains(src))
				continue;

			q.add(src);

			while (!q.isEmpty()) {

				// remove
				int rn = q.remove();

				// second time if a node is being removed then you can ignore it
				if (visited.contains(rn))
					continue;

				// visited mark
				visited.add(rn);

				// print
				System.out.print(rn + " ");

				// nbrs
				for (int nbr : map.get(rn).keySet()) {

					if (!visited.contains(nbr)) {
						q.add(nbr);
					}
				}

			}
		}

		System.out.println();

	}

	public void DFT() {

		HashSet<Integer> visited = new HashSet<Integer>();

		Stack<Integer> s = new Stack<Integer>();

		for (int src : map.keySet()) {

			if (visited.contains(src))
				continue;

			s.push(src);

			while (!s.isEmpty()) {

				// remove
				int rn = s.pop();

				// second time if a node is being removed then you can ignore it
				if (visited.contains(rn))
					continue;

				// visited mark
				visited.add(rn);

				// print
				System.out.print(rn + " ");

				// nbrs
				for (int nbr : map.get(rn).keySet()) {

					if (!visited.contains(nbr)) {
						s.push(nbr);
					}
				}

			}
		}

		System.out.println();

	}

	public boolean isCyclic() {

		HashSet<Integer> visited = new HashSet<Integer>();

		Queue<Integer> q = new LinkedList<Integer>();

		for (int src : map.keySet()) {

			if (visited.contains(src))
				continue;

			q.add(src);

			while (!q.isEmpty()) {

				// remove
				int rn = q.remove();

				// second time if a node is being removed then you can ignore it
				if (visited.contains(rn))
					return true;

				// visited mark
				visited.add(rn);

				// nbrs
				for (int nbr : map.get(rn).keySet()) {

					if (!visited.contains(nbr)) {
						q.add(nbr);
					}
				}

			}
		}

		return false;

	}

	public boolean isConnected() {

		int components = 0;

		HashSet<Integer> visited = new HashSet<Integer>();

		Queue<Integer> q = new LinkedList<Integer>();

		for (int src : map.keySet()) {

			if (visited.contains(src))
				continue;

			components++;

			q.add(src);

			while (!q.isEmpty()) {

				// remove
				int rn = q.remove();

				// second time if a node is being removed then you can ignore it
				if (visited.contains(rn))
					continue;

				// visited mark
				visited.add(rn);

				// nbrs
				for (int nbr : map.get(rn).keySet()) {

					if (!visited.contains(nbr)) {
						q.add(nbr);
					}
				}

			}
		}

		return components == 1;
	}

	public boolean isTree() {
		return !isCyclic() && isConnected();
	}

	public ArrayList<ArrayList<Integer>> getCC() {

		ArrayList<ArrayList<Integer>> bl = new ArrayList<>();

		HashSet<Integer> visited = new HashSet<Integer>();

		Queue<Integer> q = new LinkedList<Integer>();

		for (int src : map.keySet()) {

			if (visited.contains(src))
				continue;

			ArrayList<Integer> sl = new ArrayList<>();
			bl.add(sl);

			q.add(src);

			while (!q.isEmpty()) {

				// remove
				int rn = q.remove();

				// second time if a node is being removed then you can ignore it
				if (visited.contains(rn))
					continue;

				// visited mark
				visited.add(rn);

				// add in small list
				sl.add(rn);

				// nbrs
				for (int nbr : map.get(rn).keySet()) {

					if (!visited.contains(nbr)) {
						q.add(nbr);
					}
				}

			}
		}

		return bl;

	}

	private class DisjointSet {

		private class Node {
			int data;
			Node parent;
			int rank;
		}

		private HashMap<Integer, Node> mapping = new HashMap<>();

		public void create(int value) {

			Node nn = new Node();
			nn.data = value;
			nn.parent = nn;
			nn.rank = 0;

			mapping.put(value, nn);
		}

		public void union(int value1, int value2) {

			Node n1 = mapping.get(value1);
			Node n2 = mapping.get(value2);

			Node re1 = find(n1);
			Node re2 = find(n2);

			if (re1 == re2)
				return;
			else {

				if (re1.rank == re2.rank) {
					re2.parent = re1;
					re1.rank++;
				} else if (re1.rank > re2.rank) {
					re2.parent = re1;
				} else {
					re1.parent = re2;
				}
			}

		}

		public int find(int value) {

			Node n = mapping.get(value);
			return find(n).data;
		}

		private Node find(Node node) {

			if (node.parent == node)
				return node;

			Node rr = find(node.parent);
			node.parent = rr; // path compression
			return rr;
		}

	}

	private class EdgePair implements Comparable<EdgePair> {

		int v1;
		int v2;
		int cost;

		public EdgePair(int v1, int v2, int cost) {
			this.v1 = v1;
			this.v2 = v2;
			this.cost = cost;
		}

		@Override
		public int compareTo(EdgePair o) {
			return this.cost - o.cost;
		}

		@Override
		public String toString() {
			return v1 + "-" + v2 + "@" + cost;
		}
	}

	public ArrayList<EdgePair> getAllEdges() {

		ArrayList<EdgePair> edges = new ArrayList<>();

		for (int vertex : map.keySet()) {

			for (int nbr : map.get(vertex).keySet()) {

				EdgePair np = new EdgePair(vertex, nbr, map.get(vertex).get(nbr));
				edges.add(np);
			}

		}

		return edges;

	}

	public void kruskal() {

		DisjointSet ds = new DisjointSet();

		// create a new set for all the vertices
		for (int vertex : map.keySet()) {
			ds.create(vertex);
		}

		// get all edges
		ArrayList<EdgePair> edges = getAllEdges();
		// edges sort on the basis of cost
		Collections.sort(edges);

		for (EdgePair e : edges) {

			int re1 = ds.find(e.v1);
			int re2 = ds.find(e.v2);

			if (re1 == re2) {
				// do nothing
			} else {
				System.out.println(e);
				ds.union(e.v1, e.v2);
			}

		}

	}

	private class PrimsPair implements Comparable<PrimsPair> {

		int vname;
		int acqvname;
		int cost;

		public PrimsPair(int vname, int acqvname, int cost) {
			this.vname = vname;
			this.acqvname = acqvname;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return vname + " via " + acqvname + " @ " + cost;
		}

		@Override
		public int compareTo(PrimsPair o) {
			return this.cost - o.cost;
		}
	}

	public void prims() {

		PriorityQueue<PrimsPair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[map.size() + 1];

		// create a starting pair
		PrimsPair sp = new PrimsPair(1, 0, 0);
		// put pair in priority queue
		pq.add(sp);

		// work till pq is not empty
		while (!pq.isEmpty()) {

			// remove the pair with minimum cost
			PrimsPair rp = pq.remove();

			// if removed vertex is already visited then ignore it
			if (visited[rp.vname])
				continue;

			// visited mark
			visited[rp.vname] = true;

			// printing
			if (rp.acqvname != 0)
				System.out.println(rp);

			// work for nbrs
			for (int nbr : map.get(rp.vname).keySet()) {

				// work only for unvisited nbrs
				if (!visited[nbr]) {

					// make a pair for nbr and put in priority queue
					PrimsPair np = new PrimsPair(nbr, rp.vname, map.get(rp.vname).get(nbr));
					pq.add(np);
				}
			}

		}

	}

	private class DijkstraPair implements Comparable<DijkstraPair> {

		int vname;
		String psf;
		int csf;

		public DijkstraPair(int vname, String acqvname, int cost) {
			this.vname = vname;
			this.psf = acqvname;
			this.csf = cost;
		}

		@Override
		public String toString() {
			return vname + " via " + psf + " @ " + csf;
		}

		@Override
		public int compareTo(DijkstraPair o) {
			return this.csf - o.csf;
		}
	}

	public void dijkstra(int src) {

		PriorityQueue<DijkstraPair> pq = new PriorityQueue<>();
		boolean[] visited = new boolean[map.size() + 1];

		// create a starting pair
		DijkstraPair sp = new DijkstraPair(src, src + "", 0);
		// put pair in priority queue
		pq.add(sp);

		// work till pq is not empty
		while (!pq.isEmpty()) {

			// remove the pair with minimum cost
			DijkstraPair rp = pq.remove();

			// if removed vertex is already visited then ignore it
			if (visited[rp.vname])
				continue;

			// visited mark
			visited[rp.vname] = true;

			// printing
			System.out.println(rp);

			// work for nbrs
			for (int nbr : map.get(rp.vname).keySet()) {

				// work only for unvisited nbrs
				if (!visited[nbr]) {

					// make a pair for nbr and put in priority queue
					DijkstraPair np = new DijkstraPair(nbr, rp.psf + nbr, rp.csf + map.get(rp.vname).get(nbr));
					pq.add(np);
				}
			}

		}

	}

	public void bellmanFord(int src) {

		int V = map.size();

		// creating and filling the distance array
		int[] dist = new int[V + 1];
		Arrays.fill(dist, 100000);
		dist[src] = 0;

		ArrayList<EdgePair> edges = getAllEdges();

		// relax V times
		for (int i = 1; i <= V; i++) {

			for (EdgePair edge : edges) {

				int oc = dist[edge.v2];
				int nc = dist[edge.v1] + edge.cost;

				if (nc < oc) {

					if (i <= V - 1)
						dist[edge.v2] = nc;
					else {
						System.out.println("-ve wt cycle present");
						return;
					}

				}

			}

		}

		// distance array print
		for (int i = 1; i <= V; i++) {
			System.out.println(i + " -> " + dist[i]);
		}

	}

	public void floydWarshall() {

		int V = map.size();

		int[][] dist = new int[V + 1][V + 1];

		for (int i = 1; i < dist.length; i++) {
			for (int j = 1; j < dist[0].length; j++) {

				if (i == j)
					dist[i][j] = 0;
				else
					dist[i][j] = 100000;
			}
		}

		for (int vertex : map.keySet()) {

			for (int nbr : map.get(vertex).keySet()) {
				dist[vertex][nbr] = map.get(vertex).get(nbr);
			}

		}

		// logic ...
		for (int k = 1; k <= V; k++) {

			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {

					int oc = dist[i][j];
					int nc = dist[i][k] + dist[k][j];

					if (nc < oc)
						dist[i][j] = nc;
				}
			}
		}

		// printing
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {

				System.out.print(dist[i][j] + "\t");
			}

			System.out.println();
		}

	}

}