import java.io.*;
import java.util.* ;

import java.util.ArrayList;

class Solution {

	public static int LongestSubsetWithZeroSum(ArrayList<Integer> arr) {

		int maxLength = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1); // Initialize the map with sum 0 at index -1

        for (int i = 0; i < arr.size(); i++) {
            sum += arr.get(i);

            if (sum == 0) {
                maxLength = i + 1;
            } else if (sumMap.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - sumMap.get(sum));
            } else {
                sumMap.put(sum, i);
            }
        }

        return maxLength;
	}
}