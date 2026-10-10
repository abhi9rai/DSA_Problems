class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int k = k1 + k2;
        int[] diff = new int[n];
        long sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
            max = Math.max(max, diff[i]);
        }
        if (sum <= k) {
            return 0;
        }
        int left = 0;
        int right = max;
        while (left < right) {
            int mid = left + (right - left) / 2;
            long count = 0;
            for (int i = 0; i < n; i++) {
                if (diff[i] > mid) {
                    count += diff[i] - mid;
                }
            }
            if (count <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (diff[i] > left) {
                k -= diff[i] - left;
                diff[i] = left;
            }
        }
        for (int i = 0; i < n && k > 0; i++) {
            if (diff[i] == left) {
                diff[i]--;
                k--;
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) diff[i] * diff[i];
        }
        return ans;
    }
}