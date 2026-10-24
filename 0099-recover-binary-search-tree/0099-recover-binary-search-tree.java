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
    int galat = 0;
    TreeNode prev = null;
    TreeNode g1first = null;
    TreeNode g1second = null;
    TreeNode g2first = null;
    TreeNode g2second = null;
    public void recoverTree(TreeNode root) {
        fun(root);
        if (galat >= 2) {
            swap(g1first, g2second);
        } else {
            swap(g1first, g1second);
        }
    }
    void fun(TreeNode root) {
        if (root == null) {
            return;
        }
        fun(root.left);
        if (prev != null && root.val < prev.val) {
            if (galat == 0) {
                g1first = prev;
                g1second = root;
                galat++;
            } else {
                g2first = prev;
                g2second = root;
                galat++;
            }
        }
        prev = root;
        fun(root.right);
    }
    void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}