import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] proj = new int[n][2];
        for (int i = 0; i < n; i++) {
            proj[i] = new int[]{capital[i], profits[i]};
        }
        Arrays.sort(proj, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        while (k-- > 0) {
            while (idx < n) {
                if (proj[idx][0] > w) {
                    break;
                }
                pq.add(proj[idx][1]);
                idx++;
            }
            if (pq.isEmpty()) {
                return w;
            }
            int p = pq.peek();
            pq.poll();
            w = w + p;
        }
        return w;
    }
}