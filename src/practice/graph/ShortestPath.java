package practice.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by sharanya.p on 7/7/2018.
 */
public class ShortestPath {

    public static void main(String[] args) {
        /* Let us create the example graph discussed above */
        int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }


    public static void dijkstra(int graph[][], int v) {
        int n = graph.length;
        int dist[] = new int[n];
        int parent[] = new int[n];
        for (int j = 0; j < n; j++) {
            dist[j] = Integer.MAX_VALUE;
            parent[j] = Integer.MAX_VALUE;
        }
        dist[v] = 0;
        parent[v] = v;
        node node = new node(0, 0);
        PriorityQueue<node> priorityQueue = new PriorityQueue<node>();
        priorityQueue.add(node);

        while (!priorityQueue.isEmpty()) {
            node = priorityQueue.poll();
            int[] adj = graph[node.v];
            for (int i = 0; i < n; i++) {
                if (adj[i] != 0 && i != node.v) {
                    if (dist[i] > dist[node.v] + adj[i]) {
                        dist[i] = node.dist + adj[i];
                        parent[i] = node.v;
                        priorityQueue.add(new node(i, dist[i]));
                    }
                }
            }
        }


        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < n; i++)
            System.out.println(i + " tt " + dist[i] + " parent "+ parent[i]);

    }

}

class node implements Comparable<node> {
    int v;
    int dist;

    public node(int v, int dist) {
        this.v = v;
        this.dist = dist;
    }

    @Override
    public int compareTo(node o) {
        return this.dist < o.dist ? 1 : 0;
    }
}