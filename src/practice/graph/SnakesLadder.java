package practice.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sharanya.p on 7/7/2018.
 */
public class SnakesLadder {

    // An entry in queue used in BFS
    static class qentry {
        int v;// Vertex number
        int dist;// Distance of this vertex from source
    }

    public static void main(String args[]) {
        // Let us construct the board given in above diagram
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        //moves[1] = 29;
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;

        System.out.println("Min Dice throws required is " +
                getMinDiceThrows(moves, N));
    }

    public static int getMinDiceThrows(int[] moves, int N) {
        int res = 0;
        boolean[] visited = new boolean[N];
        Queue<qentry> qentries = new LinkedList<>();

        qentry qentry = new qentry();
        qentry.v = 0;
        qentry.dist = 0;
        qentries.add(qentry);

        while (!qentries.isEmpty()) {
            qentry = qentries.poll();
            visited[qentry.v] = true;

            // If front vertex is the destination
            // vertex, we are done
            if (qentry.v == N - 1)
                break;
            for (int k = qentry.v + 1; k <= qentry.v + 6 && k < N; k++) {
                if (!visited[k]) {
                    qentry q = new qentry();
                    q.dist = qentry.dist + 1;
                    if (moves[k] != -1) {
                        System.out.println(k + " " + moves[k]);
                        q.v = moves[k];
                    } else {
                        q.v = k;
                    }
                    qentries.add(q);
                }
            }
        }

        return qentry.dist;
    }

}
