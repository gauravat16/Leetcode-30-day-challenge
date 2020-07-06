package gaurav.leetcode.may.week4;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {

    public int[][] intervalIntersection(int[][] A, int[][] B) {

        List<int[]> list = new ArrayList<>();

        for (int i = 0, j = 0; i < A.length && j < B.length; ) {
            int[] currA = A[i];
            int[] currB = B[j];

            int s = Math.max(currA[0], currB[0]);
            int e = Math.min(currA[1], currB[1]);

            if (s <= e) {
                list.add(new int[]{s, e});
            }

            if (currA[1] > currB[1]) {
                j++;
            } else if (currA[1] < currB[1]) {
                i++;
            } else if (currA[1] == currB[1]) {
                i++;
                j++;
            }
        }

        return list.toArray(new int[list.size()][]);

    }
}
