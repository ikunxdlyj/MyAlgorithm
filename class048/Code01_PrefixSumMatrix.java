package class048;

public class Code01_PrefixSumMatrix {
    static class NumMatrix {
        public static int MAX_N=201;
        public static int MAX_M=201;
        public static int[][] prefixArr = new int[MAX_N][MAX_M];

        public NumMatrix(int[][] matrix) {
            prefixArr[0][0] = matrix[0][0];
            for (int i = 1; i < matrix.length; i++) {
                prefixArr[i][0] = matrix[i][0] + prefixArr[i - 1][0];
            }
            for(int j = 1; j < matrix[0].length; j++) {
                prefixArr[0][j] = matrix[0][j] + prefixArr[0][j - 1];
            }
            for (int i = 1; i < matrix.length; i++) {
                for (int j = 1; j < matrix[0].length; j++) {
                    prefixArr[i][j] = matrix[i][j] + prefixArr[i - 1][j] + prefixArr[i][j - 1] - prefixArr[i - 1][j - 1];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return prefixArr[row2][col2]
                    - (row1 > 0 ? prefixArr[row1 - 1][col2] : 0)
                    - (col1 > 0 ? prefixArr[row1][col1 - 1] : 0)
                    + (row1 > 0 && col1 > 0 ? prefixArr[row1 - 1][col1 - 1] : 0);
        }
    }
}