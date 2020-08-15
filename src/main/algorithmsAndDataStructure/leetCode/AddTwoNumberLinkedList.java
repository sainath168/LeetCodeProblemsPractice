package main.algorithmsAndDataStructure.leetCode;

public class AddTwoNumberLinkedList {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(1);

        addTwoNumbers(l1, l2);
    }

    /**
     * ListNode structure provided by leetcode and copied same here..
     */
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /* Aproach 1:
        - Check the size of the lists and make sure you are iterating through the bigger list
        - Then we take each digit of same index in both lists and add them
        - if the sumOfTwoDigits is >= 10,
                    - then do sumOfTwoDigits - 10
                    - insert the result in the node and store a remainder as 1 to add to next digit
        - else if sumOfTwoDigits is < 10
                    - then insert the sumOfTwoDigits in the node
        - Note: in next loop, we should add the remainder to the next digit before jumping into step of calculating sumOfTwoDigits
                and if there is no next Node then add the remainder to node
        */

        ListNode l3 = new ListNode();
        ListNode resultList = l3;

        int remainder = 0;

        while(l1 != null || l2 != null) {
            int digit1 = (l1 != null) ? l1.val : 0;
            int digit2 = (l2 != null) ? l2.val : 0;

            int sumOfTwoDigits = digit1 + digit2 + remainder;

            remainder = 0; //reset remainder in case if it was 1 before;

            int result = sumOfTwoDigits;
            if (sumOfTwoDigits >= 10) {
                result = sumOfTwoDigits - 10;
                remainder = 1;
            }

            l3.val = result; //current node value

            if (l1 != null) {
                l1 = l1.next;
            }


            if (l2 != null) {
                l2 = l2.next;
            }

            if (l1 != null || l2 != null) {
                l3.next = new ListNode(); // create for next
                l3 = l3.next;
            }

        }

        if (remainder == 1) {
            l3.next = new ListNode(1);
        }

        return resultList;
    }
}