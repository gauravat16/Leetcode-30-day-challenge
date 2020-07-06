package gaurav.leetcode.april.week4;

import java.util.*;

public class FirstUnique1 {

    private Queue<Integer> q;
    private Map<Integer, Integer> map;

    public FirstUnique1(int[] nums) {
        q = new LinkedList<>();
        map = new HashMap<>();
        Arrays.stream(nums).forEach(this::add);
    }

    public int showFirstUnique() {

        while (!q.isEmpty()) {
            int curr = q.peek();

            if (map.get(curr) == 1) {
                return curr;
            } else {
                q.poll();
            }
        }

        return -1;
    }

    public void add(int value) {
        if (!map.containsKey(value)) {
            map.put(value, 1);
            q.offer(value);
        } else {
            map.put(value, map.get(value) + 1);
        }
    }
}
