package class066;

import java.util.Arrays;

public class Code01_FibonacciNumber {
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib1(n - 1) + fib1(n - 2);
    }

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return process(n, dp);
    }
    public int process(int i, int[] dp) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        if (dp[i] != -1) return dp[i];
        return process(i - 1, dp) + process(i - 2, dp);
    }

    public int fib3(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib4(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int prePre = 0, pre = 1;
        int cur;
        for (int i = 2; i <= n; i++) {
            cur = prePre + pre;
            prePre = pre;
            pre = cur;
        }
        return pre;
    }
}