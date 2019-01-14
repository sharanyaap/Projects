package practice.graph;

/**
 * Created by sharanya.p on 11/29/2018.
 */
public class KMST {

    class subset {
        int rank;
        int parent;
    }

    class Edge implements Comparable<Edge> {
        int src, dest, weight;

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    private int find(subset[] subsets, int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    private void union(subset[] subsets, int src, int dest) {
        int x = find(subsets, src);
        int y = find(subsets, dest);
        if (subsets[x].rank < subsets[y].rank) {
            subsets[x].parent = y;
        } else if (subsets[y].rank < subsets[x].rank) {
            subsets[y].parent = x;
        } else {
            subsets[y].parent = x;
            subsets[x].rank++;
        }
    }



}
