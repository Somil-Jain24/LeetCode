class Solution {
    public int numOfSubarrays(int[] arr) {
        long mod = 1000000007L;
        long ans = 0;
        int prefixSum = 0;
        int evenCount = 1; // Empty prefix sum (0) is even
        int oddCount = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 == 0) {
                // Current prefix sum is even; subtract any previous odd prefix sum to get an odd subarray sum
                ans = (ans + oddCount) % mod;
                evenCount++;
            } else {
                // Current prefix sum is odd; subtract any previous even prefix sum to get an odd subarray sum
                ans = (ans + evenCount) % mod;
                oddCount++;
            }
        }

        return (int) ans;
    }
}