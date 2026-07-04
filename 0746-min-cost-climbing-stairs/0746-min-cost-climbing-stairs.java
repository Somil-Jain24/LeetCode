class Solution {

    // BY MEMOIZATION
    // public int minCost(int[] cost, int idx, int[] dp) {
    //     if(idx == 0 || idx == 1) return cost[idx];
    //     if(dp[idx] != -1) return dp[idx]; 
    //     return dp[idx] = cost[idx] + Math.min(minCost(cost,idx-1, dp),minCost(cost,idx-2, dp));
    // }
    // public int minCostClimbingStairs(int[] cost) {
    //     int n = cost.length;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp, -1);
    //     return Math.min(minCost(cost, n - 1, dp), minCost(cost, n - 2, dp));
        
    // }

    //BY TABULATION
    public int minCostClimbingStairs(int[] cost){ 
        int n = cost.length;
        if(n == 2) return Math.min(cost[0] , cost[1]);
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2 ; i < n ; i++){
            dp[i] = Math.min(dp[i-2], dp[i-1]) + cost[i];
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}