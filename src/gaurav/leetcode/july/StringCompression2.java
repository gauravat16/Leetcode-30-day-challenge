package gaurav.leetcode.july;

import java.util.HashMap;
import java.util.Map;

public class StringCompression2 {

    public int getLengthOfOptimalCompression(String s, int k) {
        Map<Character, Integer> counts = new HashMap<>();

        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return helper(counts, k);
    }

    private int helper(Map<Character, Integer> counts, int k) {
        if (k == 0) {
            int len = 0;
            for (char c : counts.keySet()) {
                if (counts.get(c) > 1) {
                    len += 1 + String.valueOf(counts.get(c)).length();
                }
                if (counts.get(c) == 1) {
                    len++;
                }

            }

            return len;

        }

        int min = Integer.MAX_VALUE;

        for (char c : counts.keySet()) {
            int freq = counts.get(c);

            if (k >= freq && freq > 0) {
                counts.put(c, 0);
                min = Math.min(helper(counts, k - freq), min);
                counts.put(c, freq);
            }

        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(new StringCompression2().getLengthOfOptimalCompression("aaabcccd", 2));
    }
}
