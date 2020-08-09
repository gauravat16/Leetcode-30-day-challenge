package gaurav.leetcode.july;

public class FlattenLL {

    private Node dummy;

    public Node flatten(Node head) {

        dummy = new Node(0);
        Node returnNode = dummy;

        helper(head);

        return returnNode.next;

    }

    private void helper(Node head) {
        if (head == null) return;

        dummy.next = head;
        head.prev = dummy;
        dummy = dummy.next;
        Node next = head.next;

        if (head.child != null) {
            head.next = head.child;
            helper(head.child);
        }
        helper(next);
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        /**
         *  1---2---3---4---5---6--NULL
         *          |
         *          7---8---9---10--NULL
         *              |
         *              11--12--NULL
         */
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);

        node.next.next.child = new Node(7);
        node.next.next.child.next = new Node(8);
        node.next.next.child.next.next = new Node(9);
        node.next.next.child.next.next.next = new Node(10);

        node.next.next.child.next.child = new Node(11);
        node.next.next.child.next.child.next = new Node(12);


        System.out.println(new FlattenLL().flatten(node));


    }
}
