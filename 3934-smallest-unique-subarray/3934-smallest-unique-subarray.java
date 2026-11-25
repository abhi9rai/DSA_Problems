import java.util.*;
class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int N = n + 1;
        int[] s = new int[N];
        int maxVal = 0;
        for (int i = 0; i < n; i++) {
            s[i] = nums[i];
            maxVal = Math.max(maxVal, nums[i]);
        }
        s[n] = 0;
        int alphabet = Math.max(maxVal + 1, N);
        int[] cnt = new int[alphabet];
        int[] sa = new int[N];
        int[] c = new int[N];
        for (int x : s) {
            cnt[x]++;
        }
        for (int i = 1; i < alphabet; i++) {
            cnt[i] += cnt[i - 1];
        }
        for (int i = N - 1; i >= 0; i--) {
            sa[--cnt[s[i]]] = i;
        }
        int classes = 1;
        c[sa[0]] = 0;
        for (int i = 1; i < N; i++) {
            if (s[sa[i]] != s[sa[i - 1]]) {
                classes++;
            }
            c[sa[i]] = classes - 1;
        }
        int[] pn = new int[N];
        int[] cn = new int[N];
        for (int len = 1; len < N; len *= 2) {
            for (int i = 0; i < N; i++) {
                pn[i] = sa[i] - len;
                if (pn[i] < 0) {
                    pn[i] += N;
                }
            }
            Arrays.fill(cnt, 0, classes, 0);
            for (int x : pn) {
                cnt[c[x]]++;
            }
            for (int i = 1; i < classes; i++) {
                cnt[i] += cnt[i - 1];
            }
            for (int i = N - 1; i >= 0; i--) {
                sa[--cnt[c[pn[i]]]] = pn[i];
            }
            cn[sa[0]] = 0;
            int newClasses = 1;
            for (int i = 1; i < N; i++) {
                int cur = sa[i];
                int prev = sa[i - 1];
                int mid = (cur + len) % N;
                int midPrev = (prev + len) % N;
                if (c[cur] != c[prev] ||
                    c[mid] != c[midPrev]) {
                    newClasses++;
                }
                cn[cur] = newClasses - 1;
            }
            int[] temp = c;
            c = cn;
            cn = temp;
            classes = newClasses;
        }
        int[] suffix = new int[n];
        for (int i = 1; i < N; i++) {
            suffix[i - 1] = sa[i];
        }
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) {
            rank[suffix[i]] = i;
        }
        int[] lcp = new int[n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int r = rank[i];
            if (r == 0) {
                continue;
            }
            int j = suffix[r - 1];
            while (i + k < n && j + k < n &&
                   nums[i + k] == nums[j + k]) {
                k++;
            }
            lcp[r] = k;
            if (k > 0) {
                k--;
            }
        }
        int ans = n;
        for (int i = 0; i < n; i++) {
            int r = rank[i];
            int maxLcp = lcp[r];
            if (r + 1 < n) {
                maxLcp = Math.max(maxLcp, lcp[r + 1]);
            }
            int len = maxLcp + 1;
            if (i + len <= n) {
                ans = Math.min(ans, len);
            }
        }
        return ans;
    }
}
