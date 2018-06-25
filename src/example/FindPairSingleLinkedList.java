package example;

import example.model.Node;

/**
 * Created by sharanya.p on 12/5/2016.
 */
public class FindPairSingleLinkedList {

    private Node head;

    private int sum;

    public void insert(int data) {
        if (head == null) {
            head = new Node(data, null);
        } else {
            Node currentNode = head;
            Node lastNode = new Node(data, null);
            //System.out.println();
            while (currentNode.getRightNode() != null) {
                //System.out.print(currentNode.getData() + " ----> ");
                currentNode = currentNode.getRightNode();
            }
            //System.out.print(currentNode.getData() + " ----> ");
            //System.out.print(lastNode.getData() + " ----> ");
            currentNode.setRightNode(lastNode);
        }
    }

    public void pairSum(Node node) {
        if (node == null) {
            return;
        } else {
            int diff = sum - node.getData();
            Node found = nextVal(node, diff);
            if (found != null) {
                System.out.println("CurrentNode :: " + node.getData() + " NextVal ::  " + found.getData());
            }
            pairSum(node.getRightNode());
        }
    }

    public Node nextVal(Node node, int diff) {
        do {
            if (node.getData() == diff) {
                return node;
            }
            node = node.getRightNode();
        } while (node != null);
        return null;
    }

    public static void main(String args[]) {
        FindPairSingleLinkedList list = new FindPairSingleLinkedList();
        list.insert(3);
        list.insert(6);
        list.insert(7);
        list.insert(8);
        list.insert(9);
        list.insert(10);
        list.insert(11);
        list.sum = 17;
        //System.out.println();
        list.pairSum(list.head);
    }

}


