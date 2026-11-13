import java.util.*;
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        Deque<int[]> dq = new ArrayDeque<>();
        long cost = 0;
        long ans = 0;
        int right = nums.length - 1;
        for (int left = nums.length - 1; left >= 0; left--) {
            int value = nums[left];
            int count = 1;
            while (!dq.isEmpty() && dq.peekLast()[0] < value) {
                int[] last = dq.pollLast();
                cost += (long) (value - last[0]) * last[1];
                count += last[1];
            }
            dq.offerLast(new int[]{value, count});
            while (cost > k) {
                int[] first = dq.peekFirst();
                cost -= first[0] - nums[right];
                first[1]--;
                if (first[1] == 0) {
                    dq.pollFirst();
                }
                right--;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}
