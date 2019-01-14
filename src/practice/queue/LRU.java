package practice.queue;

import java.util.HashMap;

/**
 * Created by sharanya.p on 2/5/2018.
 */
public class LRU {

    private int capacity;
    private HashMap<Integer, LRUNode> map = new HashMap<>();
    private LRUNode head = null;
    private LRUNode end = null;

    public static void main(String[] args) {

        LRU lru = new LRU(2);
        lru.set(1, 10);
        lru.set(5, 12);
        System.out.println(lru.get(5));
        System.out.println(lru.get(1));
        System.out.println(lru.get(10));
        lru.set(6, 14);
        System.out.println(lru.get(5));
    }

    public LRU(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            LRUNode n = map.get(key);
            remove(n);
            setHead(n);
            return n.value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)) {
            LRUNode old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        } else {
            LRUNode created = new LRUNode(key, value);
            if (map.size() >= capacity) {
                // System.out.println("Removing : ");
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
    }

    public void setHead(LRUNode n) {
        n.next = head;
        n.pre = null;
        if (head != null)
            head.pre = n;
        head = n;
        if (end == null)
            end = head;
    }

    public void remove(LRUNode n) {
        if (n.pre != null) {
            n.pre.next = n.next;
        } else {
            head = n.next;
        }
        if (n.next != null)
            n.next.pre = n.pre;
        else
            end = n.pre;
    }
}

class LRUNode {
    int key;
    int value;
    LRUNode pre;
    LRUNode next;

    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
