class Solution {
    public static double median(int[] a, int[] b) {
    	// Write your code here.
        if (a.length > b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }
        
        int m = a.length;
        int n = b.length;
        int start = 0;
        int end = m;
        
        while (start <= end) {
            int partitionX = (start + end) / 2;
            int partitionY = (m + n + 1) / 2 - partitionX;
            
            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX - 1];
            int minRightX = (partitionX == m) ? Integer.MAX_VALUE : a[partitionX];
            
            int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY - 1];
            int minRightY = (partitionY == n) ? Integer.MAX_VALUE : b[partitionY];
            
            if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
                if ((m + n) % 2 == 0) {
                    return (double)(Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
                } else {
                    return (double)Math.max(maxLeftX, maxLeftY);
                }
            } else if (maxLeftX > minRightY) {
                end = partitionX - 1;
            } else {
                start = partitionX + 1;
            }
        }
        
        throw new IllegalArgumentException("Arrays are not sorted!");
    }
}