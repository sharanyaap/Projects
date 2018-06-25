package interviewbit;

import java.util.*;

/**
 * Created by sharanya.p on 1/27/2018.
 */
public class StacksAndQueues {

    public static void main(String[] args) {
        //Braces
        StacksAndQueues stacksAndQueues = new StacksAndQueues();
        String a = "((a + b))";
        System.out.println(stacksAndQueues.braces(a));

        //Rain Water
        List<Integer> integers = new ArrayList<Integer>() {{
            add(0);
            add(1);
            add(0);
            add(2);
            add(1);
            add(0);
            add(1);
            add(3);
            add(2);
            add(1);
            add(2);
            add(1);
        }};
        System.out.println(stacksAndQueues.trap(integers));

        //Histogram
        ArrayList aList = new ArrayList<Integer>() {{
            add(2);
            add(1);
            add(5);
            add(6);
            add(2);
            add(3);
        }};
        System.out.println(stacksAndQueues.largestRectangleArea(aList));

        integers = new ArrayList() {{
            add(1);
            add(3);
            add(-1);
            add(-3);
            add(5);
            add(3);
            add(6);
            add(7);
        }};

        System.out.println(stacksAndQueues.slidingMaximum(integers, 3));

        ArrayList<String> b = new ArrayList<String>();
        b.add("5");
        b.add("1");
        b.add("2");
        b.add("+");
        b.add("4");
        b.add("*");
        b.add("+");
        b.add("3");
        b.add("-");
        System.out.println(stacksAndQueues.evalRPN(b));
    }

    public int evalRPN(ArrayList<String> a) {
        Stack<Integer> operands = new Stack<Integer>();
        String operators = "+*-/";
        for (int i = 0; i < a.size(); i++) {
            String c = a.get(i);

            if (!operators.contains(c))
                operands.push(Integer.parseInt(c));
            else {
                int x = operands.pop();
                int y = operands.pop();
                String op = c;
                if (op == "+")
                    operands.push(x + y);
                else if (op == "-")
                    operands.push(y - x);
                else if (op == "*")
                    operands.push(y * x);
                else if (op == "/")
                    operands.push(y / x);
            }
        }
        System.out.println(operands.size());
        return operands.pop();
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> a, int b) {
        Deque<Integer> deque = new ArrayDeque<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (a == null || a.size() == 0)
            return result;

        int i = 0;
        while (i < b) {
            while (!deque.isEmpty() && a.get(deque.getLast()) <= a.get(i))
                deque.removeLast();
            deque.addLast(i++);
        }

        int[] max = new int[a.size() - b + 1];
        max[i - b] = a.get(deque.getFirst());
        System.out.println("Deque : " + deque);

        while (i < a.size()) {
            while (!deque.isEmpty() && a.get(deque.getLast()) <= a.get(i))
                deque.removeLast();
            deque.addLast(i);
            if (!deque.isEmpty() && i - b >= deque.getFirst())
                deque.removeFirst();

            ++i;
            max[i - b] = a.get(deque.getFirst());
        }

        System.out.println("Deque : " + deque);
        for (int j = 0; j < max.length; j++)
            result.add(max[j]);


        return result;
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        int maxArea = 0;
        int areaWithTop;
        int top = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < A.size()) {
            if (stack.isEmpty() || A.get(i) >= A.get(stack.peek())) {
                stack.push(i);
                i++;
            } else {
                top = stack.peek();
                stack.pop();
                areaWithTop = A.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
                if (areaWithTop > maxArea) {
                    maxArea = areaWithTop;
                }
            }
        }
        while (!stack.isEmpty()) {
            top = stack.peek();
            stack.pop();
            areaWithTop = A.get(top) * (stack.isEmpty() ? i : i - stack.peek() - 1);
            if (areaWithTop > maxArea) {
                maxArea = areaWithTop;
            }
        }
        return maxArea;
    }

    public int trap(final List<Integer> A) {
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];
        left[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) > left[i - 1]) {
                left[i] = A.get(i);
            } else {
                left[i] = left[i - 1];
            }
        }
        right[A.size() - 1] = A.get(A.size() - 1);
        for (int i = A.size() - 2; i >= 0; i--) {
            if (A.get(i) > right[i + 1]) {
                right[i] = A.get(i);
            } else {
                right[i] = right[i + 1];
            }
        }
        int area = 0;
        for (int i = 0; i < A.size(); i++) {
            area += (Math.min(left[i], right[i]) - A.get(i));
        }
        return area;
    }

    public int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (Character c : A.toCharArray()) {
            if (c == '(' || c == '+' || c == '-' || c == '*' || c == '/') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.peek() == '(') {
                    return 1;
                } else {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        stack.pop();
                    }
                    stack.pop();
                }
            }
        }
        return 0;
    }
}

class MinStack {
    Stack<Integer> minStack = new Stack<Integer>();
    Stack<Integer> stack = new Stack<Integer>();

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int num = stack.pop();
            if (minStack.peek() == num) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (stack.isEmpty())
            return -1;
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}
