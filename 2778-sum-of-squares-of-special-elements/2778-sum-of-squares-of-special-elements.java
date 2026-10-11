class Solution {
    public int sumOfSquares(int[] nums) {
        int sum = 0;
        for(int i = 1; i<= nums.length; i++){
            if(nums.length % i == 0)sum += Math.pow(nums[i-1], 2);
        }
        return sum;
    }
}