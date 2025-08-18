package class067;

import java.util.Arrays;

public class Code01_MinimumPathSum {
    public int minPathSum1(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(grid.length - 1, grid[0].length - 1, grid, dp);
    }

    public int f(int i, int j, int[][] grid, int[][] dp) {
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        if (dp[i][j] != -1) return dp[i][j];
        if (i == 0) {
            return grid[0][j] + f(i, j - 1, grid, dp);
        }
        if (j == 0) {
            return grid[i][0] + f(i - 1, j, grid, dp);
        }
        dp[i][j] = grid[i][j] + Math.max(f(i - 1, j, grid, dp), f(i, j - 1, grid, dp));
        return dp[i][j];
    }

    public int minPathSum2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        // i==0
        for (int j = 1; j < grid[0].length; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        // j==0
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public int minPathSum3(int[][] grid) {
        int[] pre = new int[grid[0].length];
        int[] cur = new int[grid[0].length];
        pre[0] = grid[0][0];
        for (int j = 1; j < grid[0].length; j++) {
            pre[j] = pre[j - 1] + grid[0][j];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0) {
                    cur[j] = pre[j] + grid[i][j];
                } else {
                    cur[j] = grid[i][j] + Math.min(pre[j], cur[j - 1]);
                }
            }
            int[] temp = cur;
            cur = pre;
            pre = temp;
        }
        return pre[grid[0].length - 1];
    }
}