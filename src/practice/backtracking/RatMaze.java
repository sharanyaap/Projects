package practice.backtracking;

import java.util.Arrays;

/**
 * Created by sharanya.p on 8/28/2018.
 */
public class RatMaze {

    public static int N = 4;

    public static void main(String[] args) {
        RatMaze rat = new RatMaze();
        int maze[][] = {{1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {1, 1, 1, 1}
        };
        rat.solveMaze(maze);
    }

    void solveMaze(int[][] maze) {
        int[][] sol = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if (!solveMazeUtil(maze, 0, 0, sol)) {
            System.out.println("Could not finish the maze");
            return;
        }
        printSolution(sol);
    }

    void printSolution(int[][] sol) {
        /*Arrays.stream(sol).forEach(i -> Arrays.stream(i).forEach(j -> {
            System.out.println(i[j]);
            System.out.println();
        }));*/

        Arrays.stream(sol).map(Arrays::toString).forEach(System.out::println);
    }

    boolean isSafe(int[][] maze, int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N && maze[x][y] == 1;
    }

    boolean solveMazeUtil(int[][] maze, int x, int y, int[][] sol) {
        if (x == N - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }
        if (isSafe(maze, x, y)) {
            sol[x][y] = 1;
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

}
