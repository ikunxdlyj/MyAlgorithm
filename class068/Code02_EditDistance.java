package class068;

import java.util.Arrays;

public class Code02_EditDistance {
    public int minDistance1(String word1, String word2) {
        if (word1 == null || word1.isEmpty()) {
            return word2.length();
        }
        if (word2 == null || word2.isEmpty()) {
            return word1.length();
        }
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        for (int i = 0; i <= s1.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(s1.length, s2.length, s1, s2, dp);
    }

    public int f(int len1, int len2, char[] s1, char[] s2, int[][] dp) {
        if (len1 == 0) {
            return len2;
        }
        if (len2 == 0) {
            return len1;
        }
        if (dp[len1][len2] != -1) {
            return dp[len1][len2];
        }
        if (s1[len1 - 1] == s2[len2 - 1]) {
            dp[len1][len2] = f(len1 - 1, len2 - 1, s1, s2, dp);
            return dp[len1][len2];
        } else {
            int insert = 1 + f(len1, len2 - 1, s1, s2, dp);
            int delete = 1 + f(len1 - 1, len2, s1, s2, dp);
            int replace = 1 + f(len1 - 1, len2 - 1, s1, s2, dp);
            dp[len1][len2] = Math.min(insert, java.lang.Math.min(delete, replace));
            return dp[len1][len2];
        }
    }

    public int minDistance2(String word1, String word2) {
        if (word1 == null || word1.isEmpty()) {
            return word2.length();
        }
        if (word2 == null || word2.isEmpty()) {
            return word1.length();
        }
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int[][] dp = new int[s1.length + 1][s2.length + 1];
        dp[0][0] = 0;
        for (int j = 1; j <= s2.length; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= s1.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= s1.length; i++) {
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int insert = 1 + dp[i][j - 1];
                    int delete = 1 + dp[i - 1][j];
                    int replace = 1 + dp[i - 1][j - 1];
                    dp[i][j] = Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[s1.length][s2.length];
    }

    public int minDistance3(String word1, String word2) {
        if (word1 == null || word1.isEmpty()) {
            return word2.length();
        }
        if (word2 == null || word2.isEmpty()) {
            return word1.length();
        }
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int[] pre = new int[s2.length + 1];
        int[] cur = new int[s2.length + 1];
        for (int j = 0; j <= s2.length; j++) {
            pre[j] = j;
        }
        int insert, delete, replace;
        for (int i = 1; i <= s1.length; i++) {
            cur[0] = i;
            for (int j = 1; j <= s2.length; j++) {
                if (s1[i - 1] == s2[j - 1]) {
                    cur[j] = pre[j - 1];
                } else {
                    insert = 1 + cur[j - 1];
                    delete = 1 + pre[j];
                    replace = 1 + pre[j - 1];
                    cur[j] = Math.min(insert, Math.min(delete, replace));
                }
            }
            int[] temp = cur;
            cur = pre;
            pre = temp;
        }
        return pre[s2.length];
    }
}