package class003;

public class BinarySystem {
    public static void main(String[] args) {
        printBinary(32);
    }
    public static void printBinary(int num) {
        StringBuilder sb = new StringBuilder();
        for(int i=31; i>=0; i--) {
            sb.append((num>>i)&1);
        }
        System.out.println(sb);
    }
}