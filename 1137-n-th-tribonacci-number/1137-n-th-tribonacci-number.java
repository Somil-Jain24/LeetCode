class Solution {
    // by memoization
    // public int trifibo(int n , int[] dp){
    //     if(n == 0) return 0;
    //     if(n == 2 || n == 1) return 1;
    //     if(dp[n] != -1) return dp[n];
    //     return dp[n] = trifibo(n-1, dp) + trifibo(n-2, dp) + trifibo(n-3, dp); 
    // }
    // public int tribonacci(int n) {
    //     int[] dp = new int[n+1];
    //     Arrays.fill(dp, -1);
    //     return trifibo(n , dp);
    // }

    // BY TABULATION
    public int tribonacci(int n){
        if(n == 0) return 0;
        if(n == 2 || n == 1) return 1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3 ; i<=n ;i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
}