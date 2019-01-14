package practice.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

/**
 * Created by sharanya.p on 8/23/2018.
 */
public class TrainPlatform {

    static class Node implements Comparable<Node> {
        int start;
        int end;

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            return this.end <= o.end ? -1 : 1;
        }
    }

    static int findPlatform(int[] arr, int dep[], int n) {
        int res = 0;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(arr[i], dep[i]);
            nodes[i].start = arr[i];
            nodes[i].end = dep[i];
        }

        Arrays.sort(nodes);

        int i = 0;
        int min = nodes[0].start;
        int max = nodes[0].end;
        while (i < n - 1) {
            if (nodes[i + 1].start <= nodes[i].end) {
                res++;
                max = nodes[i+1].end;
            }
            i++;
        }

        return res;
    }


    // Driver program to test methods of graph class
    public static void main(String[] args) {
        int arr[] = {900, 940, 950, 1100, 1500, 1800};
        int dep[] = {910, 1200, 1120, 1130, 1900, 2000};
        int n = arr.length;
        System.out.println("Minimum Number of Platforms Required = "
                + findPlatform(arr, dep, n));
    }

}
