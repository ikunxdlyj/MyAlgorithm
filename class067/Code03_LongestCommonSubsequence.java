package class067;

import java.util.Arrays;

public class Code03_LongestCommonSubsequence {
    public int longestCommonSubsequence1(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 0; i <= s1.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(s1.length, s2.length, s1, s2, dp);
    }

    public int f(int len1, int len2, char[] s1, char[] s2, int[][] dp) {
        if (len1 == 0 || len2 == 0) return 0;
        if (dp[len1][len2] != -1) return dp[len1][len2];
        if (s1[len1 - 1] == s2[len2 - 1]) dp[len1][len2] = 1 + f(len1 - 1, len2 - 1, s1, s2, dp);
        else dp[len1][len2] = Math.max(f(len1 - 1, len2, s1, s2, dp), f(len1, len2 - 1, s1, s2, dp));
        return dp[len1][len2];
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int len1 = 1; len1 <= s1.length; len1++) {
            for (int len2 = 1; len2 <= s2.length; len2++) {
                if (s1[len1 - 1] == s2[len2 - 1]) {
                    dp[len1][len2] = 1 + dp[len1 - 1][len2 - 1];
                } else {
                    dp[len1][len2] = Math.max(dp[len1 - 1][len2], dp[len1][len2 - 1]);
                }
            }
        }
        return dp[s1.length][s2.length];
    }

    public int longestCommonSubsequence3(String text1, String text2) {
        char[] s1 = text1.toCharArray();
        char[] s2 = text2.toCharArray();
        int[] pre = new int[s2.length + 1];
        int[] cur = new int[s2.length + 1];
        for (int len1 = 1; len1 <= s1.length; len1++) {
            for (int len2 = 1; len2 <= s2.length; len2++) {
                if (s1[len1 - 1] == s2[len2 - 1]) {
                    cur[len2] = 1 + pre[len2 - 1];
                } else {
                    cur[len2] = Math.max(cur[len2 - 1], pre[len2]);
                }
            }
            int[] temp = pre;
            pre = cur;
            cur = temp;
        }
        return pre[s2.length];
    }

}