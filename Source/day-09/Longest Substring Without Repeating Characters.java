import java.util.* ;

class Solution 
{
	public static int uniqueSubstrings(String input) 
    {
		int maxLen = 0;
        Set<Character> uniqueChars = new HashSet<>();
        int start = 0;
        int end = 0;
        
        while (end < input.length()) {
            char currentChar = input.charAt(end);
            
            if (uniqueChars.contains(currentChar)) {
                maxLen = Math.max(maxLen, end - start);
                while (input.charAt(start) != currentChar) {
                    uniqueChars.remove(input.charAt(start));
                    start++;
                }
                start++;
            } else {
                uniqueChars.add(currentChar);
            }
            
            end++;
        }
        
        maxLen = Math.max(maxLen, end - start);
        
        return maxLen;
	}
}
