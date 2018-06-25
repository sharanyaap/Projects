package practice.search;

/**
 * Created by sharanya.p on 6/17/2018.
 */
public class BoyerMooreBadHeuristic {

    public static void main(String[] args) {
        char txt[] = "ABAAABCD".toCharArray();
        char pat[] = "ABC".toCharArray();
        new BoyerMooreBadHeuristic().search(txt, pat);
    }

    public static final int NO_OF_CHARS = 256;

    // The preprocessing function for Boyer Moore's
    // bad character heuristic
    void badCharHeuristic(char[] str, int size, int badchar[]) {
        int i;

        // Initialize all occurrences as -1
        for (i = 0; i < NO_OF_CHARS; i++)
            badchar[i] = -1;
        // Fill the actual value of last occurrence
        // of a character
        for (i = 0; i < size; i++)
            badchar[str[i]] = i;
    }

    private void search(char[] txt, char[] pat) {
        int m = pat.length;
        int n = txt.length;

        int badchar[] = new int[NO_OF_CHARS];

        /* Fill the bad character array by calling
       the preprocessing function badCharHeuristic()
       for given pattern */
        badCharHeuristic(pat, m, badchar);

        int s = 0;
        int cnt = 0;
        while (s <= n - m) {
            int j = m - 1;
            cnt++;
            while (j >= 0 && pat[j] == txt[s + j]) {
                j--;
                cnt++;
            }
            if (j < 0) {
                System.out.println("Found pattern at " + s);
                /* Shift the pattern so that the next
               character in text aligns with the last
               occurrence of it in pattern.
               The condition s+m < n is necessary for
               the case when pattern occurs at the end
               of text */
                s += (s + m < n) ? m - badchar[txt[s + m]] : 1;
            } else {
                /* Shift the pattern so that the bad character
               in text aligns with the last occurrence of
               it in pattern. The max function is used to
               make sure that we get a positive shift.
               We may get a negative shift if the last
               occurrence  of bad character in pattern
               is on the right side of the current
               character. */
                s += Integer.max(1, j - badchar[txt[s + j]]);
            }
        }
        System.out.println("Count :: " + cnt);
    }

}
