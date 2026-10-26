
import java.util.*;
class Solution {
    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0 && !visited[i][j]) {
                    Queue<Integer> q = new LinkedList<>();
                    q.add(i * n + j);
                    visited[i][j] = true;
                    long sum = 0;
                    while (!q.isEmpty()) {
                        int cell = q.poll();
                        int row = cell / n;
                        int col = cell % n;
                        sum += grid[row][col];
                        for (int d = 0; d < 4; d++) {
                            int nr = row + dr[d];
                            int nc = col + dc[d];
                            if (nr >= 0 && nr < m &&
                                nc >= 0 && nc < n &&
                                grid[nr][nc] > 0 &&
                                !visited[nr][nc]) {
                                visited[nr][nc] = true;
                                q.add(nr * n + nc);
                            }
                        }
                    }
                    if (sum % k == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
