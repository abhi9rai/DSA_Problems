import java.util.*;
class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        ArrayList<Integer>[] tree = new ArrayList[n];
        ArrayList<Integer>[] newTree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
            newTree[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            tree[parent[i]].add(i);
        }
        int[] last = new int[26];
        Arrays.fill(last, -1);
        int[] prev = new int[n];
        int[] newParent = new int[n];
        int[] stack = new int[2 * n + 5];
        int top = 0;
        stack[top++] = 1;
        while (top > 0) {
            int event = stack[--top];
            if (event > 0) {
                int node = event - 1;
                int c = s.charAt(node) - 'a';
                prev[node] = last[c];
                if (last[c] != -1) {
                    newParent[node] = last[c];
                } else {
                    newParent[node] = parent[node];
                }
                last[c] = node;
                stack[top++] = -(node + 1);
                for (int child : tree[node]) {
                    stack[top++] = child + 1;
                }
            } else {
                int node = -event - 1;
                int c = s.charAt(node) - 'a';
                last[c] = prev[node];
            }
        }
        for (int i = 1; i < n; i++) {
            newTree[newParent[i]].add(i);
        }
        int[] order = new int[n];
        int count = 1;
        order[0] = 0;
        for (int i = 0; i < count; i++) {
            int node = order[i];
            for (int child : newTree[node]) {
                order[count++] = child;
            }
        }
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = count - 1; i > 0; i--) {
            int node = order[i];
            ans[newParent[node]] += ans[node];
        }
        return ans;
    }
}
