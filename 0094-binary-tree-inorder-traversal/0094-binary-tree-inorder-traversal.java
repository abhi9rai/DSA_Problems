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
    List<Integer> ans = new ArrayList<>();
    void fun(TreeNode node) {
        if(node == null)
            return;
        fun(node.left);
        ans.add(node.val);
        fun(node.right);
        return;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        fun(root);
        return ans;
    }
}

