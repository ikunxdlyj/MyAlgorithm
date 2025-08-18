package class066;

public class Code02_MinimumCostForTickets {
    public static final int[] durations = {1, 7, 30};

    public int mincostTickets1(int[] days, int[] costs) {
        return f(0, days, costs);
    }
    public int f(int i, int[] days, int[] costs) {
        if (i >= days.length) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for (int k = 0, j = i; k < 3; k++) {
            while (j < days.length && days[i] + durations[k] <= days[j]) {
                j++;
            }
            ans = Math.min(ans, costs[k] + f(j, days, costs));
        }
        return ans;
    }
}