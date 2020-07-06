package gaurav.leetcode.may.week3;

import gaurav.leetcode.ds.ListNode;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        ListNode even = new ListNode(0);
        ListNode odd = new ListNode(0);

        ListNode evenTemp = even;
        ListNode oddTemp = odd;

        int idx = 1;
        while (head != null) {
            if (idx % 2 == 0) {
                evenTemp.next = head;
                evenTemp = evenTemp.next;
            } else {
                oddTemp.next = head;
                oddTemp = oddTemp.next;
            }
            head = head.next;
            idx++;
        }

        evenTemp.next = null;
        oddTemp.next = even.next;

        return odd.next;


    }
}
