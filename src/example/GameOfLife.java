package example;

/**
 * Created by sharanya.p on 1/14/2018.
 */
public class GameOfLife {

    public static void main(String[] args) {

        int M = 10, N = 10;

        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        };

        // Displaying the grid
        System.out.println("Original Generation");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        nextGeneration(grid, M, N);
    }

    // Function to print next generation
    static void nextGeneration(int grid[][], int M, int N) {
        int[][] future = new int[M][N];
        for (int i = 1; i < M - 1; i++) {
            for (int j = 1; j < N - 1; j++) {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                if (grid[i + 1][j] == 1)
                    aliveNeighbours++;
                if (grid[i][j + 1] == 1)
                    aliveNeighbours++;
                if (grid[i - 1][j] == 1)
                    aliveNeighbours++;
                if (grid[i][j - 1] == 1)
                    aliveNeighbours++;
                if (grid[i + 1][j + 1] == 1)
                    aliveNeighbours++;
                if (grid[i + 1][j - 1] == 1)
                    aliveNeighbours++;
                if (grid[i - 1][j - 1] == 1)
                    aliveNeighbours++;
                if (grid[i - 1][j + 1] == 1)
                    aliveNeighbours++;
                if (grid[i][j] == 1 && aliveNeighbours < 2)
                    future[i][j] = 0;
                else if (grid[i][j] == 1 && aliveNeighbours > 3)
                    future[i][j] = 0;
                else if (grid[i][j] == 0 && aliveNeighbours == 3)
                    future[i][j] = 1;
                else
                    future[i][j] = grid[i][j];
            }
        }

        System.out.println("Next Generation");
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (future[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }

}
