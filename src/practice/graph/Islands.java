package practice.graph;

/**
 * Created by sharanya.p on 9/4/2018.
 */
public class Islands {

    //No of rows and columns
    static final int ROW = 5, COL = 5;


    boolean isSafe(int r, int c, int[][] M, int[][] visited) {
        return r >= 0 && c >= 0 && r < ROW && c < COL && visited[r][c] != 1 && M[r][c] == 1;
    }


    void DFSUtil(int r, int c, int[][] M, int[][] visited) {
        int[] rn = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] cn = {-1, 0, 1, -1, 1, -1, 0, 1};
        visited[r][c] = 1;

        for (int i = 0; i < 8; ++i) {
            if (isSafe(r + rn[i], c + cn[i], M, visited)) {
                DFSUtil(r + rn[i], c + cn[i], M, visited);
            }
        }
    }


    int countIslands(int[][] M) {
        int[][] visited = new int[ROW][COL];
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (M[i][j] == 1 && visited[i][j] != 1) {
                    DFSUtil(i, j, M, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int M[][] = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        Islands I = new Islands();
        System.out.println("Number of islands is: " + I.countIslands(M));

    }


}
