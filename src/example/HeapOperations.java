package example;

import example.model.Heap;

/**
 * Created by sharanya.p on 11/22/2017.
 */
public class HeapOperations {

    public Heap createHeap(int capacity, int heap_type) {
        Heap heap = new Heap();
        heap.setCapacity(capacity);
        heap.setHeap_type(heap_type);
        heap.setCount(0);
        int[] array = new int[capacity];
        heap.setArray(array);
        return heap;
    }

    int parent(Heap h, int i) {
        if (h.getCount() == 0)
            return -1;
        return (i - 1) / 2;
    }

    int leftChild(Heap h, int i) {
        if (h.getCount() == 0)
            return -1;
        return 2 * i + 1;
    }

    int rightChild(Heap h, int i) {
        if (h.getCount() == 0)
            return -1;
        return 2 * i + 2;
    }

    void percolateDown(Heap h, int i) {
        int l = leftChild(h, i);
        int r = rightChild(h, i);
        int temp;
        int max;
        if (h.getArray()[i] < h.getArray()[l])
            max = l;
        else
            max = i;
        if (h.getArray()[i] < h.getArray()[r])
            max = r;
        if (max != i) {
            temp = h.getArray()[i];
            h.getArray()[i] = h.getArray()[max];
            h.getArray()[max] = temp;
        }
        percolateDown(h, max);
    }

    int deleteMax(Heap h) {
        if (h.getCount() == 0)
            return -1;
        int data = h.getArray()[0];

        h.getArray()[0] = h.getArray()[h.getCount() - 1];
        h.getArray()[h.getCount() - 1] = 0;
        h.setCount(h.getCount() - 1);
        percolateDown(h, 0);
        return data;
    }

    void insert(Heap h, int data) {
        if (h.getCount() == 0) {
            h = createHeap(1, 1);
            h.getArray()[0] = data;
            h.setCount(h.getCount() + 1);
        } else {
            h.getArray()[h.getCount()] = data;
            h.setCount(h.getCount() + 1);
            percolateUp(h, h.getCount() - 1);
        }
    }

    private void percolateUp(Heap h, int i) {
        int p = parent(h, i);
        if (h.getArray()[p] < h.getArray()[i]) {
            int temp = h.getArray()[i];
            h.getArray()[i] = h.getArray()[p];
            h.getArray()[p] = temp;
        }
        if (i >= 0) {
            percolateUp(h, p);
        }
    }

}
