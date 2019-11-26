package CodeBase.LinkedList;

public class SingleLinkedList {
    Node head;

    class Node{
        int data;
        Node next;

        Node(int val)
        {
            data = val;
            next = null;
        }
    }
    void add(int x)
    {
        Node ptr = new Node(x);
        ptr.next=head;
        head=ptr;
    }
    void delete(int x)
    {
        if(head.data==x)
        {
            Node ptr=head;
            head=head.next;
            ptr=null;

        }else {
            Node ptr = head;
            while (ptr.next!=null)
            {
                if(ptr.next.data==x)
                {
                    Node ptr2=ptr.next;
                    ptr.next=ptr.next.next;
                    ptr2=null;
                }
                else ptr=ptr.next;
            }

        }
    }
    void printList()
    {
        Node ptr = head;
        while(ptr!=null)
        {
            System.out.print(ptr.data+" ");
            ptr=ptr.next;
        }
        System.out.println();
    }
    public static void main(String args[])
    {
        SingleLinkedList list = new SingleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.printList();
        list.delete(7);
        list.delete(2);
        list.printList();

    }

}
