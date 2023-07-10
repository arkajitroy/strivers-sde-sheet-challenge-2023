import java.util.* ;
import java.io.*; 

class Solution {

	static int kthLargest(ArrayList<Integer> arr, int size, int K) {
		return kthLargest(arr, 0, size - 1, K);
	}

	static int kthLargest(ArrayList<Integer> arr, int low, int high, int K) {
		int partitionIndex = partition(arr, low, high);
		if (partitionIndex == K - 1) {
			return arr.get(partitionIndex);
		} else if (partitionIndex > K - 1) {
			return kthLargest(arr, low, partitionIndex - 1, K);
		} else {
			return kthLargest(arr, partitionIndex + 1, high, K);
		}
	}

	static int partition(ArrayList<Integer> arr, int low, int high) {
		int pivot = arr.get(high);
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (arr.get(j) > pivot) {
				i++;
				Collections.swap(arr, i, j);
			}
		}
		Collections.swap(arr, i + 1, high);
		return i + 1;
	}
}
