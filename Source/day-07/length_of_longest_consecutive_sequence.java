import java.io.*;
import java.util.* ;

class Solution {
    public static int lengthOfLongestConsecutiveSequence(int[] arr, int N) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;
        for (int num : arr) {
            if (!set.contains(num - 1)) {
                int currentLength = 1;
                while (set.contains(num + 1)) {
                    num++;
                    currentLength++;
                }
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
