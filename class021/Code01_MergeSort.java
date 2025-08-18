package class021;

import java.util.Arrays;

public class Code01_MergeSort {
    public static void main(String[] args) {
        int times = 1000;
        for (int i = 0; i < times; i++) {
            int length = (int) (Math.random() * 1000);
            int lowerBound = -(int) (Math.random() * 1000);
            int upperBound = (int) (Math.random() * 1000);
            int[] arr1 = buildArray(length, lowerBound, upperBound);
            int[] arr2 = copyArray(arr1);
            Arrays.sort(arr1);
            mergeSort(0, arr2.length - 1, arr2);
            if (!isSameArray(arr1, arr2)) {
                System.out.println("Error!!!");
            }
        }
        System.out.println("Finish!");
    }

    public static boolean isSameArray(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] copyArray(int[] arr) {
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        return arr2;
    }

    public static int[] buildArray(int length, int lowerBound, int upperBound) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = lowerBound + (int) (Math.random() * (upperBound + 1 - lowerBound));
        }
        return arr;
    }

    public static void mergeSort(int l, int r, int[] arr) {
        if (l == r) {
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(l, mid, arr);
        mergeSort(mid + 1, r, arr);
        merge(l, mid, r, arr);
    }

    public static void merge(int l, int mid, int r, int[] arr) {
        // 修复2：正确实现归并逻辑
        int[] help = new int[r - l + 1];
        int i = l;       // 左区间起始位置
        int j = mid + 1; // 右区间起始位置
        int k = 0;       // help数组的索引（从0开始）

        // 合并两个有序区间
        while (i <= mid && j <= r) {
            help[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        // 复制剩余元素
        while (i <= mid) {
            help[k++] = arr[i++];
        }
        while (j <= r) {
            help[k++] = arr[j++];
        }

        // 将排序好的数据复制回原数组
        for (int m = 0; m < help.length; m++) {
            arr[l + m] = help[m];
        }
    }
}