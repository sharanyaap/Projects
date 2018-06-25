package interviewbit.graphProb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by sharanya.p on 3/2/2018.
 */
public class CloneGraph {

    public static void main(String[] args) {

    }

    HashMap<UndirectedGraphNode,UndirectedGraphNode> map;

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        map = new HashMap<>();
        return auxCloneGraph(node);
    }

    public UndirectedGraphNode auxCloneGraph(UndirectedGraphNode node){
        if (node == null)
            return node;
        if (map.containsKey(node))
            return map.get(node);
        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(node, clone);
        for (UndirectedGraphNode neighbor :node.neighbors){
            clone.neighbors.add(auxCloneGraph(neighbor));
        }
        return clone;
    }
}

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
};
