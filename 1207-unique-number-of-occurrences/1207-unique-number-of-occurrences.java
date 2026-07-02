class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Set<Integer> set = new HashSet<>();
        for(int key : map.keySet()){
            if(set.contains(map.get(key))) return false;
            else set.add(map.get(key));
        }
        return true;
    }
}