import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> ans = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == s) {
                    int[] temp = {Math.min(arr[i], arr[j]), Math.max(arr[i], arr[j])};
                    ans.add(temp);
                }
            }
        }

        ans.sort(Comparator.comparingInt(a -> a[0]));

        return ans;
    }
}
