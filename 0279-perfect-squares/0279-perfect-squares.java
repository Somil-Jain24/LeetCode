class Solution {
    public boolean perfectsquare(int num){
        int n = (int)(Math.sqrt(num));
        return (n*n == num);
    }
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for(int i = 0; i<= n; i++){
        if(perfectsquare(i)) dp[i] = 1;
            else{
                int min = Integer.MAX_VALUE;
                for(int j=1; j*j<=i ; j++){
                    int count = dp[j*j] + dp[i-j*j];
                    min = Math.min(count , min);
                }
                dp[i] = min;
            }
        }
        return dp[n];
    }
}