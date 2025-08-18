package class020;

public class GetMaxValue {
    public static void main(String[] args) {
        int[] arr = {1, 3, 10, -10, 1000};
        System.out.println(getMaxValue(arr));
    }

    public static int getMaxValue(int[] arr) {
        return f(0, arr.length - 1, arr);
    }

    public static int f(int l, int r, int[] arr) {
        if (l == r) {
            return arr[l];
        }
        int mid = l + (r - l) / 2;

        return Math.max(f(l, mid, arr), f(mid+1, r, arr));
    }
}