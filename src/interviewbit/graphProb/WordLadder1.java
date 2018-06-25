package interviewbit.graphProb;

import java.util.*;

/**
 * Created by sharanya.p on 3/2/2018.
 */
public class WordLadder1 {

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        ArrayList<String> dictV = new ArrayList<String>();
        dictV.add("hot");
        dictV.add("dot");
        dictV.add("dog");
        dictV.add("lot");
        dictV.add("log");
        System.out.println(ladderLength(start, end, dictV));
    }

    public static int ladderLength(String start, String end, ArrayList<String> dictV) {
        Queue<WordNode> queue = new LinkedList<>();
        queue.add(new WordNode(start, 1));
        Set<String> set = new HashSet<>(dictV);
        set.add(end);
        while (!queue.isEmpty()) {
            WordNode top = queue.poll();
            String word = top.word;
            if (word.equals(end)) {
                return top.numSteps;
            }
            char[] arr = word.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char temp = arr[i];
                    if (arr[i] != c)
                        arr[i] = c;
                    String newWord = new String(arr);
                    if (set.contains(newWord)) {
                        queue.add(new WordNode(newWord, top.numSteps+1));
                        set.remove(newWord);
                    }
                    arr[i] = temp;
                }
            }
        }
        return 0;
    }
}

class WordNode {
    String word;
    int numSteps;

    public WordNode(String word, int numSteps) {
        this.word = word;
        this.numSteps = numSteps;
    }
}
