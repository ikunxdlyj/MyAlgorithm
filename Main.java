import java.io.*;

public class Main {
    public static int N = 1000;
    public static int[] arr = new int[N];

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
            f(arr);
        }
        out.flush();
        out.close();
        br.close();
    }

    public static void f(int[] nums) {
        return;
    }
}