package class032;

public class Code02_DesignBitsetTest {

    public static class Bitset {
        public static int[] bitset;
        public static int size;
        public static int notExist;
        public static int exist;
        public static boolean reverse;

        public Bitset(int n) {
            bitset = new int[(n + 31) / 32];
            size = n;
            notExist = n;//存在的数量
            exist = 0;//不存在的数量
            reverse = false;
        }

        public void fix(int idx) {
            int index = idx / 32;
            int bits = idx % 32;
            if (!reverse) {
                if ((bitset[index] & (1 << bits)) == 0) {
                    bitset[index] |= (1 << bits);
                    exist++;
                    notExist--;
                }
            } else {
                if ((bitset[index] & (1 << bits)) != 0) {
                    bitset[index] &= (~(1 << bits));
                    exist++;
                    notExist--;
                }
            }
        }

        public void unfix(int idx) {
            int index = idx / 32;
            int bits = idx % 32;
            if (!reverse) {
                if ((bitset[index] & (1 << bits)) != 0) {
                    bitset[index] &= ~(1 << bits);
                    exist--;
                    notExist++;
                }
            } else {
                if ((bitset[index] & (1 << bits)) == 0) {
                    bitset[index] |= 1 << bits;
                    exist--;
                    notExist++;
                }
            }
        }

        public void flip() {
            reverse = !reverse;
            int temp = notExist;
            notExist = exist;
            exist = temp;
        }

        public boolean all() {
            return exist == size;
        }

        public boolean one() {
            return exist > 0;
        }

        public int count() {
            return exist;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            int bitIndex = 0;
            for (int num : bitset) {
                for (int i = 0; i < 32 && bitIndex < size; i++, bitIndex++) {
                    int curBit = (num >> i) & 1;
                    curBit = !reverse ? curBit : (curBit ^ 1);
                    sb.append(curBit);
                }
            }
            return sb.toString();
        }
    }
}