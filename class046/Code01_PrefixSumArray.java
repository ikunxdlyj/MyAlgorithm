package class046;

public class Code01_PrefixSumArray {
    class NumArray {
        public static int MAX_N = 10001;
        public static int[] prefixArr = new int[MAX_N];

        public NumArray(int[] nums) {
            prefixArr[0] = nums[0];
            for (int i = 1; i < MAX_N; i++) {
                prefixArr[i] = prefixArr[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return left == 0 ? prefixArr[right] : (prefixArr[right] - prefixArr[left - 1]);
        }
    }
}