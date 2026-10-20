class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);
        int ans = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) {
                continue;
            }
            boolean possible = true;
            for (int i = 0; i < n; i += k) {
                int count = 0;
                for (int j = 0; j < k - 1; j++) {
                    if (nums[i + j] > nums[i + j + 1]) {
                        count++;
                    }
                }
                if (nums[i + k - 1] > nums[i]) {
                    count++;
                }
                if (count > 1) {
                    possible = false;
                    break;
                }
                for (int j = i; j < i + k; j++) {
                    if (nums[j] < sorted[i] ||
                        nums[j] > sorted[i + k - 1]) {
                        possible = false;
                        break;
                    }
                }
                if (!possible) {
                    break;
                }
            }
            if (possible) {
                ans += k;
            }
        }
        return ans;
    }
}
