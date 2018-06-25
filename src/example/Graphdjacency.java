package example;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by sharanya.p on 1/7/2018.
 */
public class Graphdjacency {

    public static void main(String args[]) {
        int V = 4;
        Vector<Integer> adj[] = new Vector[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new Vector<>();
        }

        addEdge(adj, 0, 2);
        addEdge(adj, 0, 3);
        addEdge(adj, 1, 3);
        addEdge(adj, 2, 3);

        System.out.println("Sum of dependencies is " +
                findSum(adj, V));
    }

    private static void addEdge(Vector[] edges, int src, int dest){
        edges[src].addElement(dest);
    }

    private static int findSum(Vector[] adj, int V){
        int sum = 0;

        // just find the size at each vector's index
        for (int u = 0; u < V; u++)
            sum += adj[u].size();

        return sum;
    }

}

