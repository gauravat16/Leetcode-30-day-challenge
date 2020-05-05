package gaurav.leetcode.may.week1;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 */

public class FindFirstUnique {


    public int firstUniqChar(String s) {
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (count[c - 'a'] == 1) return i;
        }

        return -1;
    }

    public int firstUniqChar2(String s) {
        Map<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!map.containsKey(c)) {
                map.put(c, new int[]{i, 1});
            } else {
                map.get(c)[1]++;
            }
        }

        int minIdx = Integer.MAX_VALUE;

        for (Map.Entry<Character, int[]> e : map.entrySet()) {
            if (e.getValue()[1] == 1) {
                minIdx = Math.min(minIdx, e.getValue()[0]);
            }
        }

        return minIdx == Integer.MAX_VALUE ? -1 : minIdx;
    }
}
