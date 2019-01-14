package practice.bst;

/**
 * Created by sharanya.p on 11/28/2018.
 */
public class IntervalTree {
    class Node {
        Interval interval;
        int highTree;
        Node left;
        Node right;

        public Node() {
        }

        public Node(Interval i) {
            Node node = new Node();
            node.interval = i;
            node.left = null;
            node.right = null;
            node.highTree = i.high;
        }
    }


    public static void main(String[] args) {
        // Let us create interval tree shown in above figure
        /*Interval appt[] = { {1, 5}, {3, 7}, {2, 6}, {10, 15},
                {5, 6}, {4, 100}};
        int n = sizeof(appt)/sizeof(appt[0]);*/
    }


}

class Interval {
    int low;
    int high;

    public Interval(int low, int high) {
        this.low = low;
        this.high = high;
    }
}