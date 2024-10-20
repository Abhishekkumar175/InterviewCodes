class Solution {
    public int numberOfSubstrings(String s, int k) {
        int n = s.length();
        int count = 0;
        
        // Sliding window variables
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int left = 0;  // left pointer for the sliding window
        int validCharCount = 0;  // Count of characters that appear at least k times
        
        // Expand the window with right pointer
        for (int right = 0; right < n; right++) {
            char rightChar = s.charAt(right);
            
            // Add current character to frequency map
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            
            // If this character has reached exactly k frequency, increment validCharCount
            if (freqMap.get(rightChar) == k) {
                validCharCount++;
            }
            
            // Check if we have a valid window
            while (validCharCount > 0) {
                // Count the substrings from this window
                count += (n - right);  // All substrings from 'left' to 'n' are valid
                
                // Now, try to shrink the window from the left
                char leftChar = s.charAt(left);
                if (freqMap.get(leftChar) == k) {
                    validCharCount--;  // We're removing a valid character, so decrease validCharCount
                }
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);  // Reduce the frequency of the leftChar
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);  // Remove it from the map if its count is 0
                }
                left++;  // Move left pointer to shrink the window
            }
        }
        
        return count;
    }
}





/*
Given a string s and an integer k, return the total number of substrings of s where at least one character appears at least k times.

 

Example 1:

Input: s = "abacb", k = 2

Output: 4

Explanation:

The valid substrings are:

"aba" (character 'a' appears 2 times).
"abac" (character 'a' appears 2 times).
"abacb" (character 'a' appears 2 times).
"bacb" (character 'b' appears 2 times).
Example 2:

Input: s = "abcde", k = 1

Output: 15

Explanation:

All substrings are valid because every character appears at least once.

 

Constraints:

1 <= s.length <= 3000
1 <= k <= s.length
s consists only of lowercase English letters.
*/
