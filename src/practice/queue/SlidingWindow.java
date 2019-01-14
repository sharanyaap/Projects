package practice.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.DelayQueue;

/**
 * Created by sharanya.p on 10/25/2018.
 */
public class SlidingWindow {

    public static void main(String[] args) {

        int arr[] = {12, 1, 78, 90, 57, 89, 56};
        int k = 3;
        printMax(arr, arr.length, k);

    }

    // A Dequeue (Double ended queue) based method for printing maixmum element of
    // all subarrays of size k
    static void printMax(int arr[], int n, int k) {

        Deque<Integer> qi = new LinkedList<>();
        int i;
        for (i = 0; i < k; i++) {
            while (!qi.isEmpty() && arr[i] >= arr[qi.peekLast()])
                qi.removeLast();
            qi.addLast(i);
        }
        // Process rest of the elements, i.e., from arr[k] to arr[n-1]
        for (; i < n; ++i) {
            System.out.print(arr[qi.peek()] + " ");

            while (!qi.isEmpty() && qi.peek() <= i - k)
                qi.removeFirst();

            while (!qi.isEmpty() && arr[i] >= arr[qi.peekLast()])
                qi.removeLast();
            qi.addLast(i);
        }
        // Print the maximum element of last window
        System.out.print(arr[qi.peek()]);


    }
}
