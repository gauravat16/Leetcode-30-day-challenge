package gaurav.leetcode.may.week2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/find-the-town-judge/
 */
public class FindJudge {

    public int findJudge(int N, int[][] trust) {

        int[] trustedBy = new int[N + 1];

        for (int[] t : trust) {
            int by = t[0];
            int trusts = t[1];

            if (trustedBy[by] != Integer.MAX_VALUE && trustedBy[by] >= 0) {
                trustedBy[by] = Integer.MAX_VALUE;
            }

            if (trustedBy[trusts] != Integer.MAX_VALUE) {
                trustedBy[trusts]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            if (trustedBy[i] == N - 1) {
                return i;
            }
        }

        return -1;
    }

    public int findJudge1(int N, int[][] trust) {

        Map<Integer, List<Integer>> personTrusts = new HashMap<>();
        Map<Integer, List<Integer>> personTrustedBy = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            personTrusts.put(i, new ArrayList<>());
            personTrustedBy.put(i, new ArrayList<>());
        }

        for (int[] t : trust) {
            personTrusts.get(t[0]).add(t[1]);
            personTrustedBy.get(t[1]).add(t[0]);
        }

        for (int i = 1; i <= N; i++) {
            if (personTrusts.get(i).size() == 0 && personTrustedBy.get(i).size() == N - 1) {
                return i;
            }
        }

        return -1;
    }
}
