class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }
        long[] count = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                count[i] += freq[j];
            }
            count[i]--;
        }
        long[][] arr = new long[n][2];
        for (int i = 0; i < n; i++) {
            int factor = items[i][0];
            arr[i][0] = items[i][1];
            arr[i][1] = count[factor];
        }
        java.util.Arrays.sort(arr, (a, b) ->
            Long.compare(a[0], b[0])
        );
        long minPrice = arr[0][0];
        long spent = 0;
        long bonus = 0;
        for (int i = 0; i < n; i++) {
            long price = arr[i][0];
            long capacity = arr[i][1];
            if (price >= 2 * minPrice) {
                break;
            }
            long remaining = budget - spent;
            long take = Math.min(capacity, remaining / price);
            spent += take * price;
            bonus += take;
            if (take < capacity) {
                break;
            }
        }
        long answer = bonus * 2 + (budget - spent) / minPrice;
        return (int) answer;
    }
}
