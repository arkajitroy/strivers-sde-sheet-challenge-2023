import java.util.*;

class Solution {
    public static String kthPermutation(int n, int k) {
        // Write your code here.
      int[] nums = new int[n];
      for (int i = 1; i <= n; i++) {
          nums[i - 1] = i;
      }

      int[] factorial = new int[n + 1];
      factorial[0] = 1;
      for (int i = 1; i <= n; i++) {
          factorial[i] = factorial[i - 1] * i;
      }

      k--;

      StringBuilder sb = new StringBuilder();

      for (int i = 1; i <= n; i++) {
          int index = k / factorial[n - i];
          sb.append(nums[index]);
          System.arraycopy(nums, index + 1, nums, index, n - index - 1);
          k -= index * factorial[n - i];
      }

      return sb.toString();
    }
}