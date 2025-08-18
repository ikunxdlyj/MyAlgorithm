public class CheckPowersOfThree {
    public static final int[] powers = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683, 59049, 177147, 531441, 1594323, 4782969};

    public boolean checkPowersOfThree1(int n) {
        return f(0, 0, n);
    }

    public boolean f(int i, int cur, int n) {
        if (i == powers.length) {
            return cur == n;
        }
        if (cur > n) {
            return false;
        }
        if (cur == n) {
            return true;
        }

        boolean p1 = f(i + 1, cur, n);
        boolean p2 = f(i + 1, cur + powers[i], n);
        return p1 || p2;
    }


   public boolean checkPowersOfThree2(int n) {
        while(n!=0){
            if(n%3==2) {
                return false;
            }
            n/=3;
        }
        return true;
   }
}
