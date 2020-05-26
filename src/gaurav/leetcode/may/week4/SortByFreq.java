package gaurav.leetcode.may.week4;

import java.util.PriorityQueue;

public class SortByFreq {

    public String frequencySort(String s) {

        int[] count = new int[128];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)]++;
        }

        PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (int i = 0; i < count.length; i++) {
            pq.offer(new Point((char) (i), count[i]));
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            for (int i = 0; i < p.count; i++) {
                sb.append(p.c);
            }

        }

        return sb.toString();

    }

    class Point {
        char c;
        int count;

        public Point(char c, int count) {
            this.c = c;
            this.count = count;
        }

    }
}
