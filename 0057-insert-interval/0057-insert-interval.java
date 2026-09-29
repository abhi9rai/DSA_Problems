class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] a = new int[n + 1][2];
        int i = 0;
        int j = 0;
        while (i < n && intervals[i][0] < newInterval[0]) {
            a[j++] = intervals[i++];
        }
        a[j++] = newInterval;
        while (i < n) {
            a[j++] = intervals[i++];
        }
        return merge(a);
    }
    public int[][] merge(int[][] a) {
        ArrayList<int[]> res = new ArrayList<>();
        int start = a[0][0];
        int end = a[0][1];
        for (int i = 1; i < a.length; i++) {
            int start2 = a[i][0];
            int end2 = a[i][1];
            if (end >= start2) {
                end = Math.max(end, end2);
            }
            else {
                res.add(new int[]{start, end});
                start = start2;
                end = end2;
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[res.size()][]);
    }
}