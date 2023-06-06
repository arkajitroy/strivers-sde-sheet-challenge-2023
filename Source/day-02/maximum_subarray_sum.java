import java.util.* ;
import java.io.*; 

class Solution {
	
	public static long maxSubarraySum(int[] nums, int n) {
		long maxSum = nums[0];
		long currSum = nums[0];

		for(int i=1; i<n; i++){
			currSum = Math.max(nums[i], currSum + nums[i]);
			maxSum = Math.max(maxSum, currSum);
		}
		if(maxSum < 0) return 0;
		return maxSum;
	}
}
