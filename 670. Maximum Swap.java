// You are given an integer num. You can swap two digits at most once to get the maximum valued number.
// Return the maximum valued number you can get.

// Example 1:

// Input: num = 2736
// Output: 7236
// Explanation: Swap the number 2 and the number 7.
// Example 2:

// Input: num = 9973
// Output: 9973
// Explanation: No swap.
 

// Constraints:
// 0 <= num <= 108

class Solution {
    //T.C = O(n)
    public int maximumSwap(int num) {
        char numArr[] = Integer.toString(num).toCharArray();
        int n = numArr.length;
        char maxElement = numArr[n-1];
        int maxIndex = n-1;
        int swapIdx1=-1;
        int swapIdx2=-1;

        for(int i=n-2; i>=0; i--){
            if(numArr[i] > maxElement){
                maxElement=numArr[i];
                maxIndex=i;
            }else if(numArr[i] < maxElement){
                swapIdx1=i;
                swapIdx2=maxIndex;
            }
        }
        //perform swapping
        if(swapIdx1 != -1){
            char temp = numArr[swapIdx1];
            numArr[swapIdx1] = numArr[swapIdx2];
            numArr[swapIdx2]=temp;
        }
        return Integer.parseInt(new String(numArr));
    }
}
