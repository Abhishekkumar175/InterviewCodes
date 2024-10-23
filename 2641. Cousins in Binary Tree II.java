/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        //bfs
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int prevSum = root.val;
        while(!queue.isEmpty()){
            int size = queue.size();
            int curSum=0;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                node.val = prevSum-node.val;
                int sibsum=0;
                if(node.left!=null){
                    sibsum+=node.left.val;
                }
                if(node.right!=null){
                    sibsum+=node.right.val;
                }
                if(node.left!=null){
                    curSum += node.left.val;
                    node.left.val = sibsum;
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    curSum += node.right.val;
                    node.right.val = sibsum;
                    queue.offer(node.right);
                }
            }
            prevSum = curSum;
        }
        return root;
    }
}



/*
Given the root of a binary tree, replace the value of each node in the tree with the sum of all its cousins' values.
Two nodes of a binary tree are cousins if they have the same depth with different parents.
Return the root of the modified tree.
Note that the depth of a node is the number of edges in the path from the root node to it.

Example 1:
Input: root = [5,4,9,1,10,null,7]
Output: [0,0,0,7,7,null,11]
Explanation: The diagram above shows the initial binary tree and the binary tree after changing the value of each node.
- Node with value 5 does not have any cousins so its sum is 0.
- Node with value 4 does not have any cousins so its sum is 0.
- Node with value 9 does not have any cousins so its sum is 0.
- Node with value 1 has a cousin with value 7 so its sum is 7.
- Node with value 10 has a cousin with value 7 so its sum is 7.
- Node with value 7 has cousins with values 1 and 10 so its sum is 11.

Example 2:
Input: root = [3,1,2]
Output: [0,0,0]
Explanation: The diagram above shows the initial binary tree and the binary tree after changing the value of each node.
- Node with value 3 does not have any cousins so its sum is 0.
- Node with value 1 does not have any cousins so its sum is 0.
- Node with value 2 does not have any cousins so its sum is 0.
 
Constraints:
The number of nodes in the tree is in the range [1, 105].
1 <= Node.val <= 104
*/
