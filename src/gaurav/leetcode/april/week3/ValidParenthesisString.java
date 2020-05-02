package gaurav.leetcode.april.week3;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        char[] arr = s.toCharArray();

        int minOpen = 0, maxOpen = 0;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (c == '(') {
                minOpen++;
                maxOpen++;
            } else if (c == ')') {
                minOpen--;
                maxOpen--;
            } else {
                minOpen--;
                maxOpen++;
            }

            if (maxOpen < 0) {
                return false;
            }

            minOpen = Math.max(minOpen, 0);

        }

        return minOpen == 0;
    }
}
