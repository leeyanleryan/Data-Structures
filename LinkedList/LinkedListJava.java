package LinkedList;

public class LinkedListJava {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.InsertIndex(7, 0);  // [7]
        ll.InsertIndex(8, 0);  // [8, 7]
        ll.InsertFront(10);          // [10, 8, 7]
        ll.RemoveFront();                  // [8, 7]
        ll.InsertIndex(20, 2); // [8, 7, 20]
        ll.InsertFront(10);          // [10, 8, 7, 20]
        ll.RemoveFront();
        ll.RemoveBack();
        ll.RemoveBack();
        ll.RemoveFront();
        ll.RemoveBack();
        ll.PrintList();
    }
}

class LinkedList {
    public Node head;
    public int length;

    public LinkedList() {
        this.head = null;
        this.length = 0;
    }

    /*
     * @brief  gets index of node with specified value in linked list
     * @param  value: value of node
     * @return -1: node does not exist
     *         index: index of node
     */
    public int Search(int value) {
        if (length == 0) {
            return -1;
        }
        int index = 0;
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return index;
            }
            index++;
            temp = temp.next;
        }
        return -1;
    }

    public void InsertFront(int value) {
        if (length == 0) {
            head = new Node(value);
        }
        else {
            Node temp = new Node(value);
            temp.next = head;
            head = temp;
        }
        length++;
    }

    public void InsertIndex(int value, int index) {
        if (index > length) {
            System.out.println("Index is outside of linked list");
            return;
        }
        else if (length == 0 || index == 0) {
            InsertFront(value);
            return;
        }
        Node temp = new Node(value);
        Node iter = head;
        for (int i = 0; i < index-1; i++) {
            iter = iter.next;
        }
        temp.next = iter.next;
        iter.next = temp;
        length++;
    }

    public void InsertBack(int value) {
        if (length == 0) {
            head = new Node(value);
            length++;
        }
        else {
            InsertIndex(value, length);
        }
    }

    public Node RemoveFront() {
        if (length == 0) {
            System.out.println("Can't remove from empty list");
            return null;
        }
        Node prevhead = head;
        Node temp = head.next;
        head = temp;
        length--;
        return prevhead;
    }

    public Node RemoveIndex(int index) {
        if (index >= length) {
            System.out.println("Index is outside of linked list");
            return null;
        }
        else if (length == 0) {
            System.out.println("Can't remove from empty list");
            return null;
        }
        else if (index == length-1) {
            return RemoveBack();
        }
        else if (index == 0) {
            return RemoveFront();
        }
    }

    public Node RemoveBack() {
        if (length == 0) {
            System.out.println("Can't remove from empty list");
            return null;
        }
        else if (length == 1) {
            Node temp = head;
            head = null;
            length--;
            return temp;
        }
        Node iter = head;
        for (int i = 0; i < length-2; i++) {
            iter = iter.next;
        }
        Node prevTail = iter.next;
        iter.next = null;
        length--;
        return prevTail;
    }

    public void PrintList() {
        if (length == 0) {
            System.out.print("[]");
            return;
        }
        Node temp = head;
        System.out.print("[");
        while (temp.next != null) {
            System.out.print(temp.value + ", ");
            temp = temp.next;
        }
        System.out.print(temp.value);
        System.out.print("]");
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }
}