package practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sharanya.p on 6/15/2018.
 */
public class BalancedParenthesis {

    public static void main(String[] args) {
        String in = "[{}](){[()()]()}";
        in = "[(])";
        Map<Character, Character> map = new HashMap() {{
            put('[', ']');
            put('{', '}');
            put('(', ')');
        }};
        BalancedParenthesis parenthesis = new BalancedParenthesis();
        System.out.println(String.valueOf(parenthesis.checkBalance(in, map)));
    }

    private boolean checkBalance(String in, Map map) {
        boolean result = false;
        char[] arr = in.toCharArray();
        int i = 0;
        Stack<Character> stack = new Stack<>();
        while (i < arr.length) {
            while (arr[i] == '{' || arr[i] == '[' || arr[i] == '(') {
                System.out.println("Push into Stack :: " + arr[i]);
                stack.push(arr[i]);
                i++;
            }
            while (i < arr.length && (arr[i] == '}' || arr[i] == ']' || arr[i] == ')')) {
                Character rem = stack.pop();
                System.out.println("Pop from stack :: " + rem + " matched for :: " + arr[i]);
                if (map.get(rem).equals(arr[i])) {
                    i++;
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            result = true;
        }
        return result;
    }

}
