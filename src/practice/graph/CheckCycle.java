package practice.graph;

import java.util.Arrays;

/**
 * Created by sharanya.p on 10/1/2018.
 */
public class CheckCycle {

    int V;
    int E;
    Edge edge[];

    public CheckCycle(int v, int e) {
        V = v;
        E = e;
        edge = new Edge[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new Edge();
        }
    }


    class Edge {
        int src;
        int dest;
    }

    class Subset {
        int parent;
        int rank;
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset subset[], int src, int dest) {
        int s = find(subset, src);
        int d = find(subset, dest);
        if (subset[s].rank < subset[d].rank) {
            subset[s].parent = d;
        } else if (subset[d].rank < subset[s].rank) {
            subset[d].parent = s;
        } else {
            subset[s].parent = d;
            subset[d].rank++;
        }
    }

    boolean isCycle(CheckCycle graph) {
        int V = graph.V;
        int E = graph.E;

        Subset[] subsets = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        for (int e = 0; e < E; e++) {
            int x = find(subsets, graph.edge[e].src);
            int y = find(subsets, graph.edge[e].dest);
            if (x == y)
                return true;
            union(subsets, x, y);
        }
        return false;
    }

    public static void main(String args[]) {
        CheckCycle graph = new CheckCycle(3, 3);
// add edge 0-1
        graph.edge[0].src = 0;
        graph.edge[0].dest = 1;

// add edge 1-2
        graph.edge[1].src = 1;
        graph.edge[1].dest = 2;

// add edge 0-2
        graph.edge[2].src = 0;
        graph.edge[2].dest = 2;

        if (graph.isCycle(graph))
            System.out.println("Contains cycle");
        else {
            System.out.println("Does not contain cycle");
        }

    }

}
