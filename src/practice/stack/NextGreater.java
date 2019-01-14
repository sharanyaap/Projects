package practice.stack;

import java.util.Stack;

/**
 * Created by sharanya.p on 11/25/2018.
 */
public class NextGreater {

    public static void main(String[] args) {
        int arr[] = {11, 13, 21, 3};
        new NextGreater().solve(arr);
    }

    private void solve(int arr[]) {
        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];
            if (!stack.isEmpty()) {
                int ele = stack.pop();
                while (ele < next) {
                    System.out.println(ele + "--->" + next);
                    if (stack.isEmpty())
                        break;
                    ele = stack.pop();
                }
                if (ele > next)
                    stack.push(ele);
            }
            stack.push(next);
        }

        int ele, next;
        /* After iterating over the loop, the remaining
           elements in stack do not have the next greater
           element, so print -1 for them */
        while (stack.isEmpty() == false) {
            ele = stack.pop();
            next = -1;
            System.out.println(ele + " -- " + next);
        }
    }

}
