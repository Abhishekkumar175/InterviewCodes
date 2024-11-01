class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashMap<String,Integer> map = new HashMap<>();
        // N + M
        for(String word : s1.split(" ")){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(String word : s2.split(" ")){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        ArrayList<String> list = new ArrayList<>();
        // n+m
        for(Map.Entry<String,Integer> entry :map.entrySet()){
            if(entry.getValue()==1){
                list.add(entry.getKey());
            }
        }
        String res[] = new String[list.size()];
        // K
        list.toArray(res);
        return res;
    }
}




/*
A sentence is a string of single-space separated words where each word consists only of lowercase letters.
A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.
Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

Example 1:
Input: s1 = "this apple is sweet", s2 = "this apple is sour"
output: ["sweet","sour"]

Explanation:
The word "sweet" appears only in s1, while the word "sour" appears only in s2.

Example 2:
Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]

 
Constraints:
1 <= s1.length, s2.length <= 200
s1 and s2 consist of lowercase English letters and spaces.
s1 and s2 do not have leading or trailing spaces.
All the words in s1 and s2 are separated by a single space.
*/
