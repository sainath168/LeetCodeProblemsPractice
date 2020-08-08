package main.algorithmsAndDataStructure.linkedListDataStructure;

import java.util.Iterator;

public class LinkedList {

    //just creating main method here only for ease
    public static void main(String[] args) {
        java.util.LinkedList<Integer> integers = new java.util.LinkedList<>();
        integers.addFirst(3);
        integers.addFirst(4);

        Iterator<Integer> ints = integers.iterator();
        while (ints.hasNext()) {
            System.out.println(ints.next());
        }



        /*LinkedList list = new LinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addFirst(5);
        list.deleteFirst();

        System.out.println(list.indexOf(30));
        System.out.println(list.contains(30));

        list.deleteLast();
        list.deleteLast();
        list.deleteLast();
        list.deleteLast();
        list.deleteFirst();
        list.deleteFirst();*/

    }

    class Node {
        private int value;
        private Node next;

        Node(int val) {
            this.value = val;
            // this.next = null;  // we can have this but by default object value will be null
        }
    }

    private Node first;
    private Node last;

    /**
     *
     * @param item
     */
    public void addLast(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            //else means, we have some node already, so we update the last item's with next node's address in it
            last.next = node;
            last = node;
        }
    }

    /**
     *
     * @param item
     */
    public void addFirst(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            first = last = node;
        } else {
            //else mean we already have some node, so we have to make newly created node as first node and update the next value to previous first node
            node.next = first;
            first = node;
        }
    }

    private boolean isEmpty() {
        return first == null;
    }

    /**
     * O(1)
     */
    public void deleteFirst() {
        // update the first node to second node in the list and unlink the first node so that garbage collector can pick it
        if (first == last) {
            first = last = null;
            return;
        }
        Node secondNode = first.next;
        first.next = null;
        first = secondNode;
    }

    /**
     * O(n) - while loop to figure out last but one node
     */
    public void deleteLast() {
        // update the last but one node's next value to null
        // and unlink the last node so that garbage collector can take care of it
        if (first == last) {
            first = last = null;
            return;
        }

        Node targetNode = first;
        Node lastButOneNode = null;
        while (targetNode.next != null) {
            lastButOneNode = targetNode;
            targetNode = targetNode.next;
        }
        if (lastButOneNode != null) {
            lastButOneNode.next = null;
            last = lastButOneNode;
        }


        //Note: if currentNode.next == last, then currentNode is nothing but last but one
    }

    /**
     *
     * @param item -- value in the list
     * @return
     */
    public int indexOf(int item) {
        Node currentNode = first;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.value == item)
                return index;
            currentNode = currentNode.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) >= 0;   // or != -1
    }


}
