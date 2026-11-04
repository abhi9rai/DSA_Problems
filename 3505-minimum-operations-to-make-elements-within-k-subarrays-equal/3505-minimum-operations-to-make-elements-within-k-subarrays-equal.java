import java.util.*;
class Solution {
    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();
    long leftSum = 0;
    long rightSum = 0;
    int leftSize = 0;
    int rightSize = 0;
    void addLeft(int num) {
        left.put(num, left.getOrDefault(num, 0) + 1);
        leftSum += num;
        leftSize++;
    }
    void addRight(int num) {
        right.put(num, right.getOrDefault(num, 0) + 1);
        rightSum += num;
        rightSize++;
    }
    void removeLeft(int num) {
        int count = left.get(num);
        if (count == 1)
            left.remove(num);
        else
            left.put(num, count - 1);
        leftSum -= num;
        leftSize--;
    }
    void removeRight(int num) {
        int count = right.get(num);
        if (count == 1)
            right.remove(num);
        else
            right.put(num, count - 1);
        rightSum -= num;
        rightSize--;
    }
    void rebalance() {
        while (leftSize > rightSize + 1) {
            int num = left.lastKey();
            removeLeft(num);
            addRight(num);
        }
        while (leftSize < rightSize) {
            int num = right.firstKey();
            removeRight(num);
            addLeft(num);
        }
    }
    void add(int num) {
        if (left.isEmpty() || num <= left.lastKey())
            addLeft(num);
        else
            addRight(num);
        rebalance();
    }
    void remove(int num) {
        if (left.containsKey(num))
            removeLeft(num);
        else
            removeRight(num);
        rebalance();
    }
    long getCost() {
        int median = left.lastKey();
        return (long) median * leftSize - leftSum
             + rightSum - (long) median * rightSize;
    }
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long[] cost = new long[n - x + 1];
        for (int i = 0; i < n; i++) {
            add(nums[i]);
            if (i >= x)
                remove(nums[i - x]);
            if (i >= x - 1)
                cost[i - x + 1] = getCost();
        }
        long INF = Long.MAX_VALUE / 4;
        long[][] dp = new long[k + 1][n + 1];
        for (int i = 0; i <= k; i++)
            Arrays.fill(dp[i], INF);
        Arrays.fill(dp[0], 0);
        for (int j = 1; j <= k; j++) {
            for (int i = 1; i <= n; i++) {
                dp[j][i] = dp[j][i - 1];
                if (i >= x && dp[j - 1][i - x] != INF) {
                    dp[j][i] = Math.min(
                        dp[j][i],
                        dp[j - 1][i - x] + cost[i - x]
                    );
                }
            }
        }
        return dp[k][n];
    }
}