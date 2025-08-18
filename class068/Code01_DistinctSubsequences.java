package class068;

import java.util.Arrays;

public class Code01_DistinctSubsequences {
    public int numDistinct1(String str1, String str2) {
        char[] s = str1.toCharArray();
        char[] t = str2.toCharArray();
        int[][] dp = new int[s.length + 1][t.length + 1];
        for (int i = 0; i <= s.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(0, 0, s, t, dp);
    }

    public int f(int i, int j, char[] s, char[] t, int[][] dp) {
        if (i == s.length) {
            return j == t.length ? 1 : 0;
        }
        if (j == t.length) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = f(i + 1, j, s, t, dp);
        if (s[i] == t[j]) {
            ans += f(i + 1, j + 1, s, t, dp);
        }
        dp[i][j] = ans;
        return ans;
    }

//    public int numDistinct2(String str1, String str2) {
//        char[] s = str1.toCharArray();
//        char[] t = str2.toCharArray();
//        int[][] dp = new int[s.length + 1][t.length + 1];
//        dp[s.length][t.length] = 1;
//        for (int i = s.length - 1; i >= 0; i--) {
//            dp[i][t.length] = 1;
//        }
//        for()
//    }
}