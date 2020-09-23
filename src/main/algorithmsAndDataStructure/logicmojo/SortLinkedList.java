package main.algorithmsAndDataStructure.logicmojo;

import main.algorithmsAndDataStructure.leetCode.ListNode;

public class SortLinkedList {
    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);

        ListNode second = new ListNode(3);
        second.next = new ListNode(4);


       /* ListNode temp;
        ListNode new_list;


        temp = first;
        new_list = temp;

        temp.next = second;
        temp = second;
        temp.next = first;

        System.out.println("In temp list " + temp.val + ", " + temp.next.val);
        System.out.println("In temp list " + new_list.val + ", " + new_list.next.val);*/

        ListNode finalList = mergeTwoLists(first, second);

        System.out.println("In temp list " + finalList.val + ", " +
                finalList.next.val + ", " + finalList.next.next.val +
                ", " + finalList.next.next.next.val);


    }

    private static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {


        ListNode finalList;

        ListNode temp;

        if (listNode1.val < listNode2.val) {
            temp = listNode1;
            listNode1 = temp.next;
        } else {
            temp = listNode2;
            listNode2 = temp.next;
        }

        finalList = temp;

        while (listNode1 != null && listNode2 != null) {

            if (listNode1.val < listNode2.val) {
                temp.next = listNode1;
                temp = listNode1;
                listNode1 = temp.next;
            } else {
                temp.next = listNode2;
                temp = listNode2;
                listNode2 = temp.next;
            }
        }

        // at the end
        if (listNode1 == null)
            temp.next = listNode2;

        if (listNode2 == null)
            temp.next = listNode1;

        return finalList;
    }
}
