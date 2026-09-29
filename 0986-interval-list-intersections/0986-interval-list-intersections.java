class Solution {
    public int[][] intervalIntersection(int[][] a, int[][] b) {
        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < a.length && j < b.length) {
            int start1 = a[i][0];
            int end1 = a[i][1];
            int start2 = b[j][0];
            int end2 = b[j][1];
            if (start1 <= end2 && start2 <= end1) {
                int start = Math.max(start1, start2);
                int end = Math.min(end1, end2);

                res.add(new int[]{start, end});
            }
            if (end1 <= end2) {
                i++;
            } else {
                j++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}