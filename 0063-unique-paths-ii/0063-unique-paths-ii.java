class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int c = 1; c < n; c++) {
            if(obstacleGrid[0][c] == 1) dp[0][c] = 0;
            else dp[0][c] = dp[0][c - 1];    
        }
        for (int r = 1; r < m; r++) {
             if(obstacleGrid[r][0] == 1) dp[r][0] = 0;
            else dp[r][0] = dp[r-1][0];
        }   
        
        for(int i = 1 ; i< m ;i++){
            for(int j = 1 ; j< n ; j++){
                if(obstacleGrid[i][j] == 1)  dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
        
    }
}