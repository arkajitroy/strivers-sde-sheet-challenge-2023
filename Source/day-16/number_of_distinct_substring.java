import java.util.HashSet;

class Solution {

  public static int distinctSubstring(String word) {
    HashSet<String> distinctSubstrings = new HashSet<>();

    int n = word.length();

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j <= n; j++) {
        String substring = word.substring(i, j);
        distinctSubstrings.add(substring);
      }
    }

    return distinctSubstrings.size();
  }

  public static void main(String[] args) {
    String word = "banana";

    int count = distinctSubstring(word);
    System.out.println(count); // Output: 21
  }
}
