class Solution {
    int mod = 1000000007;
    long[][] comb = new long[1001][1001];
    public int numOfWays(int[] nums) {
        for (int i = 0; i <= nums.length; i++) {
            comb[i][0] = 1;
            comb[i][i] = 1;
            for (int j = 1; j < i; j++) {
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % mod;
            }
        }
        return (int) ((ways(nums) - 1 + mod) % mod);
    }
    long ways(int[] nums) {
        if (nums.length <= 2) {
            return 1;
        }
        int root = nums[0];
        java.util.List<Integer> left = new java.util.ArrayList<>();
        java.util.List<Integer> right = new java.util.ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < root) {
                left.add(nums[i]);
            } else {
                right.add(nums[i]);
            }
        }
        int[] l = new int[left.size()];
        int[] r = new int[right.size()];
        for (int i = 0; i < left.size(); i++) {
            l[i] = left.get(i);
        }
        for (int i = 0; i < right.size(); i++) {
            r[i] = right.get(i);
        }
        long leftWays = ways(l);
        long rightWays = ways(r);
        long result = comb[nums.length - 1][left.size()];
        result = result * leftWays % mod;
        result = result * rightWays % mod;
        return result;
    }
}
