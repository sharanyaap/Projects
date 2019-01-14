package practice.linkedlist;

/**
 * Created by sharanya.p on 7/10/2018.
 */
public class AddNumberLL {

    node head1, head2, result;
    int carry;
    node cur;

    class node
    {
        int val;
        node next;

        public node(int val)
        {
            this.val = val;
        }
    }

    /* A utility function to push a value to linked list */
    void push(int val, int list)
    {
        node newnode = new node(val);
        if (list == 1)
        {
            newnode.next = head1;
            head1 = newnode;
        }
        else if (list == 2)
        {
            newnode.next = head2;
            head2 = newnode;
        }
        else
        {
            newnode.next = result;
            result = newnode;
        }

    }

    // Function to print linked list
    void printlist(node head)
    {
        while (head != null)
        {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    void addlists(){

    }

    public static void main(String[] args) {
        AddNumberLL list = new AddNumberLL();
        list.head1 = null;
        list.head2 = null;
        list.result = null;
        list.carry = 0;
        int arr1[] = { 9, 9, 9 };
        int arr2[] = { 1, 8 };

        // Create first list as 9->9->9
        for (int i = arr1.length - 1; i >= 0; --i)
            list.push(arr1[i], 1);

        // Create second list as 1->8
        for (int i = arr2.length - 1; i >= 0; --i)
            list.push(arr2[i], 2);

        list.addlists();

        list.printlist(list.result);
    }
}
