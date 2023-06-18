import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<String>> partition(String s) {
        List<List<String>> partitions = new ArrayList<>();
        List<String> currentPartition = new ArrayList<>();
        partitionHelper(s, 0, currentPartition, partitions);
        return partitions;
    }

    public static void partitionHelper(String s, int start, List<String> currentPartition, List<List<String>> partitions) {
        if (start == s.length()) {
            partitions.add(new ArrayList<>(currentPartition));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                String palindrome = s.substring(start, i + 1);
                currentPartition.add(palindrome);
                partitionHelper(s, i + 1, currentPartition, partitions);
                currentPartition.remove(currentPartition.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> result = partition(s);
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}
