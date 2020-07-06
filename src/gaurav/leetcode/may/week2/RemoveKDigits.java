package gaurav.leetcode.may.week2;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {

        char[] arr = num.toCharArray();

        if (arr.length == k) return "0";

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < arr.length; i++) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
                k--;
            }
            stack.push(arr[i]);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        sb.reverse();

        while (sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);


        return sb.length() == 0 ? "0" : sb.toString();

    }
}
