package gaurav.leetcode.july;

public class HammingDistance {


    public int hammingDistance(int x, int y) {

        int xor = x ^ y;

        int count = 0;

        while (xor > 0) {
            count++;
            xor &= xor - 1;
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println(new HammingDistance().hammingDistance(1, 4));
    }
}
