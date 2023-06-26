import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        int count = 0;
        HashMap<Integer, Integer> xorCount = new HashMap<>();
        int xor = 0;

        for (int i = 0; i < arr.size(); i++) {
            xor = xor ^ arr.get(i);

            if (xor == x)
                count++;

            if (xorCount.containsKey(xor ^ x))
                count += xorCount.get(xor ^ x);

            xorCount.put(xor, xorCount.getOrDefault(xor, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        // Example usage
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(4);
        arr.add(2);
        arr.add(2);
        arr.add(6);
        arr.add(4);

        int xor = 6;

        int count = subarraysXor(arr, xor);

        System.out.println("Count of subarrays with XOR " + xor + ": " + count);
    }
}
