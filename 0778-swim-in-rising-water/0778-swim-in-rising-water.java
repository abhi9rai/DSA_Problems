class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = Math.max(grid[0][0], grid[n - 1][n - 1]);
        int high = n * n - 1;
        int ans = high;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(grid, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public boolean isPossible(int[][] grid, int t) {
        int n = grid.length;
        if (grid[0][0] > t) {
            return false;
        }
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            if (x == n - 1 && y == n - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n
                    && !visited[nx][ny] && grid[nx][ny] <= t) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
        return false;
    }
}