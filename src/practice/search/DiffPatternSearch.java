package practice.search;

/**
 * Created by sharanya.p on 6/16/2018.
 */
public class DiffPatternSearch {

    public static void main(String[] args) {
        char txt[] = "ABCEABCDABCEABCD".toCharArray();
        char pat[] = "ABCD".toCharArray();
        search(txt, pat);
    }

    private static void search(char[] txt, char[] pat) {
        int i = 0;
        int j = 0;
        int N = txt.length;
        int M = pat.length;
        while (i < N) {
            if (txt[i] == pat[j]) {
                i++;
                j++;
            } else {
                i = i - j + M;
                j = 0;
            }
            if (j == pat.length) {
                System.out.println("Pattern found at " + (i - j));
                j = 0;
            }
        }
    }


}
