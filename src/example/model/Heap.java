package example.model;

/**
 * Created by sharanya.p on 11/22/2017.
 */
public class Heap {
    public int[] getArray() {
        return array;
    }

    public void setArray(int[] array) {
        this.array = array;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getHeap_type() {
        return heap_type;
    }

    public void setHeap_type(int heap_type) {
        this.heap_type = heap_type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    int[] array;
    int count;
    int heap_type;
    int capacity;
}
