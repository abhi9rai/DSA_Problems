import java.util.*;
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int src = k;
        src--;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < times.length; i++) {
            int s = times[i][0];
            int d = times[i][1];
            int w = times[i][2];
            adj.get(s - 1).add(new int[]{d - 1, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.add(new int[]{0, src});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int d = p[0];
            int node = p[1];
            if (d > dist[node]) {
                continue;
            }
            for (int j = 0; j < adj.get(node).size(); j++) {
                int neigh = adj.get(node).get(j)[0];
                int wt = adj.get(node).get(j)[1];
                if (d + wt < dist[neigh]) {
                    dist[neigh] = d + wt;
                    pq.add(new int[]{d + wt, neigh});
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dist[i]);
        }
        if (res != Integer.MAX_VALUE) {
            return res;
        }
        return -1;
    }
}