package gaurav.leetcode.april.week4;

import java.util.HashMap;
import java.util.Map;

class LRUCache {


    private LinkedList ll;
    private int capacity;
    private Map<Integer, LinkedList.ListNode> kvMap;

    public LRUCache(int capacity) {
        ll = new LinkedList();
        kvMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!kvMap.containsKey(key)) {
            return -1;
        }

        LinkedList.ListNode node = kvMap.get(key);
        if (ll.head.next == node) return node.value;

        kvMap.remove(node.key);
        ll.removeNode(node);

        ll.addToFirst(node);

        kvMap.put(node.key, node);

        return kvMap.get(key).value;
    }

    public void put(int key, int value) {
        if (kvMap.containsKey(key)) {
            LinkedList.ListNode node = kvMap.get(key);
            node.value = value;
            ll.removeNode(node);
            ll.addToFirst(node);
        } else {
            if (kvMap.size() == capacity) {
                LinkedList.ListNode node = ll.removeFromLast();
                kvMap.remove(node.key);
            }
            kvMap.put(key, ll.addToFirst(key, value));
        }

    }

    class LinkedList {

        private ListNode head;
        private ListNode tail;

        public LinkedList() {
            this.head = new ListNode(-1, -1, null, null);
        }

        class ListNode {
            int value;
            int key;
            ListNode next;
            ListNode prev;

            public ListNode(int key, int value, ListNode next, ListNode prev) {
                this.value = value;
                this.next = next;
                this.prev = prev;
                this.key = key;
            }
        }

        public ListNode addToFirst(int key, int val) {
            ListNode node = head.next;
            head.next = new ListNode(key, val, node, head);
            if (node != null) node.prev = head.next;
            if (tail == null || tail == head) tail = head.next;
            return head.next;
        }

        public ListNode addToFirst(ListNode newNode) {
            ListNode node = head.next;
            newNode.prev = head;
            newNode.next = node;
            head.next = newNode;
            if (node != null) node.prev = head.next;
            if (tail == null || tail == head) tail = head.next;
            return head.next;
        }

        public ListNode removeFromLast() {
            if (tail != null) {
                ListNode node = tail;
                tail = tail.prev;
                tail.next = null;
                return node;
            }
            return null;
        }

        public void removeNode(ListNode node) {
            if (node == tail) {
                removeFromLast();
            } else {
                node.prev.next = node.next;
                if (node.next != null) {
                    node.next.prev = node.prev;
                }
            }

            node.next = null;
            node.prev = null;

        }

    }

}