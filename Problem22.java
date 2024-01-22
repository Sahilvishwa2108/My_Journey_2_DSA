class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] arr = new int[2];
        int arrSum = 0;
        int actualSum = nums.length * (nums.length + 1) / 2;

        for (int i = 0; i < nums.length; i++) {
            arrSum += nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    arr[0] = nums[i]; // Found the duplicate number
                }
            }
        }

        arr[1] = actualSum - (arrSum - arr[0]); // Calculate the missing number
        return arr;
    }
}

/* 
645. Set Mismatch

You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.

You are given an integer array nums representing the data status of this set after the error.

Find the number that occurs twice and the number that is missing and return them in the form of an array.

 

Example 1:

Input: nums = [1,2,2,4]
Output: [2,3]
Example 2:

Input: nums = [1,1]
Output: [1,2]
 

Constraints:

2 <= nums.length <= 10^4
1 <= nums[i] <= 10^4 */