package practice.backtracking;

import java.util.*;

/**
 * Created by sharanya.p on 8/27/2018.
 */
public class RemoveInvalidParenthesis {

    public static void main(String[] args) {
        String exp = "()())()";
        removeInvalidParenthesis(exp);

    }

    static void removeInvalidParenthesis(String str) {
        if (str.isEmpty())
            return;
        List<String> visit = new LinkedList<>();
        Queue<String> q = new LinkedList<>();
        String temp;
        boolean level = false;
        q.add(str);
        visit.add(str);
        while (!q.isEmpty()) {
            str = q.poll();
            if (isValidString(str)) {
                System.out.println(str);
                level = true;
            }
            if (level)
                continue;
            for (int i = 0; i < str.length(); i++) {
                if (!isParenthesis(str.charAt(i)))
                    continue;

                // Removing parenthesis from str and
                // pushing into queue,if not visited already
                temp = str.substring(0, i) + str.substring(i + 1);
                if (!visit.contains(temp)) {
                    //q.push(temp);
                    q.add(temp);
                    visit.add(temp);
                    //visit.insert(temp);
                }
            }
        }
    }

    //  method checks if character is parenthesis(open
// or closed)
    static boolean isParenthesis(char c) {
        return ((c == '(') || (c == ')'));
    }

    static boolean isValidString(String str) {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }

}
