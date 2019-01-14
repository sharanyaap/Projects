package practice.graph;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by sharanya.p on 7/8/2018.
 */
public class UnDirectedGraph {

    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; // Adjacency List Represntation

    public UnDirectedGraph(int n) {
        this.V = n;
        adj = new LinkedList[n];
        for (int i = 0; i < V; ++i)
            adj[i] = new LinkedList();
    }

    public void addEdge(int s, int e) {
        adj[s].add(e);
        adj[e].add(s);
    }

    public boolean isCyclic() {
        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        // Call the recursive helper function to detect cycle in
        // different DFS trees
        for (int u = 0; u < V; u++)
            if (!visited[u]) // Don't recur for u if already visited
                if (isCyclicUtil(u, visited, -1))
                    return true;

        return false;

    }

    public boolean isCyclicUtil(int v, boolean visited[], int parent) {
        // Mark the current node as visited
        visited[v] = true;
        Integer i;

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> it = adj[v].iterator();
        while (it.hasNext()) {
            i = it.next();

            // If an adjacent is not visited, then recur for that
            // adjacent
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, v))
                    return true;
            }

            // If an adjacent is visited and not parent of current
            // vertex, then there is a cycle.
            else if (i != parent)
                return true;
        }
        return false;
    }

    public static void main(String args[]) {
        UnDirectedGraph g1 = new UnDirectedGraph(5);

        g1.addEdge(1, 0);
        g1.addEdge(0, 2);
        g1.addEdge(2, 0);
        g1.addEdge(0, 3);
        g1.addEdge(3, 4);

        if (g1.isCyclic())
            System.out.println("UnDirectedGraph contains cycle");
        else
            System.out.println("UnDirectedGraph doesn't contains cycle");

        UnDirectedGraph g2 = new UnDirectedGraph(3);
        g2.addEdge(0, 1);
        g2.addEdge(1, 2);
        g2.addEdge(2,2);
        if (g2.isCyclic())
            System.out.println("UnDirectedGraph contains cycle");
        else
            System.out.println("UnDirectedGraph doesn't contains cycle");
    }

}

