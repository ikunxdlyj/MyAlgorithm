package class054;

import java.util.Arrays;

public class Code01_SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(arr, k)));
    }

    public static int[] deque = new int[100001];
    public static int l, r;

    public static int[] maxSlidingWindow(int[] nums, int k) {
        l = r = 0;
        int[] ans = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            while (l < r && nums[i] >= nums[deque[r - 1]]) {
                r--;
            }
            deque[r++] = i;
            if (i < k - 1) {
                continue;
            }
            ans[i - k + 1] = nums[deque[l]];
            // 因为是出窗口，所以此时即使窗口左端和此时deque[l]的数相同，下个循环他就过期了
            // 所以是小于等于都出去
            if (deque[l] <= i - k + 1) {
                l++;
            }
        }
        return ans;

    }

}