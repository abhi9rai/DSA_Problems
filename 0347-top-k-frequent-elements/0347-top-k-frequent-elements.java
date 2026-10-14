class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> {
                if (a[0] != b[0])
                    return a[0] - b[0];
                return a[1] - b[1];
            }
        );
        int n = nums.length;
        HashMap<Integer, Integer> f = new HashMap<>();
        for (int i = 0; i < n; i++) {
            f.put(nums[i], f.getOrDefault(nums[i], 0) + 1);
        }
        for (var i : f.entrySet()) {
            int element = i.getKey();
            int freq = i.getValue();
            int[] curr = {freq, element};
            if (pq.size() < k) {
                pq.add(curr);
                continue;
            }
            if (curr[0] > pq.peek()[0]) {
                pq.poll();
                pq.add(curr);
            }
        }
        int[] res = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            res[i++] = temp[1];
        }
        return res;
    }
}