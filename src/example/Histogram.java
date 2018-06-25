package example;

import java.util.Stack;

/**
 * Created by sharanya.p on 10/28/2017.
 */
public class Histogram {

    public static void main(String[] args) {
        int A[] = {6,2,5,4,5,1,6};
        Histogram histogram = new Histogram();
        System.out.println(histogram.maxRectangleArea(A, A.length));
    }

    private int maxRectangleArea(int A[], int n) {
        int maxArea = 0;
        Stack<Integer> s = new Stack<>();
        int top;
        int areaWithTop;
        int i = 0;
        while (i < n) {
            if (s.empty() || A[s.peek()] <= A[i]) {
                System.out.println(s.empty() ? "Stack is empty" : "Value of A[s.peek()] <= A[i] " + s.peek() + A[s.peek()] + A[i]);
                s.push(i++);
            } else {
                top = s.pop();
                System.out.println("Top = " + top);
                areaWithTop = A[top] * (s.empty() ? i : i - s.peek() - 1);
                System.out.println("Area with top = " + areaWithTop);
                if (maxArea < areaWithTop) {
                    maxArea = areaWithTop;
                    System.out.println("MaxArea = " + maxArea);
                }
            }
        }

        // Now pop the remaining bars from stack and calculate area with every
        // popped bar as the smallest bar
        while (s.empty() == false) {
            top = s.pop();
            areaWithTop = A[top] * (s.empty() ? i : i - s.peek() - 1);

            if (maxArea < areaWithTop)
                maxArea = areaWithTop;
        }

        return maxArea;
    }


    private int solve(int[] hist, int n) {
        int max_area = 0, areawithtop = 0;
        Stack<Integer> s = new Stack<>();
        int i = 0;
        while (i < n) {
            if (s.isEmpty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            } else {
                int ts = s.peek();
                s.pop();
                areawithtop = hist[ts] * (s.isEmpty() ? i : i - s.peek() - 1);
                if (areawithtop > max_area)
                    max_area = areawithtop;
            }
        }

        while (!s.isEmpty()){
            int ts = s.peek();
            s.pop();
            areawithtop = hist[ts] * (s.isEmpty() ? i : i - s.peek() - 1);
            if (areawithtop > max_area)
                max_area = areawithtop;
        }

        return max_area;
    }

}

