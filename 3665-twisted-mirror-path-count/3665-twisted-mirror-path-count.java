class Solution {
    int MOD = 1000000007;
    int m, n;
    int[][] grid;
    int[][][] memo;
    int solve(int r, int c, int dir) {
        if (r < 0 || r >= m || c < 0 || c >= n) {
            return -1;
        }
        if (grid[r][c] == 0) {
            return r * n + c;
        }
        if (memo[r][c][dir] != -2) {
            return memo[r][c][dir];
        }
        int nr, nc, nextDir;
        if (dir == 0) {
            nr = r + 1;
            nc = c;
            nextDir = 1;
        } else {
            nr = r;
            nc = c + 1;
            nextDir = 0;
        }
        if (nr >= m || nc >= n) {
            memo[r][c][dir] = -1;
        } else {
            memo[r][c][dir] = solve(nr, nc, nextDir);
        }
        return memo[r][c][dir];
    }
    int getDestination(int r, int c, int dir) {
        int nr = r;
        int nc = c;
        if (dir == 0) {
            nc++;
        } else {
            nr++;
        }
        if (nr >= m || nc >= n) {
            return -1;
        }
        if (grid[nr][nc] == 0) {
            return nr * n + nc;
        }
        return solve(nr, nc, dir);
    }
    public int uniquePaths(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        memo = new int[m][n][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j][0] = -2;
                memo[i][j][1] = -2;
            }
        }
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 || dp[i][j] == 0) {
                    continue;
                }
                int ways = dp[i][j];
                int right = getDestination(i, j, 0);
                if (right != -1) {
                    int nr = right / n;
                    int nc = right % n;
                    dp[nr][nc] = (int) (
                        (dp[nr][nc] + (long) ways) % MOD
                    );
                }
                int down = getDestination(i, j, 1);
                if (down != -1) {
                    int nr = down / n;
                    int nc = down % n;
                    dp[nr][nc] = (int) (
                        (dp[nr][nc] + (long) ways) % MOD
                    );
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}