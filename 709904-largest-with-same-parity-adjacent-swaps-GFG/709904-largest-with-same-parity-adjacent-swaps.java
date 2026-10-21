
import java.util.*;

class Solution {
    public ArrayList<Integer> lexicographicallyLargest(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();

        // Process each contiguous group of same parity
        int i = 0;

        while (i < n) {
            int j = i;

            // Find the end of this same-parity group
            while (j + 1 < n &&
                   (arr[j] % 2) == (arr[j + 1] % 2)) {
                j++;
            }

            // Sort this group in descending order
            Integer[] group = new Integer[j - i + 1];

            for (int k = i; k <= j; k++) {
                group[k - i] = arr[k];
            }

            Arrays.sort(group, Collections.reverseOrder());

            for (int value : group) {
                ans.add(value);
            }

            i = j + 1;
        }

        return ans;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna