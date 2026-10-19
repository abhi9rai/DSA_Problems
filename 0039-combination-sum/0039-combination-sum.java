class Solution {
    public void fun(int[] a, int idx, int sum, int tar,
                    List<Integer> ds, List<List<Integer>> ans) {
        if (idx == a.length) {
            if (sum == tar) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (a[idx] + sum <= tar) {
            ds.add(a[idx]);
            sum = sum + a[idx];
            fun(a, idx, sum, tar, ds, ans);
            ds.remove(ds.size() - 1);
            sum = sum - a[idx];
        }
        fun(a, idx + 1, sum, tar, ds, ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        fun(candidates, 0, 0, target, ds, ans);
        return ans;
    }
}