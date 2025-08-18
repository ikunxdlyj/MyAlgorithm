package class031;

public class Code02_PowerOfThree {
    public static void main(String[] args) {
        long a = 1;
        while (a * 3 <= Integer.MAX_VALUE) {
            a *= 3;
        }
        System.out.println(a);
    }

    public boolean isPowerOfThree(int n) {
//        if (n <= 0) {
//            return false;
//        }
//        return 1162261467 % n == 0;
        return n > 0 && 1162261467 % n == 0;
    }
}