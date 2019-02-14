package practice.heap;

import java.util.Scanner;

/**
 * Created by sharanya.p on 10/23/2018.
 */
public class KLargest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Binary Heap Test\n\n");
        System.out.println("Enter size of Binary heap");

        while(true){

        }

    }


}

class BinHeap {

    int[] heap;
    int size;

    int getLeft(int i) {
        int l = i * 2 + 1;
        if (l < size) {
            return l;
        }
        return 0;
    }

    int getRight(int i) {
        int r = i * 2 + 2;
        if (r < size) {
            return r;
        }
        return 0;
    }

    int getParent(int i) {
        int p = (i - 1) / 2;
        if (p >= 0) {
            return p;
        }
        return 0;
    }

    void heapify(int i) {
        int l = getLeft(i);
        int r = getRight(i);
        int small = heap[i];
        if (heap[l] < heap[i]) {
            small = l;
        }
        if (heap[r] < small) {
            small = r;
        }
        if (small != heap[i]) {
            int temp = heap[i];
            heap[i] = heap[small];
            heap[small] = temp;
            heapify(small);
        }
    }
}