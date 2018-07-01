package practice.stack;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by sharanya.p on 6/30/2018.
 */
public class Histogram {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        Stack<Integer> s = new Stack<Integer>();
        int i = 0;
        int n = h.length;
        long max_area = 0; // Initialize max area
        int tp;  // To store top of stack
        long area_with_top; // To store area with top bar as the smallest bar
        while (i < n) {
            if (s.isEmpty() || h[i] > h[s.peek()]) {
                s.push(i++);
            } else {
                tp = s.pop();
                area_with_top = h[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
                if (area_with_top > max_area) {
                    max_area = area_with_top;
                }
            }
        }
        while (!s.isEmpty()) {
            tp = s.pop();
            area_with_top = h[tp] * (s.isEmpty() ? i : i - s.peek() - 1);
            if (area_with_top > max_area) {
                max_area = area_with_top;
            }
        }
        return max_area;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }
*/
        int[] h = {1,2,3,4,5};
        long result = largestRectangle(h);
        System.out.println(result);
        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }

}
