class Solution {
    public int[] twoSum(int[] nums, int target) {
        //Create a Hashmap where key is arr[i] and value is i
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i =0; i<nums.length; i++){
            map.put(nums[i],i);
        }
        //if current is equal to target
        for(int i=0; i<nums.length; i++){
            if(nums[i]==target && map.containsKey(0)){
               return new int[] {i, map.get(0)};
             
            }
            else if(map.containsKey(target-nums[i])){
                //is the element non-repeatable
                if(map.get(target-nums[i])>i){
                  
                  return new int[]{i, map.get(target-nums[i])};
                
                }
            }
        }
         return new int[] {};
        
    }
}

//  int n = nums.length;
//         for (int i = 0; i < n - 1; i++) {
//             for (int j = i + 1; j < n; j++) {
//                 if (nums[i] + nums[j] == target) {
//                     return new int[]{i, j};
//                 }
//             }
//         }
//         return new int[]{}; // No solution found




/*
Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

 

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]
 

Constraints:

2 <= nums.length <= 104
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.
*/
