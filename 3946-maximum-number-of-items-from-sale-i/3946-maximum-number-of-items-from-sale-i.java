class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            minPrice = Math.min(minPrice, items[i][1]);
        }
        int[] free = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int gain = free[i] + 1;
            for (int j = budget; j >= price; j--) {
                if (dp[j - price] != -1) {
                    dp[j] = Math.max(dp[j],
                        dp[j - price] + gain);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= budget; i++) {
            if (dp[i] != -1) {
                int remaining = (budget - i) / minPrice;
                ans = Math.max(ans, dp[i] + remaining);
            }
        }
        return ans;
    }
}
