package practice.dp;

/**
 * Created by sharanya.p on 7/17/2018.
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "aggtab";
        String s2 = "gxtxayb";
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int m = c1.length;
        int n = c2.length;

        LongestCommonSubsequence subsequence = new LongestCommonSubsequence();
        System.out.println(subsequence.lcs(c1, c2, m, n));
    }

    int lcs(char[] c1, char[] c2, int m, int n) {
        int[][] lcs = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    lcs[i][j] = 0;
                } else if (c1[i - 1] == c2[j - 1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                } else {
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                }
            }
        }
        return lcs[m][n];
    }

}
