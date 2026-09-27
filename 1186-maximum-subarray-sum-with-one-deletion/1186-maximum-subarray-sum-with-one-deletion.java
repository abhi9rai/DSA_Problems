class Solution {
    public int maximumSum(int[] arr) {

        int n = arr.length;

        int nodelete = arr[0];
        int onedelete = Integer.MIN_VALUE;

        int res = arr[0];

        for (int i = 1; i < n; i++) {

            int prevnodelete = nodelete;
            int prevonedelete = onedelete;
            nodelete = Math.max(
                prevnodelete + arr[i],
                arr[i]
            );
            int v2 = Integer.MIN_VALUE;

            if (prevonedelete != Integer.MIN_VALUE) {
                v2 = prevonedelete + arr[i];
            }
            onedelete = Math.max(
                prevnodelete,
                v2
            );

            res = Math.max(
                res,
                Math.max(nodelete, onedelete)
            );
        }

        return res;
    }
}