package practice.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by sharanya.p on 7/8/2018.
 */
public class TopologicalSortGraph {

    private int v;
    private LinkedList<Integer> adj[];

    public TopologicalSortGraph(int n) {
        this.v = n;
        adj = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v) {
        adj[u].add(v);
    }

    public void topologicalSort() {
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++)
            visited[i] = false;

        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                topologicalSortUtil(i, visited, stack);
            }
        }

        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }

    public void topologicalSortUtil(int v, boolean visited[],
                                    Stack stack) {

        visited[v] = true;
        Iterator<Integer> iterator = adj[v].iterator();
        while (iterator.hasNext()) {
            int u = iterator.next();

            if (!visited[u]) {
                topologicalSortUtil(u, visited, stack);
            }
        }

        stack.push(v);
    }

    // Driver method
    public static void main(String args[]) {
        // Create a graph given in the above diagram
        TopologicalSortGraph g = new TopologicalSortGraph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
    }

}
