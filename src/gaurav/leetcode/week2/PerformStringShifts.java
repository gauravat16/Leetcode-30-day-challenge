package gaurav.leetcode.week2;

import java.util.LinkedList;

public class PerformStringShifts {

    public String stringShift(String s, int[][] shifts) {

        char[] arr = s.toCharArray();

        LinkedList<Character> ll = new LinkedList<>();
        for (char c : arr) {
            ll.add(c);
        }

        int move = 0;
        for (int[] shift : shifts) {
            if (shift[0] == 0) {
                move += shift[1];
            } else {
                move -= shift[1];
            }
        }

        if (move > 0) {
            leftShift(ll, move);
        } else {
            rightShift(ll, -move);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : ll) {
            sb.append(c);
        }

        return sb.toString();

    }

    void leftShift(LinkedList<Character> ll, int times) {
        for (int i = 0; i < times; i++) {
            char c = ll.removeFirst();
            ll.addLast(c);
        }
    }

    void rightShift(LinkedList<Character> ll, int times) {
        for (int i = 0; i < times; i++) {
            char c = ll.removeLast();
            ll.addFirst(c);
        }
    }

}
