import java.util.*;
class Solution {
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};
    boolean isValid(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return false;
        }
        return true;
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        while (!q.isEmpty() && fresh > 0) {
            time++;
            int size = q.size();
            while (size-- > 0) {
                int[] p = q.poll();
                int i = p[0];
                int j = p[1];
                for (int k = 0; k < 4; k++) {
                    int newI = i + x[k];
                    int newJ = j + y[k];
                    if (isValid(newI, newJ, n, m)
                            && grid[newI][newJ] == 1) {
                        grid[newI][newJ] = 2;
                        fresh--;
                        q.add(new int[]{newI, newJ});
                    }
                }
            }
        }
        if (fresh > 0) {
            return -1;
        }
        return time;
    }
}
