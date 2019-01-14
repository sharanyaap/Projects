package practice.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by sharanya.p on 9/24/2018.
 */
public class StockSpan {

    // A utility function to print elements of array
    static void printArray(int arr[]) {
        System.out.print(Arrays.toString(arr));
    }

    // Driver method
    public static void main(String[] args) {
        int price[] = {10, 4, 5, 90, 120, 80};
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan(price, n, S);

        // print the calculated span values
        printArray(S);
    }

    public static void calculateSpan(int price[], int n, int S[]) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        S[0] = 1;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && price[i] > price[stack.peek()]) {
                stack.pop();
            }
            S[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }
    }
}
