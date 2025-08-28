package class073;

import java.util.Arrays;

public class Code03_TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }

    public static int[][] dp = new int[21][2001];
    public static final int offset = 1000;

    public static int findTargetSumWays(int[] nums, int target) {
        Arrays.fill(dp[nums.length], 0);
        dp[nums.length][target + offset] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = -1000; j <= 1000; j++) {
                if (j + offset + nums[i] < 2001) {
                    dp[i][j + offset] = dp[i + 1][j + offset + nums[i]];
                }
                if (j + offset - nums[i] >= 0) {
                    dp[i][j + offset] += dp[i + 1][j + offset - nums[i]];
                }
            }
        }
        return dp[0][offset];
    }


}