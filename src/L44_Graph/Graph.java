package L44_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
		map.get(v2).put(v1, cost);

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

}
