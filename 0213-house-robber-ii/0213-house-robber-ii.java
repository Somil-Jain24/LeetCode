class Solution {
    // BY MEMOIZATION
    public int amount(int[] nums, int i, int end, int[] dp) {
        if(i > end) return 0;
        if(dp[i] != -1) return dp[i];
        int take = nums[i] + amount(nums, i+2, end, dp);    
        int skip = amount(nums, i+1, end, dp);
        return dp[i] = Math.max(take , skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[nums.length];
        Arrays.fill(dp1 ,-1);
        int[] dp2 = new int[nums.length];
        Arrays.fill(dp2 ,-1);
        int case1 = amount(nums , 0 , n-2 , dp1);
        int case2 = amount(nums , 1 , n-1 , dp2);
        return Math.max(case1 , case2);
    }

    //BY TABULATION
    // public int rob(int[] nums){
    //     int n = nums.length;
    //     if(n == 1) return nums[0];
    //     int[] dp = new int[n];
    //     dp[0] = nums[0];
    //     dp[1] = Math.max(nums[0], nums[1]);
    //     for(int i = 2; i < nums.length; i++){
    //         int take = nums[i] + dp[i-2];
    //         int skip = dp[i-1];
    //         dp[i] = Math.max(take, skip);
    //     }
    //     return dp[n-1];
    // }
}