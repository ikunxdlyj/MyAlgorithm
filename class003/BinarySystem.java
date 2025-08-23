package class003;

public class BinarySystem {
    public static void main(String[] args) {
        for(int i=0;i<=100;i++){
            int num=(int)(Math.random()*10000);
            printBinary(num);
            printBinary(rightOne(num));
            System.out.println("---------------------------");
        }
    }

    public static int rightOne(int num) {
        return num & (-num);
    }

    public static void printBinary(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            sb.append((num >> i) & 1);
        }
        System.out.println(sb);
    }
}