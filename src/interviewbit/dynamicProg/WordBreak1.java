package interviewbit.dynamicProg;

import java.util.ArrayList;

/**
 * Created by sharanya.p on 2/20/2018.
 */
public class WordBreak1 {
    public static boolean wordbreak(String s, ArrayList<String> dictionary) {
        boolean[] t = new boolean[s.length() + 1];
        t[0] = true;

        for (int i = 0; i < s.length(); i++) {
            if (!t[i])
                continue;
            for (String word : dictionary) {
                int length = word.length();
                int end = i + length;
                if (end > s.length())
                    continue;
                if (t[end])
                    continue;
                if (s.substring(i, end).equals(word))
                    t[end] = true;
            }
        }
        return t[s.length()];
    }

    public static void main(String[] args) {
        ArrayList<String> b = new ArrayList<String>();
        b.add("cat");
        b.add("cats");
        b.add("and");
        b.add("sand");
        b.add("dog");
        String a = "catsanddog";
        System.out.println("List is : " + b);
        System.out.println("String is  : " + a);

        if (!wordbreak(a, b))
            System.out.print("Not ");
        System.out.println("Breakable");

    }
}
