package gaurav.leetcode.june.week1;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class RandomizedSet {

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private static final Random r = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.get(val);
            list.set(idx, list.get(list.size() - 1));
            map.put(list.get(list.size() - 1), idx);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        return false;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {

        int idx = r.nextInt(list.size());
        return list.get(idx);

    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(0));
        System.out.println(randomizedSet.insert(0));

    }
}
