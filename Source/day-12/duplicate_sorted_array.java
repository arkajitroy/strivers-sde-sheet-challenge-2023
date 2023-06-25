import java.util.ArrayList;

class Solution {
	public static int removeDuplicates(ArrayList<Integer> arr,int n) {
		int ptr1 = 0, ptr2 = 1;

        while (ptr2 < n) {
            if (arr.get(ptr1).equals(arr.get(ptr2)))
                ptr2++;
            else {
                arr.set(ptr1 + 1, arr.get(ptr2));
                ptr1++;
                ptr2++;
            }
        }

        return ptr1 + 1;
	}
}