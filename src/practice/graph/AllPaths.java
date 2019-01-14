package practice.graph;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by sharanya.p on 10/1/2018.
 */
public class AllPaths {

    LinkedList<Integer> adj[];
    int V;

    public AllPaths(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new LinkedList<>();
        }
        //Arrays.stream(adj).forEach(a -> a = new LinkedList<>());
    }

    private void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public static void main(String[] args) {

        AllPaths g = new AllPaths(4);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);

        int s = 2, d = 3;
        System.out.println(g.countPaths(s, d));
    }

    private int countPaths(int s, int d) {
        int cnt = 0;
        boolean visited[] = new boolean[V];
        Arrays.fill(visited, false);
        return DFSUtil(s, d, cnt, visited);
    }

    private int DFSUtil(int node, int d, int cnt, boolean visited[]) {
        visited[node] = true;
        if (node == d) {
            cnt++;
        }
        Iterator<Integer> it = adj[node].iterator();
        while (it.hasNext()) {
            Integer nn = it.next();
            if (!visited[nn])
                cnt = DFSUtil(nn, d, cnt, visited);
        }
        visited[node] = false;
        return cnt;
    }

}
