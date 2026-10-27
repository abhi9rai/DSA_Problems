class Solution {
    boolean res = true;
    void dfs(int[][] a, int node, int c, int[] colours) {
        colours[node] = c;
        for (int j = 0; j < a[node].length; j++) {
            int neigh = a[node][j];
            if (colours[neigh] != -1 && colours[neigh] == c) {
                res = false;
            }
            if (colours[neigh] == -1) {
                dfs(a, neigh, 1 - c, colours);
            }
        }
        return;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colours = new int[n];
        Arrays.fill(colours, -1);
        for (int i = 0; i < n; i++) {
            if (colours[i] == -1) {
                dfs(graph, i, 0, colours);
            }
        }
        return res;
    }
}