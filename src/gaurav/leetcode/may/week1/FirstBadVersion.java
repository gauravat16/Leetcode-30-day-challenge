package gaurav.leetcode.may.week1;

import java.util.Arrays;

public class FirstBadVersion {

    public int firstBadVersion(int n) {

        int s = 1, e = n;
        while (s <= e) {

            int mid = s + (e - s) / 2;
            boolean isMidBad = isBadVersion(mid);

            if (!isMidBad) {
                s = mid + 1;
            } else {
                if (isBadVersion(mid - 1)) {
                    e = mid - 1;
                } else {
                    return mid;
                }
            }
        }

        Arrays.stream(new int[]{}).max().getAsInt();

        return -1;

    }

    private boolean isBadVersion(int n) {
        //Will be given in the question.
        return true;
    }
}
