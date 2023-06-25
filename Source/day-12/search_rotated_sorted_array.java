class Solution {
    public static int search(int arr[], int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == key) {
                return mid;
            }

            // Check if the left half is sorted
            if (arr[start] <= arr[mid]) {
                // Check if the key lies within the sorted range of the left half
                if (key >= arr[start] && key < arr[mid]) {
                    end = mid - 1; // Continue the binary search in the left half
                } else {
                    start = mid + 1; // Continue the binary search in the right half
                }
            } else {
                // The right half must be sorted
                // Check if the key lies within the sorted range of the right half
                if (key > arr[mid] && key <= arr[end]) {
                    start = mid + 1; // Continue the binary search in the right half
                } else {
                    end = mid - 1; // Continue the binary search in the left half
                }
            }
        }

        return -1; // Key not found
    }

    public static void main(String[] args) {
        // Example usage
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int key = 0;

        int index = search(arr, key);

        if (index != -1) {
            System.out.println("Key found at index: " + index);
        } else {
            System.out.println("Key not found");
        }
    }
}
