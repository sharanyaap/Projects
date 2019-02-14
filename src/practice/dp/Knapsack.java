package practice.dp;

/**
 * Created by sharanya.p on 7/25/2018.
 * https://www.geeksforgeeks.org/0-1-knapsack-problem-dp-10/
 */
public class Knapsack {

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
        System.out.println(unboundedKnapsack(W, n, val, wt));
    }

    // A utility function that returns maximum of two integers
    static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    static int knapSack(int W, int wt[], int val[], int n) {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 0; i <= n; i++) {
            for (w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (wt[i - 1] <= w)
                    K[i][w] = max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }

        return K[n][W];
    }

    // Returns the maximum value with knapsack
    // of W capacity
    private static int unboundedKnapsack(int W, int n,
                                         int[] val, int[] wt) {
        int dp[] = new int[W + 1];
        dp[0] = 0;
        for (int w = 0; w <= W; w++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= w)
                    dp[w] = Math.max(dp[w], dp[w - wt[j]] + val[j]);
            }
        }
        return dp[W];
    }

}
