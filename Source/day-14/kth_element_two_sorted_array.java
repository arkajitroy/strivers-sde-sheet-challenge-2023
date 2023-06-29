class KthElementOfSortedArrays {
    public static int countSmallerOrEqual(int[] row, int target) {
        int count = 0;
        int left = 0;
        int right = row.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (row[mid] <= target) {
                count = mid + 1;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return count;
    }

    public static int ninjaAndLadoos(int row1[], int row2[], int m, int n, int k) {
        int left = Math.min(row1[0], row2[0]);
        int right = Math.max(row1[m - 1], row2[n - 1]);
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = countSmallerOrEqual(row1, mid) + countSmallerOrEqual(row2, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                result = mid;
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] row1 = {5, 4, 3};
        int[] row2 = {3, 11, 23, 45, 52};
        int m = row1.length;
        int n = row2.length;
        int k = 4;

        int kthElement = ninjaAndLadoos(row1, row2, m, n, k);
        System.out.println(kthElement);
        // Output: 11
    }
}
