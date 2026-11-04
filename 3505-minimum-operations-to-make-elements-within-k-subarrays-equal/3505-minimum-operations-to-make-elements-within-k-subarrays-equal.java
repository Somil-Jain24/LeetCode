
import java.util.*;

class Solution {

    TreeMap<Integer, Integer> low = new TreeMap<>();
    TreeMap<Integer, Integer> high = new TreeMap<>();

    long lowSum = 0;
    long highSum = 0;

    int lowSize = 0;
    int highSize = 0;

    void add(TreeMap<Integer, Integer> map, int val) {
        map.put(val, map.getOrDefault(val, 0) + 1);
    }

    void remove(TreeMap<Integer, Integer> map, int val) {
        int count = map.get(val);

        if (count == 1) {
            map.remove(val);
        } else {
            map.put(val, count - 1);
        }
    }

    void insert(int val) {

        if (low.isEmpty() || val <= low.lastKey()) {
            add(low, val);
            lowSum += val;
            lowSize++;
        } else {
            add(high, val);
            highSum += val;
            highSize++;
        }

        balance();
    }

    void erase(int val) {

        if (low.containsKey(val)) {
            remove(low, val);
            lowSum -= val;
            lowSize--;
        } else {
            remove(high, val);
            highSum -= val;
            highSize--;
        }

        balance();
    }

    void balance() {

        int target = (lowSize + highSize + 1) / 2;

        while (lowSize > target) {

            int val = low.lastKey();

            remove(low, val);
            lowSum -= val;
            lowSize--;

            add(high, val);
            highSum += val;
            highSize++;
        }

        while (lowSize < target) {

            int val = high.firstKey();

            remove(high, val);
            highSum -= val;
            highSize--;

            add(low, val);
            lowSum += val;
            lowSize++;
        }
    }

    long getCost() {

        long median = low.lastKey();

        return median * lowSize - lowSum
             + highSum - median * highSize;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;

        long[] cost = new long[n - x + 1];

        // Calculate the cost of every window.
        for (int i = 0; i < x; i++) {
            insert(nums[i]);
        }

        cost[0] = getCost();

        for (int i = x; i < n; i++) {

            erase(nums[i - x]);
            insert(nums[i]);

            cost[i - x + 1] = getCost();
        }

        // Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[][] dp = new long[k + 1][n + 1];

        for (int j = 1; j <= k; j++) {
            Arrays.fill(dp[j], INF);
        }

        for (int j = 1; j <= k; j++) {

            for (int i = 1; i <= n; i++) {

                // Skip current element
                dp[j][i] = dp[j][i - 1];

                // Select a window of size x
                if (i >= x && dp[j - 1][i - x] != INF) {

                    long take = dp[j - 1][i - x]
                              + cost[i - x];

                    dp[j][i] = Math.min(dp[j][i], take);
                }
            }
        }

        return dp[k][n];
    }
}
