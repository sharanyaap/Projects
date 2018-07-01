package practice.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/**
 * Created by sharanya.p on 7/1/2018.
 */
public class GridBlockMoves {

    static final int[] X_OFFSETS = {-1, 0, 1, 0};
    static final int[] Y_OFFSETS = {0, 1, 0, -1};

    public static void main(String[] args) {
        String[] grid = {".X.", "...", "..."};
        int startX = 0;
        int startY = 0;
        int goalX = 0;
        int goalY = 2;
        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        System.out.println(result);
    }

    // Complete the minimumMoves function below.
    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        if (startX == goalX && startY == goalY) {
            return 0;
        }

        char[][] arr = new char[grid.length][];
        int j = 0;
        for (String s :
                grid) {
            arr[j++] = s.toCharArray();
        }

        int size = grid.length;

        int[][] moves = new int[size][size];
        IntStream.range(0, size).forEach(x -> Arrays.fill(moves[x], -1));

        moves[startX][startY] = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));

        while (true) {
            Point head = queue.poll();
            for (int i = 0; i < X_OFFSETS.length; i++) {
                int nextX = head.x;
                int nextY = head.y;

                while (isOpen(arr, nextX + X_OFFSETS[i], nextY + Y_OFFSETS[i])) {
                    nextX += X_OFFSETS[i];
                    nextY += Y_OFFSETS[i];

                    if (nextX == goalX && nextY == goalY) {
                        return moves[head.x][head.y] + 1;
                    }

                    if (moves[nextX][nextY] < 0) {
                        moves[nextX][nextY] = moves[head.x][head.y] + 1;
                        queue.offer(new Point(nextX, nextY));
                    }
                }
            }
        }
    }

    static boolean isOpen(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid.length && grid[x][y] == '.';
    }

}

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}