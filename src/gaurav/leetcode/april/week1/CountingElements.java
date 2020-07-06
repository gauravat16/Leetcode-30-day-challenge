package gaurav.leetcode.april.week1;

import java.util.HashMap;
import java.util.Map;

public class CountingElements {
    public int countElements(int[] arr) {

        Map<Integer, Integer> countMap = new HashMap<>();

        for (int i : arr) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        int count = 0;

        for (int i : arr) {
            if (countMap.containsKey(i + 1) && countMap.get(i) > 0 && countMap.get(i + 1) > 0) {
                count += 1;
            }
        }


        return count;
    }
}
