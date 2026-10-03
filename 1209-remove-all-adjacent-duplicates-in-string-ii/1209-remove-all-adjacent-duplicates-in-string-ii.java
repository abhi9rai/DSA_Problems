import java.util.*;
class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        Deque<int[]> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (st.isEmpty()) {
                st.push(new int[]{c, 1});
                continue;
            }
            if (st.peek()[0] != c) {
                st.push(new int[]{c, 1});
                continue;
            }
            if (st.peek()[1] < k - 1) {
                st.peek()[1]++;  
                continue;
            }
            st.pop();
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            int[] p = st.pop();
            for (int j = 0; j < p[1]; j++) {
                sb.append((char) p[0]);
            }
        }
        return sb.reverse().toString();
    }
}