class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap <Integer , Integer> hm = new HashMap<>();
        for(int num : arr){
            hm.put(num , hm.getOrDefault(num , 0)+1);
        }
        Set <Integer> set = new HashSet<>();
        for(int n : hm.values()){
            if(set.contains(n)){
                return false;
            }else{
                set.add(n);
            }
        }
        return true;
    }
}