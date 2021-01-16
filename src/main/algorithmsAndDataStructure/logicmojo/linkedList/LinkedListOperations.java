package main.algorithmsAndDataStructure.logicmojo.linkedList;

public class LinkedListOperations {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    static class LinkedList {
        public Node head = null;
        public Node tail = null;


        public void insert(int data) {
            Node node = new Node(data);

            if (head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }
    }

    public static void main(String[] args) {

        LinkedList linkedList = new LinkedList();
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);


    }


}
