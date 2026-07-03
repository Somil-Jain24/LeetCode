class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('o');
        vowels.add('i');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] arr = s.toCharArray();
        int count = 0;
       

        for (int i = 0; i < k; i++) {
            if (vowels.contains(arr[i])) {
                count++;
            }
        }
        int max = count;
        for(int i = k ; i<arr.length;i++){
            if(vowels.contains(arr[i-k])){
                count--;
            }
            if(vowels.contains(arr[i])){
                count++;
            }
            max = max > count ? max : count;
        }
        return max;
    }
}