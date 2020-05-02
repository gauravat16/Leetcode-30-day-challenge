package gaurav.leetcode.april.week2;

import gaurav.leetcode.ds.ListNode;

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }


        return slow;

    }
}
