package class031;

public class Code03_Near2power {

    public int near2power(int n) {
        if (n <= 0) {
            return 1;
        }
        n--;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }
}