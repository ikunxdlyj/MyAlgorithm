package class023;

import java.io.*;

public class Code01_QuickSort {
    public static int N;
    public static int[] arr = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(br);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        while (in.nextToken() != StreamTokenizer.TT_EOF) {
            N = (int) in.nval;
            for (int i = 0; i < N; i++) {
                in.nextToken();
                arr[i] = (int) in.nval;
            }
            quickSort(arr, 0, N - 1);
            for (int i = 0; i < N - 1; i++) {
                out.print(arr[i] + " ");
            }
            out.print(arr[N - 1]);
        }
        out.flush();
        out.close();
        br.close();
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int randomIndex = l + (int) (Math.random() * (r - l + 1));
        int pivot = arr[randomIndex];
        f(l, r, pivot, arr);
        quickSort(arr, l, first - 1);
        quickSort(arr, last + 1, r);
    }

    public static int first, last;

    public static void f(int l, int r, int pivot, int[] arr) {
        if (l >= r) {
            return;
        }
        first = l;
        last = r;
        int index = l;
        while (index <= last) {
            if (arr[index] < pivot) {
                swap(index++, first++, arr);
            } else if (arr[index] > pivot) {
                swap(index, last--, arr);
            } else {
                index++;
            }
        }
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}