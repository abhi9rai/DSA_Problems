/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    ArrayList<Integer> temp = new ArrayList<>();
    void fun(TreeNode root) {
        if (root == null) {
            return;
        }
        fun(root.left);
        temp.add(root.val);
        fun(root.right);
    }
    public boolean findTarget(TreeNode root, int k) {
        fun(root);
        int i = 0;
        int j = temp.size() - 1;
        while (i < j) {
            int sum = temp.get(i) + temp.get(j);
            if (sum == k) {
                return true;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}