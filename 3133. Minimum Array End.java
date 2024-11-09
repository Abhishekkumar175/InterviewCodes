class Solution {
    public long minEnd(int n, int x) {
        long result = x;
        long mask;
        n--; // Reducing n by 1 to exclude x from the iteration

        // Step 1: Iterate over each bit position with mask starting at 1 and shifting left
        for (mask = 1; n > 0; mask <<= 1) {
            // Step 2: If the corresponding bit in x is 0
            if ((mask & x) == 0) {
                // Set the bit in result based on the least significant bit of n
                result |= (n & 1) * mask;
                // Shift n to the right by 1 to process the next bit
                n >>= 1;
            }
        }

        return result;
    }
    
}




/*
You are given two integers n and x. You have to construct an array of positive integers nums of size n where for every 0 <= i < n - 1, nums[i + 1] is greater than nums[i], and the result of the bitwise AND operation between all elements of nums is x.

Return the minimum possible value of nums[n - 1].

 

Example 1:

Input: n = 3, x = 4

Output: 6

Explanation:

nums can be [4,5,6] and its last element is 6.

Example 2:

Input: n = 2, x = 7

Output: 15

Explanation:

nums can be [7,15] and its last element is 15.

 

Constraints:

1 <= n, x <= 108
*/ 
