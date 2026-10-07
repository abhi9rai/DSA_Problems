class Solution {
    public int firstOccurrence(int[] a, int x) {
        int n = a.length;
        int low = 0, high = n - 1;
        int res = -1;
        while (low <= high) {
            int guess = (high + low) / 2;
            if (a[guess] < x) {
                low = guess + 1;
            }
            else if (a[guess] > x) {
                high = guess - 1;
            }
            else {
                res = guess;
                high = guess - 1;
            }
        }
        return res;
    }
    public int secondOccurrence(int[] a, int x) {
        int n = a.length;
        int low = 0, high = n - 1;
        int res = -1;
        while (low <= high) {
            int guess = (high + low) / 2;
            if (a[guess] < x) {
                low = guess + 1;
            }
            else if (a[guess] > x) {
                high = guess - 1;
            }
            else {
                res = guess;
                low = guess + 1;
            }
        }
        return res;
    }
    public int[] searchRange(int[] nums, int target) {
        int first = firstOccurrence(nums, target);
        int second = secondOccurrence(nums, target);
        return new int[]{first, second};
    }
}