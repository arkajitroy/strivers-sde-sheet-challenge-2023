class TrappingRainWater {
    public static long getTrappedWater(long[] arr, int n) {
        long[] leftMax = new long[n];
        long[] rightMax = new long[n];

        // Calculate the maximum height of bars on the left
        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        // Calculate the maximum height of bars on the right
        rightMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], arr[i]);
        }

        long trappedWater = 0;

        // Calculate the trapped water for each bar
        for (int i = 1; i < n - 1; i++) {
            long waterHeight = Math.min(leftMax[i], rightMax[i]) - arr[i];
            if (waterHeight > 0) {
                trappedWater += waterHeight;
            }
        }

        return trappedWater;
    }

    public static void main(String[] args) {
        long[] arr = {3, 0, 0, 2, 0, 4};
        int n = arr.length;

        long trappedWater = getTrappedWater(arr, n);
        System.out.println("Trapped Water: " + trappedWater);
        // Output: Trapped Water: 10
    }
}
