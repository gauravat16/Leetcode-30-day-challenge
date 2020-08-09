package gaurav.leetcode.random;

import java.util.PriorityQueue;

public class HappyString {

    public String longestDiverseString(int a, int b, int c) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((v1, v2) -> v2.count - v1.count);
        if (a > 0) pq.offer(new Pair('a', a));
        if (b > 0) pq.offer(new Pair('b', b));
        if (c > 0) pq.offer(new Pair('c', c));

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int delta = Math.min(2, curr.count);

            if (sb.length() > 0) {
                char last = sb.charAt(sb.length() - 1);
                while (curr != null && last == curr.c) {
                    delta = 1;
                    Pair temp = curr;
                    curr = pq.poll();
                    pq.offer(temp);
                }
                if (curr == null || last == curr.c) break;
            }

            for (int i = 0; i < delta; i++) {
                sb.append(curr.c);
            }

            curr.count -= delta;
            if (curr.count > 0) {
                pq.offer(curr);
            }

        }

        return sb.toString();

    }

    class Pair {
        char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

        public String toString() {
            return "[" + c + " ," + count + "=" + count + "]";
        }
    }

    public static void main(String[] args) {
        System.out.println(new HappyString().longestDiverseString(1, 1, 7));
        System.out.println(new HappyString().longestDiverseString(7, 1, 0));
        System.out.println(new HappyString().longestDiverseString(4, 42, 7));

    }
}
