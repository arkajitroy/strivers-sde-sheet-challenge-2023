import java.util.*;

class Solution 
{
	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
		ArrayList<Integer> mergedResult = new ArrayList<>();
		
		// Create a priority queue to store the elements from the K arrays
		PriorityQueue<Element> pq = new PriorityQueue<>();
		
		// Add the first element from each array to the priority queue
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> array = kArrays.get(i);
			pq.offer(new Element(array.get(0), i, 0));
		}
		
		// Merge the arrays using the priority queue
		while (!pq.isEmpty()) {
			Element minElement = pq.poll();
			int arrayIndex = minElement.arrayIndex;
			int elementIndex = minElement.elementIndex;
			
			// Add the smallest element to the merged result
			mergedResult.add(minElement.value);
			
			// If the array has more elements, add the next element to the priority queue
			if (elementIndex < kArrays.get(arrayIndex).size() - 1) {
				pq.offer(new Element(kArrays.get(arrayIndex).get(elementIndex + 1), arrayIndex, elementIndex + 1));
			}
		}
		
		return mergedResult;
	}

	// Helper class to store the element value, array index, and element index
	static class Element implements Comparable<Element> {
		int value;
		int arrayIndex;
		int elementIndex;
		
		public Element(int value, int arrayIndex, int elementIndex) {
			this.value = value;
			this.arrayIndex = arrayIndex;
			this.elementIndex = elementIndex;
		}
		
		@Override
		public int compareTo(Element other) {
			return Integer.compare(this.value, other.value);
		}
	}
}
