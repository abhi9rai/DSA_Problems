class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        int minNeed = Math.min(need1, need2);
        int maxNeed = Math.max(need1, need2);
        long costA = (long) need1 * cost1 + (long) need2 * cost2;
        long costB = (long) minNeed * costBoth
                   + (long) (need1 - minNeed) * cost1
                   + (long) (need2 - minNeed) * cost2;
        long costC = (long) maxNeed * costBoth;
        return Math.min(costA, Math.min(costB, costC));
    }
}