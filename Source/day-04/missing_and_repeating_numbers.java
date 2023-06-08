// Missing and repeating numbers

import java.util.* ;
import java.io.*; 
import java.util.ArrayList;

class Solution {

    public static int[] missingAndRepeating(ArrayList<Integer> arr, int n) {
        int missing = 0;
        int repeating = 0;

        // Find the repeating number
        for (int num : arr) {
            int i = Math.abs(num) - 1;
            if (arr.get(i) > 0) {
                arr.set(i, -arr.get(i));
            } else {
                repeating = Math.abs(num);
            }
        }

        // Find the missing number
        for (int i = 0; i < n; i++) {
            if (arr.get(i) > 0) {
                missing = i + 1;
                break;
            }
        }

        return new int[]{missing, repeating};
    }
}