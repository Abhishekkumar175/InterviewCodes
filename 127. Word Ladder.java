class Solution {
    public List<String> getNeighbours(String word, HashSet<String> set){
        List<String> neighbours = new ArrayList<>();
        //M^2*26
        for(int i=0;i<word.length();i++){  //3 -> 0,1,2,  (3,3)
            for(char ch='a';ch<='z';ch++){
                if(ch==word.charAt(i)){
                    continue;
                }
                String newWord = word.substring(0,i) + ch+word.substring(i+1,word.length());
                if(set.contains(newWord)){
                    neighbours.add(newWord);
                }
                
            }
           
        }
        return neighbours;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList); //O(N)
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        if(set.contains(beginWord)){
           set.remove(beginWord);
        }
        
        
        int level=0;
        //O(N)
        while(!queue.isEmpty()){
            int curLevelSize = queue.size();
            //level wise traversal
            for(int i=0;i<curLevelSize;i++){
                String node = queue.poll();
                if(node.equals(endWord)){
                    return level+1;
                }
                //adjList
                List<String> neighbours = getNeighbours(node, set);
                for(String word : neighbours){
                    if(set.contains(word)){
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }
            level++;
        }
        return 0;

    }
}





/*
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
Every adjacent pair of words differs by a single letter.
Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
sk == endWord
Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

Example 1:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
Output: 5
Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.

Example 2:
Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
Output: 0
Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 
Constraints:
1 <= beginWord.length <= 10
endWord.length == beginWord.length
1 <= wordList.length <= 5000
wordList[i].length == beginWord.length
beginWord, endWord, and wordList[i] consist of lowercase English letters.
beginWord != endWord
All the words in wordList are unique.
*/ 
