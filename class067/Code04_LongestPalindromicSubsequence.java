package class067;

import java.util.Arrays;

public class Code04_LongestPalindromicSubsequence {
    public int longestPalindromeSubseq1(String str) {
        char[] s = str.toCharArray();
        int[][] dp = new int[s.length][s.length];
        for (int i = 0; i < s.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, s.length - 1, s, dp);
    }

    public int f(int l, int r, char[] s, int[][] dp) {
        if (l == r) {
            return 1;
        }
        if (l + 1 == r) {
            return s[l] == s[r] ? 2 : 1;
        }
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (s[l] == s[r]) {
            dp[l][r] = 2 + f(l + 1, r - 1, s, dp);
        } else {
            dp[l][r] = Math.max(f(l + 1, r, s, dp), f(l, r - 1, s, dp));
        }
        return dp[l][r];
    }

    public int longestPalindromeSubseq2(String str) {
        char[] s = str.toCharArray();
        int[][] dp = new int[s.length][s.length];
//        for (int l = 0; l < s.length-1; l++) {
//            dp[l][l] = 1;
//            dp[l][l + 1] = s[l] == s[l + 1] ? 2 : 1;
//        }
//        dp[s.length-1][s.length-1] = 1;
        for (int l = 0; l < s.length; l++) {
            dp[l][l] = 1;
        }
        for (int l = 0; l < s.length - 1; l++) {
            dp[l][l + 1] = s[l] == s[l + 1] ? 2 : 1;
        }
        for (int l = s.length - 2; l >= 0; l--) {
            for (int r = l + 1; r < s.length; r++) {
                if (s[l] == s[r]) {
                    dp[l][r] = 2 + dp[l + 1][r - 1];
                } else {
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                }
            }
        }
        return dp[0][s.length - 1];
    }


}