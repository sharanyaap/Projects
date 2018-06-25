package interviewbit.dynamicProg;

import java.util.ArrayList;

/**
 * Created by sharanya.p on 2/21/2018.
 */
public class MinimumSumPath {

    public int minPathSumWithDFS(int[][] grid) {
        return dfs(0, 0, grid);
    }

    public int dfs(int i, int j, int[][] grid) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (i < grid.length - 1 && j < grid[0].length - 1) {
            int r1 = grid[i][j] + dfs(i + 1, j, grid);
            int r2 = grid[i][j] + dfs(i, j + 1, grid);
            return Math.min(r1, r2);
        }

        if (i < grid.length - 1) {
            return grid[i][j] + dfs(i + 1, j, grid);
        }

        if (j < grid[0].length - 1) {
            return grid[i][j] + dfs(i, j + 1, grid);
        }

        return 0;
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        temp.add(3);
        temp.add(2);
//         System.out.println(temp);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();

        temp.add(4);
        temp.add(3);
        temp.add(1);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();

        temp.add(5);
        temp.add(6);
        temp.add(1);
        a.add(new ArrayList<Integer>(temp));
        temp.clear();

        for (ArrayList<Integer> list : a)
            System.out.println(list);

        MinimumSumPath minimumSumPath = new MinimumSumPath();
        int[][] arr = new int[a.size()][a.get(0).size()];
        for (int i = 0; i < a.size() ; i++){
            for (int j = 0; j < a.get(i).size(); j++){
                arr[i][j] = a.get(i).get(j);
            }
        }
        System.out.println(minimumSumPath.minPathSumWithDFS(arr));
    }
}
