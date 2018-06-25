package interviewbit;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by sharanya.p on 1/26/2018.
 */
public class LinkedListProb {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        LinkedListProb prob = new LinkedListProb();
        System.out.println(prob.lPalin(node1));
        System.out.println(prob.lPalinStack(node1));

        System.out.println(prob.reverseBetween(node1, 2, 3));

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node2;
        System.out.println(prob.detectCycle(node1));

        node1.val = 6;
        node2.val = 4;
        node3.val = 3;
        node4.val = 2;
        node5.val = 5;
        ListNode node6 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        System.out.println(prob.partition(node1, 3));

        node1.next = null;
        System.out.println(prob.partition(node1, 1));

    }

    public ListNode partition2(ListNode A, int B) {
        if (A == null) return null;

        ListNode fakeHead1 = new ListNode(0);
        ListNode fakeHead2 = new ListNode(0);
        fakeHead1.next = A;

        ListNode curr = A;
        ListNode prev = fakeHead1;
        ListNode p2 = fakeHead2;

        while (curr != null) {
            if (curr.val < B) {
                curr = curr.next;
                prev = prev.next;
            } else {
                p2.next = curr;
                prev.next = curr.next;

                curr = prev.next;
                p2 = p2.next;
            }
        }
        p2.next = null;

        prev.next = fakeHead2.next;
        return fakeHead1.next;
    }

    public ListNode partition(ListNode A, int B) {
        if (A == null)
            return null;
        int length = 0;
        ListNode last = null;
        ListNode lastBegin = null;
        ListNode prev = null;
        ListNode cur = A;
        ListNode res = null;
        while (A != null) {
            length++;
            A = A.next;
        }
        ListNode newLast = null;
        while (cur != null && length > 0) {
            if (cur.val < B) {
                prev = cur;
                cur = cur.next;
                if (res == null) {
                    res = prev;
                }
            } else {
                if (prev != null) {
                    prev.next = cur.next;
                }
                newLast = new ListNode(cur.val);
                cur = cur.next;
                if (last == null) {
                    last = newLast;
                    lastBegin = last;
                } else {
                    last.next = newLast;
                    last = last.next;
                }
            }
            length--;
        }
        if (prev != null)
            prev.next = lastBegin;
        else
            res = lastBegin;
        return res;
    }

    public ListNode detectCycle(ListNode a) {
        ListNode fast = a;
        ListNode slow = a;
        boolean foundCycle = false;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                foundCycle = true;
                System.out.println("Found loop at :: " + slow.val);
                break;
            }
        }
        if (foundCycle == true) {
            fast = a;
            while (fast != slow) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
        return null;
    }


    public ListNode reverseBetween(ListNode A, int B, int C) {
        if (B == C) return A;
        head = A;
        ListNode prev = null;//track (m-1)th node
        ListNode first = new ListNode(0); //First's next points to mth Node
        ListNode second = new ListNode(0); //Seconds next points to (n+1)th node

        int i = 0;
        ListNode p = A;
        while (p != null) {
            i++;
            if (i == B - 1)
                prev = p;

            if (i == B)
                first.next = p;

            if (i == C) {
                second.next = p.next;
                p.next = null;
            }
            p = p.next;
        }

        if (first.next == null)
            return A;

        //Reverse list from m to n
        ListNode p1 = first.next;
        ListNode p2 = p1.next;
        p1.next = second.next;
        while (p1 != null && p2 != null) {
            ListNode t = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = t;

        }
        if (prev != null)
            prev.next = p1;
        else
            return p1;
        return head;
    }


    ListNode head;
    ListNode left;

    public int lPalinStack(ListNode A) {
        int res = 1;
        head = A;
        Stack<Integer> stack = new Stack<>();
        while (A != null) {
            stack.push(A.val);
            A = A.next;
        }
        A = head;
        while (A != null) {
            if (A.val != stack.pop()) {
                res = 0;
                break;
            }
            A = A.next;
        }
        return res;
    }

    public int lPalin(ListNode A) {
        head = A;
        return isPalindromeUtil(A) == true ? 1 : 0;
    }

    boolean isPalindromeUtil(ListNode root) {
        left = head;
        if (root == null) {
            return true;
        }
        boolean res = isPalindromeUtil(root.next);
        if (res == false) {
            return false;
        }
        boolean com = left.val == root.val;
        left = left.next;
        return com;
    }
}

class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
