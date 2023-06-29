import java.util.ArrayList;

class MatrixMedian {
    public static int getMedian(ArrayList<ArrayList<Integer>> matrix) {
        int rows = matrix.size();
        int cols = matrix.get(0).size();
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;

        // Find the minimum and maximum values in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int value = matrix.get(i).get(j);
                minValue = Math.min(minValue, value);
                maxValue = Math.max(maxValue, value);
            }
        }

        int targetCount = (rows * cols + 1) / 2;
        int low = minValue;
        int high = maxValue;

        // Perform binary search to find the median value
        while (low < high) {
            int mid = low + (high - low) / 2;
            int count = 0;

            // Count the number of elements less than or equal to mid
            for (int i = 0; i < rows; i++) {
                int index = binarySearch(matrix.get(i), mid);
                count += index + 1;
            }

            if (count < targetCount) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }

    // Binary search to find the index of the first element greater than target
    private static int binarySearch(ArrayList<Integer> array, int target) {
        int left = 0;
        int right = array.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array.get(mid) > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(3);
        row1.add(5);
        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(2);
        row2.add(6);
        row2.add(9);
        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(3);
        row3.add(6);
        row3.add(9);

        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);

        int median = getMedian(matrix);
        System.out.println("Median: " + median);
    }
}
