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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean lefttoright = true;
        while (!q.isEmpty()) {
            int size = q.size();
            int[] temp = new int[size];
            int first = 0;
            int last = size - 1;
            for (int i = 0; i < size; i++) {
                TreeNode t = q.poll();
                if (lefttoright) {
                    temp[first] = t.val;
                    first++;
                } else {
                    temp[last] = t.val;
                    last--;
                }
                if (t.left != null) {
                    q.offer(t.left);
                }
                if (t.right != null) {
                    q.offer(t.right);
                }
            }
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                level.add(temp[i]);
            }
            ans.add(level);
            lefttoright = !lefttoright;
        }
        return ans;
    }
}