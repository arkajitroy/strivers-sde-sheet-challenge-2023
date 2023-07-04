import java.util.ArrayList;

class Solution
{
    public static int singleNonDuplicate(ArrayList<Integer> arr)
    {
        //    Write your code here.
        int left = 0;
        int right = arr.size() - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr.get(mid).equals(arr.get(mid + 1))) {
                left = mid + 2;
            } else {
                right = mid;
            }
        }

        return arr.get(left);
    }
}