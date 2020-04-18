package gaurav.leetcode.week2;

import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int v : stones) {
            maxHeap.offer(v);
        }

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 < stone2) {
                maxHeap.offer(stone2 - stone1);
            } else if (stone1 > stone2) {
                maxHeap.offer(stone1 - stone2);
            }
        }

        return maxHeap.size() == 0 ? 0 : maxHeap.poll();
    }
}
