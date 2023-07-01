import java.util.ArrayList;

class Solution {
	public static int longestSubSeg(ArrayList<Integer> arr , int n, int k) {
		// Write your code here.
		int maxCount = 0;
		int left = 0;
		int right = 0;
		int zeroCount = 0;
		
		while (right < n) {
			if (arr.get(right) == 0) {
				zeroCount++;
			}
			
			while (zeroCount > k) {
				if (arr.get(left) == 0) {
					zeroCount--;
				}
				left++;
			}
			
			int subsegLength = right - left + 1;
			maxCount = Math.max(maxCount, subsegLength);
			
			right++;
		}
		
		return maxCount;
	}
}