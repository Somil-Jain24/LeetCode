class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer , Integer> map = new HashMap<>();
            int[] res = {-1, -1};
            int rem = 0;
        for(int i = 0;i<nums.length;i++){
            rem = target - nums[i];
            if(map.containsKey(rem)){
                res[0] = map.get(rem);
                res[1] = i;
                return res;
            }else map.put(nums[i] , i);
        }
        return res;
    }
}