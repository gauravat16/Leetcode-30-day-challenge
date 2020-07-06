package gaurav.leetcode.may.week3;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan {
    private Deque<int[]> stack;

    public OnlineStockSpan() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {

        int count = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            count += stack.pop()[1];
        }

        stack.push(new int[]{price, count});
        return stack.peek()[1];
    }

}
