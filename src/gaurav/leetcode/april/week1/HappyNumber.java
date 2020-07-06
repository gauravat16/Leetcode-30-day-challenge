package gaurav.leetcode.april.week1;

public class HappyNumber {

    public boolean isHappy(int n) {
        int slow = n, fast = n;

        do {
            slow = mathMulp(slow);
            fast = mathMulp(mathMulp(fast));
        } while (slow != fast);

        if (slow == 1) {
            return true;
        }

        return false;
    }

    int mathMulp(int n) {
        int mulp = 0;
        while (n > 0) {
            int last = n % 10;
            mulp += last * last;
            n /= 10;
        }
        return mulp;
    }
}
