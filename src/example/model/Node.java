package example.model;

/**
 * Created by sharanya.p on 12/5/2016.
 */
public class Node {

    private int data;
    private Node rightNode;

    public Node(int data,Node rightNode)
    {
        this.data = data;
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

}
