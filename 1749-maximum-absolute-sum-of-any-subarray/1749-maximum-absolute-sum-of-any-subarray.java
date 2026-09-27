class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0;
        int minSum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            maxSum = Math.max(0, maxSum + nums[i]);
            minSum = Math.min(0, minSum + nums[i]);
            ans = Math.max(ans, Math.max(maxSum, -minSum));
        }
        return ans;
    }
}