package LinkedList;

public class LinkedListJava {
    public static void main(String[] args) {
        
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
            Node temp = new Node(value);
        }

        public void InsertIndex(int value, int index) {
            Node temp = new Node(value);
        }

        public void InsertBack(int value) {
            Node temp = new Node(value);

            if (length == 0) {
                head = temp;
            }
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
}