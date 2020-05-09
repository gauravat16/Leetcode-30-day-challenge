package gaurav.leetcode.may.week2;

public class IsPerfectSquare {

    public boolean isPerfectSquare(int num) {
        if (num == 1) return true;

        int s = 0;
        int e = num / 2;

        while (s <= e) {
            int mid = s + ((e - s) / 2);
            double div = (double) num / mid;

            if (div == mid) {
                return true;
            }

            if (div > mid) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }

        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(new IsPerfectSquare().isPerfectSquare(5));
    }
}
