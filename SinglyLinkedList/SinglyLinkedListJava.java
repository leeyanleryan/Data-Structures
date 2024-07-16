package SinglyLinkedList;

public class SinglyLinkedListJava {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        Testing(sll);
        /*
         * Expected print statements:
         * [10, 5]
         * [5]
         * []
         * Can't remove from empty list
         * []
         * [7, 8, 9]
         * [3, 7, 5, 8, 9, 4]
         * 0
         * 2
         * 5
         * -1
         * [7, 8, 9]
         * []
         * Index is outside of linked list
         * [9, 6]
         * [9]
         * []
         * Can't remove from empty list
         * []
         * 
         * Should any mismatch of print statements occur, check Testing function.
         */
    }

    public static void Testing(SinglyLinkedList sll) {
        sll.InsertFront(5);
        sll.InsertFront(10);
        sll.PrintList(); // [10, 5]
        sll.RemoveFront();
        sll.PrintList(); // [5]
        sll.RemoveFront();
        sll.PrintList(); // []
        sll.RemoveFront(); // Can't remove from empty list
        sll.PrintList(); // []
        sll.InsertAtIndex(7, 0);
        sll.InsertAtIndex(8, 1);
        sll.InsertAtIndex(9, 2);
        sll.PrintList(); // [7, 8, 9]
        sll.InsertAtIndex(3, 0);
        sll.InsertAtIndex(4, sll.length);
        sll.InsertAtIndex(5, 2);
        sll.PrintList(); // [3, 7, 5, 8, 9, 4]
        System.out.println(sll.Search(3)); // 0
        System.out.println(sll.Search(5)); // 2
        System.out.println(sll.Search(4)); // 5
        System.out.println(sll.Search(100)); // -1
        sll.RemoveAtIndex(2);
        sll.RemoveAtIndex(sll.length-1);
        sll.RemoveAtIndex(0);
        sll.PrintList(); // [7, 8, 9]
        sll.RemoveAtIndex(2);
        sll.RemoveAtIndex(1);
        sll.RemoveAtIndex(0);
        sll.PrintList(); // []
        sll.RemoveAtIndex(2); // Index is outside of linked list
        sll.InsertBack(9);
        sll.InsertBack(6);
        sll.PrintList(); // [9, 6]
        sll.RemoveBack();
        sll.PrintList(); // [9]
        sll.RemoveBack();
        sll.PrintList(); // []
        sll.RemoveBack(); // Can't remove from empty list
        sll.PrintList(); // []
    }
}

/*
 * Functions implemented:
 * Search
 * InsertFront, InsertAtIndex, InsertBack
 * RemoveFront, RemoveAtIndex, RemoveBack
 * PrintList
 */
class SinglyLinkedList {
    public Node head;
    public Node tail;
    public int length;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
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

    public void InsertAtIndex(int value, int index) {
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
            InsertAtIndex(value, length);
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

    public Node RemoveAtIndex(int index) {
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
        Node iter = head;
        for (int i = 0; i < index-1; i++) {
            iter = iter.next;
        }
        Node removedNode = iter.next;
        iter.next = iter.next.next;
        length--;
        return removedNode;
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
            System.out.println("[]");
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
        System.out.println();
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