package gaurav.leetcode.week3;

import java.util.Arrays;
import java.util.List;

public class BinaryMatrixAPI {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {

        int lastOne = Integer.MAX_VALUE;

        List<Integer> size = binaryMatrix.dimensions();

        int r = 0;

        while (r < size.get(0)) {
            int s = 0, e = size.get(1) - 1;
            while (s <= e) {
                int mid = s + ((e - s) / 2);
                int val = binaryMatrix.get(r, mid);

                if (val == 1 && (mid == 0 || (mid > 0 && binaryMatrix.get(r, mid - 1) == 0))) {
                    lastOne = Math.min(lastOne, mid);
                    break;
                } else if (val == 1) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }

            }
            r++;
        }

        return lastOne == Integer.MAX_VALUE ? -1 : lastOne;

    }

    static class BinaryMatrix {
        int[][] mat;

        public BinaryMatrix(int[][] mat) {
            this.mat = mat;
        }

        List<Integer> dimensions() {
            return Arrays.asList(mat.length, mat[0].length);
        }

        int get(int r, int c) {
            return mat[r][c];
        }
    }

    public static void main(String[] args) {
        BinaryMatrix binaryMatrix = new BinaryMatrix(new int[][]{{0, 0}, {0, 0}});
        System.out.println(new BinaryMatrixAPI().leftMostColumnWithOne(binaryMatrix));
    }
}
