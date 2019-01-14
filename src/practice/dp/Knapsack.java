package practice.dp;

/**
 * Created by sharanya.p on 7/25/2018.
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
        int k[][] = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    k[i][w] = 0;
                else if (wt[i - 1] <= w) {
                    k[i][w] = max(val[i - 1] + k[i - 1][w - wt[i - 1]], k[i - 1][w]);
                } else {
                    k[i][w] = k[i - 1][w];
                }
            }
        }
        return k[n][W];
    }

    // Returns the maximum value with knapsack
    // of W capacity
    private static int unboundedKnapsack(int W, int n,
                                         int[] val, int[] wt) {
        int dp[] = new int[W + 1];
        dp[0] = 0;
        for (int i = 0; i <= W; i++) {
            for (int j = 0; j < n; j++) {
                if (wt[j] <= i)
                    dp[i] = Math.max(dp[i], dp[i - wt[j]] + val[j]);
            }
        }
        return dp[W];
    }

}
