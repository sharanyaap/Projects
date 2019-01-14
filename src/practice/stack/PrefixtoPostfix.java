package practice.stack;

import java.util.Stack;

/**
 * Created by sharanya.p on 9/24/2018.
 */
public class PrefixtoPostfix {

    public static void main(String[] args) {
        String prefix = "*-A/BC-/AKL";
        PrefixtoPostfix prefixtoPostfix = new PrefixtoPostfix();
        System.out.println(prefixtoPostfix.convertPretoPost(prefix));
    }

    // funtion to check if character is operator or not
    boolean isOperator(char x) {
        switch (x) {
            case '+':
            case '-':
            case '/':
            case '*':
                return true;
        }
        return false;
    }

    String convertPretoPost(String prefix) {
        char[] pre = prefix.toCharArray();
        Stack<String> stack = new Stack<>();
        for (int i = prefix.length() - 1; i >= 0; i--) {
            if (isOperator(pre[i])) {
                String c1 = stack.pop();
                String c2 = stack.pop();
                String str = c1 + c2 + pre[i];
                stack.push(str);
            } else {
                stack.push(String.valueOf(pre[i]));
            }
        }
        // stack contains only the Postfix expression
        return stack.peek();
    }

}
