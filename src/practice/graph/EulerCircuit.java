package practice.graph;

import java.util.LinkedList;

/**
 * Created by sharanya.p on 1/16/2019.
 */
public class EulerCircuit {

    int V;
    LinkedList<Integer> adj[];
    int in[];

    public EulerCircuit(int v) {
        V = v;
        adj = new LinkedList[V];
        in = new int[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
            in[i] = 0;
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
        in[w]++;
    }

    public boolean isEulerianCycle() {
        if (!isSC()) {
            return false;
        }

        for (int i = 0; i < V; i++) {
            if (adj[i].size() != in[i])
                return false;
        }
        return true;
    }

    public boolean isSC() {
        boolean visited[] = new boolean[V];

        for (int i = 0; i < V; i++) {

        }
        return false;
    }


    public void DFSUtil() {

    }

    public static void main(String[] args) {
        EulerCircuit g = new EulerCircuit(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 0);

        if (g.isEulerianCycle())
            System.out.println("Given directed graph is eulerian ");
        else
            System.out.println("Given directed graph is NOT eulerian ");
    }


}


