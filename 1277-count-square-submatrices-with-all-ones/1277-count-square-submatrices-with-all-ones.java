class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j<n ; j++){
                if(i > 0 && j > 0){
                    if(matrix[i-1][j-1] > 0 && matrix[i][j-1] > 0 && matrix[i-1][j] > 0 && matrix[i][j] > 0){
                        int min = Math.min(matrix[i-1][j-1] , Math.min((matrix[i][j-1]) , matrix[i-1][j]));
                        matrix[i][j] = min + 1; 
                    }
                }
            }
        }
        int sum = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0; j<n ; j++){
                sum += matrix[i][j];
            }
        }

        return sum; 
    }
}