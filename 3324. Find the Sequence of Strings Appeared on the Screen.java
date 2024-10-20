class Solution {
    public List<String> stringSequence(String target) {
       List<String> result = new ArrayList<>();
        StringBuilder screen = new StringBuilder();
        char currentChar = 'a';  // Start with 'a' since we can only press Key 1 initially.

        for (int i = 0; i < target.length(); i++) {
            char targetChar = target.charAt(i);

            // Append 'a' (Key 1 pressed) until the length of the screen matches the length of the target.
            screen.append('a');
            result.add(screen.toString());

            // Now use Key 2 to change 'a' to the desired target character.
            while (screen.charAt(screen.length() - 1) != targetChar) {
                // Increment the last character using Key 2
                char lastChar = screen.charAt(screen.length() - 1);
                char nextChar = (char) (lastChar + 1);

                // Wrap around from 'z' to 'a'
                if (nextChar > 'z') {
                    nextChar = 'a';
                }

                // Update the last character on the screen
                screen.setCharAt(screen.length() - 1, nextChar);
                result.add(screen.toString());
            }
        }

        return result;
    }
}





/*
You are given a string target.

Alice is going to type target on her computer using a special keyboard that has only two keys:

Key 1 appends the character "a" to the string on the screen.
Key 2 changes the last character of the string on the screen to its next character in the English alphabet. For example, "c" changes to "d" and "z" changes to "a".
Note that initially there is an empty string "" on the screen, so she can only press key 1.

Return a list of all strings that appear on the screen as Alice types target, in the order they appear, using the minimum key presses.

 

Example 1:

Input: target = "abc"

Output: ["a","aa","ab","aba","abb","abc"]

Explanation:

The sequence of key presses done by Alice are:

Press key 1, and the string on the screen becomes "a".
Press key 1, and the string on the screen becomes "aa".
Press key 2, and the string on the screen becomes "ab".
Press key 1, and the string on the screen becomes "aba".
Press key 2, and the string on the screen becomes "abb".
Press key 2, and the string on the screen becomes "abc".
Example 2:

Input: target = "he"

Output: ["a","b","c","d","e","f","g","h","ha","hb","hc","hd","he"]

 

Constraints:

1 <= target.length <= 400
target consists only of lowercase English letters.
*/
