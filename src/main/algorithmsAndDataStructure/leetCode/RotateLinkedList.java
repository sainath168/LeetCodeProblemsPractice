package main.algorithmsAndDataStructure.leetCode;

public class RotateLinkedList {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        /*
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);*/

        ListNode result = RotateLinkedList.rotateList(node, 2000000000);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }


    public static ListNode rotateList(ListNode head, int k) {

        if (k == 0 || head == null) {
            return head;
        }


        ListNode finalHead = null;
        ListNode finalTail = null;


        int i = 1;
        while (i < 3) {
            ListNode copyHead = new ListNode();
            copyHead = head;

            ListNode lastElement = copyHead;
            while (lastElement.next != null) {
                lastElement = lastElement.next;
            }

            ListNode newNode = new ListNode();
            //now we have the last node in copy
            newNode.val = lastElement.val;
            newNode.next = null;

            // Resultant head and tail points to last element
            finalHead = newNode;
            finalTail = newNode;

            while (copyHead.next != null) {
                ListNode newNode2 = new ListNode(copyHead.val);
                // point last element's next to head (rotate)
                finalTail.next = newNode2;
                finalTail = newNode2;
                copyHead = copyHead.next;
            }
            i++;
            head = finalHead;
        }


        return finalHead;

    }



}
