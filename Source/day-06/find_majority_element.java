package Source.day-06;

class Solution {
    public static int findMajority(int[] arr, int n) {
        if (n == 0) {
            return -1;
        }

        int majorityElement = arr[0];
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (count == 0) {
                majorityElement = arr[i];
                count = 1;
            } else if (arr[i] == majorityElement) {
                count++;
            } else {
                count--;
            }
        }

        int occurrences = 0;
        for (int num : arr) {
            if (num == majorityElement) {
                occurrences++;
            }
        }

        return (occurrences > n / 2) ? majorityElement : -1;
    }
}

