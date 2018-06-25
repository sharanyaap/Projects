package example;

/**
 * Created by sharanya.p on 1/13/2018.
 */
public class UboundedKnapsack {

    public static void main(String[] args) {
        int W = 100;
        int val[] = {10, 30, 20};
        int wt[] = {5, 10, 15};
        int n = val.length;
        System.out.println(unboundedKnapsack(W, n, val, wt));
    }

    private static int max(int i, int j) {
        return (i > j) ? i : j;
    }

    private static int unboundedKnapsack(int W, int n,
                                         int[] val, int[] wt) {
        int[] dp = new int[W + 1];

        for (int i = 0; i <= W; i++) {
            for (int j = 0; j <= n; j++) {
                if (wt[j] <= i) {
                    dp[i] = max(val[j] + dp[i - wt[j]], dp[i]);
                }
            }
        }
        return dp[W];
    }

}
