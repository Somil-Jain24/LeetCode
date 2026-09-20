class Solution {
    public int paths(int row, int col, int m, int n, int[][] dp){
        if(row >= m || col >= n) return 0;
        if(row == m-1 || col == n-1) return 1;
        if(dp[row][col] != -1) return dp[row][col];
        
        return dp[row][col] = paths(row+1, col, m, n, dp) + paths(row, col+1, m, n, dp);

    }
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        for (int[] row : dp) {
        Arrays.fill(row, -1);
        }
        return paths(0, 0, m, n, dp);
    }
}