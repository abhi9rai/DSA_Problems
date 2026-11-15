class Solution {
    public int numOfSubarrays(int[] arr) {
        int mod = 1000000007;
        long even = 1;
        long odd = 0;
        long ans = 0;
        int parity = 0;
        for (int num : arr) {
            parity ^= (num & 1);
            if (parity == 1) {
                ans += even;
                odd++;
            } else {
                ans += odd;
                even++;
            }
            ans %= mod;
        }
        return (int) ans;
    }
}