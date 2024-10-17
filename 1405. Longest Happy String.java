// A string s is called happy if it satisfies the following conditions:

// s only contains the letters 'a', 'b', and 'c'.
// s does not contain any of "aaa", "bbb", or "ccc" as a substring.
// s contains at most a occurrences of the letter 'a'.
// s contains at most b occurrences of the letter 'b'.
// s contains at most c occurrences of the letter 'c'.
// Given three integers a, b, and c, return the longest possible happy string. If there are multiple longest happy strings, return any of them. If there is no such string, return the empty string "".

// A substring is a contiguous sequence of characters within a string.

// Example 1:
// Input: a = 1, b = 1, c = 7
// Output: "ccaccbcc"
// Explanation: "ccbccacc" would also be a correct answer.
// Example 2:
// Input: a = 7, b = 1, c = 0
// Output: "aabaa"
// Explanation: It is the only correct answer in this case.
 
// Constraints:
// 0 <= a, b, c <= 100
// a + b + c >

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // create a pq (decreasing order of element count)
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        if(a>0){
            pq.offer(new Pair(a,'a'));
        }
        if(b>0){
            pq.offer(new Pair(b,'b'));
        }
        if(c>0){
            pq.offer(new Pair(c,'c'));
        }

        StringBuilder res = new StringBuilder();
        while(!pq.isEmpty()){
            Pair node = pq.poll();
            int n = res.length(); 
            char ch = node.ch;
            int count = node.count;
            // if current element is same as last two then push the second highest freq
            // element
            if(n>=2 && res.charAt(n-1) == ch && res.charAt(n-2) == ch) {
                // if sec highest freq element is not present then break
                if(pq.isEmpty()) break;
                Pair sec = pq.poll();
                res.append(sec.ch);
                sec.count--;
                if(sec.count>0){
                    pq.offer(new Pair(sec.count,sec.ch));
                }
            }else{
                res.append(node.ch);
                node.count--;
            }
            // if element count is not 0, insert in pq with updated count
            if(node.count>0){
                pq.offer(new Pair(node.count,node.ch));
            }
        }
        return res.toString();
    }
}


class Pair implements Comparable<Pair> {
    int count;
    char ch;
    Pair(int count, char ch){
        this.count = count;
        this.ch = ch;
    } 
    public int compareTo(Pair that){
        return that.count - this.count; // dec order of count
    }
}
