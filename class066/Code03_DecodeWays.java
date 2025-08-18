package class066;

import java.util.Arrays;

public class Code03_DecodeWays {
    //        一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：
//
//            "1" -> 'A'
//
//            "2" -> 'B'
//
//            ...
//
//            "25" -> 'Y'
//
//            "26" -> 'Z'
    public int numDecodings1(String str) {
        char[] s = str.toCharArray();
        int[] dp = new int[s.length + 1];
        Arrays.fill(dp, -1);
        return f(0, s, dp);
    }
    public int f(int i, char[] s, int[] dp) {
        if (i == s.length) {
            return 1;
        }
        if (dp[i] != -1) {
            return dp[i];
        }
        if (s[i] == '0') {
            return 0;
        } else {
            int ans = f(i + 1, s, dp);
            if (i + 1 < s.length && (s[i] - '0') * 10 + (s[i + 1] - '0') <= 26) {
                ans += f(i + 2, s, dp);
            }
            dp[i] = ans;
            return ans;
        }
    }

    public int numDecodings2(String str) {
        char[] s = str.toCharArray();
        int[] dp = new int[s.length + 1];
        dp[s.length] = 1;
        int ans;
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == '0') {
                ans = 0;
            } else {
                ans = dp[i + 1];
                if (i + 1 < s.length && (s[i] - '0') * 10 + (s[i + 1] - '0') <= 26) {
                    ans += dp[i + 2];
                }
            }
            dp[i] = ans;
        }
        return dp[0];
    }

    public int numDecodings3(String str) {
        char[] s = str.toCharArray();
        int pre = 1, prePre = 1;
        int cur;
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == '0') {
                cur = 0;
            } else {
                cur = pre;
                if (i + 1 < s.length && (s[i] - '0') * 10 + (s[i + 1] - '0') <= 26) {
                    cur += prePre;
                }
            }
            prePre = pre;
            pre = cur;
        }
        return pre;
    }

}