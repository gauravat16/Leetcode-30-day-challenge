package gaurav.leetcode.may.week1;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    /**
     * Uses Array to keep count
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        boolean[] arr = new boolean[52];
        for (char j : J.toCharArray()) {
            if (j >= 'A' && j <= 'Z') {
                arr[j - 'A' + 26] = true;
            } else {
                arr[j - 'a'] = true;
            }
        }

        for (char s : S.toCharArray()) {
            if ((s >= 'A' && s <= 'Z' && arr[s - 'A' + 26])
                    || (s >= 'a' && s <= 'z' && arr[s - 'a'])) {
                count++;
            }
        }

        return count;
    }

    /**
     * Using HashSet
     *
     * @param J
     * @param S
     * @return
     */
    public int numJewelsInStones2(String J, String S) {
        int count = 0;
        Set<Character> jewels = new HashSet<>();
        for (char j : J.toCharArray()) {
            jewels.add(j);
        }

        for (char s : S.toCharArray()) {
            if (jewels.contains(s)) {
                count++;
            }
        }

        return count;

    }
}
