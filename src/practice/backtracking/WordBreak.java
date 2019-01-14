package practice.backtracking;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sharanya.p on 8/26/2018.
 */
public class WordBreak {


    public static void main(String[] args) {
        List<String> dict = Arrays.asList("this", "th", "is", "famous", "word", "break", "b", "r", "e", "a", "k", "br", "bre", "brea", "ak", "prob", "lem");
        Node t = new Node();
        for (String word : dict)
            insertTrie(t, word);
        String str = "wordbreakproblem";

        System.out.println(wordBreak(t, str));
    }

    public static void insertTrie(Node head, String str) {
        Node node = head;

        for (int i = 0; i < str.length(); i++) {
            if (node.next[str.charAt(i) - 'a'] == null) {
                node.next[str.charAt(i) - 'a'] = new Node();
            }
            node = node.next[str.charAt(i) - 'a'];
        }
        node.exist = true;
    }

    public static boolean wordBreak(Node head, String str) {
        boolean[] good = new boolean[str.length() + 1];
        good[0] = true;
        for (int i = 0; i < str.length(); i++) {
            if (good[i]) {
                Node node = head;
                for (int j = i; j < str.length(); j++) {
                    if (node == null)
                        break;
                    node = node.next[str.charAt(j) - 'a'];
                    if (node != null && node.exist)
                        good[j + 1] = true;
                }
            }
        }


        return good[str.length()];
    }


}

class Node {
    int CHAR_SIZE = 26;
    boolean exist;
    Node[] next;

    Node() {
        next = new Node[CHAR_SIZE];
        exist = false;
    }
}