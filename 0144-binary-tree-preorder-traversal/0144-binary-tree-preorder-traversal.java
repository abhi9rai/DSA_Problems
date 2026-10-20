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

    List <Integer> ans = new ArrayList<>();
    void fun (TreeNode node){
        if(node==null)
            return;
        ans.add(node.val);
        fun(node.left);
        fun(node.right);
        return;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        fun(root);
        return ans;
    }
}