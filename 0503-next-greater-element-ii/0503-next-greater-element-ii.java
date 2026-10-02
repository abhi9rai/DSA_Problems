import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n;
            while (!st.empty() && st.peek() <= nums[index]) {
                st.pop();
            }
            if (st.empty()) {
                res[index] = -1;
            } else {
                res[index] = st.peek();
            }
            st.push(nums[index]);
        }
        return res;
    }
}