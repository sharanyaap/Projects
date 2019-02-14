package practice.backtracking;

import java.util.Arrays;

/**
 * Created by sharanya.p on 1/17/2019.
 * https://www.geeksforgeeks.org/word-break-problem-using-backtracking/
 */
public class WordBreakBT {

    public static void main(String[] args) {
        WordBreakBT wordBreakBT = new WordBreakBT();
        wordBreakBT.wordBreak("iloveicecreamandmango");
        wordBreakBT.wordBreak("ilovesamsungmobile");
    }

    void wordBreak(String word) {
        String result = "";
        wordBreakUtil(word, word.length(), result);
    }

    void wordBreakUtil(String word, int n, String result) {
        for (int i = 1; i <= n; i++) {
            String sub = word.substring(0, i);
            if (isWordInDictionary(sub)) {
                if (i == n) {
                    result += sub;
                    System.out.println(result);
                    return;
                }
                wordBreakUtil(word.substring(i), n - i, result + sub + " ");
            }
        }
    }

    boolean isWordInDictionary(String word) {
        String dictionary[] = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "love", "ice", "cream"};
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].equals(word))
                return true;
        }
        return false;
    }

}
