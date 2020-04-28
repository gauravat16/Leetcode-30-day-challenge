package gaurav.leetcode.week4;

import java.util.*;

public class FirstUnique2 {

    private LinkedHashSet<Integer> uniqueSet;
    private Set<Integer> set;

    public FirstUnique2(int[] nums) {
        uniqueSet = new LinkedHashSet<>();
        set = new HashSet<>();
        Arrays.stream(nums).forEach(this::add);
    }

    public int showFirstUnique() {

        for (int v : uniqueSet){
            return v;
        }
        return -1 ;
    }

    public void add(int value) {
        if (!set.contains(value)) {
            set.add(value);
            uniqueSet.add(value);
        } else {
            set.add(value);
            uniqueSet.remove(value);
        }
    }

    public static void main(String[] args) {
        FirstUnique1 firstUnique1 = new FirstUnique1(new int[]{});
        FirstUnique2 firstUnique2 = new FirstUnique2(new int[]{});

        long start = System.currentTimeMillis();

        for (int i = 1; i < 999999; i++) {
            firstUnique1.add(i);
        }

        for (int i = 1; i < 999999; i++) {
            firstUnique1.add(i);
        }

        firstUnique1.add(1000000);

        System.out.println(firstUnique1.showFirstUnique());

        System.out.println((System.currentTimeMillis() - start));


        start = System.currentTimeMillis();

        for (int i = 1; i < 999999; i++) {
            firstUnique2.add(i);
        }

        for (int i = 1; i < 999999; i++) {
            firstUnique2.add(i);
        }

        firstUnique2.add(1000000);

        System.out.println(firstUnique2.showFirstUnique());

        System.out.println((System.currentTimeMillis() - start));

    }
}
