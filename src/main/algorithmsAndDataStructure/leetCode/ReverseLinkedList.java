package main.algorithmsAndDataStructure.leetCode;

import java.util.ArrayList;
import java.util.List;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(head.val);
        System.out.println(head.next.val);


        ListNode result = reverseList(head);
        System.out.println(result.val);
        System.out.println(result.next.val);
        //System.out.println(result.next.next.val);

    }

    static ListNode reverseList(ListNode head) {
        /*
        Approach 1:
        Create a new ListNode and store the values from tail to head using Recursive method
        */

        //base condition
        if (head == null || head.next == null) {
            return head; //last element in the original list
        }

        ListNode reverseHead = reverseList(head.next);

        // here the head would be the one that is passed in to this method
        head.next.next = head;
        head.next = null;

        return reverseHead;
    }

    static void getLastElement(ListNode head, ListNode node) {
        if (head == null) {
            return;
        }
        getLastElement(head.next, node);
        node = new ListNode(head.val);
    }
}
