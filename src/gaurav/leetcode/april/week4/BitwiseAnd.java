package gaurav.leetcode.april.week4;

public class BitwiseAnd {

    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        while(m!=n){
            m>>=1;
            n>>=1;
            count++;
        }
        return m<<count;
    }

//    public int rangeBitwiseAnd(int m, int n) {
//
//        if (m == 0 || n == 0) {
//            return 0;
//        }
//        long closestPow = Math.round(Math.log(m) / Math.log(2));
//
//        long twoPow = (long) Math.pow(2, closestPow);
//
//        while (twoPow <= n) {
//            if (m < twoPow) {
//                return 0;
//            }
//            twoPow *= 2;
//        }
//
//        int j = m;
//        for (int i = m + 1; i <= n; i++) {
//            if (i == Integer.MIN_VALUE) {
//                break;
//            }
//            j &= i;
//        }
//
//        return j;
//    }


    public static void main(String[] args) {
        System.out.println(new BitwiseAnd().rangeBitwiseAnd(3, 11));
    }
}
