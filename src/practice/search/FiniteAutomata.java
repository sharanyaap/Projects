package practice.search;

/**
 * Created by sharanya.p on 6/17/2018.
 */
public class FiniteAutomata {

    public static void main(String[] args) {
        char[] txt = "GEEKSGEEKS FOR GEEKS".toCharArray();
        char[] pat = "ACACAGA".toCharArray();
        new FiniteAutomata().search(pat, txt);
    }

    public static final int NO_OF_CHARS = 256;

    /* Prints all occurrences of pat in txt */
    private void search(char pat[], char txt[]) {
        int M = pat.length;
        int N = txt.length;

        int[][] TF = new int[M + 1][NO_OF_CHARS];

        computeTransFun(pat, M, TF);

        // process text over FA.
        int i, j = 0;
        for (i = 0; i < N; i++) {
            j = TF[j][txt[i]];
            if (j == M) {
                System.out.println("pattern found at index " + (i - M + 1));
            }
        }
    }

    /* This function builds the TF table which represents Finite Automata for a
   given pattern  */
    void computeTransFun(char pat[], int M, int TF[][]) {
        int i, lps = 0, x;

        // Fill entries in first row
        for (x = 0; x < NO_OF_CHARS; x++) {
            TF[0][x] = 0;
        }
        TF[0][pat[0]] = 1;

        // Fill entries in other rows
        for (i = 1; i <= M; i++) {
            // Copy values from row at index lps
            //System.out.println("\ni ---> " + i);
            for (x = 0; x < NO_OF_CHARS; x++) {
                TF[i][x] = TF[lps][x];
                //System.out.print("\tTF[" + i + "][" + x + "] ---> " + TF[i][x]);
                //System.out.print("-" + TF[i][x] + "-");
            }
            // Update lps for next row to be filled
            if (i < M) {
                // Update the entry corresponding to this character
                TF[i][pat[i]] = i + 1;
                lps = TF[lps][pat[i]];
            }
        }

        for (int k = 65; k < 91; k++) {
            //if ((k == 69 || k == 71 || k == 75 || k == 83))
            if ((k == 65 || k == 67 || k == 71))
                System.out.print("-" + Character.toString((char) k) + "-");
        }
        for (i = 0; i <= M; i++) {
            //System.out.println("\ni ---> " + i);
            System.out.println("\n");
            for (x = 0; x < NO_OF_CHARS; x++) {
                //if (x > 64 && x < 91 && (x == 69 || x == 71 || x == 75 || x == 83))
                if ((x == 65 || x == 71 || x == 67))
                    System.out.print("-" + TF[i][x] + "-");
            }
        }
        System.out.println();
    }


}
