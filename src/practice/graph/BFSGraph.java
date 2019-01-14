package practice.graph;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

/**
 * Created by sharanya.p on 7/4/2018.
 */
public class BFSGraph {

    private int V; // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists

    public static void main(String[] args) {
        BFSGraph g = new BFSGraph(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);
        System.out.println("");
        g.DFS(2);
    }

    public BFSGraph(int n) {
        V = n;
        adj = new LinkedList[V];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int i, int j) {
        adj[i].add(j);
    }

    public void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[V];

        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ---> ");
            ListIterator<Integer> iterators = adj[v].listIterator();
            while (iterators.hasNext()) {
                Integer nv = iterators.next();
                if (!visited[nv]) {
                    queue.add(nv);
                    visited[nv] = true;
                }
            }
        }
    }

    boolean[] visited;

    public void DFS(int v) {
        visited = new boolean[V];
        visited[v] = true;

        DFSUtil(2);

    }

    public void DFSUtil(int n) {
        System.out.print(n + "--->");
        visited[n] = true;
        ListIterator<Integer> iterator = adj[n].listIterator();
        while (iterator.hasNext()) {
            int nv = iterator.next();
            if (!visited[nv]) {
                DFSUtil(nv);
            }
        }
    }

}
